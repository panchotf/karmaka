package karmaka.v1;


import karmaka.v1.effet.*;

import java.util.Collections;
import java.util.LinkedList;


public class JeuCartes {
	
	// attributs d'un jeu de cartes
	private LinkedList<Carte> tasCartes;
	public static final int nbrCartes = 64;

	
	// constructeur du jeu de cartes
	public JeuCartes(Partie partie){
		// instancie le jeu de cartes 
		this.tasCartes = new LinkedList<>();

		// Instance des effets

		// deplacer

		Effet deplacerVfToMain = new Deplacer(partie, partie.getAdversaire().getViefuture(), partie.getJoueur().getMain());

		Effet deplacerMainToVf = new Deplacer(partie, partie.getJoueur().getMain(), partie.getJoueur().getViefuture());

		Effet deplacerVftoVf = new Deplacer(partie, partie.getAdversaire().getViefuture(), partie.getJoueur().getViefuture());

		Effet deplacerMainToMain = new Deplacer(partie, partie.getJoueur().getMain(), partie.getAdversaire().getMain());

		Effet deplacerMaintoFosse = new Deplacer(partie, partie.getJoueur().getMain(), partie.getDefausse());

		Effet deplacerOuvreToMain = new Deplacer(partie, partie.getAdversaire().getOeuvreExposee(), partie.getJoueur().getMain());

		Effet puiserSource = new Deplacer(partie, partie.getJeu().getTasCartes(), partie.getJoueur().getPile());

		Effet deplacerFosseToVf = new Deplacer(partie, partie.getDefausse(), partie.getJoueur().getViefuture());

		Effet deplacerFosseToMain = new Deplacer(partie, partie.getDefausse(), partie.getJoueur().getMain());

		Effet deplacerSourceToPile = new Deplacer(partie, partie.getJeu().getTasCartes(), partie.getAdversaire().getPile());

		Effet deplacerMaintoOuvre = new Deplacer(partie, partie.getJoueur().getMain(), partie.getAdversaire().getOeuvres());

		Effet deplacerMainAdvToFosse = new Deplacer(partie, partie.getAdversaire().getMain(), partie.getDefausse());

		Effet deplacerVfToFosse = new Deplacer(partie, partie.getAdversaire().getViefuture(), partie.getDefausse());

		Effet deplacerOuvreToFosse = new Deplacer(partie, partie.getAdversaire().getOeuvreExposee(), partie.getDefausse());






		// copier
		Effet copier = new Copier(partie, partie.getDefausse());

		//regarder
		Effet regarder = new Regarder(partie, partie.getDefausse(), true);

		Effet regaderVf = new Regarder(partie, partie.getJoueur().getViefuture(), false);

		Effet regarderMain = new Regarder(partie, partie.getAdversaire().getMain(), false);

		Effet regarderSource = new Regarder(partie, partie.getJeu().getTasCartes(), false);





		
		// On créé toutes les cartes

//		test
		Carte test1 = new Carte("test1", Points.Un, Couleur.BLEU);
		test1.addEffet(regarder);
		test1.addEffet(3, deplacerMainToVf);
		test1.addEffet(copier);
		test1.addEffet(regaderVf);
		tasCartes.add(test1);

		Carte test2 = new Carte("test2", Points.Un, Couleur.BLEU);
		test2.addEffet(regarder);
		test2.addEffet(3, deplacerMainToVf);
		test2.addEffet(copier);
		tasCartes.add(test2);

		//création de 12 autres cartes test
		for(int i=3; i<15; i++){
			Carte test = new Carte("test"+i, Points.Un, Couleur.BLEU);
			test.addEffet(3, deplacerMainToVf);
			tasCartes.add(test);
		}




		
		/*Carte transmigration1 = new Carte("Transmigration", Points.Un, Couleur.BLEU);
		transmigration1.addEffet(deplacerVfToMain);
		tasCartes.add(transmigration1);
		Carte transmigration2 = new Carte("Transmigration", Points.Un, Couleur.BLEU);
		transmigration2.addEffet(deplacerVfToMain);
		tasCartes.add(transmigration2);
		Carte transmigration3 = new Carte("Transmigration", Points.Un, Couleur.BLEU);
		transmigration3.addEffet(deplacerVfToMain);
		tasCartes.add(transmigration3);
		
		Carte destinee1 = new Carte("Destinee", Points.Un, Couleur.BLEU);
		tasCartes.add(destinee1);
		Carte destinee2 = new Carte("Destinee", Points.Un, Couleur.BLEU);
		tasCartes.add(destinee2);
		Carte destinee3 = new Carte("Destinee", Points.Un, Couleur.BLEU);
		tasCartes.add(destinee3);
		
		Carte Coupdoeil1 = new Carte("Coup D'Oeil", Points.Trois, Couleur.BLEU);
		tasCartes.add(Coupdoeil1);
		Carte Coupdoeil2 = new Carte("Coup D'Oeil", Points.Trois, Couleur.BLEU);
		tasCartes.add(Coupdoeil2);
		Carte Coupdoeil3 = new Carte("Coup D'Oeil", Points.Trois, Couleur.BLEU);
		tasCartes.add(Coupdoeil3);
		
		Carte ReveBrises1 = new Carte("Rêves Brisés", Points.Trois, Couleur.BLEU);
		tasCartes.add(ReveBrises1);
		Carte ReveBrises2 = new Carte("Rêves Brisés", Points.Trois, Couleur.BLEU);
		tasCartes.add(ReveBrises2);
		Carte ReveBrises3 = new Carte("Rêves Brisés", Points.Trois, Couleur.BLEU);
		tasCartes.add(ReveBrises3);
		
		Carte duperie1 = new Carte("Duperie", Points.Trois, Couleur.BLEU);
		tasCartes.add(duperie1);
		Carte duperie2 = new Carte("Duperie", Points.Trois, Couleur.BLEU);
		tasCartes.add(duperie2);
		
		Carte deni1 = new Carte("Déni", Points.Trois, Couleur.BLEU);
		tasCartes.add(deni1);
		Carte deni2 = new Carte("Déni", Points.Trois, Couleur.BLEU);
		tasCartes.add(deni2);
		Carte deni3 = new Carte("Déni", Points.Trois, Couleur.BLEU);
		tasCartes.add(deni3);
		
		Carte vol1 = new Carte("Vol", Points.Trois, Couleur.BLEU);
		tasCartes.add(vol1);
		//Carte vol2 = new Carte("Vol", Points.Trois, Couleur.BLEU);
		//tasCartes.add(vol2);
		
		Carte vo1 = new Carte("Vo", Points.Trois, Couleur.ROUGE);
		tasCartes.add(vo1);
		Carte vo2 = new Carte("Vo", Points.Trois, Couleur.ROUGE);
		tasCartes.add(vo2);
		Carte vo3 = new Carte("Vo", Points.Trois, Couleur.ROUGE);
		tasCartes.add(vo3);
		Carte vo4 = new Carte("Vo", Points.Trois, Couleur.ROUGE);
		tasCartes.add(vo4);
		Carte vo5 = new Carte("Vo", Points.Trois, Couleur.ROUGE);
		tasCartes.add(vo5);
		Carte vo6 = new Carte("Vo", Points.Trois, Couleur.ROUGE);
		tasCartes.add(vo6);
		*/
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
