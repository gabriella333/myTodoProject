import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {


	public static void main(String[] args) {

		int nyttVal;
		int valtAlternativ;
		boolean notCorrectValue = true;
		Scanner scan = new Scanner(System.in);
		ArrayList<TodoItem> myTodoList = new ArrayList<>();

		Menu visaMeny = new Menu();
		valtAlternativ = visaMeny.nyttVal;

		while (notCorrectValue){
			switch(valtAlternativ){
			default:
				System.out.println("Du måste ange ett av alternativen 1-8");
				nyttVal = scan.nextInt();
				break;
			case 1:

				notCorrectValue = false;
				break;
			case 2:

				notCorrectValue = false;
				break;
			case 3:

				notCorrectValue = false;
				break;
			case 4:

				notCorrectValue = false;
				break;
			case 5:

				notCorrectValue = false;
				break;
			case 6:

				notCorrectValue = false;
				break;
			case 7:

				notCorrectValue = false;
				break;
			case 8:

				notCorrectValue = false;
				break;
			}

		}


		TodoItem td1 = new TodoItem("Städa", "Noggrann veckostädning!", 1);
		myTodoList.add(td1);
		System.out.println(td1.todoDescription);
		System.out.println(td1.dateCreated);
		System.out.println(td1.endDate);
		System.out.println(td1.todoStatus);
		System.out.println(myTodoList);

	}




}
