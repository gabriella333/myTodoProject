import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuValue {

	String nyttVal;
	Scanner scan = new Scanner(System.in);
	boolean notCorrectValue = true;
	EditList el = new EditList();//Innehåller alla metoder till att manipulera myTodoList

	public MenuValue() {

		while (notCorrectValue){
			System.out.println();
			System.out.print("Välj alternativ 1-8 (eller M för att visa meny): ");
			nyttVal = scan.next();

			switch(nyttVal){
			default:
				System.out.println("Du måste ange ett av alternativen 1-8 eller M");
				nyttVal = scan.next();
				break;
			case "1":
				el.visaLista();
				//notCorrectValue = false;
				break;
			case "2":
				el.addTodoItem();
				//notCorrectValue = false;
				break;
			case "3":
				el.removeTodoItem();
				//notCorrectValue = false;
				break;
			case "4":
				el.changeStatusTodoItem();
				//notCorrectValue = false;
				break;
			case "5":
				el.findTodoItem();
				//notCorrectValue = false;
				break;
			case "6":
				el.editTodoItem();
				//notCorrectValue = false;
				break;
			case "7":
				el.deleteDoneTodoItem();
				//notCorrectValue = false;
				break;
			case "8":
				System.out.println("Stänger programmet och sparar ner i en xml fil (gabyprojekt1.xml)!");
				
//				// Using XmlIO to save an object to file, errors are unexpected (write protected files)
//                try {
//                    XmlIO.saveObject("gabyprojekt1.xml", TodoList.myTodoList);
//                    break;
//                } catch (IOException ex) {
//                    Logger.getLogger(TodoList.class.getName()).log(Level.SEVERE, null, ex);
//                }
//				//XmlIO.saveObject("gabyprojekt1.xml", TodoList.myTodoList);
                
				notCorrectValue = false;
				break;
			case "M":
				Menu.visaMenu();
				break;
			}
		}
	}
}



