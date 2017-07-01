package ui;

import models.EditList;
import models.TodoItem;

public class MenuEdit {

	public static void visaMenuEdit(TodoItem td, int ID){
		System.out.println(EditList.toString(td));
		System.out.println();
		System.out.println("Choose property of ID " + ID + " to edit:");
		System.out.println("1. Todo name");
		System.out.println("2. End date");
		System.out.println("3. Status");
		System.out.println("4. Stop editing");

	}
}