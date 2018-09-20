// Défini le plateau de jeu
public class Grid {
	
	private char[] coord = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' };
	private char sea = '#';
	private char ship = 'o';
	private char hit = 'X';
	private char miss = 'm';
	
	private char[][] grid;
	
	public Grid() {
		grid = new char[10][10];
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				grid[j][i] = sea;
			}
		}
		
		System.out.println("\nVoici la grille de jeu ! \n");
	}
	
	public void displayGrid() {
		for (int i = 0; i < 10; i++) {
			if(i==0) System.out.print("\t" + (i) + "  ");
			else System.out.print((i) + "  ");
		}
		// Reviens à la ligne
		System.out.println("\n");
		
		for (int i = 0; i < 10; i++) {
			System.out.print(coord[i] + "\t");
			for (int j = 0; j < 10; j++) {
				System.out.print(grid[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void updateDisplay() {
		//TODO
	}
}
