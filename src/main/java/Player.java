import java.awt.Point;
import java.util.ArrayList;

public class Player {
	
	private final String CHOIXBATEAU="Choisir un bateau\n1-Porte Avion\n2-Croiseur\n3-Contre torpilleur\n4-Sous-marin\n5-Torpilleur";
	
	private int id;
	private Grid grid;
	private ArrayList<Ship> ships;
	
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
		Ship ship=new PorteAvion();
		grid.placeShip(ship);
		ships.add(ship);
		ship=new Croiseur();
		grid.placeShip(ship);
		ships.add(ship);
		ship=new ContreTorpilleur();
		grid.placeShip(ship);
		ships.add(ship);
		ship=new SousMarin();
		grid.placeShip(ship);
		ships.add(ship);
		ship=new Torpilleur();
		grid.placeShip(ship);
		ships.add(ship);
	}
	
	private void takeShot()
	{
		Ship s=selectShip();
		
	}
	
	private Ship selectShip()
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
	
}
