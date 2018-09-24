import java.awt.Point;
import java.util.ArrayList;

public class IHM
{
	public static final String placerBateaux="Placement des bateaux";
	
	public static int selectShip(ArrayList<String> ship_names)
	{
		System.out.println("Selctionner un bateau");
		for(int i=0;i<ship_names.size();i++)
		{
			System.out.println(i+1+"-"+ship_names.get(i));
		}
		String input=System.console().readLine();
		int choix=Integer.parseInt(input);
		return choix;
	}
	
	public static Point getCoordonnnees()
	{
		System.out.println("Entrer x");
		String input=System.console().readLine();
		int x=Integer.parseInt(input);
		
		System.out.println("Entrer y");
		input=System.console().readLine();
		int y=Integer.parseInt(input);
		
		return new Point(x,y);	
	}
	
	public static String getOrientation()
	{
			System.out.println("Entrer l orientation, v pour vertical, h pour horizontal");
			String input=System.console().readLine();
			return input;
	}
	
	public static void ShipCollision()
	{
		System.out.println("Un bateau se trouve deja a cet emplacement");
	}
	
	public static void WallCollision()
	{
		System.out.println("Un bateau se trouve deja a cet emplacement");
	}
	
	public static void PlacementBateau(String nom)
	{
		System.out.println("Placement du "+nom);
	}
	
	
	
}
