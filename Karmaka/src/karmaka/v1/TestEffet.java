package karmaka.v1;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestEffet implements Effet {
	
	private LinkedList<Carte> defausse;
	private Partie partie;
	//private LinkedList<Carte> depart;

	public TestEffet(Partie partie, LinkedList<Carte> defausse) {
		this.defausse = defausse;
		this.partie = partie;
		//this.arrivee = arrivee;
	}
	
	
	@Override
	public void effet(Partie partie, Joueur joueur, int nombre, LinkedList<Carte> depart, LinkedList<Carte> arrivee, String cible, Carte carte){
		//carte = depart.getFirst();
    	//depart.remove(carte);
    	//arrivee.add(carte);
		
		System.out.println(defausse);
		
	    //if (depart != null && !depart.isEmpty()) {
	      //  carte = depart.getFirst();
	        // Faites ce que vous avez besoin de faire avec "carte"
	        // depart.remove(carte);
	        // arrivee.add(carte);
	   // } else {
	    //    System.out.println("Erreur : la liste depart est null ou vide.");
	    //}
		
	}
	
	@Override
	public void applyEffet(Partie partie) {
		effet(partie, null, 0, null, null, "", null);
		System.out.println("L'effet s'active bien");
	}
}
