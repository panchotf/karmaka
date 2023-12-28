package karmaka.v1.effet;

import karmaka.v1.Carte;
import karmaka.v1.Effet;
import karmaka.v1.Joueur;
import karmaka.v1.Partie;
import karmaka.v1.Terminal;


import java.util.LinkedList;

public class Puiser implements Effet {

    //meme effet que deplacer sauf que c'est la premiere carte du depart qui est deplacée, pas de choix possible

    private final Partie partie;

    private LinkedList<Carte> depart;

    private LinkedList<Carte> arrivee;

    private String saisieClavier;
    private Terminal terminal = new Terminal();

    public Puiser(Partie partie, LinkedList<Carte> depart, LinkedList<Carte> arrivee) {
//		System.out.println(partie.getDefausse());
        this.partie = partie;
        this.depart = depart;
        this.arrivee = arrivee;

    }


    public LinkedList<Carte> getDepart(){
        return this.depart;
    }

    public LinkedList<Carte> getArrivee(){
        return this.arrivee;
    }



    @Override
    public void effet(Partie partie, Joueur joueur, int nombre, LinkedList<Carte> depart, LinkedList<Carte> arrivee, String cible, Carte carte, boolean opif){

    }

    @Override
    public void applyEffet(Partie partie) {

        partie.addCarte(arrivee, depart.getFirst());//on ajoute la carte à la liste des cartes arrivée

        partie.removeCarte(depart, depart.getFirst().getNom());//on enlève la carte de la main du joueur
        System.out.println("La carte a bien été puisée.");
        System.out.println(arrivee);//on affiche la liste des cartes arrivée
    }

    //Carte carte = getPartie().getDefausse().getFirst();
    //System.out.println(partie.getDefausse());
    //System.out.println(getDepart());
    //System.out.println(getArrivee());
    //getPartie().getDefausse().remove(carte);
    //partie.getTest().add(carte);
}

