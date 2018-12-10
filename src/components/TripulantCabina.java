/*
 * Un tripulant de cabina es defineix pel seu passaport, nom, edat, data d’alta 
 * en la companyia, hores que porta de vol, rang i barres
 */
package components;

/**
 *
 * @author root
 */
public class TripulantCabina extends Tripulant {

	private int barres;

	public TripulantCabina(String passaport, String nom, int edat, int horesVol, String rang) {
		super(passaport, nom, edat, horesVol);
		assignarBarres(rang);
	}

	public void setRang(String rang) {
		this.rang = rang;
	}

	public int getBarres() {
		return barres;
	}

	public void setBarres(int barres) {
		this.barres = barres;
	}

	public static TripulantCabina nouTripulantCabina() {
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

		System.out.println("\nQuin rang té el tripulant?: C-Comandant, CP-Copilot, EV-Enginyer de vol");

		return new TripulantCabina(passaport, nom, edat, hores, DADES.next());
	}

	public void modificarTripulantCabina() {
		super.modificarComponent();
		System.out.println("\nEl rang actual del tripulant és:" + rang);
		assignarBarres((String) demanarDades(
				"\nQuin és el nou rang del tripulant?: C-Comandant, CP-Copilot, EV-Enginyer de vol", 2));

	}

	public void mostrarTripulantCabina() {
		super.mostrarComponent();
		System.out.println("\nRang: " + rang);
		System.out.println("\nBarres: " + barres);
	}

	public void assignarBarres(String pRang) {

		switch (pRang) {
		case "C":
			rang = "Comandant";
			barres = 4;
			break;
		case "CP":
			rang = "Copilot";
			if (horesVol < 1500) {
				barres = 2;
			} else {
				barres = 3;
			}
			break;
		case "EV":
			rang = "Enginyer de vol";
			barres = 1;
			break;
		default:
			System.out.println("\nEl rang no és correcte");
			break;
		}

	}

}
