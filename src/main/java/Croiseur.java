import java.awt.Point;

public class Croiseur extends Ship 
{
	private final static int taille=4;
	private final static int firing_range=2;
	private final static String name="Croiseur";
	
	public Croiseur() {
		super(name, taille, firing_range);
	}
}
