package pizzaordersystem.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import pizzaordersystem.bean.Pizza;

public class AdminDAO extends BaseDAO {
	Connection con = null;
	int i = 0;

	public boolean checkCredentials(String username, String password) {
		con = getConnection();
		String temp = null;
		boolean flag = false;
		try (PreparedStatement ps = con.prepareStatement("Select * from AdminDetails where username=?");) {
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				temp = rs.getString("Password");
				if (password.equals(temp)) {
					flag = true;
				}
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public String addPizza(Pizza pizza) {
		con = getConnection();
		try (CallableStatement cs = con.prepareCall("{?=call AddPizza(?,?,?,?)}");)
		{
			cs.setString(2, pizza.getPizzaName());
			cs.setString(3, pizza.getSize());
			cs.setFloat(4, pizza.getPrice());
			cs.setString(5, pizza.getPizzaType());

			cs.registerOutParameter(1, Types.INTEGER);

			i = cs.executeUpdate();

			pizza.setPizzaId(cs.getInt(1));
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i != 0) {
			return "Pizza added successfully.";
		} else {
			return "Pizza cannot be added!\nTry again.";
		}
	}

	public String updatePizza(Pizza updatedPizza) {
		con = getConnection();
		i = 0;
		try {
			CallableStatement cs = con.prepareCall("{? = call findPizza(?,?,?) }");
			cs.setString(2, updatedPizza.getPizzaName());
			cs.setString(3, updatedPizza.getSize());
			cs.setString(4, updatedPizza.getPizzaType());

			cs.registerOutParameter(1, Types.INTEGER);

			i = cs.executeUpdate();
			if (i != 0) {
				updatedPizza.setPizzaId(cs.getInt(1));
				cs = con.prepareCall("{call updatePizza(?,?,?,?,?)}");
				cs.setInt(1, updatedPizza.getPizzaId());
				cs.setString(2, updatedPizza.getPizzaName());
				cs.setString(3, updatedPizza.getSize());
				cs.setFloat(4, updatedPizza.getPrice());
				cs.setString(5, updatedPizza.getPizzaType());

				i = cs.executeUpdate();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i != 0) {
			return "Pizza updated.";
		} else {
			return "Pizza cannot be updaated.";
		}
	}

	public String deletePizza(String pizzaName) {

		con = getConnection();
		try (PreparedStatement ps = con.prepareStatement("Delete from PizzaMaster where pizzaName= ?");) {
			ps.setString(1, pizzaName);
			i = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i != 0) {
			return "Pizza deleted successfully.";
		} else {
			return "Pizza cannot be deleted.";
		}
	}

	public ArrayList<Pizza> displayPizza() {
		con = getConnection();
		ResultSet rs = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("Select * from PizzaMaster");
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
		try {
			while (rs.next()) {
				Pizza pizza = new Pizza();
				pizza.setPizzaId(rs.getInt(1));
				pizza.setPizzaName(rs.getString(2));
				pizza.setSize(rs.getString(3));
				pizza.setPrice(rs.getFloat(4));
				pizza.setPizzaType(rs.getString(5));
				pizzaList.add(pizza);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pizzaList;
	}
}
