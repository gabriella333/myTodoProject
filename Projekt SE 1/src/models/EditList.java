package models;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.XmlIO;
import ui.TodoList;


public class EditList implements Iterator<TodoItem>{

	static Scanner scan = new Scanner(System.in);

	public EditList() {
	}

	//******************************
	//Alternativ 1. Visa hela listan
	//******************************
	public static void visaLista(){
		System.out.println("ID   Todo         Klar senast   Status");
		System.out.println("--   ----         -----------   ------");
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
		//TODO: Hur läser jag in en String med flera värden?
		//while (scan.hasNext()) nyttTodo = nyttTodo + " " + scan.next();
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
				if (nyttStatus.equals("Y")){
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
		boolean keepOnEditing= true;
		int counter = 0;
		System.out.println();
		System.out.print("Which todo-ID do you want to edit: ");
		try
		{
			int ID = Integer.parseInt(scan.next()); 
			Iterator<TodoItem> it = Listan.myTodoList.iterator();
			while (it.hasNext()){
				TodoItem td = it.next();
				if (td.getID() == ID){
					counter++;

					while(keepOnEditing) {

						System.out.println(toString(td));
						System.out.println("Choose property of ID " + ID + " to edit:");
						System.out.println("1. Todo name");
						System.out.println("2. End date");
						System.out.println("3. Status");
						System.out.println("4. Stop editing");
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
								System.out.println("Should be in the format yyyy-mm-dd");
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
		}
		catch (NumberFormatException e) {
			System.out.println("Incorrect ID value! Try again!");
			editTodoItem();
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
		if (removeStatus.equals("Y")){
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

	//*******************************************************
	//Alternativ 8. Avsluta program och spara ner till xml-fil
	//*******************************************************
	public static void stopProgram() {
		System.out.println("Stänger programmet och sparar ner i en xml fil (gabyprojekt1.xml)!");
		// Using XmlIO to save an object to file, errors are unexpected (write protected files)
		try {
			Listan listan = TodoList.listan;
			System.out.println(TodoList.listan.myTodoList.get(0).getTodoName());
			XmlIO.saveObject("gabyprojekt1.xml", listan);
		} 
		catch (IOException ex) {
			System.out.println("Här blir det fel!");
			Logger .getLogger(TodoList.class.getName()).log(Level.SEVERE, null, ex);
		}	 
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public TodoItem next() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String toString(TodoItem td) {
		return td.getID() +"  " + td.getTodoName()  + "          " + td.getEndDate() + "  " + td.isTodoStatus();
	}
}
