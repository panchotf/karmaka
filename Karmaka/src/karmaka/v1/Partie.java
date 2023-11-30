package karmaka.v1;
import java.util.Scanner;

public class Partie {
	
	
	
	public static void main(String[] args) {
		
		
		System.out.println("Entrer nom du joueur 1");
        Joueur joueur1 = new Joueur(LecteurEntrees.lireChaine());
		
        System.out.println("Entrer nom du joueur 2");
        Joueur joueur2 = new Joueur(LecteurEntrees.lireChaine());
        
        joueur1.toString();
        

	}
}
