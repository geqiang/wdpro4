package com.qfedu.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qfedu.entity.Cartitem;
import com.qfedu.entity.OrderCartitem;
import com.qfedu.service.CartitemService;
import com.qfedu.service.OrderService;
import com.qfedu.service.Impl.CartitemServiceImpl;
import com.qfedu.service.Impl.OrderServiceImpl;

import javafx.scene.chart.PieChart.Data;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SqlSession mSession; 
	
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
			
			tijiao(request, response);
		}else if("select".equalsIgnoreCase(Operation)){
			select(request, response);
		}else if("remai".equalsIgnoreCase(Operation)){
			remai(request, response);
		}
	
	
	}

	protected void tijiao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String oname = request.getParameter("contactname");
		String otele = request.getParameter("mobile");
		String addr = request.getParameter("dizhi");
		String poset = request.getParameter("youbian");
		String name = request.getParameter("user");
		CartitemService cart = mSession.getMapper(CartitemService.class);
		
		
		OrderCartitem ord = new OrderCartitem();
		boolean flag =false;
		List<Cartitem> list =(List<Cartitem>)request.getSession().getAttribute("list");
		long time = System.currentTimeMillis();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
		OrderService orde = mSession.getMapper(OrderService.class);
		for(Cartitem c:list){
			ord.setPid(c.getPid());
			ord.setO1(c.getPname());
			ord.setO2(c.getImg1());
			ord.setO3(c.getCount());
			
		ord.setOname(oname);
		ord.setOtele(otele);
		ord.setAddr(addr);
		ord.setName(name);
		ord.setPoset(poset);
		
		
		ord.setTime(sdf.format(date));
		ord.setStatus("未支付");
		ord.setPrices(c.getPrice());
		
	
		flag = orde.addOrder(ord)>0;
		}
		if(flag) {
			response.sendRedirect("dingdan1.jsp");
		}
			
		}
	
	protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService orde = mSession.getMapper(OrderService.class);
		List<OrderCartitem> list = orde.getOrder();
		request.getSession().setAttribute("list",list);
		System.out.println(list);
		request.getRequestDispatcher("/dingdan.jsp").forward(request, response);

		
		
	}
	
protected void remai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	OrderService orde = mSession.getMapper(OrderService.class);
		List<OrderCartitem> list = orde.getremai();
		request.setAttribute("list",list);
		System.out.println(list);
		request.getRequestDispatcher("/remai.jsp").forward(request, response);

		
		
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
