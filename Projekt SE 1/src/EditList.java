import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EditList implements Iterator<TodoItem>{

	Scanner scan = new Scanner(System.in);

	public EditList() {
	}

	//******************************
	//Alternativ 1. Visa hela listan
	//******************************
	public void visaLista(){
		System.out.println("ID   Todo         Klar senast   Status");
		System.out.println("--   ----         -----------   ------");
		Iterator<TodoItem> it = TodoList.myTodoList.iterator(); 
		while (it.hasNext()){
			TodoItem td = it.next();
			System.out.println(toString(td));
		}
	}

	//***************************************
	//Alternativ 2. Lägg till en ny aktivitet
	//***************************************
	public void addTodoItem() {
		System.out.println();
		System.out.print("What todo: ");
		String nyttTodo = scan.next(); //TODO: Hur läser jag in en String med flera värden?
		//while (scan.hasNext()) nyttTodo = nyttTodo + " " + scan.next();
		System.out.print("No of days will it take to execute: ");
		int nyttTodoDays = Integer.parseInt(scan.next()); //TODO: NumberFormatException
		int ID = (int) Math.ceil(Math.random()*1000);
		TodoItem td = new TodoItem(nyttTodo, nyttTodoDays, ID);
		TodoList.myTodoList.add(td);
	}

	//***********************************
	//Alternativ 3. Tag bort en aktivitet
	//***********************************
	public void removeTodoItem() {
		int counter = 0;
		System.out.println();
		System.out.print("Which todo-ID to remove: ");
		int ID = Integer.parseInt(scan.next()); //TODO: NumberFormatException
		Iterator<TodoItem> it = TodoList.myTodoList.iterator();
		while (it.hasNext()){
			TodoItem td = it.next();
			if (td.ID == ID){
				counter++;
				System.out.println("td name = " + td.todoName);
				TodoList.myTodoList.remove(td);
				break;
			}
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
	public void changeStatusTodoItem(){
		System.out.println();
		System.out.print("Which todo-ID to change status: ");
		int ID = Integer.parseInt(scan.next()); //TODO: exception!
		changeStatusTodoItem(ID);
	}

	public void changeStatusTodoItem(int ID){
		int counter = 0;

		Iterator<TodoItem> it = TodoList.myTodoList.iterator();
		while (it.hasNext()){
			TodoItem td = it.next();
			if (td.ID == ID){
				counter++;
				System.out.println("Status on ID " + td.ID + " is " + td.todoStatus);
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
	public void findTodoItem(){
		int counter = 0;
		System.out.println();
		System.out.print("Which todo activity are you looking for: ");
		String todoName = scan.next();
		Iterator<TodoItem> it = TodoList.myTodoList.iterator();
		while (it.hasNext()){
			TodoItem td = it.next();
			if (td.todoName.equals(todoName)){
				counter++;
				//System.out.println("The activity " + td.todoName + " was found!");
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
	public void editTodoItem(){
		boolean keepOnEditing= true;
		int counter = 0;
		System.out.println();
		System.out.print("Which todo-ID do you want to edit: ");
		int ID = Integer.parseInt(scan.next()); //TODO: exception!
		Iterator<TodoItem> it = TodoList.myTodoList.iterator();
		while (it.hasNext()){
			TodoItem td = it.next();
			if (td.ID == ID){
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
						System.out.println("New name for todo (" + td.todoName + ") :");
						td.setTodoName(scan.next());
						break;
					case "2":
						System.out.println("New end date for todo ("+ td.endDate + "): ");
						String inEndDate = scan.next();						
						//TODO: Kolla format på datum! Exception!!! 
						td.setEndDate(LocalDate.parse(inEndDate)); //DateTimeParseException
						break;
					case "3":
						changeStatusTodoItem(td.ID);
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
	public void deleteDoneTodoItem(){
		System.out.println();
		System.out.print("Remove all activities with status DONE (Y/N):");
		String removeStatus = scan.next();
		if (removeStatus.equals("Y")){
			Iterator<TodoItem> it = TodoList.myTodoList.iterator();
			while (it.hasNext()){
				TodoItem td = it.next();
				if (td.isTodoStatus()){
					System.out.println("td name = " + td.todoName + " is now removed");
					it.remove();
				}
			}
			System.out.println("All activities with status DONE is now removed");
			return;
		} else if (removeStatus.equals("N")) return;
		this.deleteDoneTodoItem();		
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

	public String toString(TodoItem td) {
		return td.ID +"  " + td.todoName  + "          " + td.endDate + "  " + td.todoStatus;
	}
}
