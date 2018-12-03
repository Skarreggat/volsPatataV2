/*
 * Una ruta nacional es defineix pel seu codi, aeroport d’origen, aeroport de 
 * destí, distància i país
 */
package components;

import java.util.Scanner;

/**
 *
 * @author root
 */
public class RutaNacional extends Ruta {

    private final static Scanner DADES = new Scanner(System.in);

  
    private String pais;


    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */
    public RutaNacional(String codi, String pais, String aeroportOri, String aeroportDes, double distancia) {
        super(codi,aeroportOri, aeroportDes,distancia);
        this.pais = pais;
 
    }

    /*
    Mètodes accessors
     */
    

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear una nova ruta nacional.
    Les dades a demanar són les que necessita el constructor.
    - Heu de tenir en compte que els aeroports no tene per què estar formats per una única 
    paraula, per exemple, El Prat.
     */
    public static RutaNacional novaRutaNacional() {

        String codi, aeroportOri, aeroportDes, pais;
        double distancia;

        System.out.println("\nCodi de la ruta nacional:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja de buffer
        System.out.println("\nAeroport d'origen de la ruta nacional:");
        aeroportOri = DADES.nextLine();
        System.out.println("\nAeroport de destí de la ruta nacional:");
        aeroportDes = DADES.nextLine();
        System.out.println("\nPaís de la ruta nacional:");
        pais = DADES.nextLine();
        System.out.println("\nDistància de la ruta nacional:");
        distancia = DADES.nextDouble();

        return new RutaNacional(codi, aeroportOri, aeroportDes, pais, distancia);

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
    
 
    public void modificarRutaNacional() {

        
        System.out.println("\nEl codi de la ruta nacional és:" + codi);
        System.out.println("\nQuin és el nou codi de la ruta nacional?");
        codi = DADES.next();
        DADES.nextLine(); //Neteja de buffer
        System.out.println("\nL'aeroport d'origen de la ruta nacional és:" + aeroportOri);
        System.out.println("\nQuin és el nou l'aeroport d'origen de la ruta nacional?");
        aeroportOri = DADES.nextLine();
        System.out.println("\nL'aeroport de destí de la ruta nacional és:" + aeroportDes);
        System.out.println("\nQuin és el nou l'aeroport de destí de la ruta nacional?");
        aeroportDes = DADES.nextLine();
        System.out.println("\nEl país de la ruta nacional és:" + pais);
        System.out.println("\nQuin és el nou país de la ruta nacional:");
        pais = DADES.nextLine();
        System.out.println("\nLa distància de la ruta nacional és:");
        System.out.println("\nQuina és la nova distància de la ruta nacional?");
        distancia = DADES.nextDouble();
    }

    public void mostrarRutaNacional() {
        super.mostrarComponent();
        System.out.println("\nPaís: " + pais);
        
    }
}
