import java.awt.Point;
import java.util.ArrayList;

public class SousMarin extends Ship 
{
	
	public SousMarin(String orintation, Point begin) {
		this.name = "SousMarin";
		this.size = 3;
		this.firingRange = 4;
		this.orientation = orintation;
		this.begin = begin;
		this.life = 2;
		this.affectedCases = new ArrayList<Point>();
		this.cases = new ArrayList<Point>();
	}
}