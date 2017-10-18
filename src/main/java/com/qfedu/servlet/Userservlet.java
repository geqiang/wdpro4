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

import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.service.Impl.UserServiceImpl;



/**
 * Servlet implementation class Userservlet
 */
@WebServlet("/Userservlet")
public class Userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    private SqlSession mSession;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userservlet() {
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
		
		
		if(op2 != null) {
			Operation = null;
		}
		
		if("zhuche".equalsIgnoreCase(Operation)){
			zhuche(request, response);			
		}else if("denglu".equalsIgnoreCase(Operation)){
			denglu(request, response);		
		}else if("zhucheTest".equalsIgnoreCase(Operation)){
			zhucheTest(request, response);
		}else if(Operation==null){
			selectuser(request, response);
		}else if("delete".equalsIgnoreCase(Operation)){
			delete(request, response);
		}else if("delete2".equalsIgnoreCase(Operation)){
			delete2(request, response);	
		}else if("zhuche1".equalsIgnoreCase(Operation)){
			zhuche1(request, response);				
		}else if("xiugai".equalsIgnoreCase(Operation)){
			xiugai(request, response);				
		}else if("xiugai1".equalsIgnoreCase(Operation)){
			xiugai1(request, response);				
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void zhuche(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("uid");
		String mail  = request.getParameter("mail");
		String tele = request.getParameter("tele");
		String pass1 =request.getParameter("pass1");
		UserService iuser = mSession.getMapper(UserService.class);

		User use = new User();
		use.setName(name);
		use.setMail(mail);
		use.setPassword(pass1);
		use.setTele(tele);
		
		System.out.println(use);
		boolean flag = iuser.addUser(use)>0;
		System.out.println(flag);
		if(flag){
			
		
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void zhuche1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("uid");
		String mail  = request.getParameter("mail");
		String tele = request.getParameter("tele");
		String pass1 =request.getParameter("pass1");
		UserService iuser = mSession.getMapper(UserService.class);

		User use = new User();
		use.setName(name);
		use.setMail(mail);
		use.setPassword(pass1);
		use.setTele(tele);
		
		System.out.println(use);
		boolean flag = iuser.addUser(use)>0;
		System.out.println(flag);
		if(flag){
			
		
			request.getRequestDispatcher("/Userservlet?op2=update").forward(request, response);
		}
	}
	protected void denglu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("userName");
		String pass1 = request.getParameter("userPass");
		UserService iuser = mSession.getMapper(UserService.class);
		User u = iuser.getUserByNamePass(name, pass1);
		
//		String pass1 = request.getParameter("pass1");
//		
//		User u = iuser.getUserByNamePass(name, pass1);
		if (u != null) {

			response.getWriter().write("true");
			
		}
		
	
	}
	protected void zhucheTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userName");
		UserService iuser = mSession.getMapper(UserService.class);
		
		User u = iuser.getUserByName(name);
		
		if (u == null) {
			response.getWriter().write("0");
			
		}
	}
	protected void selectuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService iuser = mSession.getMapper(UserService.class);

		List<User> list = iuser.getUser();
		request.setAttribute("list",list);
		request.getRequestDispatcher("/admin/user.jsp").forward(request, response);

		
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int uid = (sid ==null?0:Integer.parseInt(sid));
		UserService iuser = mSession.getMapper(UserService.class);
		User user = new User();
		user.setUid(uid);
		boolean flag = iuser.deleteUser(user);
		request.setAttribute("user", flag);
		if(flag){
		request.getRequestDispatcher("/Userservlet?op2=update").forward(request, response);
		}
		
		
	}
	protected void delete2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] sid = request.getParameterValues("chkuid");
		User emp = new User();
		UserService iuser = mSession.getMapper(UserService.class);
		for(String s :sid){
			boolean flag = iuser.delete2User(Integer.parseInt(s));
		}
		
			request.getRequestDispatcher("/Userservlet?op2=update").forward(request, response);
			}

	
	private void xiugai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		
		UserService iuser = mSession.getMapper(UserService.class);
		User u = iuser.getUserByName(sid);
		request.setAttribute("u", u);
		request.getRequestDispatcher("admin/userupdate.jsp").forward(request, response);
		
	}
	private void xiugai1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid  = request.getParameter("id");
		int id =(sid ==null ?0:Integer.parseInt(sid));
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");
		String tele = request.getParameter("tele");
		

		User user = new User();
		user.setUid(id);
		user.setName(name);
		user.setPassword(password);
		user.setMail(mail);
		user.setTele(tele);
		UserService iuser = mSession.getMapper(UserService.class);
		boolean flag = iuser.updateUser(user);
		if(flag) {
			request.getRequestDispatcher("/Userservlet?op2=update").forward(request, response);
		}
	}

}
