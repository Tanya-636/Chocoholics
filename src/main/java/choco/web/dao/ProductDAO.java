package choco.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import choco.web.model.Cart;
import choco.web.model.Product;

public class ProductDAO {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	public ProductDAO() {
		super();
	}
	
	public List<Product> getAllProducts(){
		List<Product>products =new ArrayList<Product>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/chocoholics","root","root");
			PreparedStatement pst = con.prepareStatement("select * from product");
			rs=pst.executeQuery();
			while(rs.next()) {
				Product row= new Product();
				row.setId(rs.getInt("pid"));
				row.setName(rs.getString("name"));
				row.setType(rs.getString("type"));
				row.setFilling(rs.getString("filling"));
				row.setPrice(rs.getInt("price"));
				row.setImage(rs.getString("image"));
				
				products.add(row);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return products;
	}
	
	public Product getSingleProduct(int id) {
		 Product row = null;
	        try {
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");
    			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/chocoholics","root","root");
    			PreparedStatement pst = con.prepareStatement("select * from product where pid=?");
	          
	            pst.setInt(1, id);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	            	row = new Product();
	                row.setId(rs.getInt("pid"));
	                row.setName(rs.getString("name"));
	                row.setType(rs.getString("type"));
	                row.setFilling(rs.getString("filling"));
	                row.setPrice(rs.getInt("price"));
	                row.setImage(rs.getString("image"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return row;
	    }
	public double getTotalCartPrice(ArrayList<Cart> cartList) throws ClassNotFoundException {
        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                	Class.forName("com.mysql.cj.jdbc.Driver");
        			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/chocoholics","root","root");
        			PreparedStatement pst = con.prepareStatement("select price from product where pid=?");
              
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        sum+=rs.getInt("price")*item.getQuantity();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }

	
	public List<Cart> getCartProducts(ArrayList<Cart> cartList)
	{
		List<Cart> book = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                	Class.forName("com.mysql.cj.jdbc.Driver");
        			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/chocoholics","root","root");
        			PreparedStatement pst = con.prepareStatement("select * from product where pid=?");
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt("pid"));
                        row.setName(rs.getString("name"));
                        row.setType(rs.getString("type"));
                        row.setFilling(rs.getString("filling"));
                        
                        row.setPrice(rs.getInt("price")*item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        book.add(row);
                    }

                }
	}
        }
        catch(Exception e){
        	e.printStackTrace();
        }
		return book;
	}
}
        
