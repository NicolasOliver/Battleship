import java.awt.Point;
import java.util.ArrayList;

// Défini le plateau de jeu
public class Grid {
	
	public static final int SIZE=10;
	
	private ArrayList<Point> ocuupiedPoints;
	private char[] coord = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' };
	private char sea = '#';
	private char ship = 'o';
	private char hit = 'X';
	private char miss = 'm';
	
	private char[][] grid;
	
	public Grid() {
		grid = new char[10][10];
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				grid[j][i] = sea;
			}
		}
		
		System.out.println("\nVoici la grille de jeu ! \n");
	}
	
	public void displayGrid() {
		for (int i = 0; i < 10; i++) {
			if(i==0) System.out.print("\t" + (i) + "  ");
			else System.out.print((i) + "  ");
		}
		// Reviens à la ligne
		System.out.println("\n");
		
		for (int i = 0; i < 10; i++) {
			System.out.print(coord[i] + "\t");
			for (int j = 0; j < 10; j++) {
				System.out.print(grid[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void updateDisplay() {
		//TODO
	}
	
	public Boolean checkCollisions(Ship ship)
	{
		ArrayList<Point> pointsBateau=ship.getCases();
		for(Point p:pointsBateau)
		{
			for(Point pb:pointsBateau)
			{
				if(p.equals(pb))
					return true;
			}
		}
		return false;
	}
	
	//Verifier que le bateau rentre bien dans la grille
	public Boolean checkSize(Ship ship,Point point,char orientation)
	{
		int ship_size=ship.getSize();
		Boolean result=true;
		if(orientation=='v')
		{
			if((point.x+ship_size)>SIZE)
				result=false;
		}
		if(orientation=='h')
		{
			if((point.y+ship_size)>SIZE)
				result=false;
		}
		return result;
		
	}
	
	public void placeShip(Ship ship)
	{
		IHM.PlacementBateau(ship.getName());
		do
		{
			Point point=IHM.getCoordonnnees();
			char orientation=IHM.getOrientation();
			if(checkSize(ship,point,orientation))
			{
				if(checkCollisions(ship))
				{
					ship.setCases(point, orientation);
					this.ocuupiedPoints.addAll(ship.getCases());
					return;
				}
				else
					IHM.ShipCollision();
			}
			else
				IHM.WallCollision();
		}
		while(true);
	}
	
	
}
