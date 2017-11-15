package pizzaordersystem;

import java.util.Scanner;

import pizzaordersystem.controller.AdminController;
import pizzaordersystem.controller.UserController;
import pizzaordersystem.service.AdminService;
import pizzaordersystem.service.UserService;

public class PizzaOrderMain {

	public static void adminCredentialCheck() {
		Scanner sc = new Scanner(System.in);
		String username, password;

		System.out.println("---------------------------------------------------------------------------------");

		System.out.println("Enter username : ");
		username = sc.next();

		System.out.println("Enter password : ");
		password = sc.next();

		if (new AdminService().checkCredentials(username, password)) {
			System.out.println("Successfully logged in!");
			System.out.println("---------------------------------------------------------------------------------");
			showAdminMenu();
		} else {
			System.out.println("Invalid credentials");
		}
		sc.close();
	}

	public static void customerCredentialCheckMenu() {
		Scanner sc = new Scanner(System.in);
			String uname, pass;

			System.out.println("---------------------------------------------------------------------------------");

			System.out.println("Enter username : ");
			uname = sc.next();

			System.out.println("Enter password : ");
			pass = sc.next();

			if ((new UserService().checkCredential(uname,pass))) {
				System.out.println("Successfully logged in!");
				System.out.println("---------------------------------------------------------------------------------");
				showUserMenu();
			} else {
				System.out.println("Invalid credentials");
			}
		
		sc.close();
	}

	private static void showUserMenu() 
	{
		UserController userController = new UserController();
		Scanner sc = new Scanner(System.in);
		char choice = 'y';
		int ch;
		do {
			System.out.println("\t\tUser Menu\n1.Pizza Menu\n2.Order Pizza" + "\n3.Display Pizza order"+ "\nEnter your choice(1/2/3):");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				userController.displayPizza();
				break;
			case 2:
				userController.orderPizza();
				break;
			case 3:
				userController.displayPizzaOrder();
				break;
			
			default:
				System.out.println("Invalid input!\n TRY AGAIN");
			}
			System.out.println("Do you want to perform more operations?(y/n) :");
			choice = sc.next().charAt(0);
		} while (choice == 'y');
		sc.close();
		if (choice == 'n') {
			System.out.println("---------------------------------------------------------------------------------");
		}

	}

	public static void showAdminMenu() {
		AdminController adminController = new AdminController();
		Scanner sc = new Scanner(System.in);
		char choice = 'y';
		int ch;
		do {
			System.out.println("\t\tAdmin Menu\n1.Add Pizza\n2.Delete Pizza" + "\n3.Update Pizza\n4.Display Pizza"
					+ "\nEnter your choice(1/2/3/4):");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				adminController.addPizza();
				break;
			case 2:
				adminController.deletePizza();
				break;
			case 3:
				adminController.updatePizza();
				break;
			case 4:
				adminController.displayPizza();
				break;
			default:
				System.out.println("Invalid input!\n TRY AGAIN");
			}
			System.out.println("Do you want to perform more operations?(y/n) :");
			choice = sc.next().charAt(0);
		} while (choice == 'y');
		sc.close();
		if (choice == 'n') {
			System.out.println("---------------------------------------------------------------------------------");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;

		while (choice == 0) {
			System.out.println("Press 1 if you're an admin \nPress 2 if you're a customer ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("You chose Admin");
				adminCredentialCheck();
				break;

			case 2:
				System.out.println("You chose Customer");
				customerCredentialCheckMenu();
				break;

			default:
				System.out.println("Invalid Choice");
			}
		}
		sc.close();
	}

}
