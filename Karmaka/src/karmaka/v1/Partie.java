package karmaka.v1;

import java.util.ArrayList;

import java.util.Iterator;


public class Partie {

	// attributs d'une Partie 
	private ArrayList<Joueur> listJ;
	private JeuCartes jeu;
	private ArrayList<Carte> defausse;
	
	
	//******************Constructeur de la partie*************
	public Partie() {
		// instanciation de la liste des joueurs 
		listJ = new ArrayList<>();
		
		// instanciation du jeu de carte 
		jeu = new JeuCartes();
		
		// instanciation de la defausse 
		defausse = new ArrayList<>();
	}
	
	//******************Ajouter un joueur à la liste des joueurs*********
	public void ajouterUnJoueur(Joueur joueur) {
		listJ.add(joueur);
	}
	
	//*******************Ajouter des cartes dans la défausse**************
	public void defausser(Carte carte) {
		defausse.add(carte);
	}
	
    //*****************Mélange et distribution**************************
	public void distribuerCartes(){
		jeu.melanger();
		for (int i=0; i<4;i++) {
			Iterator<Joueur> it =listJ.iterator();
			while(it.hasNext()){
				Carte carte = jeu.distribuerUneCarte();
				it.next().ramasserCarte(carte);
			}
		}
		for (int i=0; i<2;i++) {
			Iterator<Joueur> it =listJ.iterator();
			while(it.hasNext()){
				Carte carte = jeu.distribuerUneCarte();
				it.next().ajouterPile(carte);
			}
		}	
		
	}
	
	
	// la partie est terminée quand un vainqueur est trouvé
	public boolean partieTerminee() {
		boolean fin =false;
		Iterator<Joueur> it =listJ.iterator();
		while (it.hasNext() && fin == false) {
			Joueur jj = it.next();
			fin=jj.isWinner();
		}
		return fin;		
	}
	
	//*****************Méthode Main************************************
	
	public static void main(String[] args) {
		// Création d'une partie Karmaka
		Partie karmaka = new Partie();
		Terminal terminal = new Terminal();
		String saisieClavier = new String();
		String nomJoueur1 = new String();
		String nomJoueur2 = new String();
		
		System.out.println("Saisissez le nom du Joueur 1 : ");
		nomJoueur1 = terminal.lireChaine();
		System.out.println("Saisissez le nom du Joueur 2 : ");
		nomJoueur2= terminal.lireChaine();
		
		// création de deux joueurs 
		Joueur Joueur1 = new Joueur(nomJoueur1);
		Joueur Joueur2 = new Joueur(nomJoueur2);
		
		// on ajoute les 2 joueurs à la partie
		karmaka.ajouterUnJoueur(Joueur1);
		karmaka.ajouterUnJoueur(Joueur2);
		
		// on affiche le jeu de cartes
		System.out.println("Les cartes du jeu sont : " + karmaka.jeu);
		System.out.println("Appuyez sur Entrée pour distribuer les cartes et commencer le jeu !");
		saisieClavier = terminal.lireChaine();
		
		// on distribue les cartes à l'ensemble des joueurs
		karmaka.distribuerCartes();
		
		// on affiche les 2 joueurs de cette partie
		// System.out.println(karmaka.listJ.get(0));
		// System.out.println(karmaka.listJ.get(1));
		
		
		int joueurActuel = 0; // Pour montrer qui est en train de jouer. En fait la variable prendre que la valeur 0 ou 1. 
		Carte cartePlateau = null; // La carte qui a été joué au tour précédent 
		
		while (karmaka.partieTerminee()==false) {
			
			 
			 Joueur joueurCourant = karmaka.listJ.get(joueurActuel);
			 joueurActuel = (joueurActuel + 1) % 2;
			 
			 
			 //************************Phase de sélection de la carte sur le plateau ou non**********************************
			 if (cartePlateau != null) {
				 System.out.println("La carte sur le plateau est "+cartePlateau.getNom()+" Souhaitez-vous la prendre ?");
				 System.out.println("(1) Oui (2) Non");
				 saisieClavier = terminal.lireChaine();
				 
				 if (saisieClavier.equals("1")) {
					 joueurCourant.ajouterVieFuture(cartePlateau);
					 cartePlateau = null; 
				 }
				 else {
					 karmaka.defausser(cartePlateau);
					 cartePlateau = null; 
				 }
				 
			 }
			 
			 //*************************Début du tour**************************************************************************
			 System.out.println(joueurCourant);
			 
			 saisieClavier = "nan";
			 
			 while (!(saisieClavier.equals("1") || saisieClavier.equals("2") || saisieClavier.equals("3"))) {
			 System.out.println("Sélectionnez une action : (1) Vie Future (2) Oeuvre (3) Jouer (4) Voir défausse");
			 saisieClavier = terminal.lireChaine();
			 
			 	if (saisieClavier.equals("4")) {
			 		System.out.println(karmaka.defausse);
			 	}
			 }
			 
			 
			 if (saisieClavier.equals("1")) {
				    System.out.println("Sélectionnez une carte de votre main à mettre dans la vie future : ");
					 saisieClavier = terminal.lireChaine();
					 Carte carteChoisie = joueurCourant.getCarteDeMain(saisieClavier);
					 joueurCourant.ajouterVieFuture(carteChoisie);
					 joueurCourant.retirerCarte(carteChoisie);
			 }
			 else if (saisieClavier.equals("2")) {
				    System.out.println("Sélectionnez une carte à mettre dans vos oeuvres : ");
					 saisieClavier = terminal.lireChaine();
					 Carte carteChoisie = joueurCourant.getCarteDeMain(saisieClavier);
					 joueurCourant.ajouterOeuvre(carteChoisie);
					 joueurCourant.retirerCarte(carteChoisie);
			 }
			 else if (saisieClavier.equals("3")) {
				    System.out.println("Sélectionnez une carte à jouer : ");
					 saisieClavier = terminal.lireChaine();
					 Carte carteChoisie = joueurCourant.getCarteDeMain(saisieClavier);
					 cartePlateau = carteChoisie;
					 joueurCourant.retirerCarte(carteChoisie);
			 }
			 
			else {
				    System.out.println("Désolé pas encore codé");
				}
			
		}
		
	}
	

}
