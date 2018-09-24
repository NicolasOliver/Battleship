import java.awt.Point;

public class Torpilleur extends Ship 
{
	private final static int taille=2;
	private final static int firing_range=5;
	private final static String name="Torpilleur";
	
	public Torpilleur() {
		super(name, taille, firing_range);
	}
}
