package components;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Tripulant implements Component {

	protected String passaport;
	protected String nom;
	protected int edat;
	protected Date dataAlta;
	protected int horesVol;
	protected String rang;

	public Tripulant(String pPassaport, String pNom, int pEdat, int pHoresVol) {
		this.passaport = pPassaport;
		this.nom = pNom;
		this.edat = pEdat;
		dataAlta = new Date();
		this.horesVol = pHoresVol;
		this.rang = null;
	}

	/*
	 * Mètodes accessors
	 */

	public void setPassaport(String passaport) {
		this.passaport = passaport;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}

	public void setDataAlta(Date dataAlta) {
		this.dataAlta = dataAlta;
	}

	public void setHoresVol(int horesVol) {
		this.horesVol = horesVol;
	}

	public void setRang(String rang) {
		this.rang = rang;
	}

	public String getPassaport() {
		return passaport;
	}

	public String getNom() {
		return nom;
	}

	public int getEdat() {
		return edat;
	}

	public Date getDataAlta() {
		return dataAlta;
	}

	public int getHoresVol() {
		return horesVol;
	}

	public String getRang() {
		return rang;
	}

	public void modificarComponent() {

		System.out.println("\nEl passaport actual del Component és:" + passaport);
		passaport = (String) demanarDades("\nQuin és el nou passaport del Component?", 2);
		System.out.println("\nEl nom actual del Component és:" + nom);
		nom = (String) demanarDades("\nQuin és el nou nom del Component?", 4);
		System.out.println("\nL'edat actual del Component és:" + edat);
		edat = (int) demanarDades("\nQuina és la nova edat del Component?", 1);
		System.out.println("Les hores de vol actuals del Component són:" + horesVol);
		horesVol = (int) demanarDades("\nQuines són les hores de vol actuals del Component:", 1);
	}

	public void mostrarComponent() {
		System.out.println("\nLes dades del Component amb passaport " + passaport + " són:");
		System.out.println("\nNom: " + nom);
		System.out.println("\nEdat: " + edat);
		System.out.println("\nData d'alta: " + new SimpleDateFormat("dd-MM-yyyy").format(dataAlta));
		System.out.println("\nHores de vol: " + horesVol);
		System.out.println("\nRang: " + rang);
	}

}
