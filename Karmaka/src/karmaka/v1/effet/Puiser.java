package karmaka.v1.effet;

import karmaka.v1.Carte;
import karmaka.v1.Effet;
import karmaka.v1.Joueur;
import karmaka.v1.Partie;
import karmaka.v1.Terminal;


import java.util.LinkedList;

/**
 * Classe Puiser qui permet de puiser une carte. Elle fonctionne en 2 étapes :
 * 1) choisir une carte cible
 * 2) déplacer la carte cible dans une autre liste
 * C'est une méthode déplacer, sauf que c'est la première carte de la liste de départ qui est déplacée : on ne choisit pas la carte dans la liste de départ
 */
public class Puiser implements Effet {

    //meme effet que deplacer sauf que c'est la premiere carte du depart qui est deplacée, pas de choix possible

    private final Partie partie;

    private LinkedList<Carte> depart;

    private LinkedList<Carte> arrivee;

    private String saisieClavier;
    private Terminal terminal = new Terminal();


    /** constructeur de la classe Puiser
     * @param partie
     * @param depart
     * @param arrivee
     */
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


    /** methode qui permet de deplacer une carte d'une liste à une autre sans la choisir
     * @param partie
     * @param nombre
     * @param nombreMax
     * @param cible
     * @param arrivee
     * @param opif
     * @param obligatoire
     */
    @Override
    public void effet(Partie partie, Joueur joueur, int nombre, int nombreMax, LinkedList<Carte> depart, LinkedList<Carte> arrivee, String cible, Carte carte, boolean opif, boolean obligatoire){

    }

    /** methode qui permet d'appliquer l'effet de la carte
     * @param partie
     */
    @Override
    public void applyEffet(Partie partie) {

        if (depart.isEmpty()) {
            System.out.println("La liste de départ est vide.");
        }else {

            partie.addCarte(arrivee, depart.getFirst());//on ajoute la carte à la liste des cartes arrivée

            partie.removeCarte(depart, depart.getFirst().getNom());//on enlève la carte de la main du joueur
            System.out.println("La carte a bien été puisée.");
            System.out.println(arrivee);//on affiche la liste des cartes arrivée
        }
    }

}

