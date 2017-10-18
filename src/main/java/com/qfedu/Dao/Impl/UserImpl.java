package com.qfedu.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qfedu.Dao.Iuser;
import com.qfedu.entity.User;
import com.qfedu.utils.DBManager;

public class UserImpl implements Iuser {
	private Connection conn;
	private PreparedStatement ptst;
	private ResultSet rs;


	@Override
	public User getUserByNamePass(String name, String pass1) {
		User user = null;
		
		conn = DBManager.getConnection();
		String sql = String.format("select * from  user where name = '%s' and password = '%s'", name, pass1);
		try {
			ptst = conn.prepareStatement(sql);
			
			rs = ptst.executeQuery();
			
			if(rs.next()) {
				user = new User();
				
				user.setName(name);
				user.setPassword(pass1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.closeAll(conn, ptst, rs);
		}
		
		return user;
	}
	@Override
	public User getUserByName(String name) {
		User user = null;
		
		conn = DBManager.getConnection();
		String sql = String.format("select * from  user where name = '%s'", name);
		try {
			ptst = conn.prepareStatement(sql);
			
			rs = ptst.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setUid(rs.getInt("uid"));
				user.setName(name);
				user.setPassword(rs.getString("password"));
				user.setTele(rs.getNString("tele"));
				user.setMail(rs.getString("mail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.closeAll(conn, ptst, rs);
		}
		
		return user;

}
	@Override
	public List<User> getUser() {
		List<User> list  =null;
		conn = DBManager.getConnection();
		
		String sql = "select uid,name,mail,tele from user";
		try {
			ptst = conn.prepareStatement(sql);
			rs = ptst.executeQuery();
			
			list = new ArrayList<>();
			User emp = null;
			
			while(rs.next()){
			emp = new User();
			emp.setUid(rs.getInt("uid"));
			emp.setName(rs.getString("name"));
			emp.setMail(rs.getString("mail"));
			emp.setTele(rs.getString("tele"));
			list.add(emp);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
		

	}
	@Override
	public boolean deleteUser(User use) {
		boolean flag = false;
		conn = DBManager.getConnection();
		String sql = "delete from user where uid =?";
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, use.getUid());
			flag = (ptst.executeUpdate()>0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public boolean delete2User(int id) {
		boolean flag= false;
		conn = DBManager.getConnection();
		String sql = "delete from user where uid =?";
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, id);
			flag = (ptst.executeUpdate()>0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	@Override
	public boolean updateUser(User use) {
		boolean flag = false;
		conn =DBManager.getConnection();
		String sql ="update user set name =?, password =?,mail =?,tele =? where uid =?";
		try {
			ptst = conn.prepareStatement(sql);
			
			ptst.setString(1, use.getName());
			ptst.setString(2, use.getPassword());
			ptst.setString(3, use.getMail());
			ptst.setString(4, use.getTele());	
			ptst.setInt(5, use.getUid());
			flag = (ptst.executeUpdate()>0);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	
}