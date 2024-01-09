package karmaka.v1.effet;

import karmaka.v1.*;

import java.util.LinkedList;

public class Rejouer implements Effet {


    private LinkedList<Carte> cible;

    private String saisieClavier;

    private Terminal terminal = new Terminal();

    /** constructeur de la classe Rejouer
     * @param partie
     * @param cible
     */
    public Rejouer (Partie partie, LinkedList<Carte> cible) {
        this.cible = cible;
    }


    /** methode qui permet de rejouer une carte
     * @param partie
     * @param nombre
     * @param nombreMax
     * @param cible
     * @param arrivee
     * @param opif
     * @param obligatoire
     */
    @Override
    public void effet(Partie partie, Joueur joueur, int nombre, int nombreMax, LinkedList<Carte> depart, LinkedList<Carte> arrivee, String cible, Carte carte, boolean opif, boolean obligatoire) {

    }


    /** methode qui permet d'appliquer l'effet de rejouer une carte
     * @param partie
     */
    @Override
    public void applyEffet(Partie partie) {
        //demander de jouer une carte dans cible
        System.out.println(cible);//affiche la liste des cartes du joueur
        while (partie.getCarte(cible, saisieClavier)==null) {//tant que la carte n'est pas dans la main du joueur
            System.out.println("Sélectionnez la carte à déplacer");//on demande au joueur de choisir une carte
            saisieClavier = terminal.lireChaine();
        }
        Carte carteChoisie = partie.getCarte(cible, saisieClavier);//on récupère la carte choisie

        //appliquer l'effet de la carte choisie
        carteChoisie.applyEffet(partie);


    }
}
