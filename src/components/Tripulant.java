package components;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Tripulant implements Component{
    
    private String passaport;
    private String nom;
    private int edat;
    private Date dataAlta;
    private int horesVol;
    private String rang;
    
    public Tripulant(String pPassaport, String pNom, int pEdat, int pHoresVol) {
        this.passaport = passaport;
        this.nom = nom;
        this.edat = edat;
        dataAlta = new Date();
        this.horesVol = horesVol;
        this.rang = null;
    }
    
    /*
    Mètodes accessors
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
    
    public void modificarComponent(){
        
        System.out.println("\nEl passaport actual del Component és:" + passaport);
        System.out.println("\nQuin és el nou passaport del Component?");
        passaport = DADES.next();
        DADES.nextLine(); //Neteja de buffer
        System.out.println("\nEl nom actual del Component és:" + nom);
        System.out.println("\nQuin és el nou nom del Component?");
        nom = DADES.nextLine();
        System.out.println("\nL'edat actual del Component és:" + edat);
        System.out.println("\nQuina és la nova edat del Component?");
        edat = DADES.nextInt();

        System.out.println("Les hores de vol actuals del Component són:" + horesVol);
        System.out.println("\nQuines són les hores de vol actuals del Component:");
        horesVol = DADES.nextInt();
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
