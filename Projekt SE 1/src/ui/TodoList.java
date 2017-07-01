package ui;

import java.io.IOException;

import io.XmlIO;
import models.Listan;
import models.MenuValue;
import models.TodoItem;

public class TodoList {

	public static Listan listan = new Listan();

	public static void start() {

//				// Loading with XmlIO, in this case the file might be missing.
//				try {
//					listan  = XmlIO.loadObject("gabyprojekt1.xml", Listan.class);
//				} catch (IOException ex) {
//					System.out.println("Could not load todolist.xml");
//				}
//				System.out.println(listan);
//				System.out.println(Listan.myTodoList);
		
		//***Bara för att ha något i listan vid start***
		TodoItem t1 = new TodoItem("Städa", 3, 369);
		Listan.myTodoList.add(t1);
		TodoItem t2 = new TodoItem("Träna", 1, 456);
		Listan.myTodoList.add(t2);
		TodoItem t3 = new TodoItem("Flyga", 20, 777);
		Listan.myTodoList.add(t3);
		
//Endast dessa två rader finns sedan!
		Menu.visaMenu();
		MenuValue.start();
	}
}
