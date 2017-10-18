package com.qfedu.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qfedu.Dao.Icartitem;
import com.qfedu.entity.Cartitem;
import com.qfedu.entity.Category;
import com.qfedu.entity.Product;
import com.qfedu.entity.User;
import com.qfedu.utils.DBManager;

public class CartitemImpl implements Icartitem {
	private Connection conn;
	private PreparedStatement ptst;
	private ResultSet rs;
	private List<Cartitem> items= new ArrayList<>();
	@Override
	public List<Cartitem> getCartitem(String name,int pid) {
		return null;
		
	}

	@Override
	public int addCartitem(Cartitem car) {
		int flag = 0;
		conn = DBManager.getConnection();
		
		
		String sql = "insert into cartitem(p8,pname,price,name,img1,count,pid) values(?,?,?,?,?,?,?)";
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, car.getP8());
			ptst.setString(2, car.getPname());
			ptst.setDouble(3, car.getPrice());
			ptst.setString(4, car.getName());
			ptst.setString(5, car.getImg1());
			ptst.setInt(6, car.getCount());
			ptst.setInt(7, car.getPid());
			flag = ptst.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deleteCartitem(Cartitem car) {
		int flag = 0;
		conn = DBManager.getConnection();
		String sql = "delete from Cartitem where caid =?";
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, car.getCaid());
			flag = ptst.executeUpdate();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public int deleteAll(Cartitem car) {
		int flag = 0;
		conn = DBManager.getConnection();
		String sql = "delete from Cartitem where name =?";
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, car.getName());
			flag = ptst.executeUpdate();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int updateCartitem(Cartitem car2) {
		int flag = 0;
		conn =DBManager.getConnection();
		String sql ="update cartitem set count =? where pid =?";
		try {
			ptst = conn.prepareStatement(sql);
			
			ptst.setInt(1, car2.getCount());
			ptst.setInt(2, car2.getPid());
			flag = ptst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Cartitem> getAll() {
	
		List<Cartitem> list  =null;
		conn = DBManager.getConnection();
		
		String sql = "select * from cartitem";
		try {
			ptst = conn.prepareStatement(sql);
			rs = ptst.executeQuery();
			
			list = new ArrayList<>();
			Cartitem emp = null;
			
			while(rs.next()){
			emp = new Cartitem();
			emp.setPid(rs.getInt("pid"));
			emp.setP8(rs.getString("p8"));
			emp.setPname(rs.getString("pname"));
			emp.setPrice(rs.getDouble("price"));
			emp.setName(rs.getString("name"));
			emp.setImg1(rs.getString("img1"));
			emp.setCount(rs.getInt("count"));
			emp.setCaid(rs.getInt("caid"));
			list.add(emp);
				
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Cartitem getCartitemId(int pid) {
		Cartitem cat = null;
		conn = DBManager.getConnection();
		String sql = "select * from Cartitem where pid =" +pid;
		
		try {
			ptst = conn.prepareStatement(sql);
			rs = ptst.executeQuery();
			if(rs.next()){
				cat=new Cartitem();
				cat.setPid(rs.getInt("pid"));
				cat.setCount(rs.getInt("count"));
				
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return cat ;

		
		
	}

	@Override
	public Cartitem getCartitemName(String name) {
		Cartitem cat = null;
		conn = DBManager.getConnection();
		String sql =String.format( "select * from Cartitem where name ='%s'",name);
		
		try {
			ptst = conn.prepareStatement(sql);
			rs = ptst.executeQuery();
			if(rs.next()){
				cat=new Cartitem();
				cat.setName(name);
				cat.setPid(rs.getInt("pid"));
				cat.setCount(rs.getInt("count"));
				cat.setPname(rs.getString("pname"));
				cat.setPrice(rs.getDouble("price"));
				cat.setImg1(rs.getString("img1"));
				
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return cat ;
	}
	
	
	

}
