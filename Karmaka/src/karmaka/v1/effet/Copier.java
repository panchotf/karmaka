package karmaka.v1.effet;

import karmaka.v1.Carte;
import karmaka.v1.Effet;
import karmaka.v1.Joueur;
import karmaka.v1.Partie;

import java.util.LinkedList;

public class Copier implements Effet {


    private LinkedList<Carte> cible;

    public Copier (Partie partie, LinkedList<Carte> cible) {
//        System.out.println(partie.getDefausse());
        this.cible = cible;

    }


    public LinkedList<Carte> getCible(){
        return this.cible;
    }
    



    @Override
    public void effet(Partie partie, Joueur joueur, int nombre, LinkedList<Carte> depart, LinkedList<Carte> arrivee, String cible, Carte carte, boolean opif) {

    }

    @Override
    public void applyEffet(Partie partie) {
        //Carte carte = getPartie().getDefausse().getFirst();
        //System.out.println(partie.getDefausse());
        System.out.println(getCible());
        //getPartie().getDefausse().remove(carte);
        //partie.getTest().add(carte);
    }
}
