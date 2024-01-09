package karmaka.v1;

import java.util.LinkedList;
import java.io.*;

/**
 * Interface des effets des cartes
 */
public interface Effet extends Serializable {

	/**
	 * Methode qui permet d'appliquer l'effet de la carte
	 * @param partie
	 * @param nombre
	 * @param nombreMax
	 * @param cible
	 * @param arrivee
	 * @param opif
	 * @param obligatoire
	 */
	void effet(Partie partie, Joueur joueur, int nombre, int nombreMax, LinkedList<Carte> depart, LinkedList<Carte> arrivee, String cible, Carte carte, boolean opif, boolean obligatoire);

	/**
	 * Methode qui permet d'appliquer l'effet de la carte
	 * @param partie
	 */
	void applyEffet(Partie partie);

}
