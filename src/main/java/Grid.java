import java.awt.Point;
import java.util.ArrayList;

// D�fini le plateau de jeu
public class Grid {
	
	public static final int SIZE=10;
	
	private ArrayList<Point> ocupiedPoints;
	private ArrayList<Point> hitPoints;
	private ArrayList<Point> missedPoints;
	private char sea = '#'; // caractere pour la mer
	private char ship = 'o'; // caractere pour un bateau
	private char hit = 'X'; // caractere pour un bateau touche
	private char miss = 'm'; // caractere pour une case manquee (sans bateau)
	
	private char[][] grid;
	
	// Initialise la grille d'un joueur
	public Grid() {
		grid = new char[10][10];
		ocupiedPoints=new ArrayList<Point>();
		hitPoints=new ArrayList<Point>();
		missedPoints=new ArrayList<Point>();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				grid[i][j] = sea;
			}
		}
	}
	
	// Affiche la grille du joueur
	public void displayGrid() {
		updateDisplay();
		for (int i = 0; i < 10; i++) {
			if(i==0) System.out.print("\t" + (i) + "  ");
			else System.out.print((i) + "  ");
		}
		// Reviens a la ligne
		System.out.println("\n");
		
		for (int i = 0; i < 10; i++) {
			System.out.print(i + "\t");
			for (int j = 0; j < 10; j++) {
				System.out.print(grid[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// Mets à jour les symboles de la grille
	public void updateDisplay() {
		for(Point p:ocupiedPoints)
		{
			grid[p.y][p.x]=ship;
		}
		for(Point p:hitPoints)
		{
			grid[p.y][p.x]=hit;
		}
		for(Point p:missedPoints)
		{
			grid[p.y][p.x]=miss;
		}
	}
	
	// check les collisions
	public Boolean checkCollisions(Ship ship)
	{
		ArrayList<Point> pointsBateau=ship.getCases();
		for(Point p:pointsBateau)
		{
			for(Point pb:ocupiedPoints)
			{
				if(p.equals(pb))
					return false;
			}
		}
		return true;
	}
	
	//Verifier que le bateau rentre bien dans la grille
	public Boolean checkSize(Ship ship,Point point,String orientation)
	{
		int ship_size=ship.getSize();
		Boolean result=true;
		if("h".equals(orientation))
		{
			if((point.x+ship_size)>SIZE)
				result=false;
		}
		if("v".equals(orientation))
		{
			if((point.y+ship_size)>SIZE)
				result=false;
		}
		return result;
		
	}
	
	// Placement des bateaux
	public void placeShip(Ship ship,Boolean flag)
	{
		IHM.PlacementBateau(ship.getName());
		Boolean drap;
		@SuppressWarnings("unchecked")
		ArrayList<Point> caseTemp = (ArrayList<Point>)ship.getCases().clone();
		
		do
		{
			drap = false;
			Point point=IHM.getCoordonnnees();
			String orientation=IHM.getOrientation();
			if(checkSize(ship,point,orientation))
			{
				ship.setCases(point, orientation);
				if(checkCollisions(ship))
				{
					if (flag) {
						for (int i = 0;i<ship.getCases().size();i++){
							if(ship.getCases().get(i).x>caseTemp.get(i).x+2 || ship.getCases().get(i).y>caseTemp.get(i).y+2){
								drap = true;
								System.out.println("Vous vous etes deplace de plus de 2 cases ou dans la mauvaise direction !");
								break;
							} 
						} 
					} 
					if (!drap){
						this.ocupiedPoints.addAll(ship.getCases());
						return;
					}
					
				}
				else
					IHM.ShipCollision();
					drap = true;
			}
			else
				IHM.WallCollision();
				drap = true;
		}
		while(drap);
	}
	
	public void setHitPoints(Point point) {
		this.hitPoints.add(point);
	}
	
	public void setMissedPoints(Point point) {
		this.hitPoints.add(point);
	}
}
