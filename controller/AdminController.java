package pizzaordersystem.controller;

import java.util.ArrayList;
import java.util.Scanner;
import pizzaordersystem.bean.Pizza;
import pizzaordersystem.service.AdminService;

public class AdminController {

	Scanner sc = new Scanner(System.in);
	
	AdminService adminService = new AdminService();


	public void addPizza() {
		Pizza newPizza = new Pizza();
		System.out.println("Enter pizza details ");
		System.out.println("Enter pizza name : ");
		newPizza.setPizzaName(sc.next());
		System.out.println("Enter pizza size (Small / Medium / Large): ");
		newPizza.setSize(sc.next());
		System.out.println("Enter pizza price : ");
		newPizza.setPrice(sc.nextFloat());
		System.out.println("Enter pizza type (Veg / Nonveg ): ");
		newPizza.setPizzaType(sc.next());
		System.out.println(adminService.addPizza(newPizza));
	}

	public void deletePizza() {
		System.out.println("Enter the name of the pizza to be deleted : ");
		System.out.println(adminService.deletePizza(sc.next()));
	}

	public void updatePizza() {
		Pizza newPizza = new Pizza();
		System.out.println("Enter the name of the pizza to be updated :");
		newPizza.setPizzaName(sc.next());
		System.out.println("Enter the updated size of the pizza :");
		newPizza.setSize(sc.next());
		System.out.println("Enter the updated price of the  pizza :");
		newPizza.setPrice(sc.nextFloat());
		System.out.println("Enter the updated type of the  pizza :");
		newPizza.setPizzaType(sc.next());
		System.out.println(adminService.updatePizza(newPizza));
	}

	public void displayPizza() {
		ArrayList<Pizza> pizzaList =adminService.displayPizza();
		
		Pizza pizzas[]= new Pizza[pizzaList.size()] ;
		for (int i = 0; i <pizzaList.size(); i++) {
			    pizzas[i]=pizzaList.get(i);
				System.out.println(pizzas[i]);
			}
		if(pizzaList.isEmpty()){
			System.out.println("No pizza in the list");
		}
	}
}
