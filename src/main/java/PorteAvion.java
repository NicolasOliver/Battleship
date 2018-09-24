import java.awt.Point;

public class PorteAvion extends Ship 
{
	private final static int taille=5;
	private final static int firing_range=2;
	private final static String name="Porte Avion";
	
	public PorteAvion() {
		super(name, taille, firing_range);
	}
	

}
