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
import com.qfedu.service.Impl.ProductServiceImpl;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SqlSession mSession; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
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
		String img1=null;
		String img2=null;
		String img3=null;
		String img4=null;
		String img5=null;	
		String p7 = null;
		String p6=null;
		Product pro = new Product();
		try {
				
				DiskFileItemFactory factory =  new DiskFileItemFactory();
				ServletFileUpload fileUpload = new ServletFileUpload(factory);
				List<FileItem> list = fileUpload.parseRequest(request);
				for(FileItem item : list){
					if(item.isFormField()){
						String fileName = item.getFieldName();
						if("pname".equalsIgnoreCase(fileName)){
							String pname = item.getString("utf-8");
							System.out.println(pname);
							pro.setPname(pname);
						}
						if("price".equalsIgnoreCase(fileName)){
							String price = item.getString("utf-8");
							System.out.println(price);
							pro.setPrice(price);
						}
						if("p8".equalsIgnoreCase(fileName)){
							String p8 = item.getString("utf-8");
							System.out.println(p8);
							pro.setP8(p8);
						}
						if("descr".equalsIgnoreCase(fileName)){
							String descr = item.getString("utf-8");
							System.out.println(descr);
							pro.setDescr(descr);
						}
						if("kuchun".equalsIgnoreCase(fileName)){
							String kuchun1 = item.getString("utf-8");
							int kuchun= Integer.parseInt(kuchun1);
							System.out.println(kuchun);
							pro.setKuchun(kuchun);
						}
						if("color".equalsIgnoreCase(fileName)){
							String color = item.getString("utf-8");
							System.out.println(color);
							pro.setColor(color);
						}
						if("P6".equalsIgnoreCase(fileName)) {
							String P6 = item.getString("utf-8");
							System.out.println(P6);
							pro.setP6(P6);
							
						}
						if("leibie".equalsIgnoreCase(fileName)) {
							String leibie1 = item.getString("utf-8");
							int leibie = Integer.parseInt(leibie1);
							System.out.println(leibie);
							pro.setCategory(leibie);
							
						}
						
			
					}else{
						
						String filedName = item.getFieldName();
						
						if("img1".equalsIgnoreCase(filedName)){
						String fileName = item.getName();	
						File f = new File(fileName);
						img1=f.getName();
						
						String path =request.getRealPath("/images") + File.separator + f.getName();
						System.out.println(path);
						File file = new File(path);
						
							item.write(file);
							pro.setImg1(fileName);
						}	
						
						if("img2".equalsIgnoreCase(filedName)){
							String fileName = item.getName();	
							File f = new File(fileName);
							img2=f.getName();
							
							String path =request.getRealPath("/images") + File.separator + f.getName();
							System.out.println(path);
							File file = new File(path);
							
								item.write(file);
								pro.setImg2(fileName);
							}
						if("img3".equalsIgnoreCase(filedName)){
							String fileName = item.getName();	
							File f = new File(fileName);
							img3=f.getName();
							
							String path =request.getRealPath("/images") + File.separator + f.getName();
							System.out.println(path);
							File file = new File(path);
							
								item.write(file);
								pro.setImg3(fileName);
							}
						
						if("img4".equalsIgnoreCase(filedName)){
							String fileName = item.getName();	
							File f = new File(fileName);
							img4=f.getName();
							
							String path =request.getRealPath("/images") + File.separator + f.getName();
							System.out.println(path);
							File file = new File(path);
							
								item.write(file);
								pro.setImg4(fileName);
							}
						if("img5".equalsIgnoreCase(filedName)){
							String fileName = item.getName();	
							File f = new File(fileName);
							img5=f.getName();
							
							String path =request.getRealPath("/images") + File.separator + f.getName();
							System.out.println(path);
							File file = new File(path);
							
								item.write(file);
								pro.setImg5(fileName);
							}
						if("p7".equalsIgnoreCase(filedName)){
							String fileName = item.getName();	
							File f = new File(fileName);
							p7=f.getName();
							
							String path =request.getRealPath("/images") + File.separator + f.getName();
							System.out.println(path);
							File file = new File(path);
							
								item.write(file);
								pro.setP7(fileName);
							}

	
					}
						}
				ProductService ipro = mSession.getMapper(ProductService.class);
				int flag = ipro.addProduct(pro);
				if(flag>0) {
					
					request.getRequestDispatcher("/ProductServlet?op2=update").forward(request, response);
				}
				
				
				
						}catch (Exception e) {
						
							e.printStackTrace();
						}
			
			
			
			
			
		
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
