import java.util.Scanner;

// D�fini le lancement et l'arr�t d'une partie 
//Singleton
public class Game {
	Player joueur1;
	Player joueur2;
	
	/* Constructeur priv� */
	private Game(){
		joueur1 = new Player(1);
		joueur2 = new Player(1);
	}
	
	/** Instance unique pr�-initialis�e */
    private static Game INSTANCE = new Game();
    
    /** Point d'acc�s pour l'instance unique du singleton */
    public static Game getInstance()
    {           
        if (INSTANCE == null){
        	INSTANCE = new Game(); 
        }
        return INSTANCE;
    }
    
    public void lancementDuJeux() {
    	String reponse;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.printf("Are you ready for the game  ? (o/n) :  ");
			reponse = sc.nextLine();
		} while (!"o".equals(reponse.toString()) && !"O".equals(reponse.toString())
				&& !"n".equals(reponse.toString()) && !"N".equals(reponse.toString()));
		if("n".equals(reponse.toString()) || "N".equals(reponse.toString())) {
			System.out.println("Au revoir !");
			sc.close();
			return;
		}
		else {
			sc.close();
			Grid grid = new Grid();
			grid.displayGrid();
			placementBateau();
			
		}
    }
    
    public void placementBateau () {
    	System.out.println("Le joueur 1 doit placer ses bateaux");
    	joueur1.placeShips();
    	System.out.println("Le joueur 2 doit placer ses bateaux");
    	joueur2.placeShips();
    	
    	batailleNavale();
    }
    
    public void batailleNavale(){
    	while (!joueur1.getShips().isEmpty() && !joueur2.getShips().isEmpty()){
    		System.out.println("Au tour du joueur 1");
    		tireJoueur(joueur1);
    		System.out.println("Au tour du joueur 2");
    		tireJoueur(joueur2);
    	}
    	
    	if (joueur1.getShips().isEmpty()){
    		System.out.println("Le joueur 1 a perdu !!!!");
    	} else if (joueur2.getShips().isEmpty()) {
    		System.out.println("Le joueur 2 a perdu !!!!");
    	}
    }
    
    public void tireJoueur(Player player){
    	Boolean succes = true;
		player.setShipChosen(player.selectShip());
		/*while (succes) {
			succes = joueur1.shot(x,y);
			System.out.println("Vous avez touch� votre cible");
			System.out.println("Vous avez rat� votre cible")
			} */
    }
    
    public static void main(String args[])
    {
    	Player player=new Player(1);
    	player.placeShips();
    	
    }
}