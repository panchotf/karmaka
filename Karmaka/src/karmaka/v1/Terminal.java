package karmaka.v1;
import java.io.*;

/**
 * Classe Terminal qui permet de lire et d'écrire dans la console
 */
public class Terminal {

	private InputStream entree;
	private PrintStream sortie;

	/**
	 * Constructeur de la classe Terminal
	 */
	public Terminal(){
		entree = System.in;
		sortie = System.out;
	}

	/**
	 * methode qui permet de lire un entier
	 * @return
	 */
	public int lireEntier(){
		DataInputStream dos = new DataInputStream(entree);
		int value=0;
		try {
			value =  dos.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
	return value;
	}

	/**
	 * methode qui permet de lire une chaine de caractere
	 * @return
	 */
	public String lireChaine(){
		String laChaine = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(entree));
		try {
			laChaine = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return laChaine;
	}

	public void afficheLaChaine(String laChaine){
		sortie.println(laChaine);
	}


	public void echo(){
		String saisieClavier = new String();
		while(saisieClavier.compareTo("exit") != 0){
			saisieClavier=lireChaine();
			afficheLaChaine(saisieClavier);
		}
	}

	public static void main(String[] args){
		Terminal nds = new Terminal();
		String saisieClavier = new String();
		saisieClavier = nds.lireChaine();
		System.out.println(saisieClavier);
//		nds.echo();
//		System.out.println("Avez vous lu Scanner ? (java.util package)");

	}

}
