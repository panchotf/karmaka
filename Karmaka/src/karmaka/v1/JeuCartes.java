package karmaka.v1;

import java.util.*;
import java.util.Collections;
import java.util.LinkedList;

public class JeuCartes {
	
	// attributs d'un jeu de cartes
	private LinkedList<Carte> tasCartes;
	public static final int nbrCartes = 64;
	
	// constructeur du jeu de cartes
	public JeuCartes(){
		// instancie le jeu de cartes 
		this.tasCartes = new LinkedList<Cartes>();
		
		// On créé toutes les cartes
		Carte vol1 = new Carte("Vol", Point.Trois, Couleur.BLEU);
		tasCartes.add(vol1);
		Carte vol2 = new Carte("Vol", Point.Trois, Couleur.BLEU);
		tasCartes.add(vol2);
		
		Carte transmigration1 = new Carte("Transmigration", Point.Un, Couleur.BLEU);
		tasCartes.add(transmigration1);
		Carte transmigration2 = new Carte("Transmigration", Point.Un, Couleur.BLEU);
		tasCartes.add(transmigration2);
		Carte transmigration3 = new Carte("Transmigration", Point.Un, Couleur.BLEU);
		tasCartes.add(transmigration3);
		
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
