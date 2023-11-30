package karmaka.v1;
import java.util.LinkedList;

public class Joueur {
	
	private String nom;
	private int ptsKarm;
	private LinkedList<Carte> main;
	private LinkedList<Carte> pile;
	private LinkedList<Carte> oeuvres;
	
	public Joueur(String nom) {
		this.nom = nom;
		this.main = new LinkedList<>();
		this.pile = new LinkedList<>();
		this.oeuvres = new LinkedList<>();
		this.ptsKarm = 0;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(this.nom);
		sb.append(this.ptsKarm);
		sb.append(this.main);
		sb.append(this.oeuvres);
		return sb.toString();
		
	}
	
}
