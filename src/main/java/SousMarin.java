import java.awt.Point;

public class SousMarin extends Ship 
{
	private final static int taille=3;
	private final static int firing_range=4;
	private final static String name="Sous-marin";
	
	public SousMarin() {
		super(name, taille, firing_range);
	}
}