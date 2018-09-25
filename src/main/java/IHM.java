import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class IHM
{
	public static final String placerBateaux="Placement des bateaux";
	
	public static int selectShip(ArrayList<String> ship_names)
	{
		System.out.println("Selectionner un bateau");
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
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrer x");
		String input=sc.nextLine();
		int x=Integer.parseInt(input);
		
		System.out.println("Entrer y");
		input=sc.nextLine();
		int y=Integer.parseInt(input);
		
		return new Point(x,y);	
		//TODO verifier inputs
	}
	
	public static String getOrientation()
	{
			Scanner sc=new Scanner(System.in);
			System.out.println("Entrer l orientation, v pour vertical, h pour horizontal");
			String input=sc.nextLine();
			return input.charAt(0);
	}
	
	public static void ShipCollision()
	{
		System.out.println("Un bateau se trouve deja a cet emplacement");
	}
	
	public static void WallCollision()
	{
		System.out.println("Bateau en dehors des limites");
	}
	
	public static void PlacementBateau(String nom)
	{
		System.out.println("Placement du "+nom);
	}
	
	
	
}
