

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddProduct
 */
@MultipartConfig
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Part file=request.getPart("image");
	String pname=request.getParameter("pname");
	String type=request.getParameter("type");
	String filling=request.getParameter("filling");
	int price=Integer.parseInt(request.getParameter("price"));
	String imageFileName=file.getSubmittedFileName();
	System.out.println("image:"+imageFileName);
	
	String uploadPath="C:/Users/tanya/eclipse-workspace/chocoholics_1/src/main/webapp/images/"+imageFileName;
	//uploading to our selected image folder
	try {
	FileOutputStream fos=new FileOutputStream(uploadPath);
	InputStream is=file.getInputStream();
	byte[] data=new byte[is.available()];
	is.read(data);
	fos.write(data);
	fos.close();}
	catch(Exception e){
		e.printStackTrace();
	}
	///db 
	Connection con=null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/chocoholics","root","root");
		PreparedStatement pst = con.prepareStatement("insert into product(name,type,filling,price,image) values(?,?,?,?,?)");
		pst.setString(1,pname);
		pst.setString(2,type);
		pst.setString(3,filling);
		pst.setInt(4,price);
		pst.setString(5,imageFileName);
		int rowsmt=pst.executeUpdate();
		
		if(rowsmt>0) {
			
			System.out.print("uploaded product");
			response.sendRedirect("AdminHomePage.jsp");
		}
		else {
			System.out.print("failed to upload");
		}
		
		
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	}

}
