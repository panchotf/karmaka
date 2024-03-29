package karmaka.v1;

import java.io.*; 
public class Main {
	

    /**
     * Méthode main qui permet de lancer le jeu.
     * @param args
     */
    public static void main(String[] args) {
        // Création d'une partie Karmaka
    	

        Terminal terminal = new Terminal();
        String saisieClavier = new String();
        String saisie = new String();
        String modeJeu = new String();
        String nomJoueur1 = new String();
        String nomJoueur2 = new String();



        
	    System.out.println("Choisissez le mode de jeu (1) VS IA (2) VS joueur : ");
	    modeJeu = terminal.lireChaine(); 
        
        if (modeJeu.equals("1")) {
        	System.out.println("Vous avez choisi le mode de jeu VS IA ");
            System.out.println("Saisissez votre nom : ");
            nomJoueur1 = terminal.lireChaine();
            nomJoueur2= "IA";

        } else if (modeJeu.equals("2")) {
            System.out.println("Saisissez le nom du Joueur 1 : ");
            nomJoueur1 = terminal.lireChaine();
            System.out.println("Saisissez le nom du Joueur 2 : ");
            nomJoueur2= terminal.lireChaine();
        }
        

        
        Partie karmaka = new Partie(nomJoueur1, nomJoueur2);
        
       
        


        // on affiche le jeu de cartes
        System.out.println("Les cartes du jeu sont : " + karmaka.getJeu());
        System.out.println("Appuyez sur Entrée pour distribuer les cartes et commencer le jeu !");
        saisieClavier = terminal.lireChaine();

        // on distribue les cartes à l'ensemble des joueurs
        karmaka.distribuerCartes();


        Carte cartePlateau = null; // La carte qui a été joué au tour précédent

        while (karmaka.partieTerminee()==false) {


            Joueur joueurCourant = karmaka.getListJ().get(karmaka.getJoueurActuel());
            karmaka.setJoueurActuel((karmaka.getJoueurActuel() +1) %2);

            // Piocher une carte si la pile est non vide
            if (joueurCourant.pileVide()==false) {
                joueurCourant.piocher();
            }

            //************************Phase de sélection de la carte sur le plateau ou non**********************************
            if (cartePlateau != null) {
                System.out.println("La carte sur le plateau est "+cartePlateau.getNom()+" Souhaitez-vous la prendre ?");
                System.out.println("(1) Oui (2) Non");
                if (joueurCourant instanceof IA) {
                	if (joueurCourant.choixRandom()>50) {
                	System.out.println("L'IA a décidé de prendre la carte");
                	saisieClavier ="1";
                	}
                	else {
                    System.out.println("L'IA a décidé de ne pas prendre la carte");
                    saisieClavier ="2";
                	}
                }
                else {
                saisieClavier = terminal.lireChaine();
                }

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
                joueurCourant.viderOeuvre(karmaka.getDefausse());
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
                saisie = "nan";
                
                while (!(saisieClavier.equals("1") || saisieClavier.equals("2") || saisieClavier.equals("3") ||(saisieClavier.equals("5") && (joueurCourant.pileVide()==false)))) {
                    System.out.println("Sélectionnez une action : (1) Vie Future (2) Oeuvre (3) Jouer (4) Voir défausse (5)Passer tour (6)Lire Carte (7)Sauvegarder");
                    
                    if (joueurCourant instanceof IA) {
                    	if(joueurCourant.choixRandom()<50) {
                    	saisieClavier = "1";
                    	}
                    	else if(joueurCourant.choixRandom()>=50 &&joueurCourant.choixRandom()<60) {
                    	saisieClavier = "2";
                    	}
                    	else if(joueurCourant.choixRandom()>=60 &&joueurCourant.choixRandom()<70) {
                    	saisieClavier = "3";
                    	}
                    	else if(joueurCourant.choixRandom()>=70 &&joueurCourant.choixRandom()<101) {
                    	saisieClavier = "5";
                    	}
                    	System.out.println("L'IA a choisi le choix " + saisieClavier);
                    	System.out.println("Appuyez sur entrée pour continuer");
                    	saisie = terminal.lireChaine();
                    	
                    }
                    else {
                    saisieClavier = terminal.lireChaine();
                    }

                    if (saisieClavier.equals("4")) {
                        System.out.println(karmaka.getDefausse());
                    }
                    
                    else if (saisieClavier.equals("7")) {
                    	try(ObjectOutputStream oos = new ObjectOutputStream(new
                    			FileOutputStream("save.ser")))
                    			{
                    			oos.writeObject(karmaka);
                    			oos.close();
                    			}
                    			catch (IOException e) {}
                        System.out.println("Partie sauvegardée");
                    }
                    
                    else if (saisieClavier.equals("6")) {
                        while (joueurCourant.getCarteDeMain(saisieClavier)==null) {
                        	
                        	if (joueurCourant instanceof IA) {
                        		saisieClavier = joueurCourant.getCarteAleatoireDeMain().getNom();
                        		System.out.println("L'IA a sélectionné la carte : "+saisieClavier);
                        		saisie = terminal.lireChaine();
                        	}
                        	else {
                        		System.out.println("Sélectionnez une carte de votre main pour lire sa description : ");
                        		saisieClavier = terminal.lireChaine();
                        	}
                        }
                        Carte carteChoisie = joueurCourant.getCarteDeMain(saisieClavier);
                        System.out.println(carteChoisie.getDescription());
                    }
                    else if ((saisieClavier.equals("5") && (joueurCourant.pileVide()==true))) {
                        System.out.println("Vous ne pouvez pas passer votre tour car votre pile est vide");
                    }

                }


                if (saisieClavier.equals("1")) {
                    while (joueurCourant.getCarteDeMain(saisieClavier)==null) {
                    	
                    	if (joueurCourant instanceof IA) {
                    		saisieClavier = joueurCourant.getCarteAleatoireDeMain().getNom();
                    		System.out.println("L'IA a sélectionné la carte : "+saisieClavier +" à mettre dans sa vie future");
                    		saisie = terminal.lireChaine();
                    	}
                    	else {
                    	
                    		System.out.println("Sélectionnez une carte de votre main à mettre dans la vie future : ");
                    		saisieClavier = terminal.lireChaine();
                    	}
                    }
                    Carte carteChoisie = joueurCourant.getCarteDeMain(saisieClavier);
                    joueurCourant.ajouterVieFuture(carteChoisie);
                    joueurCourant.retirerCarte(carteChoisie);
                }
                else if (saisieClavier.equals("2")) {
                    while (joueurCourant.getCarteDeMain(saisieClavier)==null) {
                    	
                    	if (joueurCourant instanceof IA) {
                    		saisieClavier = joueurCourant.getCarteAleatoireDeMain().getNom();
                    		System.out.println("L'IA a sélectionné la carte : "+saisieClavier + " à mettre dans ses oeuvres");
                    		saisie = terminal.lireChaine();
                    	}
                    	else {
                        System.out.println("Sélectionnez une carte à mettre dans vos oeuvres : ");
                        saisieClavier = terminal.lireChaine();
                    	}
                    }
                    Carte carteChoisie = joueurCourant.getCarteDeMain(saisieClavier);
                    joueurCourant.ajouterOeuvre(carteChoisie);
                    joueurCourant.retirerCarte(carteChoisie);
                }
                else if (saisieClavier.equals("3")) {
                    while (joueurCourant.getCarteDeMain(saisieClavier)==null) {
                    	
                    	if (joueurCourant instanceof IA) {
                    		saisieClavier = joueurCourant.getCarteAleatoireDeMain().getNom();
                    		System.out.println("L'IA a sélectionné la carte : "+saisieClavier +" à jouer");
                    		saisie = terminal.lireChaine();
                    	}
                    	else {
                    		System.out.println("Sélectionnez une carte à jouer : ");
                    		saisieClavier = terminal.lireChaine();
                    	}
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
