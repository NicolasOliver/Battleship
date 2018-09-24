import java.awt.Point;

public class ContreTorpilleur extends Ship 
{
	private final static int taille=3;
	private final static int firing_range=2;
	private final static String name="Contre torpilleur";
	
	public ContreTorpilleur() {
		super(name, taille, firing_range);
	}
}
