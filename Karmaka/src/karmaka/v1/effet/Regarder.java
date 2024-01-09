package karmaka.v1.effet;

import karmaka.v1.Carte;
import karmaka.v1.Effet;
import karmaka.v1.Joueur;
import karmaka.v1.Partie;

import java.util.*;

public class Regarder implements Effet {


    private LinkedList<Carte> cible;
    private Boolean opif;

    private int nombre;

    /** constructeur de la classe Regarder
     * @param partie
     * @param cible
     */
    public Regarder (Partie partie, LinkedList<Carte> cible) {
//        System.out.println(partie.getDefausse());
        this.cible = cible;
    }


    public LinkedList<Carte> getCible(){return this.cible;    }



    /** methode qui permet de regarder une carte
     * @param partie
     * @param nombre
     * @param nombreMax
     * @param cible
     * @param arrivee
     * @param opif
     * @param obligatoire
     */
    @Override
    public void effet(Partie partie, Joueur joueur, int nombre,int nombreMax, LinkedList<Carte> depart, LinkedList<Carte> arrivee, String cible, Carte carte, boolean opif, boolean obligatoire) {

    }

    /** methode qui permet d'appliquer l'effet de regarder une carte
     * @param partie
     */
    @Override
    public void applyEffet(Partie partie) {
        System.out.println(cible);

    }
}

