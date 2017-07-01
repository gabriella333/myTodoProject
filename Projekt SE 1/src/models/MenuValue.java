package models;

import java.util.Scanner;
import ui.Menu;

public class MenuValue {

	static String nyttVal;
	static Scanner scan = new Scanner(System.in);
	public static boolean correctValue = true;
	
	public static void start() {
		while (correctValue){

			System.out.print("Välj alternativ 1-8 (eller M för att visa meny): ");
			nyttVal = scan.next();

			switch(nyttVal){
			default:
				System.out.println("Du måste ange ett av alternativen 1-8 eller M");
				break;
			case "1":
				EditList.visaLista();
				break;
			case "2":
				EditList.addTodoItem();
				break;
			case "3":
				EditList.removeTodoItem();
				break;
			case "4":
				EditList.changeStatusTodoItem();
				break;
			case "5":
				EditList.findTodoItem();
				break;
			case "6":
				EditList.editTodoItem();
				break;
			case "7":
				EditList.deleteDoneTodoItem();
				break;
			case "8":
				EditList.stopProgram();
				correctValue = false;
				break;
			case "M":
				Menu.visaMenu();
				break;
			case "m":
				Menu.visaMenu();
				break;
			}
		}
	}
}



