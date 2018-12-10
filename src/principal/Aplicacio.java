/*
 * Una classe Aplicacio per interactuar amb l'usuari, que contengui les companyies 
 * i cridar a la resta de classes i mètodes mitjançant uns menús.
 */
package principal;

import java.text.ParseException;
import java.util.Scanner;

import components.Avio;
import components.RutaIntercontinental;
import components.RutaInternacional;
import components.RutaNacional;
import components.RutaTransoceanica;
import components.TCP;
import components.TripulantCabina;

/**
 *
 * @author root
 */
public class Aplicacio {

	private final static Scanner DADES = new Scanner(System.in);
	private static Companyia[] companyies = new Companyia[5];
	private static int posicioCompanyies = 0; // La propera posició buida del vector companyies
	private static Companyia companyiaActual = null; // Companyia seleccionada

	public static void main(String[] args) throws ParseException {
		menuPrincipal();
	}

	private static void menuPrincipal() throws ParseException {
		int opcio = 0;

		do {
			System.out.println("\nSelecciona una opció");
			System.out.println("\n0. Sortir");
			System.out.println("\n1. Gestió de companyies");
			System.out.println("\n2. Gestió d'avions");
			System.out.println("\n3. Gestió de rutes nacionals");
			System.out.println("\n4. Gestió de rutes internacionals");
			System.out.println("\n5. Gestió de rutes intercontinentals");
			System.out.println("\n6. Gestió de rutes transoceàniques");
			System.out.println("\n7. Gestió de tripulants de cabina");
			System.out.println("\n8. Gestió de tripulants de cabina de passatgers");
			System.out.println("\n9. Gestió de vols");

			opcio = DADES.nextInt();

			switch (opcio) {
			case 0:
				break;
			case 1:
				menuCompanyes();
				break;
			case 2:
				if (companyiaActual != null) {
					menuComponents(1);
				} else {
					System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
				}
				break;
			case 3:
				if (companyiaActual != null) {
					menuComponents(2);
				} else {
					System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
				}
				break;
			case 4:
				if (companyiaActual != null) {
					menuComponents(3);
				} else {
					System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
				}
				break;
			case 5:
				if (companyiaActual != null) {
					menuComponents(4);
				} else {
					System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
				}
				break;
			case 6:
				if (companyiaActual != null) {
					menuComponents(5);
				} else {
					System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
				}
				break;
			case 7:
				if (companyiaActual != null) {
					menuComponents(6);
				} else {
					System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
				}
				break;
			case 8:
				if (companyiaActual != null) {
					menuComponents(7);
				} else {
					System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
				}
				break;
			case 9:
				if (companyiaActual != null) {
					menuComponents(8);
				} else {
					System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
				}
				break;
			default:
				System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
				break;
			}
		} while (opcio != 0);
	}

	public static void menuCompanyes() {
		int opcio = 0;

		do {
			int pos = -1;
			System.out.println("\nSelecciona una opció");
			System.out.println("\n0. Sortir");
			System.out.println("\n1. Alta");
			System.out.println("\n2. Seleccionar");
			System.out.println("\n3. Modificar");
			System.out.println("\n4. LListar companyes");

			opcio = DADES.nextInt();

			switch (opcio) {
			case 0:
				break;
			case 1:
				companyies[posicioCompanyies] = Companyia.novaCompanyia();
				posicioCompanyies++;
				break;
			case 2:
				pos = selectCompanyia();
				if (pos >= 0) {
					companyiaActual = companyies[pos];
				} else {
					System.out.println("\nNo existeix aquesta companyia");
				}
				break;
			case 3:
				pos = selectCompanyia();
				if (pos >= 0) {
					companyies[pos].modificarCompanyia();
				} else {
					System.out.println("\nNo existeix aquesta companyia");
				}
				break;
			case 4:
				for (int i = 0; i < posicioCompanyies; i++) {
					companyies[i].mostrarCompanyia();
				}
				break;
			default:
				System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
				break;
			}
		} while (opcio != 0);
	}

	public static void menuComponents(int tipus) {
		int opcio = -1;
		int pos = -1;
		switch (tipus) {
		case 1: // Avio
			do {
				pos = -1;
				System.out.println("\nSelecciona una opció");
				System.out.println("\n0. Sortir");
				System.out.println("\n1. Alta");
				System.out.println("\n2. Modificar");
				System.out.println("\n3. Llistar Avions");
				opcio = DADES.nextInt();
				DADES.nextLine();
				switch (opcio) {
				case 1:
					companyiaActual.afegirAvio();
					break;
				case 2:
					pos = companyiaActual.seleccionarComponent(1, null);
					if (pos >= 0) {
						Avio avio = companyiaActual.getComponents()[pos];
						avio.modificarComponent();
					} else {
						System.out.println("\nNo existeix aquest avió");
					}
					break;
				case 3:
					for (int i = 0; i < companyiaActual.getPosicioComponents(); i++) {
						if (companyiaActual.getComponents()[i] instanceof Avio) {
							companyiaActual.getComponents()[i].mostrarComponent();
						}
					}
					break;
				default:
					System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
					break;
				}
			} while (opcio != 0);
			break;
		case 2: // Ruta nacional
			do {
				pos = -1;
				System.out.println("\nSelecciona una opció");
				System.out.println("\n0. Sortir");
				System.out.println("\n1. Alta");
				System.out.println("\n2. Modificar");
				System.out.println("\n3. Llistar Rutes Nacionals");
				opcio = DADES.nextInt();
				DADES.nextLine();
				switch (opcio) {
				case 1:
					companyiaActual.afegirRutaNacional();
					break;
				case 2:
					pos = companyiaActual.seleccionarComponent(2, null);
					if (pos >= 0) {
						RutaNacional rn = companyiaActual.getComponents()[pos];
						rn.modificarComponent();
					} else {
						System.out.println("\nNo existeix aquest avió");
					}
					break;
				case 3:
					for (int i = 0; i < companyiaActual.getPosicioComponents(); i++) {
						if (companyiaActual.getComponents()[i] instanceof RutaNacional) {
							companyiaActual.getComponents()[i].mostrarComponent();
						}
					}
					break;
				default:
					System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
					break;
				}
			} while (opcio != 0);
			break;
		case 3: // Ruta internacional
			do {
				pos = -1;
				System.out.println("\nSelecciona una opció");
				System.out.println("\n0. Sortir");
				System.out.println("\n1. Alta");
				System.out.println("\n2. Modificar");
				System.out.println("\n3. Llistar Rutes Internacionals");
				opcio = DADES.nextInt();
				DADES.nextLine();
				switch (opcio) {
				case 1:
					companyiaActual.afegirRutaNacional();
					break;
				case 2:
					pos = companyiaActual.seleccionarComponent(2, null);
					if (pos >= 0) {
						RutaInternacional ri = companyiaActual.getComponents()[pos];
						ri.modificarComponent();
					} else {
						System.out.println("\nNo existeix aquesta ruta internacional");
					}
					break;
				case 3:
					for (int i = 0; i < companyiaActual.getPosicioComponents(); i++) {
						if (companyiaActual.getComponents()[i] instanceof RutaInternacional) {
							companyiaActual.getComponents()[i].mostrarComponent();
						}
					}
					break;
				default:
					System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
					break;
				}
			} while (opcio != 0);
			break;
		case 4: // Ruta intercontinental
			do {
				pos = -1;
				System.out.println("\nSelecciona una opció");
				System.out.println("\n0. Sortir");
				System.out.println("\n1. Alta");
				System.out.println("\n2. Modificar");
				System.out.println("\n3. Llistar Rutes Intercontinentals");
				opcio = DADES.nextInt();
				DADES.nextLine();
				switch (opcio) {
				case 1:
					companyiaActual.afegirRutaIntercontinental();
					break;
				case 2:
					pos = companyiaActual.seleccionarComponent(2, null);
					if (pos >= 0) {
						RutaIntercontinental ri = companyiaActual.getComponents()[pos];
						ri.modificarComponent();
					} else {
						System.out.println("\nNo existeix aquesta ruta intercontinental");
					}
					break;
				case 3:
					for (int i = 0; i < companyiaActual.getPosicioComponents(); i++) {
						if (companyiaActual.getComponents()[i] instanceof RutaIntercontinental) {
							companyiaActual.getComponents()[i].mostrarComponent();
						}
					}
					break;
				default:
					System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
					break;
				}
			} while (opcio != 0);
			break;
		case 5: // Ruta transoceànica
			do {
				pos = -1;
				System.out.println("\nSelecciona una opció");
				System.out.println("\n0. Sortir");
				System.out.println("\n1. Alta");
				System.out.println("\n2. Modificar");
				System.out.println("\n3. Llistar Rutes Transoceàniques");
				opcio = DADES.nextInt();
				DADES.nextLine();
				switch (opcio) {
				case 1:
					companyiaActual.afegirRutaTransoceanica();
					break;
				case 2:
					pos = companyiaActual.seleccionarComponent(2, null);
					if (pos >= 0) {
						RutaIntercontinental ri = companyiaActual.getComponents()[pos];
						ri.modificarComponent();
					} else {
						System.out.println("\nNo existeix aquesta ruta transoceànica");
					}
					break;
				case 3:
					for (int i = 0; i < companyiaActual.getPosicioComponents(); i++) {
						if (companyiaActual.getComponents()[i] instanceof RutaTransoceanica) {
							companyiaActual.getComponents()[i].mostrarComponent();
						}
					}
					break;
				default:
					System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
					break;
				}
			} while (opcio != 0);
			break;
		case 6: // Tripulant cabina
			do {
				pos = -1;
				System.out.println("\nSelecciona una opció");
				System.out.println("\n0. Sortir");
				System.out.println("\n1. Alta");
				System.out.println("\n2. Modificar");
				System.out.println("\n3. Llistar Tripulants Cabina");
				opcio = DADES.nextInt();
				DADES.nextLine();
				switch (opcio) {
				case 1:
					companyiaActual.afegirTripulantCabina();
					break;
				case 2:
					pos = companyiaActual.seleccionarComponent(3, null);
					if (pos >= 0) {
						TripulantCabina tcv = companyiaActual.getComponents()[pos];
						tcv.modificarComponent();
					} else {
						System.out.println("\nNo existeix aquest tripulant de cabina");
					}
					break;
				case 3:
					for (int i = 0; i < companyiaActual.getPosicioComponents(); i++) {
						if (companyiaActual.getComponents()[i] instanceof TripulantCabina) {
							companyiaActual.getComponents()[i].mostrarComponent();
						}
					}
					break;
				default:
					System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
					break;
				}
			} while (opcio != 0);
			break;
		case 7: // TCP
			do {
				pos = -1;
				System.out.println("\nSelecciona una opció");
				System.out.println("\n0. Sortir");
				System.out.println("\n1. Alta");
				System.out.println("\n2. Modificar");
				System.out.println("\n3. Llistar TCPs");
				opcio = DADES.nextInt();
				DADES.nextLine();
				switch (opcio) {
				case 1:
					companyiaActual.afegirTCP();
					break;
				case 2:
					pos = companyiaActual.seleccionarComponent(3, null);
					if (pos >= 0) {
						TCP tcp = companyiaActual.getComponents()[pos];
						tcp.modificarComponent();
					} else {
						System.out.println("\nNo existeix aquest TCP.");
					}
					break;
				case 3:
					for (int i = 0; i < companyiaActual.getPosicioComponents(); i++) {
						if (companyiaActual.getComponents()[i] instanceof TCP) {
							companyiaActual.getComponents()[i].mostrarComponent();
						}
					}
					break;
				default:
					System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
					break;
				}
			} while (opcio != 0);
			break;
		case 8: // Vol
			do {
				pos = -1;
				System.out.println("\nSelecciona una opció");
				System.out.println("\n0. Sortir");
				System.out.println("\n1. Alta");
				System.out.println("\n2. Modificar");
				System.out.println("\n3. Afegir avió");
				System.out.println("\n4. Afegir ruta");
				System.out.println("\n5. Afegir tripulant");
				System.out.println("\n6. Llistar vol");
				opcio = DADES.nextInt();
				DADES.nextLine();
				switch (opcio) {
				case 1:
					companyiaActual.afegirVol();
					break;
				case 2:
					pos = companyiaActual.seleccionarComponent(4, null);
					if (pos >= 0) {
						Vol vol = companyiaActual.getComponents()[pos];
						vol.modificarComponent();
					} else {
						System.out.println("\nNo existeix aquest vol.");
					}
					break;
				case 3:
					companyiaActual.afegirAvioVol();
					break;
				case 4:
					System.out.println("\n Quin tipus de ruta vol afegir?");
					System.out.println("\n2. Nacional");
					System.out.println("\n3. Internacional");
					System.out.println("\n4. Intercontinental");
					System.out.println("\n5.Transoceànica");
					switch (DADES.nextInt()) {
					case 1:
						companyiaActual.afegirRutaVol(2);
						break;
					case 2:
						companyiaActual.afegirRutaVol(3);
						break;
					case 3:
						companyiaActual.afegirRutaVol(4);
						break;
					case 4:
						companyiaActual.afegirRutaVol(5);
						break;
					default:
						System.out.println("\nEl tipus de ruta no és correcte...");
						break;
					}
					DADES.nextLine();
					break;
				case 5:
					System.out.println("\n Quin tipus de tripulant vol afegir?");
					System.out.println("\n6. Tripulant Cabina");
					System.out.println("\n7. TCP");
					switch (DADES.nextInt()) {
					case 6:
						companyiaActual.afegirTripulantVol(6);
						break;
					case 7:
						companyiaActual.afegirTripulantVol(7);
						break;
					default:
						System.out.println("\nEl tipus de tripulant no és correcte...");
						break;
					}
					DADES.nextLine();
					break;
				case 6:
					for (int i = 0; i < companyiaActual.getPosicioComponents(); i++) {
						if (companyiaActual.getComponents()[i] instanceof Vol) {
							companyiaActual.getComponents()[i].mostrarComponent();
						}
					}
					break;
				default:
					System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
					break;
				}
			} while (opcio != 0);
			break;
		}
	}

	public static Integer selectCompanyia() {
		System.out.println("\nCodi de la companyia?:");
		int codi = DADES.nextInt();

		boolean trobat = false;
		int pos = -1;

		for (int i = 0; i < posicioCompanyies && !trobat; i++) {
			if (companyies[i].getCodi() == codi) {
				pos = i;
				trobat = true;
			}
		}
		return pos;
	}
}
