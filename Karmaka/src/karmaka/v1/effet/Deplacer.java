package karmaka.v1.effet;

import karmaka.v1.Carte;
import karmaka.v1.Effet;
import karmaka.v1.Joueur;
import karmaka.v1.Partie;
import karmaka.v1.Terminal;


import java.util.LinkedList;

public class Deplacer implements Effet {
	
	
	private LinkedList<Carte> depart;
	private LinkedList<Carte> arrivee;

	private String saisieClavier;
	private Terminal terminal = new Terminal();

	public Deplacer(Partie partie, LinkedList<Carte> depart, LinkedList<Carte> arrivee) {
		System.out.println(partie.getDefausse());
		this.depart = depart;
		this.arrivee = arrivee;

	}


	public LinkedList<Carte> getDepart(){
		return this.depart;
	}
	
	public LinkedList<Carte> getArrivee(){
		return this.arrivee;
	}
	
	
	
	@Override
	public void effet(Partie partie, Joueur joueur, int nombre, LinkedList<Carte> depart, LinkedList<Carte> arrivee, String cible, Carte carte, boolean opif){

	}
	
	@Override
	public void applyEffet(Partie partie) {
		System.out.println(depart);//affiche la liste des cartes du joueur

		while (partie.getCarte(depart, saisieClavier)==null) {//tant que la carte n'est pas dans la main du joueur
			System.out.println("Sélectionnez une carte à jouer : ");//on demande au joueur de choisir une carte
			saisieClavier = terminal.lireChaine();
		}
		Carte carteChoisie = partie.getCarte(depart, saisieClavier);//on récupère la carte choisie

		partie.addCarte(arrivee, carteChoisie);//on ajoute la carte à la liste des cartes arrivée

		partie.removeCarte(depart, saisieClavier);//on enlève la carte de la main du joueur
		System.out.println("La carte a bien été déplacée.");
	}

		//Carte carte = getPartie().getDefausse().getFirst();
		//System.out.println(partie.getDefausse());
		//System.out.println(getDepart());
		//System.out.println(getArrivee());
		//getPartie().getDefausse().remove(carte);
		//partie.getTest().add(carte);
}

