import java.awt.Point;
import java.util.ArrayList;

public class Croiseur extends Ship 
{
	
	public Croiseur(String orintation, Point begin) {
		this.name = "Croiseur";
		this.size = 4;
		this.firingRange = 2;
		this.orientation = orintation;
		this.begin = begin;
		this.life = 2;
		this.affectedCases = new ArrayList<Point>();
		this.cases = new ArrayList<Point>();
	}
}
