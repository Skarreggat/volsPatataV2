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
public class RutaTransoceanica extends Ruta {

    private String paisOri;
    private String paisDes;
    private String continentOri;
    private String continentDes;
    private String ocea;


    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */
    public RutaTransoceanica(String codi, String aeroportOri, String aeroportDes, String paisOri, String paisDes, String continentOri, String continentDes, String ocea, double distancia) {

        super(codi, aeroportOri, aeroportDes, distancia);
        this.paisOri = paisOri;
        this.paisDes = paisDes;
        this.continentOri = continentOri;
        this.continentDes = continentDes;
        this.ocea = ocea;

    }

    /*
    Mètodes accessors
     */


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
        
        super.modificarComponent();

        
        System.out.println("\nEl país d'origen de la ruta transoceànica és:" + paisOri);
        System.out.println("\nQuin és el nou país d'origen de la ruta transoceànica:");
        paisOri = DADES.nextLine();
        System.out.println("\nEl país de destí de la ruta transoceànica és:" + paisDes);
        System.out.println("\nQuin és el nou país de destí de la ruta transoceànica?");
        paisDes = DADES.nextLine();
        System.out.println("\nEl continent d'origen de la ruta transoceànica és:" + continentOri);
        System.out.println("\nQuin és el nou continent d'origen de la ruta transoceànica?");
        continentOri = DADES.nextLine();
        System.out.println("\nEl continent de destí de la ruta transoceànica és:" + continentDes);
        System.out.println("\nQuin és el nou continent de destí de la ruta transoceànica?");
        continentDes = DADES.nextLine();
        System.out.println("\nL'oceà que sobrevola la ruta transoceànica és:" + ocea);
        System.out.println("\nQuin és el nou oceà que sobrevola la ruta transoceànica?");
        ocea = DADES.nextLine();


    }

    public void mostrarRutaTransoceanica() {
        
        super.mostrarComponent();
        System.out.println("\nPaís d'origen: " + paisOri);
        System.out.println("\nPaís de destí: " + paisDes);
        System.out.println("\nContinent d'origen: " + continentOri);
        System.out.println("\nContinent de destí: " + continentDes);
        System.out.println("\nOceà que sobrevola: " + ocea);

    }
}
