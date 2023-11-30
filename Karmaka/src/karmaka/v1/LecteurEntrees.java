package karmaka.v1;

import java.util.Scanner;

public class LecteurEntrees {
    private static final Scanner scanner = new Scanner(System.in);

    public static int lireEntier() {
        System.out.println("Entrez un entier : ");
        while (!scanner.hasNextInt()) {
            System.out.println("Ce n'est pas un entier. Réessayez : ");
            scanner.next(); // Vide la ligne incorrecte
        }
        return scanner.nextInt();
    }

    public static double lireNombreDecimal() {
        System.out.println("Entrez un nombre décimal : ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Ce n'est pas un nombre décimal. Réessayez : ");
            scanner.next(); // Vide la ligne incorrecte
        }
        return scanner.nextDouble();
    }

    public static String lireChaine() {
//      System.out.println("Entrez une chaîne de caractères : ");
        return scanner.nextLine();
    }

    public static void fermerScanner() {
        scanner.close();
    }

    // Méthode principale pour tester
    public static void main(String[] args) {
        int entier = lireEntier();
        System.out.println("Vous avez saisi l'entier : " + entier);

        double decimal = lireNombreDecimal();
        System.out.println("Vous avez saisi le nombre décimal : " + decimal);

        String chaine = lireChaine();
        System.out.println("Vous avez saisi la chaîne : " + chaine);

        fermerScanner();
    }
}

