package karmaka.v1;

import java.util.LinkedList;

public class EffetDummy implements Effet {
	
	
	private LinkedList<Carte> depart;
	private LinkedList<Carte> arrivee;

	public EffetDummy(Partie partie, LinkedList<Carte> depart, LinkedList<Carte> arrivee) {
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
	public void effet(Partie partie, Joueur joueur, int nombre, LinkedList<Carte> depart, LinkedList<Carte> arrivee, String cible, Carte carte){

	}
	
	@Override
	public void applyEffet(Partie partie) {
		//Carte carte = getPartie().getDefausse().getFirst();
		//System.out.println(partie.getDefausse());
		System.out.println(getDepart());
		//getPartie().getDefausse().remove(carte);
		//partie.getTest().add(carte);
	}
}
