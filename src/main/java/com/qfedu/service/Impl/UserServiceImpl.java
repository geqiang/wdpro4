package com.qfedu.service.Impl;

import com.qfedu.entity.User;

import java.util.List;

import com.qfedu.Dao.Iuser;
import com.qfedu.Dao.Impl.UserImpl;
import com.qfedu.service.UserService;

public class UserServiceImpl implements UserService {
	private Iuser ius = new UserImpl();

	@Override
	public User getUserByNamePass(String name, String pass1) {
		return ius.getUserByNamePass(name, pass1);
	}
	@Override
	public User getUserByName(String name) {
		return ius.getUserByName(name);
	}
	@Override
	public List<User> getUser() {
		return ius.getUser();
	}
	@Override
	public boolean deleteUser(User use) {
		return ius.deleteUser(use);
	}
	@Override
	public boolean delete2User(int id) {
		return ius.delete2User(id);
	}
	@Override
	public boolean updateUser(User use) {
		// TODO Auto-generated method stub
		return ius.updateUser(use);
	}
	@Override
	public int addUser(User use) {
		// TODO Auto-generated method stub
		return 0;
	}

}
