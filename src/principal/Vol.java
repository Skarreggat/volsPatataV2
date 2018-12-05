package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import components.Avio;
import components.Component;
import components.TCP;
import components.Tripulant;
import components.TripulantCabina;

/**
 *
 * @author root
 */
public class Vol implements Component {

	private String codi;
	private Object ruta;
	private Avio avio;
	private Tripulant[] tripulacio;
	private int posicioTripulacio;
	private TCP cap;
	private Date dataSortida;
	private Date dataArribada;
	private LocalTime horaSortida;
	private LocalTime horaArribada;
	private String durada;

	// CONSTRUCTOR
	public Vol(String codi, Date dataSortida, Date dataArribada, LocalTime horaSortida, LocalTime horaArribada) {
		this.codi = codi;
		ruta = null;
		avio = null;
		tripulacio = new Tripulant[32];
		posicioTripulacio = 0;
		cap = null;
		this.dataSortida = dataSortida;
		this.dataArribada = dataArribada;
		this.horaSortida = horaSortida;
		this.horaArribada = horaArribada;
		calcularDurada();
	}

	// GETTERS & SETTERS
	public String getCodi() {
		return codi;
	}

	public void setCodi(String codi) {
		this.codi = codi;
	}

	public Object getRuta() {
		return ruta;
	}

	public void setRuta(Object ruta) {
		this.ruta = ruta;
	}

	public Avio getAvio() {
		return avio;
	}

	public void setAvio(Avio avio) {
		this.avio = avio;
	}

	public Tripulant[] getTripulacio() {
		return tripulacio;
	}

	public void setTripulacio(Tripulant[] tripulacio) {
		this.tripulacio = tripulacio;
	}

	public int getPosicioTripulacio() {
		return posicioTripulacio;
	}

	public void setPosicioTripulacio(int posicioTripulacio) {
		this.posicioTripulacio = posicioTripulacio;
	}

	public TCP getCap() {
		return cap;
	}

	public void setCap(TCP cap) {
		this.cap = cap;
	}

	public Date getDataSortida() {
		return dataSortida;
	}

	public void setDataSortida(Date dataSortida) {
		this.dataSortida = dataSortida;
	}

	public Date getDataArribada() {
		return dataArribada;
	}

	public void setDataArribada(Date dataArribada) {
		this.dataArribada = dataArribada;
	}

	public LocalTime getHoraSortida() {
		return horaSortida;
	}

	public void setHoraSortida(LocalTime horaSortida) {
		this.horaSortida = horaSortida;
	}

	public LocalTime getHoraArribada() {
		return horaArribada;
	}

	public void setHoraArribada(LocalTime horaArribada) {
		this.horaArribada = horaArribada;
	}

	public String getDurada() {
		return durada;
	}

	public void setDurada(String durada) {
		this.durada = durada;
	}

	public static Vol nouVol() throws ParseException {
		String codi;
		Date dataSortida, dataArribada;
		LocalTime horaSortida, horaArribada;
		int hora, minuts;

		System.out.println("\nCodi del vol?");
		codi = DADES.next();

		System.out.println("\nData de sortida del vol?: (dd-mm-yyyy)");
		dataSortida = new SimpleDateFormat("dd-MM-yyyy").parse(DADES.next());
		System.out.println("\nData d'arribada del vol?: (dd-mm-yyyy)");
		dataArribada = new SimpleDateFormat("dd-MM-yyyy").parse(DADES.next());

		System.out.println("\nA quina hora surt el vol?");
		hora = DADES.nextInt();
		System.out.println("\nA quins minuts de la hora surt el vol?");
		minuts = DADES.nextInt();
		horaSortida = LocalTime.of(hora, minuts, 0, 0);

		System.out.println("\nA quina hora arriba el vol?");
		hora = DADES.nextInt();
		System.out.println("\nA quins minuts de la hora arriba el vol?");
		minuts = DADES.nextInt();
		horaArribada = LocalTime.of(hora, minuts, 0, 0);

		return new Vol(codi, dataSortida, dataArribada, horaSortida, horaArribada);
	}

	private void calcularDurada() {

		long segonsDurada = (dataArribada.getTime() + (horaArribada.getHour() * 3600 + horaArribada.getMinute() * 60))
				- (dataSortida.getTime() + (horaSortida.getHour() * 3600 + horaSortida.getMinute() * 60));

		durada = (segonsDurada / 3600000) + " h - " + ((segonsDurada - (3600 * (segonsDurada / 3600))) / 60) + " m";
	}

	public void afegirTripulant(Tripulant tripulant) {
		if (tripulant instanceof TripulantCabina) {
			tripulacio[posicioTripulacio] = tripulant;
			posicioTripulacio++;
		} else if (tripulant instanceof TCP) {
			// Comprovar si cap de cabina o no
			String capDeCabina = (String) demanarDades("Vol que el TCP introduit sigui cap de cabina? Si/No", 2);
			if ("si".equals(capDeCabina.trim().toLowerCase())) {
				// Si ja existeix cap, el seu rang passa a null
				if (cap == null) {
					cap.setRang(null);
				}
				tripulant.setRang("cap");
				cap = (TCP) tripulant;
			}
			tripulacio[posicioTripulacio] = tripulant;
			posicioTripulacio++;
		}
	}

	public void mostrarComponent() {
		System.out.println("\nLes dades del vol amb codi " + codi + " són:");

		System.out.println("\nRuta: ");
		if (ruta != null) {
			ruta.mostrarComponent();
		}

		System.out.println("\nAvio: ");
		if (avio != null) {
			avio.mostrarComponent();
		}

		System.out.println("\nData de sortida: " + new SimpleDateFormat("dd-MM-yyyy").format(dataSortida));
		System.out.println("\nData d'arribada: " + new SimpleDateFormat("dd-MM-yyyy").format(dataArribada));
		System.out.println("\nHores de sortida: " + horaSortida.getHour() + ":" + horaSortida.getMinute());
		System.out.println("\nHores d'arribada: " + horaArribada.getHour() + ":" + horaArribada.getMinute());

		System.out.println("\nLa tripulació de cabina és:");
		for (int i = 0; i < posicioTripulacio; i++) {
			if (tripulacio[i] != null && tripulacio[i] instanceof TripulantCabina) {
				tripulacio[i].mostrarComponent();
			}
		}

		System.out.println("\nLa tripulació de cabina de passatgers és:");
		for (int i = 0; i < posicioTripulacio; i++) {
			if (tripulacio[i] != null && tripulacio[i] instanceof TCP) {
				tripulacio[i].mostrarComponent();
			}
		}

		System.out.println("\nDurada: " + durada);
	}

	public void modificarComponent() throws ParseException {
		int hora, minuts;

		System.out.println("\nEl codi del vol és: " + codi);
		codi = (String) demanarDades("\nQuin és el nou codi del vol?", 2);

		System.out
				.println("\nLa data de sortida del vol és: " + new SimpleDateFormat("dd-MM-yyyy").format(dataSortida));
		dataSortida = new SimpleDateFormat("dd-MM-yyyy")
				.parse((String) demanarDades("\nQuina és la nova data de sortida del vol?: (dd-mm-yyyy)", 2));

		System.out.println(
				"\nLa data d'arribada del vol avió: " + new SimpleDateFormat("dd-MM-yyyy").format(dataArribada));
		dataArribada = new SimpleDateFormat("dd-MM-yyyy")
				.parse((String) demanarDades("\nQuina avió la nova data d'arribada del vol?: (dd-mm-yyyy)", 2));

		System.out
				.println("\nL'hora de sortida del vol avió: " + horaSortida.getHour() + ":" + horaSortida.getMinute());
		hora = (int) demanarDades("\nQuina avió la nova hora de sortida del vol?", 1);
		minuts = (int) demanarDades("\nQuins són els nous minuts de la hora de sortida del vol?", 1);
		horaSortida = LocalTime.of(hora, minuts);

		System.out.println(
				"\nL'hora d'arribada del vol avió: " + horaArribada.getHour() + ":" + horaArribada.getMinute());
		hora = (int) demanarDades("\nQuina avió la nova hora d'arribada del vol?", 1);
		minuts = (int) demanarDades("\nQuins són els nous minuts de l'hora d'arribada del vol?", 1);
		horaArribada = LocalTime.of(hora, minuts);
	}
}
