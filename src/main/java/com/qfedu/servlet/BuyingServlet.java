package com.qfedu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qfedu.Dao.Icartitem;
import com.qfedu.Dao.Iproduct;
import com.qfedu.Dao.Iuser;
import com.qfedu.Dao.Impl.CartitemImpl;
import com.qfedu.Dao.Impl.ProductImpl;
import com.qfedu.Dao.Impl.UserImpl;
import com.qfedu.entity.Cartitem;
import com.qfedu.entity.Product;
import com.qfedu.entity.User;
import com.qfedu.service.CartitemService;
import com.qfedu.service.ProductService;
import com.qfedu.service.UserService;
import com.qfedu.service.Impl.UserServiceImpl;

/**
 * Servlet implementation class BuyingServlet
 */
@WebServlet("/BuyingServlet")
public class BuyingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SqlSession mSession; 
 /**
  * @see HttpServlet#HttpServlet()
  */
 public BuyingServlet() {
     super();
 }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		mSession = new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsReader("mybatis-config.xml"))
				.openSession(true);
		String Operation = request.getParameter("op");
		if(Operation==null){
			insert1(request, response);	
			
		}else if("insert".equalsIgnoreCase(Operation)){
			insert1(request, response);
			
		}else if("select".equalsIgnoreCase(Operation)){
			select(request, response);
			
		}else if("delete".equalsIgnoreCase(Operation)){
			delete(request, response);
			
		}else if("delete2".equalsIgnoreCase(Operation)){
			delete2(request, response);
			
		}else if("select2".equalsIgnoreCase(Operation)){
			select2(request, response);
			
		}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/*protected void insert1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("user");
		String pid1 = request.getParameter("id");
		int pid = Integer.parseInt(pid1);
		String count1 = request.getParameter("count");
		int count = Integer.parseInt(count1);
		Product pro = ipro.getProductId(pid);
		Double Price = Double.parseDouble(pro.getPrice());
		User use = iuser.getUserByName(name);
		
		Cartitem cart = new Cartitem();
		cart.setP8(pro.getP8());
		cart.setPname(pro.getPname());
		cart.setPrice(Price);
		cart.setName(use.getName());
		cart.setImg1(pro.getImg1());
		cart.setCount(count);
		boolean flag = icar.addCartitem(cart);
		if(flag) {
			response.sendRedirect("GouwucheServlet?op=select");
		}
		
		
		
	}

	*/
	protected void select2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("user");
		
		if("".equalsIgnoreCase(name)){
			
			request.getRequestDispatcher("/entry.html").forward(request, response);
			
		}else{
			request.getRequestDispatcher("BuyingServlet?op=insert").forward(request, response);
		}

		
		
	}
	
	protected void insert1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("user");
		String pid1 = request.getParameter("id");
		int pid = Integer.parseInt(pid1);
		String count1 = request.getParameter("count");
		int count = Integer.parseInt(count1);
		ProductService ipro = mSession.getMapper(ProductService.class);
		Product pro = ipro.getProductId(pid);
		Double Price = Double.parseDouble(pro.getPrice());
		UserService iuser = mSession.getMapper(UserService.class);
		User use = iuser.getUserByName(name);
		CartitemService icar = mSession.getMapper(CartitemService.class);
		Cartitem cart1 = icar.getCartitemId(pid);
		int count3=0;
		int flag = 0;
		

		if(cart1==null){
			Cartitem cart = new Cartitem();
			cart.setP8(pro.getP8());
			cart.setPname(pro.getPname());
			cart.setPrice(Price);
			cart.setName(use.getName());
			cart.setImg1(pro.getImg1());
			cart.setCount(count);
			cart.setPid(pid);
			flag = icar.addCartitem(cart);
			
		}else{
			int count2= cart1.getCount();
			count3 = count2+count;
			Cartitem cart2 = new Cartitem();
		
			cart2.setCount(count3);
			cart2.setPid(pid);
			flag= icar.updateCartitem(cart2);
					
					
		}
		

		if(flag>0) {
			response.sendRedirect("BuyingServlet?op=select");
		}
		
		
		
	}
	
	
	
	protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartitemService icar = mSession.getMapper(CartitemService.class);
		List<Cartitem> list = icar.getAll();
		request.getSession().setAttribute("list",list);
		System.out.println(list);
		request.getRequestDispatcher("/Orderr.jsp").forward(request, response);

		
		
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sid = request.getParameter("id");
		int caid = (sid ==null?0:Integer.parseInt(sid));
		Cartitem car = new Cartitem();
		car.setCaid(caid);
		CartitemService icar = mSession.getMapper(CartitemService.class);
		int flag = icar.deleteCartitem(car);
		request.setAttribute("pro", flag);
		if(flag>0){
		request.getRequestDispatcher("BuyingServlet?op=select").forward(request, response);
		}
		
		
	}
	
	protected void delete2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("user");
		Cartitem car = new Cartitem();
		car.setName(name);
		CartitemService icar = mSession.getMapper(CartitemService.class);
		int flag = icar.deleteAll(car);
		request.setAttribute("pro", flag);
		if(flag>0){
		request.getRequestDispatcher("BuyingServlet?op=select").forward(request, response);
		}
		
		
	}
}
