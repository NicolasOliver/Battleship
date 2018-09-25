import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	
	private final String CHOIXBATEAU="Choisir un bateau\n1-Porte Avion\n2-Croiseur\n3-Contre torpilleur\n4-Sous-marin\n5-Torpilleur";
	
	private int id;
	private Grid grid;
	private ArrayList<Ship> ships;
	private Ship shipChosen;
	
	public Player(int id)
	{
		this.id=id;
		ships=new ArrayList<Ship>();
		grid=new Grid();
	}
	
	public int getId() {
		return id;
	}
	
	//Methode pour placer les bateaux
	public void placeShips() 
	{
		Point point = new Point(0,0);
		Grid grid = new Grid();
		grid.displayGrid();
		Ship ship=new PorteAvion("v", point);
		grid.placeShip(ship);
		ships.add(ship);
		grid.displayGrid();
		
		
		ship=new Croiseur("v", point);
		grid.placeShip(ship);
		ships.add(ship);
		grid.displayGrid();
	
		ship=new ContreTorpilleur("v", point);
		grid.placeShip(ship);
		ships.add(ship);
		grid.displayGrid();
		
		ship=new SousMarin("v", point);
		grid.placeShip(ship);
		ships.add(ship);
		grid.displayGrid();
		
		ship=new Torpilleur("v", point);
		grid.placeShip(ship);
		ships.add(ship);
		grid.displayGrid();
		
		System.out.println("Les bateaux ont �t� plac�s");
	}
	
	private void takeShot()
	{
		Ship s=selectShip();
		
	}
	
	public Ship selectShip()
	{
		ArrayList<String> ship_names=new ArrayList<String>();
		for(int i=0;i<ships.size();i++)
		{
			ship_names.add(ships.get(i).getName());
		}
		int i=IHM.selectShip(ship_names);
		//TODO Verifier input
		return ships.get(i);
	}

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
