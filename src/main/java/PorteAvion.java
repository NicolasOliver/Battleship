import java.awt.Point;
import java.util.ArrayList;

public class PorteAvion extends Ship 
{
	
	public PorteAvion(String orintation, Point begin) {
		this.name = "PorteAvion";
		this.size = 5;
		this.firingRange = 2;
		this.orientation = orintation;
		this.begin = begin;
		this.life = 2;
		this.affectedCases = new ArrayList<Point>();
		this.cases = new ArrayList<Point>();
	}
	

}
