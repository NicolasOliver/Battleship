import java.awt.Point;
import java.util.ArrayList;

public class Ship {
	
	// On déclare les différents paramètres pour chaque bâteau
	protected int firingRange; // Sa portée de tir
	protected int size; // La taille du bâteau
	protected String name; // Le nom de bâteau
	protected int life; // Le nombre de vie d'un bâteau
	protected String orientation; // v si vertical h si horizontal
	protected ArrayList<Point> cases; // Ensemble des points du bâteau
	protected ArrayList<Point> affectedCases; // Ensemble des points endommagés du bâteau;
	protected Point begin; // Première case du bâteau
	
	// Constructeur d'un bâteau comprenant son nom, sa taille, son portée de tir et son orientation
	public Ship(){}
	
	// Getters
	public String getName() { return name; }
	public int getLife() { return life; }
	public int getSize() { return size; }
	public int getFiringRange() { return firingRange; }
	public String getOrientation() { return orientation; }
	public Point getBegin() { return begin; }
	
	// Pour gérer quand un bâteau est touché
	public void hit(Point point) {
    	affectedCases.add(point); // Pour ne pas toucher 2 fois de suite au même endroit
        life--;
        System.out.println("Touché ! C'était un " + name);
        if(life == 0) {
            System.out.println("Qui est d'ailleur coulé !");
            return;
        }
        System.out.println();
    }
	
	//Definir les cases occuppees par le bateau
	public void setCases(Point begin,String orientation)
	{
		this.begin=begin;
		this.orientation=orientation;
		cases.add(begin);
		for(int i=1;i<cases.size();i++)
		{
			Point previous=cases.get(i-1);
			if(orientation=="h")
			{
				Point point=new Point(previous.x+1,previous.y);
				cases.add(point);
			}
			else if(orientation=="v")
			{
				Point point=new Point(previous.x,previous.y+1);
				cases.add(point);
			}
		}
	}
	
	
	public ArrayList<Point> getCases() {
		return cases;
	}
	
	
}
