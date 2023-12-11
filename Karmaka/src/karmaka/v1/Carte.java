package karmaka.v1;

import java.util.*;

public class Carte {
	
	private String nom;
    private Points points;
    private Couleur couleur;
//    private Effet effet;

    private ArrayList<Effet> effets; // Utilisation d'une liste pour stocker les effets

    // Constructeur

    public Carte (String nom, Points points, Couleur couleur/*, Effet effet*/) {
        this.setNom(nom);
    	this.setCouleur(couleur);
    	this.setPoints(points);
//    	this.effet = effet;
        effets = new ArrayList<>();

    }

    
    /*public Carte (String nom, Points points, Couleur couleur) {
        this.setNom(nom);
    	this.setCouleur(couleur);
    	this.setPoints(points);
    }*/



    // Méthode pour ajouter un effet à la liste
    public void addEffet(Effet effet) {
        this.effets.add(effet);
    }

    public void addEffet(int nombre, Effet effet) {
        for(int i=0; i<nombre; i++){
            this.effets.add(effet);
        }
    }


//  ================================== GETTERS & SETTERS ==================================
    public String getNom() {
    	return nom;
    }

    public void setNom(String nom) {
		    this.nom = nom;
	}

    public Couleur getCouleur() {
    	return couleur;
    }

    public void setCouleur(Couleur couleur) {
		    this.couleur = couleur;
	}

    public Points getPoints() {
    	return points;
    }

    public void setPoints(Points points) {
	    this.points = points;
    }

//=====================================toString==============================================
    public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.nom);
		// sb.append(this.points);
		// sb.append(this.couleur);
		return sb.toString();
    }
    
    /*public void deplacer(LinkedList<Carte> depart, LinkedList<Carte> arrivee, Carte carte) {
    	depart.remove(carte);
    	arrivee.add(carte);
    }
    
    public LinkedList<Carte> regarder(LinkedList<Carte> cible, int nombre) {
    	LinkedList <Carte> tas = new LinkedList<>();
    	for(int i=1; i<=nombre; i++) {
    		tas.add(cible.poll());
    	}
    	tas.toString();
    	return tas;
    }
    
    public Carte copier(Carte cible) {
    	return cible;
    }
    */
    

	public void applyEffet(Partie partie) {
        for(Effet effet : effets){
            effet.applyEffet(partie);
        }
		
	}
	
}
