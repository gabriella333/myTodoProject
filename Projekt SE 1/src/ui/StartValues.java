package ui;

import models.Listan;
import models.TodoItem;

public class StartValues {
	
	public static void initValues() {
		//***Bara f�r att ha n�got i listan vid start***
		TodoItem t1 = new TodoItem("St�da", 3, 369);
		Listan.myTodoList.add(t1);
		TodoItem t2 = new TodoItem("Tr�na", 1, 456);
		Listan.myTodoList.add(t2);
		TodoItem t3 = new TodoItem("Flyga", 20, 777);
		Listan.myTodoList.add(t3);
		TodoItem t4 = new TodoItem("Tv�tta", 1, 123);
		Listan.myTodoList.add(t4);
	}
}
