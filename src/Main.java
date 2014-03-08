import java.io.File;
import java.io.IOException;


public class Main {
	
	static FormatGraphe b;
	static Graphe graphe;
	
	
	
	
	
	public static void main(String[] args) {
		File fichier = new File("graph");
		
		try{
		
			FormatGraphe b = new FormatGraphe(fichier);
			int[][] mat = b.getMatrice();
			String[] list=b.getListesommets();System.out.println("La liste des sommets de mon graphe");for (int i = 0; i < b.graphe.getNbSommets(); i++) {System.out.print(list[i]+" ");}
			System.out.println();
			b.ecrireGraphe("graph");
			System.out.println("Le graphe colorié\n");
			b.ColoriageGraphe();
			for(int y=0; y<b.graphe.getNbSommets();y++)
			{
				System.out.println(b.graphe.getNoeud(y).getNom()+" : couleur "+b.graphe.getNoeud(y).getCouleur());
			}
		}
		catch(IOException e){
			System.err.println("erreur");
			System.err.println(e.getMessage());
		}
		
	}

}
