/*
 * Una ruta transoceànica es defineix pel seu codi, aeroport d’origen, aeroport 
 * de destí, distància, país d’origen, país de destí, continent d’origen, continent 
 * de destí i oceà que sobrevola.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author root
 */
public class RutaTransoceanica {

    private final static Scanner DADES = new Scanner(System.in);
    
    private String codi;
    private String aeroportOri;
    private String aeroportDes;
    private String paisOri;
    private String paisDes;
    private String continentOri;
    private String continentDes;
    private String ocea;
    private double distancia;

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */
    public RutaTransoceanica(String codi, String aeroportOri, String aeroportDes, String paisOri, String paisDes, String continentOri, String continentDes, String ocea, double distancia) {
        this.codi = codi;
        this.aeroportOri = aeroportOri;
        this.aeroportDes = aeroportDes;
        this.paisOri = paisOri;
        this.paisDes = paisDes;
        this.continentOri = continentOri;
        this.continentDes = continentDes;
        this.ocea = ocea;
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

    public String getContinentOri() {
        return continentOri;
    }

    public void setContinentOri(String continentOri) {
        this.continentOri = continentOri;
    }

    public String getContinentDes() {
        return continentDes;
    }

    public void setContinentDes(String continentDes) {
        this.continentDes = continentDes;
    }

    public String getOcea() {
        return ocea;
    }

    public void setOcea(String ocea) {
        this.ocea = ocea;
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
    - Demanar a l'usuari les dades per consola per crear una nova ruta transcoceanica.
    Les dades a demanar són les que necessita el constructor.
    - Heu de tenir en compte que els aeroports i països no tene per què estar formats
    per una única paraula, per exemple, El Prat i Regne Unit.
     */
    public static RutaTransoceanica novaRutaTransoceanica() {

        String codi, aeroportOri, aeroportDes, paisOri, paisDes, continentOri, continentDes, ocea;
        double distancia;

        System.out.println("\nCodi de la ruta transoceànica:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja de buffer
        System.out.println("\nAeroport d'origen de la ruta transoceànica:");
        aeroportOri = DADES.nextLine();
        System.out.println("\nAeroport de destí de la ruta transoceànica:");
        aeroportDes = DADES.nextLine();
        System.out.println("\nPaís d'origen de la ruta transoceànica:");
        paisOri = DADES.nextLine();
        System.out.println("\nPaís de destí de la ruta transoceànica:");
        paisDes = DADES.nextLine();
        System.out.println("\nContinent d'origen de la ruta transoceànica:");
        continentOri = DADES.nextLine();
        System.out.println("\nContinent de destí de la ruta transoceànica:");
        continentDes = DADES.nextLine();
        System.out.println("\nOceà que sobrevola la ruta transoceànica:");
        ocea = DADES.nextLine();
        System.out.println("\nDistància de la ruta transoceànica:");
        distancia = DADES.nextDouble();

        return new RutaTransoceanica(codi, aeroportOri, aeroportDes, paisOri, paisDes, continentOri, continentDes, ocea, distancia);
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
    public void modificarRutaTransoceanica() {

        System.out.println("\nEl codi de la ruta transoceànica és:"+codi);
        System.out.println("\nQuin és el nou codi de la ruta transoceànica?");
        codi = DADES.next();
        DADES.nextLine(); //Neteja de buffer
        System.out.println("\nL'aeroport d'origen de la ruta transoceànica és:"+aeroportOri);
        System.out.println("\nQuin és el nou l'aeroport d'origen de la ruta transoceànica?");
        aeroportOri = DADES.nextLine();
        System.out.println("\nL'aeroport de destí de la ruta transoceànica és:"+aeroportDes);
        System.out.println("\nQuin és el nou l'aeroport de destí de la ruta transoceànica?");
        aeroportDes = DADES.nextLine();
        System.out.println("\nEl país d'origen de la ruta transoceànica és:"+paisOri);
        System.out.println("\nQuin és el nou país d'origen de la ruta transoceànica:");
        paisOri = DADES.nextLine();
        System.out.println("\nEl país de destí de la ruta transoceànica és:"+paisDes);
        System.out.println("\nQuin és el nou país de destí de la ruta transoceànica?");
        paisDes = DADES.nextLine();
        System.out.println("\nEl continent d'origen de la ruta transoceànica és:"+continentOri);
        System.out.println("\nQuin és el nou continent d'origen de la ruta transoceànica?");
        continentOri = DADES.nextLine();
        System.out.println("\nEl continent de destí de la ruta transoceànica és:"+continentDes);
        System.out.println("\nQuin és el nou continent de destí de la ruta transoceànica?");
        continentDes = DADES.nextLine();
        System.out.println("\nL'oceà que sobrevola la ruta transoceànica és:"+ocea);
        System.out.println("\nQuin és el nou oceà que sobrevola la ruta transoceànica?");
        ocea = DADES.nextLine();
        System.out.println("\nLa distància de la ruta transoceànica és:");
        System.out.println("\nQuina és la nova distància de la ruta transoceànica?");
        distancia = DADES.nextDouble();
        
    }

    public void mostrarRutaTransoceanica() {
        System.out.println("\nLes dades de la ruta transoceànica amb codi " + codi + " són:");
        System.out.println("\nAeroport d'origen: " + aeroportOri);
        System.out.println("\nAeroport de destí: " + aeroportDes);
        System.out.println("\nPaís d'origen: " + paisOri);
        System.out.println("\nPaís de destí: " + paisDes);
        System.out.println("\nContinent d'origen: " + continentOri);
        System.out.println("\nContinent de destí: " + continentDes);
        System.out.println("\nOceà que sobrevola: " + ocea);
        System.out.println("\nDistància: " + distancia);
    }
}
