package karmaka.v1;

import java.util.Collections;
import java.util.LinkedList;

public class JeuCartes {
	
	// attributs d'un jeu de cartes
	private LinkedList<Carte> tasCartes;
//	public static final int nbrCartes = Valeur.values().length * Couleur.values().length; // 8 x 4 = 32 cartes
	
	// constructeur du jeu de cartes
	public JeuCartes(){
		// instancie le jeu de cartes 
		this.tasCartes = new LinkedList<>();
		Valeur[] v=Valeur.values(); // ici values renvoie un tableau de Valeur
		Couleur[] c=Couleur.values(); // ici values renvoie un tableau de Couleur
		for(int i=0 ; i < v.length; i++){
			for(int j=0 ; j < c.length ; j++){
				Carte carte = new Carte(v[i] , c[j] );
				// on ajoute cette carte au tas de cartes
				tasCartes.add(carte);
			}
		}
	}
	
	// retire la premiére carte du tas de cartes (la carte du dessus)
	public Carte distribuerUneCarte(){ 
		Carte c;
		// on retire la carte du dessus du tas de cartes
		 c=tasCartes.remove();
	return c;
		
	}
	
	// Mélange de toutes les cartes. Très simple ....Appel de shuffle de la classe Collections (à différencier de l'interface Collection)
	public void melanger(){
		Collections.shuffle(tasCartes);
	}
	
	
	// le tas de cartes est-il vide?
	public boolean estVide() {
		// le tas cartes est vide ?
		return tasCartes.isEmpty();
	}
	
	public String toString(){
		return tasCartes.toString();
	}
	
	public LinkedList<Carte> getTasCartes(){
		return tasCartes;
	}
	

}
