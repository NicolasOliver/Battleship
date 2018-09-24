import java.awt.Point;
import java.util.ArrayList;

public class Ship {
	
	// On d�clare les diff�rents param�tres pour chaque b�teau
	private int firingRange; // Sa port�e de tir
	private int size; // La taille du b�teau
	private String name; // Le nom de b�teau
	private int life; // Le nombre de vie d'un b�teau
	private char orientation; // v si vertical h si horizontal
	private ArrayList<Point> cases; // Ensemble des points du b�teau
	private ArrayList<Point> affectedCases; // Ensemble des points endommag�s du b�teau;
	private Point begin; // Premi�re case du b�teau
	
	// Constructeur d'un b�teau comprenant son nom, sa taille, son port�e de tir et son orientation
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
	
	// Pour g�rer quand un b�teau est touch�
	public void hit(Point point) {
    	affectedCases.add(point); // Pour ne pas toucher 2 fois de suite au m�me endroit
        life--;
        System.out.print("Touch� ! C'�tait un " + name);
        if(life == 0) {
            System.out.print("qui est d'ailleur coul� !");
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
		for(int i=1;i<this.size;i++)
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
		int a =0;
	}
	
	
	public ArrayList<Point> getCases() {
		return cases;
	}
	
	
}
