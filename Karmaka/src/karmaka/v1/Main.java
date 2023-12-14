package karmaka.v1;

public class Main {

    public static void main(String[] args) {
        // Création d'une partie Karmaka
        Partie karmaka = new Partie();
        Terminal terminal = new Terminal();
        String saisieClavier = new String();
        String nomJoueur1 = new String();
        String nomJoueur2 = new String();

        System.out.println("Saisissez le nom du Joueur 1 : ");
        nomJoueur1 = terminal.lireChaine();
        System.out.println("Saisissez le nom du Joueur 2 : ");
        nomJoueur2= terminal.lireChaine();

        // création de deux joueurs
        Joueur Joueur1 = new Joueur(nomJoueur1);
        Joueur Joueur2 = new Joueur(nomJoueur2);

        // on ajoute les 2 joueurs à la partie
        karmaka.ajouterUnJoueur(Joueur1);
        karmaka.ajouterUnJoueur(Joueur2);

        // on affiche le jeu de cartes
        System.out.println("Les cartes du jeu sont : " + karmaka.jeu);
        System.out.println("Appuyez sur Entrée pour distribuer les cartes et commencer le jeu !");
        saisieClavier = terminal.lireChaine();

        // on distribue les cartes à l'ensemble des joueurs
        karmaka.distribuerCartes();

        // on affiche les 2 joueurs de cette partie
        // System.out.println(karmaka.listJ.get(0));
        // System.out.println(karmaka.listJ.get(1));


        Carte cartePlateau = null; // La carte qui a été joué au tour précédent

        while (karmaka.partieTerminee()==false) {


            Joueur joueurCourant = karmaka.listJ.get(karmaka.getJoueurActuel());
            karmaka.setJoueurActuel((karmaka.getJoueurActuel() +1) %2);

            // Piocher une carte si la pile est non vide
            if (joueurCourant.pileVide()==false) {
                joueurCourant.piocher();
            }

            //************************Phase de sélection de la carte sur le plateau ou non**********************************
            if (cartePlateau != null) {
                System.out.println("La carte sur le plateau est "+cartePlateau.getNom()+" Souhaitez-vous la prendre ?");
                System.out.println("(1) Oui (2) Non");
                saisieClavier = terminal.lireChaine();

                if (saisieClavier.equals("1")) {
                    joueurCourant.ajouterVieFuture(cartePlateau);
                    cartePlateau = null;
                }
                else {
                    karmaka.defausser(cartePlateau);
                    cartePlateau = null;
                }

            }


            //*************************Début du tour**************************************************************************
            System.out.println(joueurCourant);

            //***************************Réincarnation ou non***************************************************************

            if(joueurCourant.estVivant()==false) {
                System.out.println("Vous êtes mort");

                //********************************Comptage des points********************************************************
                int nbPoints = joueurCourant.maxPoints(joueurCourant.sommeDesPointsParCouleur())+joueurCourant.getAnneaux();
                System.out.println("Vous avez accumulé "+nbPoints+" points dans cette vie.");
                if(nbPoints >= joueurCourant.getptsKarm())
                {
                    System.out.println("Bravo, vous pouvez vous réincarner dans la classe supérieure");
                    joueurCourant.setptsKarm(joueurCourant.getptsKarm()+1);
                }
                else {
                    System.out.println("Vous n'avez pas assez de point.");
                }

                terminal.lireChaine();


                //********************************Phase de Reincarnation*****************************************************
                joueurCourant.viderOeuvre(karmaka.defausse);
                joueurCourant.mainVieFuture();

                if (joueurCourant.nombreMain()<6) {
                    for(int i = 0; i < 6 - joueurCourant.nombreMain(); i++) {
                        karmaka.puiserSource(joueurCourant);
                    }
                }

                joueurCourant.reincarner();
            }


            //**************************S'il n'est pas en réincarnation, le joueur choisit une option de jeu******************

            else {
                // On vérifie que l'utilisateur choisie une option disponible
                saisieClavier = "nan"; // On set la saisie clavier de départ avec un string quelconque pour éviter d'avoir des soucis avec null

                while (!(saisieClavier.equals("1") || saisieClavier.equals("2") || saisieClavier.equals("3")||(saisieClavier.equals("5") && (joueurCourant.pileVide()==false)))) {
                    System.out.println("Sélectionnez une action : (1) Vie Future (2) Oeuvre (3) Jouer (4) Voir défausse (5)Passer tour");
                    saisieClavier = terminal.lireChaine();

                    if (saisieClavier.equals("4")) {
                        System.out.println(karmaka.defausse);
                        System.out.println(karmaka.test);
                    }
                    else if ((saisieClavier.equals("5") && (joueurCourant.pileVide()==true))) {
                        System.out.println("Vous ne pouvez pas passer votre tour car votre pile est vide");
                    }
                }


                if (saisieClavier.equals("1")) {
                    while (joueurCourant.getCarteDeMain(saisieClavier)==null) {
                        System.out.println("Sélectionnez une carte de votre main à mettre dans la vie future : ");
                        saisieClavier = terminal.lireChaine();
                    }
                    Carte carteChoisie = joueurCourant.getCarteDeMain(saisieClavier);
                    joueurCourant.ajouterVieFuture(carteChoisie);
                    joueurCourant.retirerCarte(carteChoisie);
                }
                else if (saisieClavier.equals("2")) {
                    while (joueurCourant.getCarteDeMain(saisieClavier)==null) {
                        System.out.println("Sélectionnez une carte à mettre dans vos oeuvres : ");
                        saisieClavier = terminal.lireChaine();
                    }
                    Carte carteChoisie = joueurCourant.getCarteDeMain(saisieClavier);
                    joueurCourant.ajouterOeuvre(carteChoisie);
                    joueurCourant.retirerCarte(carteChoisie);
                }
                else if (saisieClavier.equals("3")) {
                    while (joueurCourant.getCarteDeMain(saisieClavier)==null) {
                        System.out.println("Sélectionnez une carte à jouer : ");
                        saisieClavier = terminal.lireChaine();
                    }
                    Carte carteChoisie = joueurCourant.getCarteDeMain(saisieClavier);
                    cartePlateau = carteChoisie;
                    joueurCourant.retirerCarte(carteChoisie);
                    System.out.println("L'effet de la carte s'active. ");
                    cartePlateau.applyEffet(karmaka);
                }
                else if (saisieClavier.equals("5")) {

                }

                // On vérifie si le joueur meurt après ce tour :
                if(joueurCourant.pileVide()==true && joueurCourant.mainVide()==true) {
                    joueurCourant.tuer();
                }

            }


        }

    }
}
