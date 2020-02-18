package com.petpeer.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petperr.model.Pet;
import com.petperr.model.User;

public interface UserService {
	public int saveUser(User u);
	public boolean loginUser(User u,HttpSession session,HttpServletResponse resp);
	public List<Pet> getAllPets();
	public int addPet(Pet p);
	public int buyPet(HttpSession session,int petid,HttpServletRequest req);
	//public List<Pet> getUserPets(HttpSession session,HttpServletRequest req);
	public List<Pet> getuserpets(HttpSession session, HttpServletRequest req);
}
