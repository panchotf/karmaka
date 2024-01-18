package karmaka.v1;
import java.util.LinkedList;
import java.io.*;

import java.util.HashMap;
import java.util.Map;

import java.util.Random;

/**
 * Classe Joueur qui permet de créer un joueur avec un nom, des points de karma, des anneaux, une main, une pile, des oeuvres et une vie future.
 * Ce joueur peut etre un joueur humain ou une IA.
 */
public class Joueur implements Serializable {
	
	private Random random;
	private String nom;
	private int ptsKarm;
	private int anneaux;
	private LinkedList<Carte> main;
	private LinkedList<Carte> pile;
	private LinkedList<Carte> oeuvres;
	private LinkedList<Carte> viefuture;
	private boolean vivant;

	/**
	 * Constructeur de la classe Joueur
	 * @param nom
	 */
	public Joueur(String nom) {
		this.nom = nom;
		this.main = new LinkedList<>();
		this.pile = new LinkedList<>();
		this.oeuvres = new LinkedList<>();
		this.viefuture = new LinkedList<>();
		this.ptsKarm = 4;
		this.anneaux = 0;
		this.vivant=true;
		this.random = new Random();
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

	public LinkedList<Carte> getPile() {
		return pile;
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

	public Carte getOeuvreExposee() {
		return oeuvres.getLast();
	}

	/**
	 * Methode qui permet d'ajouter une oeuvre
	 * @param carte
	 */
	public void ajouterOeuvre(Carte carte){
		oeuvres.add(carte);
	}

	/**
	 * Methode qui permet de retirer une oeuvre
	 * @param carte
	 */
	public void retirerOeuvre(Carte carte){
		oeuvres.remove(carte);
	}

	/**
	 * methde qui permet de vider les oeuvres
	 * @param defausse
	 */
	public void viderOeuvre(LinkedList<Carte> defausse) {
		defausse.addAll(oeuvres);
		oeuvres.clear();
	}

	/**
	 * Methode qui permet d'ajouter une carte a la vie future
	 * @param carte
	 */
	public void ajouterVieFuture(Carte carte){
		viefuture.add(carte);
	}
	
	public void mainVieFuture(){
		main.addAll(viefuture);
		viefuture.clear();
	}
	
	/**
	 * Methode qui permet de piocher une carte dans la pie
	 */
	public void piocher() {
		main.add(pile.getFirst());
		pile.remove(pile.getFirst());
	}


	public int nombreMain() {
		return main.size();
	}

	/**
	 * methode qui permet de tuer un joueur
	 */
	public void tuer() {
		this.vivant = false;
	}

	/**
	 * methode qui permet de reincarner un joueur
	 */
	public void reincarner() {
		this.vivant = true;
	}

	/**
	 * methode qui permet de savoir si un joueur est vivant
	 */
	public boolean estVivant() {
		return this.vivant;
	}

	/**
	 * methode qui fait la somme des points par couleur pour un joueur
	 */
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

	/**
	 * methode qui permet de calculer le nombre de points max. Elle compare les points de chaque couleur et retourne la valeur max
	 * @param sommeDesPointsParCouleur
	 */
    public int maxPoints(Map<Couleur, Integer> sommeDesPointsParCouleur) {
        int valeurMaximale = 0;  // La valeur par défaut si la Map est vide

        for (int valeurPoints : sommeDesPointsParCouleur.values()) {
            if (valeurPoints > valeurMaximale) {
                valeurMaximale = valeurPoints;
            }
        }

        return valeurMaximale;
    }


	/**
	 * methode qui permet de recuperer une carte de la main
	 * @param nomCarte
	 */
    public Carte getCarteDeMain(String nomCarte) {
        for (Carte carte : main) {
            if (carte.getNom().equals(nomCarte)) {
                return carte;
            }
        }
        // Gestion d'erreur : la carte n'a pas été trouvée dans la main
        return null;
    }



	/**
	 * methode qui permet de recuperer une carte au hasard de la main
	 */
    public Carte getCarteAleatoireDeMain() {
        // Vérifiez si la main n'est pas vide
        if (main.isEmpty()) {
            // Gestion d'erreur : la main est vide, aucune carte à récupérer
            return null;
        }

        Random random = new Random();
        int indexAleatoire = random.nextInt(main.size());
        return main.get(indexAleatoire);
    }

	/**
	 * methode qui permet de savoir si le joueur a gagne. Il gagne s'il atteint 7 points de karma
	 * @return
	 */
	public boolean isWinner(){
		boolean jaigagne = false;
		if (ptsKarm==7)
			jaigagne=true;
		return jaigagne;
	}

	/**
	 * methode qui permet de choisir un nombre aleatoire
	 */
    public int choixRandom() {
        // Génère une probabilité aléatoire entre 0 et 100
        return random.nextInt(101);
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
