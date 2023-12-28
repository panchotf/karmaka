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

    public Regarder (Partie partie, LinkedList<Carte> cible) {
//        System.out.println(partie.getDefausse());
        this.cible = cible;
    }


    public LinkedList<Carte> getCible(){return this.cible;    }



    @Override
    public void effet(Partie partie, Joueur joueur, int nombre, LinkedList<Carte> depart, LinkedList<Carte> arrivee, String cible, Carte carte, boolean opif) {

    }

    @Override
    public void applyEffet(Partie partie) {
        System.out.println(cible);

    }
}

