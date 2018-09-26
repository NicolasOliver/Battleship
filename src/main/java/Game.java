import java.util.Scanner;

// Defini le lancement et l'arret d'une partie 
//Singleton
public class Game {
	Player joueur1;
	Player joueur2;
	
	/* Constructeur prive*/
	private Game(){
	}
	
	/** Instance unique pre-initialisee*/
    private static Game INSTANCE = new Game();
    
    /** Point d'acces pour l'instance unique du singleton */
    public static Game getInstance()
    {           
        if (INSTANCE == null){
        	INSTANCE = new Game(); 
        }
        return INSTANCE;
    }
    
    // Lancement du jeu
    public void lancementDuJeux() {
    	String reponse;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.printf("Are you ready for the game  ? (o/n) :  ");
			reponse = sc.nextLine();
		} while (!"o".equals(reponse.toString()) && !"O".equals(reponse.toString())
				&& !"n".equals(reponse.toString()) && !"N".equals(reponse.toString()));
		if("n".equals(reponse.toString()) || "N".equals(reponse.toString())) {
			System.out.println("See you !");
			return;
		}
		else {
			joueur1 = new Player(1);
			joueur2 = new Player(2);
			placementBateau();	
		}
    }
    
    // Initialisation de la position des bâteaux
    public void placementBateau () {
    	System.out.println("\nLe joueur 1 doit placer ses bateaux : \n");
    	joueur1.placeShips();
    	System.out.println("Le joueur 2 doit placer ses bateaux : ");
    	joueur2.placeShips();
    	
    	batailleNavale();
    }
    
    // Gère la partie
    public void batailleNavale(){
    	while (!joueur1.getShips().isEmpty() && !joueur2.getShips().isEmpty()){
    		System.out.println("Au tour du joueur 1 : ");
    		tireJoueur(joueur1);
    		System.out.println("Au tour du joueur 2 : ");
    		tireJoueur(joueur2);
    	}
    	
    	if (joueur1.getShips().isEmpty()){
    		System.out.println("Le joueur 1 a perdu !!!!");
    	} else if (joueur2.getShips().isEmpty()) {
    		System.out.println("Le joueur 2 a perdu !!!!");
    	}
    }
    
    // Classe qui gère les tirs du joueur
    public void tireJoueur(Player player){
    	Boolean succes = true;
		player.setShipChosen(player.selectShip());
		/*while (succes) {
			succes = joueur1.shot(x,y);
			System.out.println("Vous avez touch� votre cible");
			System.out.println("Vous avez rat� votre cible")
			} */
    }
    public static void main(String[] args)
    {
    	Player player=new Player(1);
    	player.placeShips();
    }
}