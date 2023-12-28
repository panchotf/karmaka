package karmaka.v1.effet;

import karmaka.v1.*;

import java.util.LinkedList;

import karmaka.v1.Carte;
import karmaka.v1.Effet;
import karmaka.v1.Joueur;
import karmaka.v1.Partie;
import karmaka.v1.Terminal;


import java.util.*;

public class Arranger implements Effet {

    private final Partie partie;

    private LinkedList<Carte> cible;
    private LinkedList<Carte> arrivee;

    private int nombre;

    private boolean opif;

    private String saisieClavier;
    private Terminal terminal = new Terminal();

    private LinkedList<Carte> depot;

    public Arranger(Partie partie, int nombre, LinkedList<Carte> cible, LinkedList<Carte> arrivee, boolean opif) {
        this.partie = partie;
        this.nombre = nombre;
        this.opif = opif;
        this.cible = cible;
        this.arrivee = arrivee;

    }


    public LinkedList<Carte> getCible(){
        return this.cible;
    }

    public LinkedList<Carte> getArrivee(){
        return this.arrivee;
    }





    @Override
    public void effet(Partie partie, Joueur joueur, int nombre, int nombreMax, LinkedList<Carte> depart, LinkedList<Carte> arrivee, String cible, Carte carte, boolean opif, boolean obligatoire){

    }

    @Override
    public void applyEffet(Partie partie) {
        if (opif) {
            //mettre nombre de carte nombre aléatoires de la liste cible dans la liste depot
            for (int i = 0; i < nombre; i++) {
                int random = (int) (Math.random() * cible.size());
                depot.add(cible.get(random));
            }
        }else {
            //mettre nombre de premieres cartes de la liste cible dans la liste depot
            for (int i = 0; i < nombre; i++) {
                depot.add(cible.get(i));
            }
        }
        //afficher depot
        System.out.println(depot);
    }

}
