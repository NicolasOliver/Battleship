import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class IHM
{
	public static final String placerBateaux="Placement des bateaux : ";
	
	// Selectionne un bateau
	@SuppressWarnings("resource")
	public static int selectShip(ArrayList<String> ship_names)
	{
		int choix = -1;
		System.out.println("Selectionner un bateau : \n");
		for(int i=0;i<ship_names.size();i++)
		{
			System.out.println(i+1+"-"+ship_names.get(i));
		}
		
		do {
			Scanner sc = new Scanner(System.in);
			try {
				choix=Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Ce n'est pas un entier ! ");
			}
		} while (choix <0 || choix >5);
		
		return choix-1;
	}
	
	// Demander ou placer le bateau
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
	}
	
	@SuppressWarnings("resource")
	// Savoir ou tirer
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
	}
	
	// Demander orientation du bateau
	public static String getOrientation()
	{
		String input;
		do {
			Scanner sc=new Scanner(System.in);
			System.out.println("Entrer l'orientation, v pour vertical, h pour horizontal : ");
			input=sc.nextLine();
			if(!"v".equals(input) && !"h".equals(input)){
				System.out.println("Vous avez rentre une mauvaise orientation");
			}
		} while (!"v".equals(input) && !"h".equals(input));
		return input;
	}
	
	// Detecter les collisions
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
