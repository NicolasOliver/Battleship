import java.awt.Point;
import java.util.ArrayList;

public class Player {
	
	private final String CHOIXBATEAU="Choisir un bateau : \n1-Porte Avion\n2-Croiseur\n3-Contre torpilleur\n4-Sous-marin\n5-Torpilleur";
	
	private int id; // Chaque joueur est indentifie
	private Grid grid; // Chaque joueur possede une grille de jeu
	private ArrayList<Ship> ships; // Chaque joueur possede une liste de ses bateaux
	private Ship shipChosen; // Pour savoir quel bateau est choisi
	
	// Constructeur
	public Player(int id)
	{
		this.id=id;
		ships=new ArrayList<Ship>();
		grid=new Grid();
	}
	
	// Getter
	public int getId() {
		return id;
	}
	
	// Methode pour placer les bateaux
	public void placeShips() 
	{
		/*Point point = new Point(0,0);
		grid.ShowGrid();
		
		Ship ship=new PorteAvion("v", point);
		grid.placeShip(ship, false);
		ships.add(ship);
		grid.ShowGrid();
		
		
		ship=new Croiseur("v", point);
		grid.placeShip(ship, false);
		ships.add(ship);
		grid.ShowGrid();
	
		ship=new ContreTorpilleur("v", point);
		grid.placeShip(ship, false);
		ships.add(ship);
		grid.ShowGrid();
		
		ship=new SousMarin("v", point);
		grid.placeShip(ship, false);
		ships.add(ship);
		grid.ShowGrid();
		
		ship=new Torpilleur("v", point);
		grid.placeShip(ship, false);
		ships.add(ship);
		grid.ShowGrid();;*/
		grid.ShowGrid();
		
		Point point = new Point(0,0);
		Ship ship=new PorteAvion("v", point);
		ship.setCases(point,"v");
		grid.getOcupiedPoints().addAll(ship.getCases());
		ships.add(ship);
		grid.ShowGrid();
		
	    point = new Point(1,1);
		ship=new Croiseur("v", point);
		ship.setCases(point,"v");
		grid.getOcupiedPoints().addAll(ship.getCases());
		ships.add(ship);
		grid.ShowGrid();
	
		 point = new Point(2,2);
		ship=new ContreTorpilleur("v", point);
		ship.setCases(point,"v");
		grid.getOcupiedPoints().addAll(ship.getCases());
		ships.add(ship);
		grid.ShowGrid();
		
		point = new Point(3,3);
		ship=new SousMarin("v", point);
		ship.setCases(point,"v");
		grid.getOcupiedPoints().addAll(ship.getCases());
		ships.add(ship);
		grid.ShowGrid();
		
		 point = new Point(4,4);
		ship=new Torpilleur("v", point);
		ship.setCases(point,"v");
		grid.getOcupiedPoints().addAll(ship.getCases());
		ships.add(ship);
		grid.ShowGrid();
		
		System.out.println("Les bateaux ont ete places");
	}
	
	// gere le tir
	@SuppressWarnings("unused")
	public Boolean shot(Point point, Player tireur, Player cible){
		for (int i = 0;i<cible.getShips().size();i++){
			Ship cibleShip=cible.getShips().get(i);
			for (int j = 0;j<cibleShip.getCases().size();j++)
			{	
				if (point.equals(cibleShip.getCases().get(j)))
				{
					cible.getGrid().setHitPoints(point);
					if(cibleShip.hit(point))
					{
						cible.getGrid().removeShipPoints(cibleShip.getCases());
						cible.getShips().remove(i);
					}
					return true;
				} 
				else 
				{
					System.out.println("Vous avez rate votre cible..\n");
					cible.getGrid().setMissedPoints(point);
					placeShipsAtfterShoot(tireur.getShipChosen());
					return false;
				}
			}
		}
		return false;
	}
	
	// Permet de replacer un bateau
	public void placeShipsAtfterShoot(Ship bateau) 
	{
		System.out.println("Vous pouvez replacer votre bateau");
		grid.ShowGrid();
		grid.placeShip(bateau,true);
		System.out.println("Le bateaux a ete replace");
	}
	
	// Choisir un bateau pour tirer
	public Ship selectShip()
	{
		ArrayList<String> ship_names=new ArrayList<String>();
		for(int i=0;i<ships.size();i++)
		{
			ship_names.add(ships.get(i).getName());
		}
		int i=IHM.selectShip(ship_names);
		Ship ship=ships.get(i);
		grid.ShowGrid(ship);
		return ship;
	}

	/** Getters and setters */
	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public ArrayList<Ship> getShips() {
		return ships;
	}

	public void setShips(ArrayList<Ship> ships) {
		this.ships = ships;
	}

	public String getCHOIXBATEAU() {
		return CHOIXBATEAU;
	}

	public Ship getShipChosen() {
		return shipChosen;
	}

	public void setShipChosen(Ship shipChosen) {
		this.shipChosen = shipChosen;
	}

}
