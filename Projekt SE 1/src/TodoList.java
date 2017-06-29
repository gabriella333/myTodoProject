
import java.io.IOException;
import java.util.ArrayList;

public class TodoList {

	public static ArrayList<TodoItem> myTodoList = new ArrayList<>();

	//public static MyTodoArray<To> myTodoList<T  = new MyTodoArray();
	public static void main(String[] args) {

		Menu.visaMenu();

		//Bara för att ha något i listan vid start
		TodoItem t1 = new TodoItem("Städa", 3, 369);
		myTodoList.add(t1);
		TodoItem t2 = new TodoItem("Träna", 1, 456);
		myTodoList.add(t2);
		TodoItem t3 = new TodoItem("Flyga", 20, 777);
		myTodoList.add(t3);

		MenuValue mv = new MenuValue();

		// Loading with XmlIO, in this case the file might be missing.
		//		try {
		//			myTodoList  = XmlIO.loadObject("gabyprojekt1.xml", MyTodoArray.class);
		//		} catch (IOException ex) {
		//			System.out.println("Could not load todolist.xml");
		//		}
	}
}
