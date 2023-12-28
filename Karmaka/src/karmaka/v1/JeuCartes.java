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

		Effet puiserSourceAdv = new Puiser(partie, getTasCartes(), partie.getAdversaire().getPile());

		Effet deplacerFosseToVf = new Deplacer(partie, partie.getDefausse(), partie.getJoueur().getViefuture());

		Effet deplacerFosseToMain = new Deplacer(partie, partie.getDefausse(), partie.getJoueur().getMain());//peut etre puiser

		Effet deplacerSourceToPile = new Puiser(partie, getTasCartes(), partie.getAdversaire().getPile());

		Effet deplacerMaintoOuvre = new Deplacer(partie, partie.getJoueur().getMain(), partie.getAdversaire().getOeuvres());

		Effet deplacerMainAdvToFosse = new Deplacer(partie, partie.getAdversaire().getMain(), partie.getDefausse());

		Effet deplacerVfToFosse = new Deplacer(partie, partie.getAdversaire().getViefuture(), partie.getDefausse());

		Effet deplacerOuvreToFosse = new Puiser(partie, partie.getAdversaire().getOeuvres(), partie.getDefausse());//sort la prmiere carte des oeuvres et non la dernière



		//******************************** copier*****************************

		Effet copierDeni = new Copier(partie, partie.getDefausse().getLast());

		//*********************************rejouer*****************************

		Effet rejouer = new Rejouer(partie, partie.getJoueur().getMain());

		//regarder
		Effet regarder = new Regarder(partie, partie.getDefausse());

		Effet regaderVf = new Regarder(partie, partie.getJoueur().getViefuture());

		Effet regarderMain = new Regarder(partie, partie.getAdversaire().getMain());

		Effet regarderSource = new Regarder(partie, getTasCartes());
		
		
		//***************************Arranger********************************

		Effet arrangerTest = new Arranger(partie, 3, 2, partie.getAdversaire().getMain(), partie.getJoueur().getMain(), true, false);

		Effet arrangerDestinee = new Arranger(partie, 3, 2, getTasCartes(), partie.getJoueur().getViefuture(), false, false);

		Effet arrangerDuperie = new Arranger(partie, 3, 1, partie.getAdversaire().getMain(), partie.getJoueur().getMain(), true, true);





		//Création des cartes



//*****************************************Cartes Bleus******************************************************
		
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
		Deni1.addEffet(copierDeni);
		tasCartes.add(Deni1);
		Carte Deni2 = new Carte("Déni", Points.Trois, Couleur.BLEU);
		Deni2.addEffet(deplacerMaintoFosse);
		Deni2.addEffet(copierDeni);
		tasCartes.add(Deni2);
		Carte Deni3 = new Carte("Déni", Points.Trois, Couleur.BLEU);
		Deni3.addEffet(deplacerMaintoFosse);
		Deni3.addEffet(copierDeni);
		tasCartes.add(Deni3);
		
		Carte vol1 = new Carte("Vol", Points.Trois, Couleur.BLEU);
		vol1.addEffet(puiserOuvreToMain);
		tasCartes.add(vol1);
		Carte vol2 = new Carte("Vol", Points.Trois, Couleur.BLEU);
		vol2.addEffet(puiserOuvreToMain);
		tasCartes.add(vol2);


		//*********************************Cartes Vertes**************************************************************

		Carte Lendemain1 = new Carte("Lendemain", Points.Un, Couleur.VERT);
		Lendemain1.addEffet(deplacerSourceToPile);
		Lendemain1.addEffet(rejouer);
		tasCartes.add(Lendemain1);
		Carte Lendemain2 = new Carte("Lendemain", Points.Un, Couleur.VERT);
		Lendemain2.addEffet(deplacerSourceToPile);
		Lendemain2.addEffet(rejouer);
		tasCartes.add(Lendemain2);
		Carte Lendemain3 = new Carte("Lendemain", Points.Un, Couleur.VERT);
		Lendemain3.addEffet(deplacerSourceToPile);
		Lendemain3.addEffet(rejouer);
		tasCartes.add(Lendemain3);

		Carte Recyclage1 = new Carte("Recyclage", Points.Un, Couleur.VERT);
		Recyclage1.addEffet(deplacerFosseToVf); //on ne peut chosir que parmi les 3 dernieres cartes de la fosse normalement
		tasCartes.add(Recyclage1);
		Carte Recyclage2 = new Carte("Recyclage", Points.Un, Couleur.VERT);
		Recyclage2.addEffet(deplacerFosseToVf);
		tasCartes.add(Recyclage2);
		Carte Recyclage3 = new Carte("Recyclage", Points.Un, Couleur.VERT);
		Recyclage3.addEffet(deplacerFosseToVf);
		tasCartes.add(Recyclage3);

		Carte Sauvetage1 = new Carte("Sauvetage", Points.Deux, Couleur.VERT);
		Sauvetage1.addEffet(deplacerFosseToMain);//pareil qu'au dessus
		tasCartes.add(Sauvetage1);
		Carte Sauvetage2 = new Carte("Sauvetage", Points.Deux, Couleur.VERT);
		Sauvetage2.addEffet(deplacerFosseToMain);
		tasCartes.add(Sauvetage2);
		Carte Sauvetage3 = new Carte("Sauvetage", Points.Deux, Couleur.VERT);
		Sauvetage3.addEffet(deplacerFosseToMain);
		tasCartes.add(Sauvetage3);

		Carte Longevite1 = new Carte("Longévité", Points.Deux, Couleur.VERT);
		Longevite1.addEffet(2, puiserSourceAdv);
		tasCartes.add(Longevite1);
		Carte Longevite2 = new Carte("Longévité", Points.Deux, Couleur.VERT);
		Longevite2.addEffet(2, puiserSourceAdv);
		tasCartes.add(Longevite2);
		Carte Longevite3 = new Carte("Longévité", Points.Deux, Couleur.VERT);
		Longevite3.addEffet(2, puiserSourceAdv);
		tasCartes.add(Longevite3);

		Carte Semis1 = new Carte("Semis", Points.Deux, Couleur.VERT);
		Semis1.addEffet(2, puiserSource;
		Semis1.addEffet(2,deplacerMainToVf));
		tasCartes.add(Semis1);
		Carte Semis2 = new Carte("Semis", Points.Deux, Couleur.VERT);
		Semis2.addEffet(2, puiserSource);
		Semis2.addEffet(2,deplacerMainToVf);
		tasCartes.add(Semis2);
		Carte Semis3 = new Carte("Semis", Points.Deux, Couleur.VERT);
		Semis3.addEffet(2, puiserSource);
		Semis3.addEffet(2,deplacerMainToVf);
		tasCartes.add(Semis3);

		Carte Voyage1 = new Carte("Voyage", Points.Trois, Couleur.VERT);
		Voyage1.addEffet(3, puiserSource);
		Voyage1.addEffet(rejouer);
		tasCartes.add(Voyage1);
		Carte Voyage2 = new Carte("Voyage", Points.Trois, Couleur.VERT);
		Voyage2.addEffet(3, puiserSource);
		Voyage2.addEffet(rejouer);
		tasCartes.add(Voyage2);

		Carte Jubilé1 = new Carte("Jubilé", Points.Trois, Couleur.VERT);
		Jubilé1.addEffet(2, deplacerMaintoOuvre); //normaelement, on peut en poser qu'une voir aucune
		tasCartes.add(Jubilé1);
		Carte Jubilé2 = new Carte("Jubilé", Points.Trois, Couleur.VERT);
		Jubilé2.addEffet(2, deplacerMaintoOuvre);
		tasCartes.add(Jubilé2);


		
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
