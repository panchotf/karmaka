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

    public Regarder (Partie partie, LinkedList<Carte> cible, Boolean opif) {
//        System.out.println(partie.getDefausse());
        this.cible = cible;
        this.opif = opif;
        /*if(opif){
            System.out.println(cible.getFirst());
        }
        else{
            //afficher une carte au hasard
            Random rand = new Random();
            int indexAleatoire = rand.nextInt(cible.size());
            System.out.println(cible.get(indexAleatoire));
        }*/

    }


    public LinkedList<Carte> getCible(){return this.cible;    }

    public Boolean getOpif(){return this.opif;    }

    public int getNombre(){return this.nombre;    }



    @Override
    public void effet(Partie partie, Joueur joueur, int nombre, LinkedList<Carte> depart, LinkedList<Carte> arrivee, String cible, Carte carte, boolean opif) {

    }

    @Override
    public void applyEffet(Partie partie) {
        //Carte carte = getPartie().getDefausse().getFirst();
        //System.out.println(partie.getDefausse());
        /*System.out.println(getCible());
        System.out.println(getOpif());
        System.out.println(getNombre());*/
        //getPartie().getDefausse().remove(carte);
        //partie.getTest().add(carte);

        if(opif){
            //afficher une carte au hasard
            Random rand = new Random();
            int indexAleatoire = rand.nextInt(cible.size());
            System.out.println(cible.get(indexAleatoire));
        } else{
            System.out.println(cible.getFirst());

        }
    }
}

