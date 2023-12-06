package karmaka.v1;
import java.util.LinkedList;


public class Joueur {
	
	private String nom;
	private int ptsKarm;
	private LinkedList<Carte> main;
	private LinkedList<Carte> pile;
	private LinkedList<Carte> oeuvres;
	private LinkedList<Carte> viefuture;
	private boolean vivant;
	
	public Joueur(String nom) {
		this.nom = nom;
		this.main = new LinkedList<>();
		this.pile = new LinkedList<>();
		this.oeuvres = new LinkedList<>();
		this.viefuture = new LinkedList<>();
		this.ptsKarm = 0;
		this.vivant=true;
	}
	
	// le joueur ramasse la carte et l'ajoute en dessous des cartes déjà existantes dans la main
	public void ramasserCarte(Carte carte){
		main.add(carte);
	}
	
	public void retirerCarte(Carte carte){
		main.remove(carte);
	}
	
	public void ajouterPile(Carte carte){
		pile.add(carte);
	}
	
	public void retirerPile(Carte carte){
		pile.remove(carte);
	}
	
	public boolean pileVide(){
		return pile.isEmpty();
	}
	
	public boolean mainVide(){
		return main.isEmpty();
	}
	
	public void ajouterOeuvre(Carte carte){
		oeuvres.add(carte);
	}
	
	public void retirerOeuvre(Carte carte){
		oeuvres.remove(carte);
	}
	
	public void viderOeuvre(LinkedList<Carte> defausse) {
		defausse.addAll(oeuvres);
		oeuvres.clear();
	}

	public void ajouterVieFuture(Carte carte){
		viefuture.add(carte);
	}
	
	public void mainVieFuture(){
		main.addAll(viefuture);
		viefuture.clear();
	}
	
	
	public void piocher() {
		main.add(pile.getFirst());
		pile.remove(pile.getFirst());
	}
	
	public int nombreMain() {
		return main.size();
	}
	
	public void tuer() {
		this.vivant = false;
	}
	
	public void reincarner() {
		this.vivant = true;
	}
	
	public boolean estVivant() {
		return this.vivant;
	}
	
	// Méthode publique pour pouvoir récupérer une carte dans la main du joueur 
    public Carte getCarteDeMain(String nomCarte) {
        for (Carte carte : main) {
            if (carte.getNom().equals(nomCarte)) {
                return carte;
            }
        }
        // Gestion d'erreur : la carte n'a pas été trouvée dans la main
        return null;
    }
	
	// le joueur gagne s'il atteint 7 points de karma 
	public boolean isWinner(){
		boolean jaigagne = false;
		if (ptsKarm==7)
			jaigagne=true;
		return jaigagne;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(this.nom +"  \n");
		sb.append(" KARMA : " + this.ptsKarm + " \n ");
		sb.append("MAIN ("+ this.main.size() + ") : " + this.main + " \n ");
		sb.append("PILE (" + this.pile.size() + ") : " + this.pile + " \n ");
		sb.append("VIE FUTURE (" + this.viefuture.size() + ") : " + this.viefuture + " \n ");
		sb.append("OEUVRES (" + this.oeuvres.size() + ") : " + this.oeuvres);
		return sb.toString();
		
	}
	
}
