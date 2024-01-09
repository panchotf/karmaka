package karmaka.v1.effet;

import karmaka.v1.Carte;
import karmaka.v1.Effet;
import karmaka.v1.Joueur;
import karmaka.v1.Partie;

import java.util.LinkedList;

public class Copier implements Effet {


    private Carte cible;


    /** constructeur de la classe Copier
     * @param partie
     * @param cible
     */
    public Copier (Partie partie, Carte cible) {
        this.cible = cible;

    }


    public Carte getCible(){
        return this.cible;
    }
    




    /** methode qui permet de copier l'effet d'une carte
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

    /** methode qui permet d'appliquer l'effet de la carte copiée
     * @param partie
     */
    @Override
    public void applyEffet(Partie partie) {
        System.out.println("Activation du pouvoir de"+cible.getNom());
        cible.applyEffet(partie);
    }
}
