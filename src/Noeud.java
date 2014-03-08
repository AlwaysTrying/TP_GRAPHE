import java.util.Vector;

/**
 * Cette classe fournit la représentation d'un noeud d'un graphe.
 * <P>Elle contient pour cela :
 * <ul><li>son nom</li>
 * <li>la liste des successeurs du noeud</li>
 * <li>la liste des flux dans le même ordre que les successeurs</li>
 * <li>la liste des capacités dans le même ordre que les successeurs.
 * Une capacité non précisée (infinie) correspond à la valeur -1.</li>
 * <li>un booléen qui permet de marquer le noeud</li></ul>
 *
 *
 */
public class Noeud {
	protected String nom , couleur;
	protected Vector<Noeud> successeurs;
	protected Vector<Noeud> predecesseurs;
	public Vector<Noeud> getPredecesseurs() {
		return predecesseurs;
	}




	public void setPredecesseurs(Vector<Noeud> predecesseurs) {
		this.predecesseurs = predecesseurs;
	}

	protected Vector<Integer> flux;
	protected Vector<Integer> capacites;
	protected Vector<String> color_interdite;
	public boolean marque;
	
	public Noeud(String nom){
		this.nom = nom;
		successeurs = new Vector<Noeud>();
		flux = new Vector<Integer>();
		capacites = new Vector<Integer>();
		couleur= null; 
		color_interdite=new Vector<String>();
		color_interdite.add("");
		
	}
	

	

	public void setColor_interdite(Vector<String> color_interdite , String color) {
		this.color_interdite = color_interdite;
		this.color_interdite.add(color);
	}
	
	public void ajoutercouleur_interdite(String color){
		color_interdite.add(color);
	}
	
	public Noeud getSucc(int index){
		return successeurs.get(index);
	}
	
	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Vector<String> getColor_interdite() {
		return color_interdite;
	}

	


	public int getFlux(int index){
		return flux.get(index).intValue();
	}
	
	public int getCapacite(int index){
		return capacites.get(index).intValue();
	}
	
	public String getNom(){
		return nom;
	}
	
	public int getNbSucc(){
		return successeurs.size();
	}
	
	public void addSucc(Noeud succ){
		successeurs.add(succ);
		flux.add(1);
		capacites.add(1);
	}
	
	public void addSucc(Noeud succ, int flux){
		successeurs.add(succ);
		this.flux.add(flux);
		capacites.add(1);
	}
	
	public void addSucc(Noeud succ, int flux, int capa){
		successeurs.add(succ);
		this.flux.add(flux);
		capacites.add(capa);
	}
	
	public void removeSucc(Noeud nd){
		int index = successeurs.indexOf(nd);
		successeurs.remove(index);
		flux.remove(index);
		capacites.remove(index);
	}
	
	public void removeSucc(int index){
		successeurs.remove(index);
		flux.remove(index);
		capacites.remove(index);
	}
	
	public Noeud getSucc(String nom){
		Noeud succ = null;
		for (int i = 0; i < successeurs.size(); i++) {
			if(successeurs.get(i).getNom().equals(nom)){
				succ = successeurs.get(i);
			}
		}
		return succ;
	}
}
