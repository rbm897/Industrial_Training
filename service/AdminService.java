package pizzaordersystem.service;

import java.util.ArrayList;

import pizzaordersystem.bean.Pizza;
import pizzaordersystem.database.AdminDAO;
import pizzaordersystem.exception.InputException;

public class AdminService {
	AdminDAO adminDAO = new AdminDAO();
	public boolean checkCredentials(String username , String password){
		return adminDAO.checkCredentials(username,password);
	}
	public String addPizza(Pizza p) {
		try 
		{
			if (p == null||p.getPizzaName()=="null"){
				throw new NullPointerException();
			}
			if(p.getPizzaName()==" "||p.getPizzaName()==""||p.getPizzaName()==null){
				throw new InputException();
			}
			if ((("Small".equals(p.getSize())) || ("Medium".equals((p.getSize())))
					|| "Large".equals((p.getSize()))) != true) {
				throw new InputException();
			}
			if (p.getPrice() < 0) {
				throw new InputException();
			}
			if (((("Veg").equalsIgnoreCase(p.getPizzaType()))
					|| (("NonVeg").equalsIgnoreCase(p.getPizzaType()))) == false) {
				throw new InputException();
			}
		}
		catch (NullPointerException nep)
		{
			return "Pizza object cannot be null";
		}
		catch (InputException ie)
		{
			return "Invalid pizza details!\nPlease try again.";
		}
		return adminDAO.addPizza(p);
	}

	public ArrayList<Pizza> displayPizza() {
		return adminDAO.displayPizza();
	}

	public String updatePizza(Pizza pizzaUpdate) {
		try {
			if (pizzaUpdate == null) {
				throw new NullPointerException();
			}
			int i = 0;
			String pizzaName = pizzaUpdate.getPizzaName();
			for (i = 0; i < pizzaName.length(); i++) {
				if(((pizzaName.charAt(i) >= 'A')||(pizzaName.charAt(i) <= 'Z'))!=true) {
					throw new InputException();
				}
				else if(((pizzaName.charAt(i) >= 'a')||(pizzaName.charAt(i) <= 'Z'))!=true){
					throw new InputException();
				}
			}
			if ((("Small".equals(pizzaUpdate.getSize())) || ("Medium".equals((pizzaUpdate.getSize())))
					|| "Large".equals((pizzaUpdate.getSize()))) != true) {
				throw new InputException();
			}
			if (pizzaUpdate.getPrice() < 0) {
				throw new InputException();
			}
			if (((("Veg").equalsIgnoreCase(pizzaUpdate.getPizzaType()))
					|| (("NonVeg").equalsIgnoreCase(pizzaUpdate.getPizzaType()))) == false) {
				throw new InputException();
			}
		} catch (NullPointerException nep) {
			return "Pizza object cannot be null";
		} catch (InputException ie) {
			return "Invalid pizza details!\nPlease try again.";
		}
		return adminDAO.updatePizza(pizzaUpdate);
	}
	public String deletePizza(String pizzaName) {
		return adminDAO.deletePizza(pizzaName);
	}
}
