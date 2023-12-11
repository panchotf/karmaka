package karmaka.v1.effet;

import karmaka.v1.Carte;
import karmaka.v1.Effet;
import karmaka.v1.Joueur;
import karmaka.v1.Partie;

import java.util.LinkedList;

public class Deplacer implements Effet {
	
	
	private LinkedList<Carte> depart;
	private LinkedList<Carte> arrivee;

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
		//Carte carte = getPartie().getDefausse().getFirst();
		//System.out.println(partie.getDefausse());
		System.out.println(getDepart());
		System.out.println(getArrivee());
		//getPartie().getDefausse().remove(carte);
		//partie.getTest().add(carte);
	}
}
