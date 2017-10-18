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

import com.qfedu.entity.OrderCartitem;
import com.qfedu.entity.Product;
import com.qfedu.service.OrderService;
import com.qfedu.service.UserService;
import com.qfedu.service.Impl.OrderServiceImpl;

/**
 * Servlet implementation class DingServlet
 */
@WebServlet("/DingServlet")
public class DingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SqlSession mSession;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DingServlet() {
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
		String op2 = request.getParameter("op2");
		if(op2!=null){
			Operation = null;
		}
		
			if(Operation==null) {
			
			select(request, response);
		}else if("update".equalsIgnoreCase(Operation)){
			update(request, response);
			
		}else if("update2".equalsIgnoreCase(Operation)){
			update2(request, response);
			
		}
	
	}

	protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService orde = mSession.getMapper(OrderService.class);
		List<OrderCartitem> list = orde.getOrder();
		request.getSession().setAttribute("list",list);
		System.out.println(list);
		request.getRequestDispatcher("admin/ding.jsp").forward(request, response);

		
		
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int oid = (sid == null ? 0 : Integer.parseInt(sid));
		OrderService orde = mSession.getMapper(OrderService.class);
		OrderCartitem ord = orde.getOrderId(oid);
		System.out.println(ord);
		request.getSession().setAttribute("ord", ord);
		request.getRequestDispatcher("admin/update.jsp").forward(request, response);
		
	}
	private void update2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid  = request.getParameter("id");
		int id =(sid ==null ?0:Integer.parseInt(sid));

		String prices1 = request.getParameter("prices");
		Double prices =Double.parseDouble(prices1);
		String oname = request.getParameter("oname");

		String otele = request.getParameter("otele");
		String addr = request.getParameter("addr");
		String poset = request.getParameter("poset");
		//String status= request.getParameter("status");
		String leibie= request.getParameter("leibie");
		OrderCartitem ord = new OrderCartitem();
		
		ord.setPrices(prices);
		ord.setOname(oname);
		ord.setOtele(otele);
		ord.setAddr(addr);
		ord.setPoset(poset);
		ord.setStatus(leibie);
		ord.setOid(id);
		OrderService orde = mSession.getMapper(OrderService.class);
		int flag = orde.updateOrder(ord);
		if(flag>0) {
			request.getRequestDispatcher("/DingServlet?op2=update").forward(request, response);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
