package karmaka.v1.effet;

import karmaka.v1.*;

import java.util.LinkedList;

import karmaka.v1.Carte;
import karmaka.v1.Effet;
import karmaka.v1.Joueur;
import karmaka.v1.Partie;
import karmaka.v1.Terminal;


import java.util.*;

/**
 * Classe Arranger qui permet d'arranger les cartes d'une liste. Elle fonctionne en 3 étapes :
 * 1) déplacer les cartes de la liste cible vers la liste depot
 * 2) déplacer certaines cartes de la liste depot vers la liste arrivee
 * 3) replacer les cartes restantes de depot dans un ordre choisit dans cible
 */

public class Arranger implements Effet {


    private final Partie partie;

    private LinkedList<Carte> cible;


    private LinkedList<Carte> arrivee;

    private int nombre;

    private int nombreMax;
    private boolean obligatoire;

    private boolean opif;

    private String saisieClavier;
    private Terminal terminal = new Terminal();

    private LinkedList<Carte> depot;


    /** constructeur de la classe Arranger
     * @param partie
     * @param nombre
     * @param nombreMax
     * @param cible
     * @param arrivee
     * @param opif
     * @param obligatoire
     */
    public Arranger(Partie partie, int nombre, int nombreMax, LinkedList<Carte> cible, LinkedList<Carte> arrivee, boolean opif, boolean obligatoire) {
        this.partie = partie;
        this.nombre = nombre;
        this.nombreMax = nombreMax;
        this.opif = opif;
        this.cible = cible;
        this.arrivee = arrivee;
        this.obligatoire = obligatoire;
        this.depot = new LinkedList<Carte>();

    }


    public LinkedList<Carte> getCible(){
        return this.cible;
    }

    public LinkedList<Carte> getArrivee(){
        return this.arrivee;
    }


    /** methode qui permet d'arranger les cartes d'une liste donnée
     * @param partie
     * @param joueur
     * @param nombre
     * @param nombreMax
     * @param depart
     * @param arrivee
     * @param cible
     * @param carte
     * @param opif
     * @param obligatoire
     */
    @Override
    public void effet(Partie partie, Joueur joueur, int nombre, int nombreMax, LinkedList<Carte> depart, LinkedList<Carte> arrivee, String cible, Carte carte, boolean opif, boolean obligatoire){

    }

    /**
     * Methode qui permet d'appliquer l'effet Arranger
     * @param partie
     */
    @Override
    public void applyEffet(Partie partie) {

        //*********************************deplacer les cartes de la liste cible vers la liste depot*******************************
        if (opif) {
            //mettre nombre de carte nombre aléatoires de la liste cible dans la liste depot
            for (int i = 0; i < nombre; i++) {
                int random = (int) (Math.random() * cible.size());
                depot.add(cible.get(random));
                cible.remove(random);
            }
        }else {
            //mettre nombre de premieres cartes de la liste cible dans la liste depot
            for (int i = 0; i < nombre; i++) {
                depot.add(cible.get(i));
                cible.remove(i);
            }
        }
        //afficher depot
        System.out.println(depot);
        //*********************************deplacer certaines cartes de la liste depot vers la liste arrivee*******************************

        //tant que i<nombreMax, demander au joueur s'il veut choisir une carte dans depot et la mettre dans arrivee (Si obligatoire=vrai, reponse est obligatoirement oui). Si oui, afficher depot, demander au joueur de choisir une carte dans depot, mettre la carte dans arrivee, afficher arrivee, i++.
        int i = 0;
        while (i<nombreMax) {
            if (!obligatoire) {
                System.out.println("Voulez-vous choisir une carte dans le depot ? (oui/non)");
                
                if (partie.getJoueur() instanceof IA) {
                	if(partie.getJoueur().choixRandom()<50) {
                    	saisieClavier = "oui";
                    	}
                	else {
                		saisieClavier = "non";
                	}
                }
                else {
                saisieClavier = terminal.lireChaine();
                }
                if (saisieClavier.equals("oui")) {
                    System.out.println(depot);
                    while (partie.getCarte(depot, saisieClavier) == null) {//tant que la carte n'est pas dans la main du joueur
                        System.out.println("Sélectionnez la carte à déplacer ");//on demande au joueur de choisir une carte
      
                        saisieClavier = terminal.lireChaine();
                        
                    }
                    Carte carteChoisie = partie.getCarte(depot, saisieClavier);//on récupère la carte choisie

                    partie.addCarte(arrivee, carteChoisie);//on ajoute la carte à la liste des cartes arrivée
                    partie.removeCarte(depot, saisieClavier);//on enlève la carte de la main du joueur

                    System.out.println("La carte a bien été déplacée.");
                    System.out.println(depot);//on affiche la liste des cartes depart
                    System.out.println(arrivee);//on affiche la liste des cartes arrivée
                    i++;
                } else {
                    i = nombreMax;
                }
            } else {
                while (partie.getCarte(depot, saisieClavier) == null) {//tant que la carte n'est pas dans la main du joueur
                    System.out.println("Sélectionnez la carte à déplacée ");//on demande au joueur de choisir une carte
                    saisieClavier = terminal.lireChaine();
                }
                Carte carteChoisie = partie.getCarte(depot, saisieClavier);//on récupère la carte choisie

                partie.addCarte(arrivee, carteChoisie);//on ajoute la carte à la liste des cartes arrivée

                partie.removeCarte(depot, saisieClavier);//on enlève la carte de la main du joueur
                System.out.println("La carte a bien été deplacée)");
                System.out.println(depot);//on affiche la liste des cartes depart
                System.out.println(arrivee);//on affiche la liste des cartes arrivée
                i++;
            }
        }

        //*********************************replacer les cartes restantes de depot dans un ordre choisit dans cible

        //afficher depot
        System.out.println(depot);
        //tant que depot n'est pas vide, demander au joueur de choisir une carte dans depot et la mettre dans cible. Afficher depot.
        while (!depot.isEmpty()) {
            while (partie.getCarte(depot, saisieClavier) == null) {//tant que la carte n'est pas dans le depot
                System.out.println("Sélectionnez la carte à replacer ");//on demande au joueur de choisir une carte
                saisieClavier = terminal.lireChaine();
            }
            Carte carteChoisie = partie.getCarte(depot, saisieClavier);//on récupère la carte choisie

            partie.addCarte(cible, carteChoisie);//on ajoute la carte à la liste des cartes arrivée
            partie.removeCarte(depot, saisieClavier);//on enlève la carte de la main du joueur

            System.out.println("La carte a bien été replacée)");
            System.out.println(depot);//on affiche la liste des cartes depart
        }


    }


}
















