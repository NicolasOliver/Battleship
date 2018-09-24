import java.util.Scanner;

//Main du jeu, début de la communication console
public class BattleShipMain {
	public static void main(String[] args) {
		String reponse;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.printf("Are you ready for the game  ? (o/n) :  ");
			reponse = sc.nextLine();
		} while (!"o".equals(reponse.toString()) && !"O".equals(reponse.toString())
				&& !"n".equals(reponse.toString()) && !"N".equals(reponse.toString()));
		if("n".equals(reponse.toString()) || "N".equals(reponse.toString())) {
			System.out.println("Au revoir !");
			return;
		}
		else {
			Grid grid = new Grid();
			grid.displayGrid();
		}
	}
}
