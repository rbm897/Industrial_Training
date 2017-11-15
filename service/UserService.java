package pizzaordersystem.service;

import pizzaordersystem.database.UserDAO;

import java.util.ArrayList;

import pizzaordersystem.bean.Pizza;

public class UserService 
{
	UserDAO userDAO = new UserDAO();
	public boolean checkCredential(String user , String pass)
	{
		return userDAO.checkCredential(user ,  pass);
	}
	public ArrayList<Pizza> displayPizza()
	{
		return userDAO.displayPizza();
	}

	public String orderPizza(Pizza p) 
	{
		return userDAO.orderPizza(p);
	}

	public String displayPizzaOrder(int orderId) 
	{
		return userDAO.displayPizzaOrder(orderId);
		
	}

	public void deletePizzaOrder() 
	{
		
	}
}
