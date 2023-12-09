package karmaka.v1;


import karmaka.v1.effet.EffetDummy;

import java.util.Collections;
import java.util.LinkedList;

public class JeuCartes {
	
	// attributs d'un jeu de cartes
	private LinkedList<Carte> tasCartes;
	public static final int nbrCartes = 64;
	
	// constructeur du jeu de cartes
	public JeuCartes(Partie partie){
		// instancie le jeu de cartes 
		this.tasCartes = new LinkedList<Carte>();

		// Instance des effets
		Effet dummy = new EffetDummy(partie, partie.getDefausse(), partie.getTest());
		
		// On créé toutes les cartes
		
		Carte transmigration1 = new Carte("Transmigration", Points.Un, Couleur.BLEU, dummy);
		tasCartes.add(transmigration1);
		Carte transmigration2 = new Carte("Transmigration", Points.Un, Couleur.BLEU, dummy);
		tasCartes.add(transmigration2);
		Carte transmigration3 = new Carte("Transmigration", Points.Un, Couleur.BLEU, dummy);
		tasCartes.add(transmigration3);
		
		Carte destinee1 = new Carte("Destinee", Points.Un, Couleur.BLEU, dummy);
		tasCartes.add(destinee1);
		Carte destinee2 = new Carte("Destinee", Points.Un, Couleur.BLEU, dummy);
		tasCartes.add(destinee2);
		Carte destinee3 = new Carte("Destinee", Points.Un, Couleur.BLEU, dummy);
		tasCartes.add(destinee3);
		
		Carte Coupdoeil1 = new Carte("Coup D'Oeil", Points.Trois, Couleur.BLEU, dummy);
		tasCartes.add(Coupdoeil1);
		Carte Coupdoeil2 = new Carte("Coup D'Oeil", Points.Trois, Couleur.BLEU, dummy);
		tasCartes.add(Coupdoeil2);
		Carte Coupdoeil3 = new Carte("Coup D'Oeil", Points.Trois, Couleur.BLEU, dummy);
		tasCartes.add(Coupdoeil3);
		
		Carte ReveBrises1 = new Carte("Rêves Brisés", Points.Trois, Couleur.BLEU, dummy);
		tasCartes.add(ReveBrises1);
		Carte ReveBrises2 = new Carte("Rêves Brisés", Points.Trois, Couleur.BLEU, dummy);
		tasCartes.add(ReveBrises2);
		Carte ReveBrises3 = new Carte("Rêves Brisés", Points.Trois, Couleur.BLEU, dummy);
		tasCartes.add(ReveBrises3);
		
		Carte duperie1 = new Carte("Duperie", Points.Trois, Couleur.BLEU, dummy);
		tasCartes.add(duperie1);
		Carte duperie2 = new Carte("Duperie", Points.Trois, Couleur.BLEU, dummy);
		tasCartes.add(duperie2);
		
		Carte deni1 = new Carte("Déni", Points.Trois, Couleur.BLEU, dummy);
		tasCartes.add(deni1);
		Carte deni2 = new Carte("Déni", Points.Trois, Couleur.BLEU, dummy);
		tasCartes.add(deni2);
		Carte deni3 = new Carte("Déni", Points.Trois, Couleur.BLEU, dummy);
		tasCartes.add(deni3);
		
		Carte vol1 = new Carte("Vol", Points.Trois, Couleur.BLEU, dummy);
		tasCartes.add(vol1);
		//Carte vol2 = new Carte("Vol", Points.Trois, Couleur.BLEU);
		//tasCartes.add(vol2);
		
		Carte vo1 = new Carte("Vo", Points.Trois, Couleur.ROUGE, deplace);
		tasCartes.add(vo1);
		Carte vo2 = new Carte("Vo", Points.Trois, Couleur.ROUGE, deplace);
		tasCartes.add(vo2);
		Carte vo3 = new Carte("Vo", Points.Trois, Couleur.ROUGE, deplace);
		tasCartes.add(vo3);
		Carte vo4 = new Carte("Vo", Points.Trois, Couleur.ROUGE, deplace);
		tasCartes.add(vo4);
		Carte vo5 = new Carte("Vo", Points.Trois, Couleur.ROUGE, deplace);
		tasCartes.add(vo5);
		Carte vo6 = new Carte("Vo", Points.Trois, Couleur.ROUGE, deplace);
		tasCartes.add(vo6);
		
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
