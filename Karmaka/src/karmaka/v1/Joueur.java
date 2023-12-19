package karmaka.v1;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class Joueur {
	
	private String nom;
	private int ptsKarm;
	private int anneaux;
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
		this.ptsKarm = 4;
		this.anneaux = 0;
		this.vivant=true;
	}
	
	// le joueur ramasse la carte et l'ajoute en dessous des cartes déjà existantes dans la main
	
	public int getptsKarm() {
		return ptsKarm;
	}
	
	public void setptsKarm(int ptsKarm) {
		this.ptsKarm = ptsKarm;
	}
	
	public int getAnneaux() {
		return anneaux;
	}
	
	public void setAnneaux(int anneaux) {
		this.anneaux = anneaux;
	}
	
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
	
	public LinkedList<Carte> getOeuvres() {
		return oeuvres;
	}
	
	public LinkedList<Carte> getMain() {
		return main;
	}

	public LinkedList<Carte> getViefuture() {
		return viefuture;
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
	
    public Map<Couleur, Integer> sommeDesPointsParCouleur() {
        Map<Couleur, Integer> sommePointsParCouleur = new HashMap<>();

        for (Carte carte : oeuvres) {
            Couleur couleurCarte = carte.getCouleur();
            Points pointsCarte = carte.getPoints();
            int valeurPointsCarte = pointsCarte.getpoints();
            sommePointsParCouleur.merge(couleurCarte, valeurPointsCarte, Integer::sum);
        }

        return sommePointsParCouleur;
    }
    
    public int maxPoints(Map<Couleur, Integer> sommeDesPointsParCouleur) {
        int valeurMaximale = 0;  // La valeur par défaut si la Map est vide

        for (int valeurPoints : sommeDesPointsParCouleur.values()) {
            if (valeurPoints > valeurMaximale) {
                valeurMaximale = valeurPoints;
            }
        }

        return valeurMaximale;
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
		sb.append("OEUVRES (" + this.oeuvres.size() + ") : " + this.oeuvres + " \n");
		sb.append("POINTS : " + sommeDesPointsParCouleur());
		return sb.toString();
		
	}
	
}
