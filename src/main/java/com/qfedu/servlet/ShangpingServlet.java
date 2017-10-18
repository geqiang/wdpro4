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

import com.qfedu.Dao.Iproduct;
import com.qfedu.Dao.Impl.ProductImpl;
import com.qfedu.entity.Product;
import com.qfedu.service.ProductService;
import com.qfedu.service.Impl.ProductServiceImpl;

/**
 * Servlet implementation class ShangpingServlet
 */
@WebServlet("/ShangpingServlet")
public class ShangpingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SqlSession mSession;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShangpingServlet() {
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
		
		if(Operation==null) {
			
			select1(request, response);
		}else if("select2".equalsIgnoreCase(Operation)){
			select2(request, response);
		}else if("select3".equalsIgnoreCase(Operation)){
			select3(request, response);
		}else if("xiangqing".equalsIgnoreCase(Operation)){
			xiangqing(request, response);
		}
	
	}
	
	protected void select1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService ipro = mSession.getMapper(ProductService.class);
		List<Product> list = ipro.getProduct();
		request.setAttribute("list",list);
		request.getRequestDispatcher("flowRose.jsp").forward(request, response);

		
	}

	
	protected void select2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService ipro = mSession.getMapper(ProductService.class);
		List<Product> list = ipro.getProduct();
		request.setAttribute("list",list);
		request.getRequestDispatcher("yongsheng.jsp").forward(request, response);

		
	}
	protected void select3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService ipro = mSession.getMapper(ProductService.class);
		List<Product> list = ipro.getProduct();
		request.setAttribute("list",list);
		request.getRequestDispatcher("zhubao.jsp").forward(request, response);

		
	}
	private void xiangqing(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int pid = (sid == null ? 0 : Integer.parseInt(sid));
		ProductService ipro = mSession.getMapper(ProductService.class);
		Product pro = ipro.getProductId(pid);
		request.setAttribute("pro", pro);
		request.getRequestDispatcher("xiangqing.jsp").forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
