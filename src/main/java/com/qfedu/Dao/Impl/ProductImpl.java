package com.qfedu.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qfedu.Dao.Iproduct;
import com.qfedu.entity.Category;
import com.qfedu.entity.Product;
import com.qfedu.utils.DBManager;

public class ProductImpl implements Iproduct {
	private Connection conn;
	private PreparedStatement ptst;
	private ResultSet rs;
	@Override
	public List<Product> getProduct() {
		List<Product> list  =null;
		conn = DBManager.getConnection();
		String sql = "select pid,pname,categoryId,price,kuchun,color,p6,cname,descr,p8,img1,img2,img3,img4,img5,p7 from Product,Category where Category.cid = Product.categoryId";
		try {
			ptst = conn.prepareStatement(sql);
			rs = ptst.executeQuery();
			list = new ArrayList<>();
			Product pro = null;
			
			while(rs.next()){
			pro = new Product();
			pro.setPid(rs.getInt("pid"));
			pro.setPname(rs.getString("pname"));
			pro.setCategory(rs.getInt("categoryId"));
			pro.setPrice(rs.getString("price"));
			pro.setKuchun(rs.getInt("kuchun"));
			pro.setColor(rs.getString("color"));
			pro.setP6(rs.getString("p6"));
			Category cate = new Category();
			cate.setCname(rs.getString("cname"));
			pro.setCate(cate);
			pro.setDescr(rs.getString("descr"));
			pro.setImg1(rs.getString("img1"));
			pro.setP8(rs.getString("p8"));
			pro.setImg2(rs.getString("img2"));
			pro.setImg3(rs.getString("img3"));
			pro.setImg4(rs.getString("img4"));
			pro.setImg5(rs.getString("img5"));
			pro.setP7(rs.getString("p7"));
			list.add(pro);
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addProduct(Product pro) {
		int flag = 0;
		conn = DBManager.getConnection();
		String sql = "insert into Product(pname,price,p8,descr,kuchun,color,categoryId,img1,img2,img3,img4,img5,p7,p6) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, pro.getPname());
			ptst.setString(2, pro.getPrice());
			ptst.setString(3, pro.getP8());
			ptst.setString(4, pro.getDescr());
			ptst.setInt(5, pro.getKuchun());
			ptst.setString(6, pro.getColor());
			ptst.setInt(7,pro.getCategory());
			ptst.setString(8, pro.getImg1());
			ptst.setString(9, pro.getImg2());
			ptst.setString(10, pro.getImg3());
			ptst.setString(11, pro.getImg4());
			ptst.setString(12, pro.getImg5());
			ptst.setString(13, pro.getP7());
			ptst.setString(14, pro.getP6());
			flag = ptst.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deleteProduct(Product pro) {
		// TODO Auto-generated method stub
		int flag = 0;
		conn = DBManager.getConnection();
		String sql = "delete from Product where Pid =?";
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, pro.getPid());
			flag = ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO 鑷姩鐢熸垚鐨� catch 鍧�
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int updateProduct(Product pro) {
		int flag=0;
		conn =DBManager.getConnection();
		String sql ="update Product set pname =?, price =?,descr =?,kuchun =?,color =?,p6=?,categoryId= ?,p8= ? where pid =?";
		try {
			ptst = conn.prepareStatement(sql);
			
			ptst.setString(1, pro.getPname());
			ptst.setString(2, pro.getPrice());
			ptst.setString(3, pro.getDescr());
			ptst.setInt(4, pro.getKuchun());
			ptst.setString(5, pro.getColor());
			ptst.setString(6, pro.getP6());
			ptst.setInt(7, pro.getCategory());
			ptst.setString(8, pro.getP8());
			ptst.setInt(9, pro.getPid());
			flag = ptst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Product getProductId(int pid) {
		Product pro = null;
		conn = DBManager.getConnection();
		String sql = "select * from Product,Category where Category.cid = Product.categoryId and pid = " + pid;
		
		try {
			ptst = conn.prepareStatement(sql);
			rs = ptst.executeQuery();
			if(rs.next()){
				pro=new Product();
				pro.setPid(rs.getInt("pid"));
				pro.setPname(rs.getString("pname"));
				pro.setCategory(rs.getInt("categoryId"));
				pro.setPrice(rs.getString("price"));
				pro.setKuchun(rs.getInt("kuchun"));
				pro.setColor(rs.getString("color"));
				Category cate = new Category();
				cate.setCname(rs.getString("cname"));
				pro.setCate(cate);
				pro.setDescr(rs.getString("descr"));
				pro.setP8(rs.getString("p8"));
				pro.setImg1(rs.getString("img1"));
				pro.setImg2(rs.getString("img2"));
				pro.setImg3(rs.getString("img3"));
				pro.setImg4(rs.getString("img4"));
				pro.setImg5(rs.getString("img5"));
				pro.setP7(rs.getString("p7"));
				pro.setP6(rs.getString("p6"));
				//p7涓哄浘鐗�
				
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return pro ;
	}
	

	@Override
	public int delete2Product(int pid) {
		// TODO Auto-generated method stub
		int flag= 0;
		conn = DBManager.getConnection();
		String sql = "delete from Product where pid =?";
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, pid);
			flag = ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO 鑷姩鐢熸垚鐨� catch 鍧�
			e.printStackTrace();
		}
		
		return flag;
	}


}
