package karmaka.v1;

import java.util.LinkedList;

public interface Effet {
	
	void effet(Partie partie, Joueur joueur, int nombre, LinkedList<Carte> depart, LinkedList<Carte> arrivee, String cible, Carte carte);
	void applyEffet(Partie partie);

}
