import java.util.Scanner;

//Main du jeu, début de la communication console
public class BattleShipMain {
	public static void main(String[] args) {
		String reponse;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.printf("Début du jeu : Jouer contre un ordinateur ? (o/n) : %nQuitter (q)%n ");
			reponse = sc.nextLine();
		} while (!reponse.toString().equals("o") && !reponse.toString().equals("O")
				&& !reponse.toString().equals("n") && !reponse.toString().equals("N")
				&& !reponse.toString().equals("q") && !reponse.toString().equals("Q"));
		if(reponse.toString().equals("q") || reponse.toString().equals("Q")) {
			System.out.println("Au revoir !");
			return;
		}
		if(reponse.toString().equals("o") || reponse.toString().equals("O")) {
			//Start game
		}
		else {
			//Start game contre joueur
		}
	}
}
