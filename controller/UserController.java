package pizzaordersystem.controller;

import java.util.ArrayList;
import java.util.Scanner;

import pizzaordersystem.bean.Pizza;

import pizzaordersystem.service.UserService;

public class UserController {
	UserService userService = new UserService();
	public void displayPizza()
	{
		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
		pizzaList.addAll(userService.displayPizza());
		for(int i=0;i<pizzaList.size();i++)
		{
			System.out.println(pizzaList);
		}
	}

	public void orderPizza() 
	{
		Scanner sc = new Scanner(System.in);
		Pizza p = new Pizza();
		System.out.println("Enter the name of the pizza to be ordered :");
		p.setPizzaName(sc.next());
		System.out.println("Enter the size of the pizza :");
		p.setSize(sc.next());
		System.out.println("Enter the type of the pizza :");
		p.setPizzaType(sc.next());
		sc.close();
		System.out.println(userService.orderPizza(p));
	}

	public void displayPizzaOrder() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Order number : ");
		int orderNo = sc.nextInt();
		System.out.println(userService.displayPizzaOrder(orderNo));
		sc.close();
	}

	public void deletePizzaOrder() 
	{
		
	}
}
