package models;

import java.util.Scanner;

import io.XmlIO;
import ui.Menu;

public class MenuValue {

	static String nyttVal;
	static Scanner scan = new Scanner(System.in);
	public static boolean notCorrectValue = true;
	//static EditList el = new EditList();//Innehåller alla metoder till att manipulera myTodoList
	
	public MenuValue() {	
	}

	public static void start() {
		while (notCorrectValue){

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
				notCorrectValue = false;
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



