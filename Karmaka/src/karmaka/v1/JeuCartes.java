package karmaka.v1;


import karmaka.v1.effet.*;
import java.io.*;

import java.util.Collections;
import java.util.LinkedList;


public class JeuCartes implements Serializable {
	
	// attributs d'un jeu de cartes
	private LinkedList<Carte> tasCartes;
	public static final int nbrCartes = 64;

	
	// constructeur du jeu de cartes
	public JeuCartes(Partie partie){
		// instancie le jeu de cartes 
		this.tasCartes = new LinkedList<>();

		// Instance des effets

		// deplacer

		Effet deplacerVfToMain = new Deplacer(partie, partie.getJoueur().getViefuture(), partie.getJoueur().getMain());

		Effet deplacerMainToVf = new Deplacer(partie, partie.getJoueur().getMain(), partie.getJoueur().getViefuture());

		Effet deplacerMainToMain = new Deplacer(partie, partie.getJoueur().getMain(), partie.getAdversaire().getMain());

		Effet deplacerFosseToVf = new Deplacer(partie, partie.getDefausse(), partie.getJoueur().getViefuture());

		Effet deplacerFosseToMain = new Deplacer(partie, partie.getDefausse(), partie.getJoueur().getMain());//peut etre puiser

		Effet deplacerSourceToPile = new Puiser(partie, getTasCartes(), partie.getAdversaire().getPile());

		Effet deplacerMaintoOuvre = new Deplacer(partie, partie.getJoueur().getMain(), partie.getJoueur().getOeuvres());

		Effet deplacerMainAdvToFosse = new Deplacer(partie, partie.getAdversaire().getMain(), partie.getDefausse());

		Effet deplacerVfToFosse = new Deplacer(partie, partie.getAdversaire().getViefuture(), partie.getDefausse());

		Effet deplacerOuvreToFosse = new Puiser(partie, partie.getAdversaire().getOeuvres(), partie.getDefausse());//sort la prmiere carte des oeuvres et non la dernière

		Effet deplacerMaintoFosse = new Deplacer(partie, partie.getJoueur().getMain(), partie.getDefausse());

		//*********************************puiser*****************************

		Effet puiserSourceAdv = new Puiser(partie, getTasCartes(), partie.getAdversaire().getPile());

		Effet puiserVftoVf = new Puiser(partie, partie.getAdversaire().getViefuture(), partie.getJoueur().getViefuture());

		Effet puiserOuvreToMain = new Puiser(partie, partie.getAdversaire().getOeuvres(), partie.getJoueur().getMain());

		Effet puiserSource = new Puiser(partie, getTasCartes(), partie.getJoueur().getPile());

		Effet puiserVftoFosse = new Puiser(partie, partie.getAdversaire().getViefuture(), partie.getDefausse());

		Effet puiserOeuvreToFosse = new Puiser(partie, partie.getAdversaire().getOeuvres(), partie.getDefausse());

		Effet puiserMainAdvToFosse = new Puiser(partie, partie.getAdversaire().getMain(), partie.getDefausse());

		//******************************** copier*****************************

		Effet copierDeni = new Copier(partie, partie.getDefausse().getLast());


		//*********************************rejouer*****************************

		Effet rejouer = new Rejouer(partie, partie.getJoueur().getMain());


		//**********************************regarder****************************

		Effet regaderVf = new Regarder(partie, partie.getJoueur().getViefuture());

		Effet regarderMain = new Regarder(partie, partie.getAdversaire().getMain());

		Effet regarderSource = new Regarder(partie, getTasCartes());
		
		
		//***************************Arranger********************************

		Effet arrangerTest = new Arranger(partie, 3, 2, partie.getAdversaire().getMain(), partie.getJoueur().getMain(), true, false);

		Effet arrangerDestinee = new Arranger(partie, 3, 2, getTasCartes(), partie.getJoueur().getViefuture(), false, false);

		Effet arrangerDuperie = new Arranger(partie, 3, 1, partie.getAdversaire().getMain(), partie.getJoueur().getMain(), true, true);




		//Création des cartes



//*****************************************Cartes Bleus******************************************************
		
		Carte Transmigration1 = new Carte("Transmigration", Points.Un, Couleur.BLEU, Description.TRANSMIGRATION.getDescription());
		Transmigration1.addEffet(deplacerVfToMain);
		tasCartes.add(Transmigration1);
		Carte Transmigration2 = new Carte("Transmigration", Points.Un, Couleur.BLEU, Description.TRANSMIGRATION.getDescription());
		Transmigration2.addEffet(deplacerVfToMain);
		tasCartes.add(Transmigration2);
		Carte Transmigration3 = new Carte("Transmigration", Points.Un, Couleur.BLEU, Description.TRANSMIGRATION.getDescription());
		Transmigration3.addEffet(deplacerVfToMain);
		tasCartes.add(Transmigration3);
		
		Carte Destinee1 = new Carte("Destinee", Points.Un, Couleur.BLEU, Description.DESTINEE.getDescription());
		Destinee1.addEffet(arrangerDestinee);
		tasCartes.add(Destinee1);
		Carte Destinee2 = new Carte("Destinee", Points.Un, Couleur.BLEU, Description.DESTINEE.getDescription());
		Destinee2.addEffet(arrangerDestinee);
		tasCartes.add(Destinee2);
		Carte Destinee3 = new Carte("Destinee", Points.Un, Couleur.BLEU, Description.DESTINEE.getDescription());
		Destinee3.addEffet(arrangerDestinee);
		tasCartes.add(Destinee3);
		
		Carte Coupdoeil1 = new Carte("Coup D'Oeil", Points.Un, Couleur.BLEU, Description.OEIL.getDescription());
		Coupdoeil1.addEffet(regarderMain);
		Coupdoeil1.addEffet(rejouer);
		tasCartes.add(Coupdoeil1);
		Carte Coupdoeil2 = new Carte("Coup D'Oeil", Points.Un, Couleur.BLEU, Description.OEIL.getDescription());
		Coupdoeil2.addEffet(regarderMain);
		Coupdoeil2.addEffet(rejouer);
		tasCartes.add(Coupdoeil2);
		Carte Coupdoeil3 = new Carte("Coup D'Oeil", Points.Un, Couleur.BLEU, Description.OEIL.getDescription());
		Coupdoeil3.addEffet(regarderMain);
		Coupdoeil3.addEffet(rejouer);
		tasCartes.add(Coupdoeil3);
		
		Carte ReveBrises1 = new Carte("Rêves Brisés", Points.Deux, Couleur.BLEU,Description.REVES.getDescription());
		ReveBrises1.addEffet(puiserVftoVf);
		tasCartes.add(ReveBrises1);
		Carte ReveBrises2 = new Carte("Rêves Brisés", Points.Deux, Couleur.BLEU, Description.REVES.getDescription());
		ReveBrises2.addEffet(puiserVftoVf);
		tasCartes.add(ReveBrises2);
		Carte ReveBrises3 = new Carte("Rêves Brisés", Points.Deux, Couleur.BLEU, Description.REVES.getDescription());
		ReveBrises3.addEffet(puiserVftoVf);
		tasCartes.add(ReveBrises3);
		
		Carte Duperie1 = new Carte("Duperie", Points.Trois, Couleur.BLEU, Description.DUPERIE.getDescription());
		Duperie1.addEffet(arrangerDuperie);
		tasCartes.add(Duperie1);
		Carte Duperie2 = new Carte("Duperie", Points.Trois, Couleur.BLEU, Description.DUPERIE.getDescription());
		Duperie2.addEffet(arrangerDuperie);
		tasCartes.add(Duperie2);
		
		Carte Deni1 = new Carte("Déni", Points.Deux, Couleur.BLEU, Description.DENI.getDescription());
		Deni1.addEffet(deplacerMaintoFosse);
		Deni1.addEffet(copierDeni);
		tasCartes.add(Deni1);
		Carte Deni2 = new Carte("Déni", Points.Deux, Couleur.BLEU, Description.DENI.getDescription());
		Deni2.addEffet(deplacerMaintoFosse);
		Deni2.addEffet(copierDeni);
		tasCartes.add(Deni2);
		Carte Deni3 = new Carte("Déni", Points.Deux, Couleur.BLEU, Description.DENI.getDescription());
		Deni3.addEffet(deplacerMaintoFosse);
		Deni3.addEffet(copierDeni);
		tasCartes.add(Deni3);
		
		Carte vol1 = new Carte("Vol", Points.Trois, Couleur.BLEU, Description.VOL.getDescription());
		vol1.addEffet(puiserOuvreToMain);
		tasCartes.add(vol1);
		Carte vol2 = new Carte("Vol", Points.Trois, Couleur.BLEU, Description.VOL.getDescription());
		vol2.addEffet(puiserOuvreToMain);
		tasCartes.add(vol2);


		//*********************************Cartes Vertes**************************************************************

		Carte Lendemain1 = new Carte("Lendemain", Points.Un, Couleur.VERT, Description.LENDEMAIN.getDescription());
		Lendemain1.addEffet(puiserSource);
		Lendemain1.addEffet(rejouer);
		tasCartes.add(Lendemain1);
		Carte Lendemain2 = new Carte("Lendemain", Points.Un, Couleur.VERT, Description.LENDEMAIN.getDescription());
		Lendemain2.addEffet(puiserSource);
		Lendemain2.addEffet(rejouer);
		tasCartes.add(Lendemain2);
		Carte Lendemain3 = new Carte("Lendemain", Points.Un, Couleur.VERT, Description.LENDEMAIN.getDescription());
		Lendemain3.addEffet(puiserSource);
		Lendemain3.addEffet(rejouer);
		tasCartes.add(Lendemain3);

		Carte Recyclage1 = new Carte("Recyclage", Points.Un, Couleur.VERT, Description.RECYCLAGE.getDescription());
		Recyclage1.addEffet(deplacerFosseToVf); //on ne peut chosir que parmi les 3 dernieres cartes de la fosse normalement
		tasCartes.add(Recyclage1);
		Carte Recyclage2 = new Carte("Recyclage", Points.Un, Couleur.VERT, Description.RECYCLAGE.getDescription());
		Recyclage2.addEffet(deplacerFosseToVf);
		tasCartes.add(Recyclage2);
		Carte Recyclage3 = new Carte("Recyclage", Points.Un, Couleur.VERT, Description.RECYCLAGE.getDescription());
		Recyclage3.addEffet(deplacerFosseToVf);
		tasCartes.add(Recyclage3);

		Carte Sauvetage1 = new Carte("Sauvetage", Points.Deux, Couleur.VERT, Description.SAUVETAGE.getDescription());
		Sauvetage1.addEffet(deplacerFosseToMain);//pareil qu'au dessus
		tasCartes.add(Sauvetage1);
		Carte Sauvetage2 = new Carte("Sauvetage", Points.Deux, Couleur.VERT, Description.SAUVETAGE.getDescription());
		Sauvetage2.addEffet(deplacerFosseToMain);
		tasCartes.add(Sauvetage2);
		Carte Sauvetage3 = new Carte("Sauvetage", Points.Deux, Couleur.VERT, Description.SAUVETAGE.getDescription());
		Sauvetage3.addEffet(deplacerFosseToMain);
		tasCartes.add(Sauvetage3);

		Carte Longevite1 = new Carte("Longévité", Points.Deux, Couleur.VERT, Description.LONGEVITE.getDescription());
		Longevite1.addEffet(2, puiserSourceAdv);
		tasCartes.add(Longevite1);
		Carte Longevite2 = new Carte("Longévité", Points.Deux, Couleur.VERT, Description.LONGEVITE.getDescription());
		Longevite2.addEffet(2, puiserSourceAdv);
		tasCartes.add(Longevite2);
		Carte Longevite3 = new Carte("Longévité", Points.Deux, Couleur.VERT, Description.LONGEVITE.getDescription());
		Longevite3.addEffet(2, puiserSourceAdv);
		tasCartes.add(Longevite3);

		Carte Semis1 = new Carte("Semis", Points.Deux, Couleur.VERT, Description.SEMIS.getDescription());
		Semis1.addEffet(2, puiserSource);
		Semis1.addEffet(2,deplacerMainToVf);
		tasCartes.add(Semis1);
		Carte Semis2 = new Carte("Semis", Points.Deux, Couleur.VERT, Description.SEMIS.getDescription());
		Semis2.addEffet(2, puiserSource);
		Semis2.addEffet(2,deplacerMainToVf);
		tasCartes.add(Semis2);
		Carte Semis3 = new Carte("Semis", Points.Deux, Couleur.VERT, Description.SEMIS.getDescription());
		Semis3.addEffet(2, puiserSource);
		Semis3.addEffet(2,deplacerMainToVf);
		tasCartes.add(Semis3);

		Carte Voyage1 = new Carte("Voyage", Points.Trois, Couleur.VERT, Description.VOYAGE.getDescription());
		Voyage1.addEffet(3, puiserSource);
		Voyage1.addEffet(rejouer);
		tasCartes.add(Voyage1);
		Carte Voyage2 = new Carte("Voyage", Points.Trois, Couleur.VERT, Description.VOYAGE.getDescription());
		Voyage2.addEffet(3, puiserSource);
		Voyage2.addEffet(rejouer);
		tasCartes.add(Voyage2);

		Carte Jubilé1 = new Carte("Jubilé", Points.Trois, Couleur.VERT, Description.JUBILE.getDescription());
		Jubilé1.addEffet(2, deplacerMaintoOuvre); //normaelement, on peut en poser qu'une voir aucune
		tasCartes.add(Jubilé1);
		Carte Jubilé2 = new Carte("Jubilé", Points.Trois, Couleur.VERT, Description.JUBILE.getDescription());
		Jubilé2.addEffet(2, deplacerMaintoOuvre);
		tasCartes.add(Jubilé2);


		//*********************************Cartes Rouges**************************************************************

		Carte Panique1 = new Carte("Panique", Points.Un, Couleur.ROUGE, Description.PANIQUE.getDescription());
		Panique1.addEffet(puiserVftoFosse);
		Panique1.addEffet(rejouer);
		tasCartes.add(Panique1);
		Carte Panique2 = new Carte("Panique", Points.Un, Couleur.ROUGE, Description.PANIQUE.getDescription());
		Panique2.addEffet(puiserVftoFosse);
		Panique2.addEffet(rejouer);
		tasCartes.add(Panique2);
		Carte Panique3 = new Carte("Panique", Points.Un, Couleur.ROUGE, Description.PANIQUE.getDescription());
		Panique3.addEffet(puiserVftoFosse);
		Panique3.addEffet(rejouer);
		tasCartes.add(Panique3);

		Carte DernierSouffle1 = new Carte("Dernier Souffle", Points.Un, Couleur.ROUGE, Description.SOUFFLE.getDescription());
		DernierSouffle1.addEffet(deplacerMainAdvToFosse);
		tasCartes.add(DernierSouffle1);
		Carte DernierSouffle2 = new Carte("Dernier Souffle", Points.Un, Couleur.ROUGE, Description.SOUFFLE.getDescription());
		DernierSouffle2.addEffet(deplacerMainAdvToFosse);
		tasCartes.add(DernierSouffle2);
		Carte DernierSouffle3 = new Carte("Dernier Souffle", Points.Un, Couleur.ROUGE, Description.SOUFFLE.getDescription());
		DernierSouffle3.addEffet(deplacerMainAdvToFosse);
		tasCartes.add(DernierSouffle3);

		Carte Crise1 = new Carte("Crise", Points.Deux, Couleur.ROUGE, Description.CRISE.getDescription());
		Crise1.addEffet(deplacerOuvreToFosse);
		tasCartes.add(Crise1);
		Carte Crise2 = new Carte("Crise", Points.Deux, Couleur.ROUGE, Description.CRISE.getDescription());
		Crise2.addEffet(deplacerOuvreToFosse);
		tasCartes.add(Crise2);
		Carte Crise3 = new Carte("Crise", Points.Deux, Couleur.ROUGE, Description.CRISE.getDescription());
		Crise3.addEffet(deplacerOuvreToFosse);
		tasCartes.add(Crise3);

		Carte Roulette1 = new Carte("Roulette", Points.Deux, Couleur.ROUGE, Description.ROULETTE.getDescription());
		Roulette1.addEffet(2, deplacerMaintoFosse);//normalement, on peut en poser qu'une voir aucune
		Roulette1.addEffet(3, puiserSource);
		tasCartes.add(Roulette1);
		Carte Roulette2 = new Carte("Roulette", Points.Deux, Couleur.ROUGE, Description.ROULETTE.getDescription());
		Roulette2.addEffet(2, deplacerMaintoFosse);
		Roulette2.addEffet(3, puiserSource);
		tasCartes.add(Roulette2);
		Carte Roulette3 = new Carte("Roulette", Points.Deux, Couleur.ROUGE, Description.ROULETTE.getDescription());
		Roulette3.addEffet(2, deplacerMaintoFosse);
		Roulette3.addEffet(3, puiserSource);
		tasCartes.add(Roulette3);

		Carte Fournaise1 = new Carte("Fournaise", Points.Deux, Couleur.ROUGE, Description.FOURNAISE.getDescription());
		Fournaise1.addEffet(2, puiserVftoFosse);
		tasCartes.add(Fournaise1);
		Carte Fournaise2 = new Carte("Fournaise", Points.Deux, Couleur.ROUGE, Description.FOURNAISE.getDescription());
		Fournaise2.addEffet(2, puiserVftoFosse);
		tasCartes.add(Fournaise2);
		Carte Fournaise3 = new Carte("Fournaise", Points.Deux, Couleur.ROUGE, Description.FOURNAISE.getDescription());
		Fournaise3.addEffet(2, puiserVftoFosse);
		tasCartes.add(Fournaise3);

		Carte Vengeance1 = new Carte("Vengeance", Points.Trois, Couleur.ROUGE, Description.VENGEANCE.getDescription());
		Vengeance1.addEffet(puiserOeuvreToFosse);
		tasCartes.add(Vengeance1);
		Carte Vengeance2 = new Carte("Vengeance", Points.Trois, Couleur.ROUGE, Description.VENGEANCE.getDescription());
		Vengeance2.addEffet(puiserOeuvreToFosse);
		tasCartes.add(Vengeance2);

		Carte Bassesse1 = new Carte("Bassesse", Points.Trois, Couleur.ROUGE, Description.BASSESSE.getDescription());
		Bassesse1.addEffet(2, puiserMainAdvToFosse);
		tasCartes.add(Bassesse1);
		Carte Bassesse2 = new Carte("Bassesse", Points.Trois, Couleur.ROUGE, Description.BASSESSE.getDescription());
		Bassesse2.addEffet(2, puiserMainAdvToFosse);
		tasCartes.add(Bassesse2);

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
