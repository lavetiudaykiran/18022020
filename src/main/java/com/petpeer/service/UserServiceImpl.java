package com.petpeer.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.petpeer.dao.UserDao;
import com.petperr.model.Pet;
import com.petperr.model.User;

public class UserServiceImpl implements UserService{
@Autowired
	UserDao userdao;
	public int saveUser(User u) {
		// TODO Auto-generated method stub
		return userdao.saveUser(u);
	}
	public boolean loginUser(User u, HttpSession session, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return userdao.loginUser(u, session, resp);
	}
	public List<Pet> getAllPets() {
		// TODO Auto-generated method stub
		return userdao.getAllPets();
	}
	public int addPet(Pet p) {
		// TODO Auto-generated method stub
		return userdao.addPet(p);
	}
	public int buyPet(HttpSession session, int petid, HttpServletRequest req) {
		// TODO Auto-generated method stub
		return userdao.buyPet(session, petid, req);
	}
	/*
	 * public List<Pet> getUserPets(HttpSession session, HttpServletRequest req) {
	 * // TODO Auto-generated method stub return userdao.getUserPets(session, req);
	 * }
	 */
	public List<Pet> getuserpets(HttpSession session, HttpServletRequest req) {
		// TODO Auto-generated method stub
		return userdao.getuserpets(session, req);
	}

}
