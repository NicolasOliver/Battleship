import java.awt.Point;
import java.util.ArrayList;

public class Ship {
	
	// On d�clare les diff�rents param�tres pour chaque b�teau
	protected int firingRange; // Sa port�e de tir
	protected int size; // La taille du b�teau
	protected String name; // Le nom de b�teau
	protected int life; // Le nombre de vie d'un b�teau
	protected String orientation; // v si vertical h si horizontal
	protected ArrayList<Point> cases; // Ensemble des points du b�teau
	protected ArrayList<Point> affectedCases; // Ensemble des points endommag�s du b�teau;
	protected Point begin; // Premi�re case du b�teau
	
	// Constructeur d'un b�teau comprenant son nom, sa taille, son port�e de tir et son orientation
	public Ship(){}
	
	// Getters
	public String getName() { return name; }
	public int getLife() { return life; }
	public int getSize() { return size; }
	public int getFiringRange() { return firingRange; }
	public String getOrientation() { return orientation; }
	public Point getBegin() { return begin; }
	
	// Pour g�rer quand un b�teau est touch�
	public void hit(Point point) {
    	affectedCases.add(point); // Pour ne pas toucher 2 fois de suite au m�me endroit
        life--;
        System.out.println("Touch� ! C'�tait un " + name);
        if(life == 0) {
            System.out.println("Qui est d'ailleur coul� !");
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
		for(int i=1;i<this.size;i++)
		{
			Point previous=cases.get(i-1);
			if("v".equals(orientation))
			{
				Point point=new Point(previous.x,previous.y+1);
				cases.add(point);
			}
			else if("h".equals(orientation))
			{
				Point point=new Point(previous.x+1,previous.y);
				cases.add(point);	
			}
		}
		System.out.println("initialized");
	}
	
	
	public ArrayList<Point> getCases() {
		return cases;
	}
	
	
}
