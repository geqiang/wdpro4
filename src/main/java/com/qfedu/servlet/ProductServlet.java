package com.qfedu.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qfedu.Dao.Iproduct;
import com.qfedu.Dao.Impl.ProductImpl;
import com.qfedu.entity.Product;
import com.qfedu.service.ProductService;
import com.qfedu.service.UserService;
import com.qfedu.service.Impl.ProductServiceImpl;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SqlSession mSession;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
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
			
		}else if("delete".equalsIgnoreCase(Operation)){
			delete(request, response);
		}else if("add".equalsIgnoreCase(Operation)){
			add(request, response);
		}else if("delete2".equalsIgnoreCase(Operation)){
			delete2(request, response);
		}
		
		
	}
	
	protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService ipro = mSession.getMapper(ProductService.class);
		List<Product> list = ipro.getProduct();
		request.setAttribute("list",list);
		request.getRequestDispatcher("admin/products.jsp").forward(request, response);

		
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int pid = (sid == null ? 0 : Integer.parseInt(sid));
		ProductService ipro = mSession.getMapper(ProductService.class);
		Product pro = ipro.getProductId(pid);
		request.setAttribute("pro", pro);
		request.getRequestDispatcher("admin/product.jsp").forward(request, response);
		
	}

	private void update2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid  = request.getParameter("id");
		int id =(sid ==null ?0:Integer.parseInt(sid));
		String pname = request.getParameter("pname");
		String price = request.getParameter("price");
		String kuchun1 = request.getParameter("kuchun");
		int kuchun =(kuchun1 ==null ?0:Integer.parseInt(kuchun1));
		String color = request.getParameter("color");
		String p6 = request.getParameter("p6");
		String descr = request.getParameter("descr");
		String leibie= request.getParameter("leibie");
		String P8 = request.getParameter("p8");
		int leibie1 = Integer.parseInt(leibie);
		Product pro = new Product();
		pro.setPid(id);
		pro.setPname(pname);
		pro.setPrice(price);
		pro.setKuchun(kuchun);
		pro.setColor(color);
		pro.setP6(p6);
		pro.setDescr(descr);
		pro.setCategory(leibie1);
		pro.setP8(P8);
		ProductService ipro = mSession.getMapper(ProductService.class);
		int flag = ipro.updateProduct(pro);
		if(flag>0) {
			request.getRequestDispatcher("/ProductServlet?op2=update").forward(request, response);
		}
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int pid = (sid ==null?0:Integer.parseInt(sid));
		Product pro = new Product();
		pro.setPid(pid);
		ProductService ipro = mSession.getMapper(ProductService.class);
		int flag = ipro.deleteProduct(pro);
		request.setAttribute("pro", flag);
		if(flag>0){
		request.getRequestDispatcher("/ProductServlet?op2=update").forward(request, response);
		}
		
		
	}
	
	protected void delete2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] sid = request.getParameterValues("chkuid");
		Product pro = new Product();
		ProductService ipro = mSession.getMapper(ProductService.class);
		for(String s :sid){
			int flag = ipro.delete2Product(Integer.parseInt(s));
		}
		
			request.getRequestDispatcher("/ProductServlet?op2=update").forward(request, response);
			}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/add.jsp").forward(request, response);
		
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
