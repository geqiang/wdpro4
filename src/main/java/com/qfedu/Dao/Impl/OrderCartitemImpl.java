package com.qfedu.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qfedu.Dao.IorderCartitem;
import com.qfedu.entity.Cartitem;
import com.qfedu.entity.Category;
import com.qfedu.entity.OrderCartitem;
import com.qfedu.entity.Product;
import com.qfedu.utils.DBManager;

public class OrderCartitemImpl implements IorderCartitem {
	private Connection conn;
	private PreparedStatement ptst;
	private ResultSet rs;
	@Override
	public List<OrderCartitem> getOrder() {
		List<OrderCartitem> list  =null;
		conn = DBManager.getConnection();
		
		String sql = "select * from ordered";
		try {
			ptst = conn.prepareStatement(sql);
			rs = ptst.executeQuery();
			
			list = new ArrayList<>();
			OrderCartitem emp = null;
			
			while(rs.next()){
			emp = new OrderCartitem();
			emp.setOid(rs.getInt("oid"));
			emp.setOname(rs.getString("oname"));
			emp.setOtele(rs.getString("otele"));
			emp.setAddr(rs.getString("addr"));
			emp.setPid(rs.getInt("pid"));
			emp.setO1(rs.getString("o1"));
			emp.setO2(rs.getString("o2"));
			emp.setO3(rs.getInt("o3"));
			emp.setTime(rs.getString("time"));
			emp.setStatus(rs.getString("status"));
			emp.setName(rs.getString("name"));
			emp.setPoset(rs.getString("poset"));
			emp.setPrices(rs.getDouble("prices"));
			list.add(emp);
				
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return list;
	}

	/* 
	 * @see com.qfedu.Dao.IorderCartitem#addOrder(com.qfedu.entity.OrderCartitem)
	 */
	@Override
	public int addOrder(OrderCartitem ord) {
		int flag =0;
		conn = DBManager.getConnection();
		
		String sql = "insert into ordered(oname,otele,addr,pid,o1,o2,o3,time,status,name,poset,prices) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, ord.getOname());
			ptst.setString(2, ord.getOtele());
			ptst.setString(3, ord.getAddr());
			ptst.setInt(4, ord.getPid());
			ptst.setString(5, ord.getO1());
			ptst.setString(6, ord.getO2());
			ptst.setInt(7, ord.getO3());
			ptst.setString(8, ord.getTime());
			ptst.setString(9, ord.getStatus());
			ptst.setString(10, ord.getName());
			ptst.setString(11, ord.getPoset());
			ptst.setDouble(12, ord.getPrices());
			flag = ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public OrderCartitem getOrderId(int oid) {
		OrderCartitem ord = null;
		conn = DBManager.getConnection();
		String sql = "select * from ordered where oid = " + oid;
		
		try {
			ptst = conn.prepareStatement(sql);
			rs = ptst.executeQuery();
			if(rs.next()){
				ord=new OrderCartitem();
				ord.setOid(rs.getInt("oid"));
				ord.setOname(rs.getString("oname"));
				ord.setOtele(rs.getString("otele"));
				ord.setAddr(rs.getString("addr"));
				ord.setPid(rs.getInt("pid"));
				ord.setTime(rs.getString("time"));
				ord.setO1(rs.getString("o1"));
				ord.setStatus(rs.getString("status"));
				ord.setName(rs.getString("name"));
				ord.setPoset(rs.getString("poset"));
				ord.setPrices(rs.getDouble("prices"));
				
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return ord ;
	}
	@Override
	public int updateOrder(OrderCartitem ord) {
		int flag = 0;
		conn =DBManager.getConnection();
		String sql ="update ordered set prices =?, oname =?,otele =?,addr =?,poset =?,status=?where oid =?";
		try {
			ptst = conn.prepareStatement(sql);
			
			ptst.setDouble(1, ord.getPrices());
			ptst.setString(2, ord.getOname());
			ptst.setString(3, ord.getOtele());
			ptst.setString(4, ord.getAddr());
			ptst.setString(5, ord.getPoset());
			ptst.setString(6, ord.getStatus());
			ptst.setInt(7, ord.getOid());
			flag = ptst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<OrderCartitem> getremai() {
		List<OrderCartitem> list  =null;
		conn = DBManager.getConnection();
		
		String sql = "select * from ordered order by o3 desc limit 12";
		try {
			ptst = conn.prepareStatement(sql);
			rs = ptst.executeQuery();
			
			list = new ArrayList<>();
			OrderCartitem emp = null;
			
			while(rs.next()){
			emp = new OrderCartitem();
			emp.setO2(rs.getString("o2"));
			emp.setO3(rs.getInt("o3"));
			emp.setO1(rs.getString("o1"));
			emp.setPrices(rs.getDouble("prices"));

			list.add(emp);
				
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return list;
	}

}
