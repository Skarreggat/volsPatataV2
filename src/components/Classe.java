package components;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Classe implements Component {

	private final static Scanner DADES = new Scanner(System.in);

	private String nom;
	private int capacitat;

	// CONSTRUCTOR
	public Classe(String nom, int capacitat) {
		this.nom = nom;
		this.capacitat = capacitat;
	}

	// GETTERS & SETTERS
	public String getNom() {

		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCapacitat() {
		return capacitat;
	}

	public void setCapacitat(int capacitat) {
		this.capacitat = capacitat;
	}

	public static Classe novaClasse() {
		String nom;
		int capacitat;

		System.out.println("\nNom de la classe:");
		nom = DADES.nextLine();
		System.out.println("\nCapacitat de la classe:");
		capacitat = DADES.nextInt();

		return new Classe(nom, capacitat);
	}

	public void mostrarComponent() {
		System.out.println("\nLa classe " + nom + " té una capacitat de " + capacitat);

	}

	public void modificarComponent() throws ParseException {
		System.out.println("\nNom de la classe: " + nom);
		nom = (String) demanarDades("\nEntra el nou nom:", 4);

		System.out.println("\nCapacitat de la classe: " + nom);
		capacitat = (int) demanarDades("\nEntra la nova capacitat:", 1);
	}

}
