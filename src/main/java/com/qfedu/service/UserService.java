package com.qfedu.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qfedu.entity.User;

public interface UserService {
	
	@Delete("delete from user where uid =#{uid}")
	boolean delete2User(int id);
	@Delete("delete from user where uid =#{uid}")
	boolean deleteUser(User use);
	@Insert("insert into user(name,mail,password,tele) values(#{name},#{mail},#{password},#{tele})")
	int addUser(User use);
	@Update("update user set name =#{name}, password =#{password},mail =#{mail},tele =#{tele} where uid =#{uid}")
	boolean updateUser(User use);
	@Select("select * from user where name= #{arg0} and password= #{arg1}")
	User getUserByNamePass(String name, String pass1);
	@Select("select * from  user where name = #{name}")
	User getUserByName(String name);
	@Select("select uid,name,mail,tele from user")
	List<User> getUser();
}
