package karmaka.v1.effet;

import karmaka.v1.Carte;

import karmaka.v1.Effet;
import karmaka.v1.IA;
import karmaka.v1.Joueur;
import karmaka.v1.Partie;
import karmaka.v1.Terminal;
import java.util.Random;

import java.util.LinkedList;

public class Deplacer implements Effet {

	private final Partie partie;

	private LinkedList<Carte> depart;
	private LinkedList<Carte> arrivee;

	private String saisieClavier;
	private Terminal terminal = new Terminal();

	/** constructeur de la classe Deplacer
	 * @param partie
	 * @param depart
	 * @param arrivee
	 */

	public Deplacer(Partie partie, LinkedList<Carte> depart, LinkedList<Carte> arrivee) {
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
	
	
	/** methode qui permet de déplacer une carte d'une liste à une autre
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

	/** methode qui permet d'appliquer l'effet déplacer à la carte choisie
	 * @param partie
	 */
	@Override
	public void applyEffet(Partie partie) {
		System.out.println(depart);//affiche la liste des cartes du joueur

		while (partie.getCarte(depart, saisieClavier)==null) {//tant que la carte n'est pas dans la main du joueur
			System.out.println("Sélectionnez la carte à déplacer ");//on demande au joueur de choisir une carte
			
			if (partie.getJoueur() instanceof IA) {
				 // Générer un index aléatoire
		        Random random = new Random();
		        int indexAleatoire = random.nextInt(getDepart().size()-1);

		        // Récupérer l'élément à l'index aléatoire
		        saisieClavier = getDepart().get(indexAleatoire).getNom();
				
			}
			else {
			saisieClavier = terminal.lireChaine();
			}
		}
		Carte carteChoisie = partie.getCarte(depart, saisieClavier);//on récupère la carte choisie

		partie.addCarte(arrivee, carteChoisie);//on ajoute la carte à la liste des cartes arrivée

		partie.removeCarte(depart, saisieClavier);//on enlève la carte de la main du joueur
		System.out.println("La carte a bien été déplacée.");
		System.out.println(depart);//on affiche la liste des cartes depart
		System.out.println(arrivee);//on affiche la liste des cartes arrivée
	}


}

