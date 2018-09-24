import java.awt.Point;
import java.util.ArrayList;

public class ContreTorpilleur extends Ship 
{	
	public ContreTorpilleur(String orintation, Point begin) {
		this.name = "contreTorpilleur";
		this.size = 3;
		this.firingRange = 2;
		this.orientation = orintation;
		this.begin = begin;
		this.life = 2;
		this.affectedCases = new ArrayList<Point>();
		this.cases = new ArrayList<Point>();
	}
}
