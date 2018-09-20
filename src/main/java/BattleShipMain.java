import java.util.Scanner;

//Main du jeu, début de la communication console
public class BattleShipMain {
	public static void main(String[] args) {
		String reponse;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.printf("Are you ready for the game  ? (o/n) :  ");
			reponse = sc.nextLine();
		} while (!reponse.toString().equals("o") && !reponse.toString().equals("O")
				&& !reponse.toString().equals("n") && !reponse.toString().equals("N"));
		if(reponse.toString().equals("n") || reponse.toString().equals("N")) {
			System.out.println("Au revoir !");
			return;
		}
		else {
			Grid grid = new Grid();
			grid.displayGrid();
		}
	}
}
