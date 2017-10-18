package com.qfedu.Dao;

import java.util.List;

import com.qfedu.entity.User;

public interface Iuser {
	
	List<User> getUser();
	User getUserByNamePass(String name, String pass1);
	User getUserByName(String name);

	boolean deleteUser(User use);
	boolean delete2User(int id);
	boolean updateUser(User use);
	
}
