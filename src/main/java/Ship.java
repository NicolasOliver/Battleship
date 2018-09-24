import java.awt.Point;
import java.util.ArrayList;

public class Ship {
	
	// On déclare les différents paramètres pour chaque bâteau
	private int firingRange; // Sa portée de tir
	private int size; // La taille du bâteau
	private String name; // Le nom de bâteau
	private int life; // Le nombre de vie d'un bâteau
	private char orientation; // v si vertical h si horizontal
	private ArrayList<Point> cases; // Ensemble des points du bâteau
	private ArrayList<Point> affectedCases; // Ensemble des points endommagés du bâteau;
	private Point begin; // Première case du bâteau
	
	// Constructeur d'un bâteau comprenant son nom, sa taille, son portée de tir et son orientation
	public Ship(String name, int size, int firingRange, char orientation,Point begin) {
		this.name = name;
		this.size = size;
		this.firingRange = firingRange;
		this.orientation = orientation;
		this.begin=begin;
		life = 2;
		affectedCases = new ArrayList<Point>();
		cases=new ArrayList<Point>();
	}
	
	public Ship(String name, int size, int firingRange) {
		this.name = name;
		this.size = size;
		this.firingRange = firingRange;
		life = 2;
		cases=new ArrayList<Point>();
		affectedCases = new ArrayList<Point>();
	}
	
	// Getters
	public String getName() { return name; }
	public int getLife() { return life; }
	public int getSize() { return size; }
	public int getFiringRange() { return firingRange; }
	public char getOrientation() { return orientation; }
	public Point getBegin() { return begin; }
	
	// Pour gérer quand un bâteau est touché
	public void hit(Point point) {
    	affectedCases.add(point); // Pour ne pas toucher 2 fois de suite au même endroit
        life--;
        System.out.print("Touché ! C'était un " + name);
        if(life == 0) {
            System.out.print("qui est d'ailleur coulé !");
            return;
        }
        System.out.println();
    }
	
	//Definir les cases occuppees par le bateau
	public void setCases(Point begin,char orientation)
	{
		this.begin=begin;
		this.orientation=orientation;
		cases.add(begin);
		for(int i=1;i<cases.size();i++)
		{
			Point previous=cases.get(i-1);
			if(orientation=='h')
			{
				Point point=new Point(previous.x+1,previous.y);
				cases.add(point);
			}
			else if(orientation=='v')
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
