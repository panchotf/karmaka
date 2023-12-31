package karmaka.v1;

import java.util.LinkedList;
import java.io.*;

public interface Effet extends Serializable {
	
	void effet(Partie partie, Joueur joueur, int nombre, int nombreMax, LinkedList<Carte> depart, LinkedList<Carte> arrivee, String cible, Carte carte, boolean opif, boolean obligatoire);
	void applyEffet(Partie partie);

}
