package models;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.Scanner;

import ui.MenuEdit;

public class EditList implements Iterator<TodoItem>{

	static Scanner scan = new Scanner(System.in);

	//******************************
	//Alternativ 1. Visa hela listan
	//******************************
	public static void visaLista(){
		printHeader();
		Iterator<TodoItem> it = Listan.myTodoList.iterator(); 
		while (it.hasNext()){
			TodoItem td = it.next();
			System.out.println(toString(td));
		}
	}

	//***************************************
	//Alternativ 2. Lägg till en ny aktivitet
	//***************************************
	public static void addTodoItem() {
		System.out.println();
		System.out.print("What todo: ");
		String nyttTodo = scan.next(); 
		System.out.print("No of days it will take to execute: ");
		try {
			int nyttTodoDays = Integer.parseInt(scan.next()); 
			int ID = (int) Math.ceil(Math.random()*1000);
			TodoItem td = new TodoItem(nyttTodo, nyttTodoDays, ID);
			Listan.myTodoList.add(td);
		} 
		catch (NumberFormatException e)
		{
			System.out.println("You must give a number! Try again!");
			addTodoItem();
		}
	}

	//***********************************
	//Alternativ 3. Tag bort en aktivitet
	//***********************************
	public static void removeTodoItem() {
		int counter = 0;
		System.out.println();
		System.out.print("Which todo-ID to remove: ");
		try
		{
			int ID = Integer.parseInt(scan.next());
			Iterator<TodoItem> it = Listan.myTodoList.iterator();
			while (it.hasNext()){
				TodoItem td = it.next();
				if (td.getID() == ID){
					counter++;
					System.out.println("ID " + td.getID() + " is now removed!");
					Listan.myTodoList.remove(td);
					break;
				}
			}	
		}
		catch (NumberFormatException e)
		{
			System.out.println("Incorrect ID value! Try again!");
			removeTodoItem();
		}
		if (counter == 0) {
			System.out.println("No such ID was found!");
		}
	}
	//**********************************************
	// LAMBDA funktionell programmering
	//
	//TodoList.myTodoList.removeIf(x -> x.ID == ID);
	//**********************************************


	//******************************************
	//Alternativ 4. Ändra status på en aktivitet
	//******************************************
	public static void changeStatusTodoItem(){
		System.out.println();
		System.out.print("Which todo-ID to change status: ");
		try 
		{
			int ID = Integer.parseInt(scan.next());
			changeStatusTodoItem(ID);
		}
		catch (NumberFormatException e)
		{
			System.out.println("Incorrect ID value! Try again!");
			changeStatusTodoItem();
		}
	}

	public static void changeStatusTodoItem(int ID){
		int counter = 0;

		Iterator<TodoItem> it = Listan.myTodoList.iterator();
		while (it.hasNext()){
			TodoItem td = it.next();
			if (td.getID() == ID){
				counter++;
				System.out.println("Status on ID " + td.getID() + " is " + td.isTodoStatus());
				System.out.println("Change status (Y/N): ");
				String nyttStatus = scan.next();
				if (nyttStatus.equals("Y") || nyttStatus.equals("y")){
					if (td.isTodoStatus()) {
						td.setTodoStatus(false);
					} else td.setTodoStatus(true);
				}
				else  {
					System.out.println("Ingen status är ändrad!");
					return;
				}	
			}
		}
		if (counter == 0) {
			System.out.println("No such ID was found!");
		}
	}


	//**********************************************
	//Alternativ 5. Leta efter en specifik aktivitet
	//**********************************************
	public static void findTodoItem(){
		int counter = 0;
		System.out.println();
		System.out.print("Which todo activity are you looking for: ");
		String todoName = scan.next();
		Iterator<TodoItem> it = Listan.myTodoList.iterator();
		while (it.hasNext()){
			TodoItem td = it.next();
			if (td.getTodoName().equals(todoName)){
				counter++;
				System.out.println(toString(td));
			} 
		}
		if (counter == 0) {
			System.out.println("No such activity was found!");
		}
	}

	//**********************************
	//Alternativ 6. Editera en aktivitet
	//**********************************
	public static void editTodoItem(){		
		System.out.println();
		System.out.print("Which todo-ID do you want to edit: ");
		try 
		{
			int ID = Integer.parseInt(scan.next());
			editTodoItem(ID);
		}
		catch (NumberFormatException e)
		{
			System.out.println("Incorrect ID value! Try again!");
			editTodoItem();
		}
	}

	public static void editTodoItem(int ID){
		int counter = 0;
		boolean keepOnEditing = true;
		Iterator<TodoItem> it = Listan.myTodoList.iterator();
		while (it.hasNext()){
			TodoItem td = it.next();
			if (td.getID() == ID){
				counter++;
				while(keepOnEditing) {
					MenuEdit.visaMenuEdit(td, ID);
					String editVal = scan.next();
					switch(editVal) {
					default:
						System.out.println("Du måste ange ett av alternativen 1-4");
						break;
					case "1":
						System.out.println("New name for todo (" + td.getTodoName() + ") :");
						td.setTodoName(scan.next());
						break;
					case "2":
						System.out.println("New end date for todo ("+ td.getEndDate() + "): ");
						String inEndDate = scan.next();						
						try
						{
							td.setEndDate(LocalDate.parse(inEndDate)); 
						}
						catch (DateTimeParseException dte)
						{
							System.out.println("Wrong format on date.");
							System.out.println("Date should be in the format yyyy-mm-dd");
						}
						break;
					case "3":
						changeStatusTodoItem(td.getID());
						break;
					case "4":
						keepOnEditing = false;
						break;
					}
				}
			}
		}

		if (counter == 0) {
			System.out.println("No such ID was found!");
		}
	}

	//*******************************************************
	//Alternativ 7. Tag bort alla aktiviteter med status DONE
	//*******************************************************
	public static void deleteDoneTodoItem(){
		System.out.println();
		System.out.print("Remove all activities with status DONE (Y/N):");
		String removeStatus = scan.next();
		boolean finnsEj= true;
		if (removeStatus.equals("Y") || removeStatus.equals("y")){
			Iterator<TodoItem> it = Listan.myTodoList.iterator();
			while (it.hasNext()){
				TodoItem td = it.next();
				if (td.isTodoStatus()){
					finnsEj = false;
					System.out.println("Activity " + td.getTodoName() + " is now removed");
					it.remove();
				}	
			}
			if (finnsEj) System.out.println("No activities with status DONE was found!");
			return;
		} else System.out.println("No activity was removed!"); return;	
	}

	//*****************************
	//Alternativ 8. Avsluta program
	//*****************************
	public static void stopProgram() {
		System.out.println("Stänger programmet!");
	}

	@Override
	public boolean hasNext() {
		return false;
	}
	@Override
	public TodoItem next() {
		return null;
	}

	public static void printHeader(){
		System.out.println();
		System.out.println("ID   Todo         Klar senast   Status");
		System.out.println("--   ----         -----------   ------");
	}

	public static String toString(TodoItem td) {
		return td.getID() +"  " + td.getTodoName()  + "          " + td.getEndDate() + "  " + td.isTodoStatus();
	}
}
