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

		Effet puiserVftoVf = new Puiser(partie, partie.getAdversaire().getViefuture(), partie.getJoueur().getViefuture());

		Effet deplacerMainToMain = new Deplacer(partie, partie.getJoueur().getMain(), partie.getAdversaire().getMain());

		Effet deplacerMaintoFosse = new Deplacer(partie, partie.getJoueur().getMain(), partie.getDefausse());

		Effet puiserOuvreToMain = new Puiser(partie, partie.getAdversaire().getOeuvres(), partie.getJoueur().getMain());

		Effet puiserSource = new Puiser(partie, getTasCartes(), partie.getJoueur().getPile());

		Effet deplacerFosseToVf = new Deplacer(partie, partie.getDefausse(), partie.getJoueur().getViefuture());

		Effet deplacerFosseToMain = new Deplacer(partie, partie.getDefausse(), partie.getJoueur().getMain());//peut etre puiser

		Effet deplacerSourceToPile = new Puiser(partie, getTasCartes(), partie.getAdversaire().getPile());

		Effet deplacerMaintoOuvre = new Deplacer(partie, partie.getJoueur().getMain(), partie.getAdversaire().getOeuvres());

		Effet deplacerMainAdvToFosse = new Deplacer(partie, partie.getAdversaire().getMain(), partie.getDefausse());

		Effet deplacerVfToFosse = new Deplacer(partie, partie.getAdversaire().getViefuture(), partie.getDefausse());

		Effet deplacerOuvreToFosse = new Puiser(partie, partie.getAdversaire().getOeuvres(), partie.getDefausse());//sort la prmiere carte des oeuvres et non la dernière






		// copier
		Effet copier = new Copier(partie, partie.getDefausse());

		//regarder
		Effet regarder = new Regarder(partie, partie.getDefausse());

		Effet regaderVf = new Regarder(partie, partie.getJoueur().getViefuture());

		Effet regarderMain = new Regarder(partie, partie.getAdversaire().getMain());

		Effet regarderSource = new Regarder(partie, getTasCartes());
		
		
		//***************************Arranger********************************

		Effet arrangerTest = new Arranger(partie, 3, 2, partie.getAdversaire().getMain(), partie.getJoueur().getMain(), true, false);

		Effet arrangerDestinee = new Arranger(partie, 3, 2, getTasCartes(), partie.getJoueur().getViefuture(), false, false);

		Effet arrangerDuperie = new Arranger(partie, 3, 1, partie.getAdversaire().getMain(), partie.getJoueur().getMain(), true, true);



		
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
			test.addEffet(arrangerTest);
//			test.addEffet(3, deplacerMainToVf);
			tasCartes.add(test);
		}




		
		Carte Transmigration1 = new Carte("Transmigration", Points.Un, Couleur.BLEU);
		Transmigration1.addEffet(deplacerVfToMain);
		tasCartes.add(Transmigration1);
		Carte Transmigration2 = new Carte("Transmigration", Points.Un, Couleur.BLEU);
		Transmigration2.addEffet(deplacerVfToMain);
		tasCartes.add(Transmigration2);
		Carte Transmigration3 = new Carte("Transmigration", Points.Un, Couleur.BLEU);
		Transmigration3.addEffet(deplacerVfToMain);
		tasCartes.add(Transmigration3);
		
		Carte Destinee1 = new Carte("Destinee", Points.Un, Couleur.BLEU);
		Destinee1.addEffet(arrangerDestinee);
		tasCartes.add(Destinee1);
		Carte Destinee2 = new Carte("Destinee", Points.Un, Couleur.BLEU);
		Destinee2.addEffet(arrangerDestinee);
		tasCartes.add(Destinee2);
		Carte Destinee3 = new Carte("Destinee", Points.Un, Couleur.BLEU);
		Destinee3.addEffet(arrangerDestinee);
		tasCartes.add(Destinee3);
		
		Carte Coupdoeil1 = new Carte("Coup D'Oeil", Points.Trois, Couleur.BLEU);
		Coupdoeil1.addEffet(regarderMain);
		tasCartes.add(Coupdoeil1);
		Carte Coupdoeil2 = new Carte("Coup D'Oeil", Points.Trois, Couleur.BLEU);
		Coupdoeil2.addEffet(regarderMain);
		tasCartes.add(Coupdoeil2);
		Carte Coupdoeil3 = new Carte("Coup D'Oeil", Points.Trois, Couleur.BLEU);
		Coupdoeil3.addEffet(regarderMain);
		tasCartes.add(Coupdoeil3);
		
		Carte ReveBrises1 = new Carte("Rêves Brisés", Points.Trois, Couleur.BLEU);
		ReveBrises1.addEffet(puiserVftoVf);
		tasCartes.add(ReveBrises1);
		Carte ReveBrises2 = new Carte("Rêves Brisés", Points.Trois, Couleur.BLEU);
		ReveBrises2.addEffet(puiserVftoVf);
		tasCartes.add(ReveBrises2);
		Carte ReveBrises3 = new Carte("Rêves Brisés", Points.Trois, Couleur.BLEU);
		ReveBrises3.addEffet(puiserVftoVf);
		tasCartes.add(ReveBrises3);
		
		Carte Duperie1 = new Carte("Duperie", Points.Trois, Couleur.BLEU);
		Duperie1.addEffet(arrangerDuperie);
		tasCartes.add(Duperie1);
		Carte Duperie2 = new Carte("Duperie", Points.Trois, Couleur.BLEU);
		Duperie2.addEffet(arrangerDuperie);
		tasCartes.add(Duperie2);
		
		Carte Deni1 = new Carte("Déni", Points.Trois, Couleur.BLEU);
		Deni1.addEffet(deplacerMaintoFosse);

		tasCartes.add(Deni1);
		Carte Deni2 = new Carte("Déni", Points.Trois, Couleur.BLEU);
		Deni2.addEffet(deplacerMaintoFosse);

		tasCartes.add(Deni2);
		Carte Deni3 = new Carte("Déni", Points.Trois, Couleur.BLEU);
		Deni3.addEffet(deplacerMaintoFosse);

		tasCartes.add(Deni3);
		
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
