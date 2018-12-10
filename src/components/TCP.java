/*
 * Un tripulant de cabina de passatgers (TCP) es defineix pel seu passaport, nom
 * , edat, data d’alta en la companyia, hores que porta de vol i rang
 */
package components;

/**
 *
 * @author root
 */
public class TCP extends Tripulant {

	public TCP(String passaport, String nom, int edat, int horesVol) {
		super(passaport, nom, edat, horesVol);
	}

	public static TCP nouTCP() {
		String passaport, nom;
		int edat, hores;
		System.out.println("\nPassaport del tripulant:");
		passaport = DADES.next();
		DADES.nextLine(); // Neteja de buffer
		System.out.println("\nNom del tripulant:");
		nom = DADES.nextLine();
		System.out.println("\nEdat del tripulant:");
		edat = DADES.nextInt();

		System.out.println("\nHores de vol del tripulant:");
		hores = DADES.nextInt();

		return new TCP(passaport, nom, edat, hores);
	}
}
