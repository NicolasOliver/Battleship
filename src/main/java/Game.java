import java.awt.Point;
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
    @SuppressWarnings("resource")
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
    	
    	System.out.println("\nLe joueur 2 doit placer ses bateaux : \n");
    	joueur2.placeShips();
    
    	batailleNavale();
    }
    
    // Gère la partie
    public void batailleNavale(){
    	while (!joueur1.getShips().isEmpty() && !joueur2.getShips().isEmpty()){
    		System.out.println("\nAu tour du joueur 1 : \n");
    		System.out.println("Voici votre grille :\n");
    		Grid grid=joueur1.getGrid();
    		grid.ShowGrid();
    		tireJoueur(joueur1, joueur2);
    		System.out.println("\nAu tour du joueur 2 : \n");
    		System.out.println("Voici votre grille :\n");
    		joueur2.getGrid().ShowGrid();
    		tireJoueur(joueur2, joueur1);
    	}
    	
    	if (joueur1.getShips().isEmpty()){
    		System.out.println("Le joueur 1 a perdu !!!!");
    	} else if (joueur2.getShips().isEmpty()) {
    		System.out.println("Le joueur 2 a perdu !!!!");
    	}
    }
    
    // Classe qui gère les tirs du joueur
    public void tireJoueur(Player tireur, Player cible){
    	Boolean succes = true;
		do {
			tireur.setShipChosen(tireur.selectShip());
			System.out.println("La portée du "+tireur.getShipChosen().getName()+" est de : "+tireur.getShipChosen().getFiringRange());
			System.out.println("Grille Adverse");
			cible.getGrid().ShowGridForAttacker();
			Point point = IHM.getCoordonnneesTire(tireur);
			succes = joueur1.shot(point,tireur, cible);
		} while (succes);
    }
}