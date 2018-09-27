import java.awt.Point;
import java.util.ArrayList;

public class Ship {
	
	// On declare les differents parametres pour chaque  bateau
	protected int firingRange; // Sa portee de tir
	protected int size; // La taille du bateau
	protected String name; // Le nom de bateau
	protected int life; // Le nombre de vie d'un bateau
	protected String orientation; // v si vertical h si horizontal
	protected ArrayList<Point> cases; // Ensemble des points du bateau
	protected ArrayList<Point> affectedCases; // Ensemble des points endommages du bateau;
	protected Point begin; // Premiere case du bateau
	
	
	// Constructeur d'un bateau comprenant son nom, sa taille, son portee de tir et son orientation
	public Ship(){}
	
	// Getters
	public String getName() { return name; }
	public int getLife() { return life; }
	public int getSize() { return size; }
	public int getFiringRange() { return firingRange; }
	public String getOrientation() { return orientation; }
	public Point getBegin() { return begin; }
	
	
	
	public ArrayList<Point> getAffectedCases() {
		return affectedCases;
	}

	public void setAffectedCases(ArrayList<Point> affectedCases) {
		this.affectedCases = affectedCases;
	}

	public void setFiringRange(int firingRange) {
		this.firingRange = firingRange;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public void setCases(ArrayList<Point> cases) {
		this.cases = cases;
	}

	public void setBegin(Point begin) {
		this.begin = begin;
	}

	// Pour gerer quand un bateau est touche
	public void hit(Point point) {
    	affectedCases.add(point); // Pour ne pas toucher 2 fois de suite au meme endroit
        life--;
        System.out.println("Touche ! C'etait un " + name);
        if(life == 0) {
            System.out.println("Qui est d'ailleurs coule !");
            return;
        }
        System.out.println();
    }
	
	//Definir les cases occuppees par le bateau
	public void setCases(Point begin,String orientation)
	{
		cases=new ArrayList<Point>();
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
	}
	
	
	public ArrayList<Point> getCases() {
		return cases;
	}
	
	
}
