import java.awt.Point;
import java.util.ArrayList;

public class Torpilleur extends Ship 
{
	
	public Torpilleur(String orintation, Point begin) {
		this.name = "Torpilleur";
		this.size = 2;
		this.firingRange = 5;
		this.orientation = orintation;
		this.begin = begin;
		this.life = 2;
		this.affectedCases = new ArrayList<Point>();
		this.cases = new ArrayList<Point>();
	}
}
