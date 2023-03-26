package choco.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import choco.web.model.Order;
import choco.web.model.Product;

public class OrderDAO {
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    
    


	public OrderDAO() {
		super();
	}

	public boolean insertOrder(Order model) throws ClassNotFoundException {
        boolean result = false;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/chocoholics","root","root");
			PreparedStatement pst = con.prepareStatement("insert into orders (pid, u_id, o_quantity, o_date) values(?,?,?,?)");
          
         
            pst.setInt(1, model.getId());
            pst.setInt(2, model.getUid());
            pst.setInt(3, model.getQuantity());
            pst.setString(4, model.getDate());
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
	

    public List<Order> userOrders(int id) {
        List<Order> list = new ArrayList<>();
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/chocoholics","root","root");
			PreparedStatement pst = con.prepareStatement("select * from orders where u_id=? order by orders.o_id desc");
           
        
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                ProductDAO productDao = new ProductDAO();
                int pid = rs.getInt("pid");
                Product product = productDao.getSingleProduct(pid);
                order.setOrderId(rs.getInt("o_id"));
                order.setId(pid);
                order.setName(product.getName());
                order.setType(product.getType());
                order.setFilling(product.getFilling());
                order.setPrice(product.getPrice()*rs.getInt("o_quantity"));
                order.setQuantity(rs.getInt("o_quantity"));
                order.setDate(rs.getString("o_date"));
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void cancelOrder(int id) {
        //boolean result = false;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/chocoholics","root","root");
			PreparedStatement pst = con.prepareStatement("delete from orders where o_id=?");
            
            pst.setInt(1, id);
            pst.execute();
            //result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        //return result;
 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
