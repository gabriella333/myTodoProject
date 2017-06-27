import java.util.Scanner;

public class Menu {
	
	int nyttVal;
	Scanner scan = new Scanner(System.in);

	public Menu() {
		
	}

	public int visaMenu() {
		System.out.println();
		System.out.println("***   MENY   ***");
		System.out.println("1. Visa hela listan");
		System.out.println("2. Lägg till en ny aktivitet");
		System.out.println("3. Tag bort en aktivitet");
		System.out.println("4. Ändra status på en aktivitet");
		System.out.println("5. Leta efter en specifik aktivitet");
		System.out.println("6. Editera en aktivitet");
		System.out.println("7. Tag bort alla aktiviteter med status DONE");
		System.out.println("8. AVSLUTA");

		System.out.print("Välj 1-8: ");
		nyttVal = scan.nextInt();
		System.out.println("You chose " + nyttVal + ".");
		return nyttVal;
		
	}
	
	


}
