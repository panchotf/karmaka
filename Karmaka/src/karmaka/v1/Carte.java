package karmaka.v1;

import java.util.LinkedList;

//test
public class Carte implements Effet {
	
	private String nom;
    private Points points;
    private Couleur couleur;

    public Carte (String nom, Points points, Couleur couleur) {
        this.setNom(nom);
    	this.setCouleur(couleur);
    	this.setPoints(points);
    }
    
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

    public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.points);
		sb.append(this.couleur);
		return sb.toString();
    }
    
    public void deplacer(LinkedList<Carte> depart, LinkedList<Carte> arrivee, Carte carte) {
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
    
    
	/*
    public static void main(String[]args){
    	Carte c1=new Carte(Valeur.DIX, Couleur.COEUR);
    	Carte c2=new Carte(Valeur.ROI, Couleur.COEUR);   
    	
    	System.out.println(c1);
    	System.out.println(c2);
    	
    	// la méthode ordinal() renvoie la position de l'élèment dans l'énumération
    	// ici la valeur DIX renvoie 3, la valeur ROI renvoie 6 et ainsi de suite
    	System.out.println(c1.getValeur() );
    	System.out.println(c2.getValeur() );
    	System.out.println(c1.getValeur().ordinal());
    	System.out.println(c2.getValeur().ordinal());
    	
    	// Comment récupérer les éléments d'une énumération?
		Valeur[] v=Valeur.values();
		for(int i=0 ; i < v.length; i++){
			System.out.println(v[i]);
		}
		
    	
    	// compareTo: 
    	//Returns a negative integer, zero, or a positive integer ...
    	//as this object is less than, equal to, or greater than the specified object.    	
		System.out.println(c1.getValeur().compareTo(c2.getValeur()))  ;

    }
*/


	@Override
	public void effet(int nombre, String depart, String arrivee, String cible, Carte carte) {
		// TODO Auto-generated method stub
	}
}
