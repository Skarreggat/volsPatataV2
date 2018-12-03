/*
 * Una ruta internacional es defineix pel seu codi, aeroport d’origen, aeroport 
 * de destí, distància, país d’origen i país de destí
 */
package components;

import java.util.Scanner;

/**
 *
 * @author root
 */
public class RutaInternacional {

    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private String aeroportOri;
    private String aeroportDes;
    private String paisOri;
    private String paisDes;
    private double distancia;

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */
    public RutaInternacional(String codi, String aeroportOri, String aeroportDes, String paisOri, String paisDes, double distancia) {
        this.codi = codi;
        this.aeroportOri = aeroportOri;
        this.aeroportDes = aeroportDes;
        this.paisOri = paisOri;
        this.paisDes = paisDes;
        this.distancia = distancia;
    }


    /*
    Mètodes accessors
     */
    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getAeroportOri() {
        return aeroportOri;
    }

    public void setAeroportOri(String aeroportOri) {
        this.aeroportOri = aeroportOri;
    }

    public String getAeroportDes() {
        return aeroportDes;
    }

    public void setAeroportDes(String aeroportDes) {
        this.aeroportDes = aeroportDes;
    }

    public String getPaisOri() {
        return paisOri;
    }

    public void setPaisOri(String paisOri) {
        this.paisOri = paisOri;
    }

    public String getPaisDes() {
        return paisDes;
    }

    public void setPaisDes(String paisDes) {
        this.paisDes = paisDes;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }


    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear una nova ruta internacional.
    Les dades a demanar són les que necessita el constructor.
    - Heu de tenir en compte que els aeroports països no tene per què estar formats per una única 
    paraula, per exemple, El Prat o Regne Unit.
     */
    public static RutaInternacional novaRutaInternacional() {

        String codi, aeroportOri, aeroportDes, paisOri, paisDes, continentOri, continentDes;
        double distancia;

        System.out.println("\nCodi de la ruta internacional:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja de buffer
        System.out.println("\nAeroport d'origen de la ruta internacional:");
        aeroportOri = DADES.nextLine();
        System.out.println("\nAeroport de destí de la ruta internacional:");
        aeroportDes = DADES.nextLine();
        System.out.println("\nPaís d'origen de la ruta internacional:");
        paisOri = DADES.nextLine();
        System.out.println("\nPaís de destí de la ruta internacional:");
        paisDes = DADES.nextLine();
        System.out.println("\nDistància de la ruta internacional:");
        distancia = DADES.nextDouble();

        return new RutaInternacional(codi, aeroportOri, aeroportDes, paisOri, paisDes, distancia);
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los.
    
     Retorn: cap
     */
    public void modificarRutaInternacional() {

        System.out.println("\nEl codi de la ruta internacional és:" + codi);
        System.out.println("\nQuin és el nou codi de la ruta internacional?");
        codi = DADES.next();
        DADES.nextLine(); //Neteja de buffer
        System.out.println("\nL'aeroport d'origen de la ruta internacional és:" + aeroportOri);
        System.out.println("\nQuin és el nou l'aeroport d'origen de la ruta internacional?");
        aeroportOri = DADES.nextLine();
        System.out.println("\nL'aeroport de destí de la ruta internacional és:" + aeroportDes);
        System.out.println("\nQuin és el nou l'aeroport de destí de la ruta internacional?");
        aeroportDes = DADES.nextLine();
        System.out.println("\nEl país d'origen de la ruta internacional és:" + paisOri);
        System.out.println("\nQuin és el nou país d'origen de la ruta internacional:");
        paisOri = DADES.nextLine();
        System.out.println("\nEl país de destí de la ruta internacional és:" + paisDes);
        System.out.println("\nQuin és el nou país de destí de la ruta internacional?");
        paisDes = DADES.nextLine();
        System.out.println("\nLa distància de la ruta internacional és:");
        System.out.println("\nQuina és la nova distància de la ruta internacional?");
        distancia = DADES.nextDouble();
    }

    public void mostrarRutaInternacional() {
        System.out.println("\nLes dades de la ruta internacional amb codi " + codi + " són:");
        System.out.println("\nAeroport d'origen: " + aeroportOri);
        System.out.println("\nAeroport de destí: " + aeroportDes);
        System.out.println("\nPaís d'origen: " + paisOri);
        System.out.println("\nPaís de destí: " + paisDes);
        System.out.println("\nDistància: " + distancia);
    }
}
