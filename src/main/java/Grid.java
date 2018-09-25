import java.awt.Point;
import java.util.ArrayList;

// D�fini le plateau de jeu
public class Grid {
	
	public static final int SIZE=10;
	
	private ArrayList<Point> ocupiedPoints;
	private char sea = '#';
	private char ship = 'o';
	private char hit = 'X';
	private char miss = 'm';
	
	private char[][] grid;
	
	public Grid() {
		grid = new char[10][10];
		ocupiedPoints=new ArrayList<Point>();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				grid[i][j] = sea;
			}
		}
		
		System.out.println("\nVoici la grille de jeu ! \n");
	}
	
	public void displayGrid() {
		updateDisplay();
		for (int i = 0; i < 10; i++) {
			if(i==0) System.out.print("\t" + (i) + "  ");
			else System.out.print((i) + "  ");
		}
		// Reviens � la ligne
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
	
	public void updateDisplay() {
		//TODO
		for(Point p:ocupiedPoints)
		{
			grid[p.y-1][p.x-1]=ship;
		}
		System.out.println("updated display");
	}
	
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
	
	public void placeShip(Ship ship)
	{
		IHM.PlacementBateau(ship.getName());
		do
		{
			Point point=IHM.getCoordonnnees();
			String orientation=IHM.getOrientation();
			if(checkSize(ship,point,orientation))
			{
				ship.setCases(point, orientation);
				if(checkCollisions(ship))
				{
					this.ocupiedPoints.addAll(ship.getCases());
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
