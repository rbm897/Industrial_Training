package pizzaordersystem.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import pizzaordersystem.bean.Pizza;

public class UserDAO extends BaseDAO {
	
	Connection con;
	public ArrayList<Pizza> displayPizza()
	{
		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
		con=getConnection();
		try(PreparedStatement ps = con.prepareStatement("Select * from pizzaMaster");
				ResultSet rs = ps.executeQuery();
				)
		{
			while(rs.next()){
				Pizza p = new Pizza();
				p.setPizzaId(rs.getInt(1));
				p.setPizzaName(rs.getString(2));
				p.setSize(rs.getString(3));
				p.setPrice(rs.getFloat(4));
				p.setPizzaType(rs.getString(5));
				pizzaList.add(p);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return pizzaList;
	}

	public String orderPizza(Pizza OrderedPizza) 
	{
		int i=0,orderNo = 0;
		try(
		CallableStatement cs = con.prepareCall("{? = call findPizza(?,?,?) }");
				)
		{
		cs.setString(2, OrderedPizza.getPizzaName());
		cs.setString(3, OrderedPizza.getSize());
		cs.setString(4, OrderedPizza.getPizzaType());
		cs.registerOutParameter(1, Types.INTEGER);

		i = cs.executeUpdate();
		orderNo = cs.getInt(1);
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(i==0)
		{
			return "Pizza order cannot be placed, please try again.";
		}
		else
		{
			return "Pizza ordered. Your order number is : "+ orderNo;
		}
	}


	public String displayPizzaOrder(int orderId) 
	{
		 int pizzaId=0;
	    String OrderedPizza=null;	
		try{
			PreparedStatement ps = con.prepareStatement("Select * from orderedPizza where OrderId=?");
		
			ps.setInt(1, orderId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			    pizzaId = rs.getInt(3);
			}
			ps=con.prepareStatement("Select * from pizzaMaster where pizzaid=?");
			ps.setInt(1,pizzaId);
			rs=ps.executeQuery();
			while(rs.next()){
				OrderedPizza = rs.getString("PizzaName")+" "+rs.getString("PizzaSize")+" "+rs.getFloat("PizzaPrice");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		if( OrderedPizza!=null)
		{
			return OrderedPizza;
		}
		else
		{
			return "No such order found";
		}
	}

	public boolean checkCredential(String user, String pass) 
	{
		con = getConnection();
		String temp1 = null;
		boolean flag1 = false;

		try  
		{
			PreparedStatement ps1 = con.prepareStatement("Select * from CustomerDetails where username=?");
			ps1.setString(1, user);

			ResultSet rs1 = ps1.executeQuery();

			while (rs1.next()) 
			{
				temp1 = rs1.getString("PASSWORD");
				if (pass.equals(temp1)) 
				{
					flag1 = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag1;
	}
}