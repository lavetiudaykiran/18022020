package com.petpeer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petpeer.service.UserService;
import com.petperr.model.Pet;
import com.petperr.model.User;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	UserService userservice;
@RequestMapping(value="/ureg")
public String userreg(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("cp") String cp,ModelMap  m) {
	User u=new User();
        User u1=new User();
	u.setUsername(username);
	u.setPassword(password);
	u.setCp(cp);
	if(password.equals(cp)) {
		userservice.saveUser(u);
		return "successfulreg";
	}
	else {
		m.addAttribute("msg", "Re-Enter!!");
		m.addAttribute("msg1", "Password & Confirm Password must be same!!");

		return "userregn";
	}
	
}
@RequestMapping(value="ulog")
public String userlog(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession session,HttpServletResponse resp,Model m) {
	User u=new User();
	u.setUsername(username);
	u.setPassword(password);
	boolean b=userservice.loginUser(u, session, resp);
	if(b) {
		m.addAttribute("name", "Welcome " + u.getUsername());
		List<Pet> list=userservice.getAllPets();
		m.addAttribute("petlist", list);
		return "home";
	}else {
		m.addAttribute("elogin", "Incorrect UserName&Password...Re-Try!!");
		return "login";
	}
}
@RequestMapping(value="updatepet")
public String addpetsave(@RequestParam("petname")String petname,@RequestParam("petage")String petage,@RequestParam("petplace")String petplace,ModelMap m) {
	Pet p=new Pet();
	p.setPetname(petname);
	p.setPetage(Integer.parseInt(petage));
	p.setPetplace(petplace);
	int count=userservice.addPet(p);
	if(count!= 0) {
		m.addAttribute("petSave", "Pet added Succesfully <br> Thank You!!");
		List<Pet> list=userservice.getAllPets();
		m.addAttribute("petlist", list);
		return "home";
		}else {

		m.addAttribute("petFail", "Failed to add Pet <br>Please Re-Enter Details!!");
		return "addPet";
		}
}
@RequestMapping(value="buypet")
public String buypet(HttpSession session,Model m,@RequestParam("id") String petid,HttpServletRequest req) {
	Pet p=new Pet();
	p.setId(Integer.parseInt(petid));
	userservice.buyPet(session,Integer.parseInt(petid) , req);
	m.addAttribute("sold","Thank You for Purchasing Pet!!!");
	List<Pet> list=userservice.getAllPets();
	m.addAttribute("petlist", list);
	return "home";
}

	
	  @RequestMapping("mypet") 
	  public String mypets(HttpSession session,Model m,HttpServletRequest req)
	  { 
		  List<Pet> list1=userservice.getuserpets(session, req);
	  m.addAttribute("userpetlist",list1); 
	  return "userpets"; 
	  }
	 
@RequestMapping("log")
public String login() {
	return "login";
}
@RequestMapping("home")
public String home(Model m) {
	List<Pet> list=userservice.getAllPets();
	m.addAttribute("petlist", list);
	return "home";
}
@RequestMapping("login")
public String dlogin() {
	return "login";
}
@RequestMapping("addpet")
public String addpet() {
	return "addpet";
}
@RequestMapping("logout")
public String logout() {
	return "logout";
}
@RequestMapping("buy")
public String buy() {
	return "buypet";
}
}
