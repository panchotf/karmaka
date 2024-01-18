package karmaka.v1;

import java.util.*;

import java.io.*;

/**
 * Classe Carte qui permet de créer une carte avec un nom, des points, une couleur, une description et des effets
 */
public class Carte implements Serializable {
	
	private String nom;
    private Points points;
    private Couleur couleur;
    private String description;

    private ArrayList<Effet> effets; // Utilisation d'une liste pour stocker les effets

    /**
     * Constructeur de la classe Carte
     * @param nom
     * @param points
     * @param couleur
     * @param description
     */
    public Carte (String nom, Points points, Couleur couleur, String description) {
        this.setNom(nom);
    	this.setCouleur(couleur);
    	this.setPoints(points);
    	this.description = description;
        effets = new ArrayList<>();

    }

    /**
     * Ajoute un effet à la liste des effets de la carte
     * @param effet
     */
    public void addEffet(Effet effet) {
        this.effets.add(effet);
    }

    /**
     * Ajoute un effet à la liste des effets de la carte
     * @param nombre
     * @param effet
     */
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

    public ArrayList<Effet> getEffets() {
        return effets;
    }
    
    public String getDescription() {
    	return description;
    }


//=====================================toString==============================================
    public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.nom);
		// sb.append(this.points);
		// sb.append(this.couleur);
		return sb.toString();
    }
    

    /**
     * methode applyEffet qui permet d'appliquer tous les effets contenu dans la liste effets
     * @param partie
     */
	public void applyEffet(Partie partie) {
        for(Effet effet : effets){
            effet.applyEffet(partie);
        }
		
	}
	
}
