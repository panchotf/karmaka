package karmaka.v1;

import java.util.ArrayList;


import java.util.LinkedList;

import java.util.Iterator;
import java.io.*;


public class Partie implements Serializable {

	// attributs d'une Partie 
	private ArrayList<Joueur> listJ;
	private JeuCartes jeu;
	private LinkedList<Carte> defausse;
	private LinkedList<Carte> test;
	private int joueurActuel; // Pour montrer qui est en train de jouer. En fait la variable prendre que la valeur 0 ou 1. 
	
	
	//******************Constructeur de la partie*************
	public Partie(String Joueur1, String Joueur2) {
		// instanciation de la liste des joueurs 
		listJ = new ArrayList<>();
		

		//new instanciation joueurs
		Joueur joueur1 = new Joueur(Joueur1);
		Joueur joueur2 = new Joueur(Joueur2);
		
		if (Joueur2.equals("IA")) {
			joueur2 = new IA();
        }

		// ajout des joueurs dans la liste des joueurs
		listJ.add(joueur1);
		listJ.add(joueur2);
		
	
		// instanciation de la defausse 
		defausse = new LinkedList<>();
		Carte transmigration1 = new Carte("Transmigration", Points.Un, Couleur.BLEU, Description.TRANSMIGRATION.getDescription());
		defausse.add(transmigration1);
		
		test = new LinkedList<>();
		
		joueurActuel = 0;
		
		// instanciation du jeu de carte 
		jeu = new JeuCartes(this);
	}
	
	//******************Ajouter un joueur à la liste des joueurs*********
	public void ajouterUnJoueur(Joueur joueur) {
		listJ.add(joueur);
	}
	
	//*******************Ajouter des cartes dans la défausse**************
	public void defausser(Carte carte) {
		defausse.add(carte);
		test.add(carte);
	}
	
	//******************Getter Defausse************************************
	
	public LinkedList<Carte> getDefausse() {
		return this.defausse;
	}
	
	public LinkedList<Carte> getTest() {
		return this.test;
	}
	
	//*********************Getter des Joueurs****************************
	
	public Joueur getJoueur() {
		return listJ.get(getJoueurActuel());
	}

	//methode pour récupérer l'adversaire
	public Joueur getAdversaire() {
		return listJ.get((getJoueurActuel()+1)%2);
	}
	
	
	public ArrayList<Joueur>  getListJ() {
		return this.listJ;
	}

	//*******************Getter du jeu de cartes*************************
	public JeuCartes getJeu() {
		return this.jeu;
	}


	//*******************Getter de cartes*******************************
	public Carte getCarte(LinkedList<Carte> tas, String nomCarte) {
		for (Carte carte : tas) {
			if (carte.getNom().equals(nomCarte)) {
				return carte;
			}
		}
		// Gestion d'erreur : la carte n'a pas été trouvée dans le tas
		return null;
	}

	public void removeCarte(LinkedList<Carte> tas, String nomCarte) {
		Carte carte = getCarte(tas, nomCarte);
		tas.remove(carte);
	}

	public void addCarte(LinkedList<Carte> tas, Carte carte) {
		tas.add(carte);
	}


	//********************Setter et Getter joueuractuel *****************
	
	public void setJoueurActuel(int joueurActuel) {
		this.joueurActuel = joueurActuel;
	}
	
	public int getJoueurActuel() {
		return joueurActuel;
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
	
	//*******************Puiser une carte de la source***********************
	
	public void puiserSource(Joueur joueurCourant) {
		Carte carte = jeu.distribuerUneCarte();
		joueurCourant.ajouterPile(carte);
	}

	//getter Source

	
	
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
	

}
