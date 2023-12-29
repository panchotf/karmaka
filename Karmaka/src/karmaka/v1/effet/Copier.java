package karmaka.v1.effet;

import karmaka.v1.Carte;
import karmaka.v1.Effet;
import karmaka.v1.Joueur;
import karmaka.v1.Partie;

import java.util.LinkedList;

public class Copier implements Effet {


    private Carte cible;

    public Copier (Partie partie, Carte cible) {
        this.cible = cible;

    }


    public Carte getCible(){
        return this.cible;
    }
    



    @Override
    public void effet(Partie partie, Joueur joueur, int nombre, int nombreMax, LinkedList<Carte> depart, LinkedList<Carte> arrivee, String cible, Carte carte, boolean opif, boolean obligatoire){

    }

    @Override
    public void applyEffet(Partie partie) {
        System.out.println("Activation du pouvoir de"+cible.getNom());
        cible.applyEffet(partie);
    }
}
