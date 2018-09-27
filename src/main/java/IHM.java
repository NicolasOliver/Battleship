import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class IHM
{
	public static final String placerBateaux="Placement des bateaux : ";
	
	public static int selectShip(ArrayList<String> ship_names)
	{
		System.out.println("Selectionner un bateau : ");
		for(int i=0;i<ship_names.size();i++)
		{
			System.out.println(i+1+"-"+ship_names.get(i));
		}
		
		Scanner sc = new Scanner(System.in);
		int choix=Integer.parseInt(sc.nextLine());
		return choix-1;
	}
	
	public static Point getCoordonnnees()
	{
		int x = -1;
		int y = -1;
		String input;
		Scanner sc;
		do {
			sc=new Scanner(System.in);
			System.out.println("Entrer x compris entre 0 et 9 : ");
			try {
				input=sc.nextLine();
				x=Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println("Ce n'est pas un entier ! ");
			}
		} while (x<0 || x>9);
		
		do {
			System.out.println("Entrer y compris entre 0 et 9 : ");
			try {
				input=sc.nextLine();
				y=Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println("Ce n'est pas un entier ! ");
			}
		} while (y<0 || y>9);
		
		
		return new Point(x,y);	
		//TODO verifier inputs
	}
	
	public static Point getCoordonnneesTire(Player tireur)
	{
		int x = -1;
		int y = -1;
		String input;
		Scanner sc;
		Boolean flag = false;
		
		do {
			
			do {
				sc=new Scanner(System.in);
				System.out.println("Entrer x compris entre 0 et 9 : ");
				try {
					input=sc.nextLine();
					x=Integer.parseInt(input);
				} catch (Exception e) {
					System.out.println("Ce n'est pas un entier ! ");
				}
			} while (x<0 || x>9);
			
			do {
				System.out.println("Entrer y compris entre 0 et 9 : ");
				try {
					input=sc.nextLine();
					y=Integer.parseInt(input);
				} catch (Exception e) {
					System.out.println("Ce n'est pas un entier ! ");
				}
			} while (y<0 || y>9);
			
			for(int j = 0;j<tireur.getShipChosen().getCases().size();j++){
				if (x<=tireur.getShipChosen().getCases().get(j).x+tireur.getShipChosen().getFiringRange()
					&& y<=tireur.getShipChosen().getCases().get(j).y+tireur.getShipChosen().getFiringRange()) {
				flag = true;
			}
		}
		if (!flag){
			System.out.println("Vous avez tiré hors de la porté du bateau, recommencez");
		}
		} while (!flag);
		
		
		
		
		return new Point(x,y);	
		//TODO verifier inputs
	}
	
	public static String getOrientation()
	{
		String input;
		do {
			Scanner sc=new Scanner(System.in);
			System.out.println("Entrer l'orientation, v pour vertical, h pour horizontal : ");
			input=sc.nextLine();
			if(!"v".equals(sc) && !"h".equals(sc)){
				System.out.println("Vous avez rentrez une mauvaise orientation");
			}
		} while (!"v".equals(input) && !"h".equals(input));
		return input;
	}
	
	public static void ShipCollision()
	{
		System.out.println("Un bateau se trouve deja a cet emplacement !");
	}
	
	public static void WallCollision()
	{
		System.out.println("Bateau en dehors des limites !");
	}
	
	public static void PlacementBateau(String nom)
	{
		System.out.println("Placement du "+nom+"\n");
	}
}
