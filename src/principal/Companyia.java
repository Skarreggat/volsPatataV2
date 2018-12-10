/*
 * Classe que defineix una companyia. Una companyia es defineix per un codi i un 
 * nom. A més, contindrà vectors amb avions, rutes nacionals, rutes internacionals,
 * rutes intercontinentals, rutes transocèaniques, tripulants de cabina, TCPs i vols.
 */
package principal;

import components.Avio;
import components.RutaIntercontinental;
import components.RutaInternacional;
import components.RutaNacional;
import components.RutaTransoceanica;
import components.TCP;
import components.TripulantCabina;
import java.text.ParseException;
import components.Component;
import components.Ruta;
import components.Tripulant;

/**
 *
 * @author root
 */
public class Companyia implements Component {

    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String nom;
    private Component[] components;
    private int posicioComponents;

    /*
     CONSTRUCTOR
     Paràmetres: valor per l'atribut nom
     Accions:
     - Assignar a l'atribut corresponent el valor passat com a paràmetre
     - Assignar a l'atribut codi el valor de l'atribut properCodi i actualitzar
     properCodi amb el següent codi a assignar.
     - avions s'ha d'inicialtizar buit i amb una capacitat per 200 avions.
     - rutesNacionals s'ha d'inicialtizar buit i amb una capacitat per 100 rutes nacionals.
     - rutesInternacionals s'ha d'inicialtizar buit i amb una capacitat per 200 rutes internacionals.
     - rutesIntercontinentals s'ha d'inicialtizar buit i amb una capacitat per 100 rutes intercontinentals.
     - rutesTransoceaniques s'ha d'inicialtizar buit i amb una capacitat per 45 rutes transoceàniques.
     - tripulantsCabina s'ha d'inicialtizar buit i amb una capacitat per 600 tripulants de cabina.
     - tcps s'ha d'inicialtizar buit i amb una capacitat per 1000 TCPs.
     - vols s'ha d'inicialtizar buit i amb una capacitat per 700 vols.
     - posicioRutesNacionals, posicioRutesInternacionals, posicioRutesIntercontinentals, posicioRutesTransoceaniques, 
       posicioTripulantsCabina, posicioTcps i posicioVols, s'han d'inicialitzar a 0, què serà la primera posició
       buida dels vectors inicilitzats.
     */
    public Companyia(String nom) {
        codi = properCodi;
        properCodi++;
        this.nom = nom;
        components = new Component[2945];
        posicioComponents = 0;
    }

    /*
     Mètodes accessors    
     */
    public int getCodi() {
        return codi;
    }

    public void setCodi() {
        codi = properCodi;
    }

    public static int getProperCodi() {
        return properCodi;
    }

    public static void setProperCodi() {
        properCodi++;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Component[] getComponent() {
        return components;
    }

    public void setComponent(Component[] components) {
        this.components = components;
    }

    public int getPosicioComponents() {
        return posicioComponents;
    }

    public void setPosicioComponents(int posicioComponents) {
        this.posicioComponents = posicioComponents;
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova Companyia. Les dades
     a demanar són les que necessita el constructor.
     - Heu de tenir en compte que el nom de la companyia, poden ser frases, per exemple,
     Singapore Airlines.
     Retorn: La nova companyia.
     */
    public static Companyia novaCompanyia() {

        System.out.println("\nNom de la companyia:");
        return new Companyia(DADES.nextLine());

    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte. En aquest cas
     no es pot modificar el contingut dels vectors, només el de l'atribut nom. 
     Evidentment, tampoc podeu modificar el codi.
     - Li heu de mostrar a l'usuari els valor actual del nom de l'objecte
     actual, abans de modificar-lo.
     Retorn: cap
     */
 /*
    public void modificarCompanyia() {

        System.out.println("\nNom de la companyia: " + nom);
        nom = (String)demanarDades("\nQuin és el nou nom de la companyia?", 2);

    }
     */
    public void modificarComponent() throws ParseException {
        System.out.println("\nNom de la companyia: " + nom);
        nom = (String) demanarDades("\nQuin és el nou nom de la companyia?", 2);
    }

    public void mostrarComponent() {
        System.out.println("\nLes dades de la companyia amb codi " + codi + " són:");
        System.out.println("\nNom:" + nom);
    }

    /*
    public void mostrarCompanyia() {
        System.out.println("\nLes dades de la companyia amb codi " + codi + " són:");
        System.out.println("\nNom:" + nom);
    }
     */
 /*
     AVIÓ
     */
 /*
     Paràmetres: cap
     Accions:
     - afegeix un nou avió al vector d'avions de l'objecte actual (el que cridarà
     al mètode), fent servir el mètode de la classe Avio pertinent.
     - actualitza la posició del vector d'avions.
     Retorn: cap
     */
    public void afegirAvio() {
        Avio avio = Avio.nouAvio();
        if (seleccionarComponent(1, avio.getCodi()) != -1) {
            System.out.println("\n Aquest Avio ja existeix");
        } else {

            components[posicioComponents] = avio;
            posicioComponents++;
        }
    }


    /*
     RUTA NACIONAL
     */
 /*
     Paràmetres: cap
     Accions:
     - afegeix una nova ruta nacional al vector de rutes nacionals de l'objecte 
     actual (el que cridarà al mètode), fent servir el mètode de la classe RutaNacional pertinent.
     - actualitza la posició del vector de rutes nacionals.
     Retorn: cap
     */
    public void afegirRutaNacional() {
        RutaNacional ruta = RutaNacional.novaRutaNacional();

        if (seleccionarComponent(2, ruta.getCodi()) != -1) {
            System.out.println("\n Aquesta ruta ja existeix");
        } else {

            components[posicioComponents] = ruta;
            posicioComponents++;
        }
    }

    /*
     RUTA INTERNACIONAL
     */
 /*
     Paràmetres: cap
     Accions:
     - afegeix una nova ruta internacional al vector de rutes internacionals de l'objecte 
     actual (el que cridarà al mètode), fent servir el mètode de la classe RutaInternacional pertinent.
     - actualitza la posició del vector de rutes internacionals.
     Retorn: cap
     */
    public void afegirRutaInternacional() {
        RutaInternacional ruta = RutaInternacional.novaRutaInternacional();
        if (seleccionarComponent(2, ruta.getCodi()) != -1) {
            System.out.println("\n Aquesta ruta ja existeix");
        } else {
            components[posicioComponents] = ruta;
            posicioComponents++;
        }
    }

    
    /*
     RUTA INTERCONTINENTAL
     */
 /*
     Paràmetres: cap
     Accions:
     - afegeix una nova ruta intercontinental al vector de rutes intercontinental de l'objecte 
     actual (el que cridarà al mètode), fent servir el mètode de la classe RutaIntercontinental pertinent.
     - actualitza la posició del vector de rutes intercontinental.
     Retorn: cap
     */
    public void afegirRutaIntercontinental() {
        RutaIntercontinental ruta=RutaIntercontinental.novaRutaIntercontinental();
         if (seleccionarComponent(2, ruta.getCodi()) != -1) {
            System.out.println("\n Aquesta ruta ja existeix");
        } else {
        components[posicioComponents] = ruta;
        posicioComponents++;
         }
    }

    
    /*
     RUTA TRANSOCEÀNICA
     */
 /*
     Paràmetres: cap
     Accions:
     - afegeix una nova ruta transoceànica al vector de rutes transoceàniques de l'objecte 
     actual (el que cridarà al mètode), fent servir el mètode de la classe RutaTransoceanica pertinent.
     - actualitza la posició del vector de rutes transoceàniques.
     Retorn: cap
     */
    public void afegirRutaTransoceanica() {
        RutaTransoceanica ruta=RutaTransoceanica.novaRutaTransoceanica();
        if (seleccionarComponent(2, ruta.getCodi()) != -1) {
            System.out.println("\n Aquesta ruta ja existeix");
        } else {
        components[posicioComponents] = ruta;
        posicioComponents++;
        }
    }

    

    /*
     TRIPULACIÓ CABINA
     */
 /*
     Paràmetres: cap
     Accions:
     - afegeix un nou tripulant de cabina al vector de tripulants de cabina de 
     l'objecte actual (el que cridarà al mètode), fent servir el mètode de la classe 
     TripulantCabina pertinent.
     - actualitza la posició del vector de tripulants de cabina.
     Retorn: cap
     */
    public void afegirTripulantCabina() {
        TripulantCabina tripu=TripulantCabina.nouTripulantCabina();
        if (seleccionarComponent(2, tripu.getPassaport()) != -1) {
            System.out.println("\n Aquest tripulant ja existeix");
        } else {
        components[posicioComponents] = tripu;
        posicioComponents++;
        }
    }

    

    /*
     TCP
     */
 /*
     Paràmetres: cap
     Accions:
     - afegeix un nou TCP al vector de TCPs de l'objecte actual (el que cridarà 
     al mètode), fent servir el mètode de la classe TCP pertinent.
     - actualitza la posició del vector de TCPs.
     Retorn: cap
     */
    public void afegirTCP() {
        TCP tripu=TCP.nouTCP();
        if (seleccionarComponent(2, tripu.getPassaport()) != -1) {
            System.out.println("\n Aquest tripulant ja existeix");
        } else {
        components[posicioComponents] = tripu;
        posicioComponents++;
        }
    }

    
    /*
     VOL
     */
 /*
     Paràmetres: cap
     Accions:
     - afegeix un nou vol al vector de vols de l'objecte actual (el que cridarà 
     al mètode), fent servir el mètode de la classe Vol pertinent.
     - actualitza la posició del vector de vols.
     Retorn: cap
     */
    public void afegirVol() throws ParseException {
        Vol vol=Vol.nouVol();
        if (seleccionarComponent(2, vol.getCodi()) != -1) {
            System.out.println("\n Aquest vol ja existeix");
        } else {
        components[posicioComponents] = vol;
        posicioComponents++;
        }
    }

   

    /*
     Paràmetres: cap
     Accions:
     - afegeix l'avió seleccionat de la companyia al vol seleccionat, si el vol i l'avió 
     existeixen en la companyia.
     - heu de fer servir els mètodes escaients d'aquesta classe per seleccionar els 
     avió i vol, i el mètode escaient de la classe Vol per afegir l'avió al vol seleccionat.
     - Si el vol no existeix, no s'afegirà cap avió i li mostrarem a l'usuari
     el missatge "\nNo existeix aquest vol". En cas que no existeixi l'avió
     li mostrarem el missatge "\nNo existeix aquest avió"
     Retorn: cap
     */
    public void afegirAvioVol() {
        Vol volSel;
        int pos = seleccionarVol();

        if (pos >= 0) {

            volSel = getVols()[pos];

            pos = seleccionarAvio();

            if (pos >= 0) {
                volSel.setAvio(getAvions()[pos]);
            } else {
                System.out.println("\nNo existeix aquest avió");
            }

        } else {
            System.out.println("\nNo existeix aquest vol");
        }
    }

    /*
     Paràmetres: cap
     Accions:
     - afegeix el tripulant de cabina seleccionat de la companyia al vector de
     tripulació de cabina del vol seleccionat, si el vol i el tripulant de cabina
     existeixen en la companyia.
     - heu de fer servir els mètodes escaients d'aquesta classe per seleccionar el 
     tripulant de cabina i vol, i el mètode escaient de la classe Vol per afegir 
     el tripulant de cabina al vol seleccionat.
     - Si el vol no existeix, no s'afegirà cap tripulant de cabina i li mostrarem a l'usuari
     el missatge "\nNo existeix aquest vol". En cas que no existeixi el tripulant de cabina
     li mostrarem el missatge "\nNo existeix aquest tripulant de cabina"
     Retorn: cap
     */
    public void afegirTripulantCabinaVol() {
        Vol volSel;
        int pos = seleccionarVol();

        if (pos >= 0) {

            volSel = getVols()[pos];

            pos = seleccionarTripulantCabina();

            if (pos >= 0) {
                volSel.afegirTripulantCabina(getTripulantsCabina()[pos]);
            } else {
                System.out.println("\nNo existeix aquest tripulant de cabina");
            }

        } else {
            System.out.println("\nNo existeix aquest vol");
        }
    }

    /*
     Paràmetres: cap
     Accions:
     - afegeix el TCP seleccionat de la companyia al vector de TCPs del vol seleccionat, 
     si el vol i el TCP existeixen en la companyia.
     - heu de fer servir els mètodes escaients d'aquesta classe per seleccionar el 
     TCP i vol, i el mètode escaient de la classe Vol per afegir el TCP al vol seleccionat.
     - Si el vol no existeix, no s'afegirà cap TCP i li mostrarem a l'usuari
     el missatge "\nNo existeix aquest vol". En cas que no existeixi el TCP
     li mostrarem el missatge "\nNo existeix aquest tripulant de cabina de passatgers"
     Retorn: cap
     */
    public void afegirTCPVol() {
        Vol volSel;
        int pos = seleccionarVol();

        if (pos >= 0) {

            volSel = getVols()[pos];

            pos = seleccionarTCP();

            if (pos >= 0) {
                volSel.afegirTCP(getTcps()[pos]);
            } else {
                System.out.println("\nNo existeix aquest tripulant de cabina de passatgers");
            }

        } else {
            System.out.println("\nNo existeix aquest vol");
        }
    }

    /*
     Paràmetres: cap
     Accions:
     - Afegeix la ruta seleccionada de la companyia al vol seleccionat, si el vol 
     i la ruta existeixen en la companyia, i actualitza el tipus de ruta del vol
     amb el tipus de la ruta afegida.    
     - Heu de tenir en compte que la ruta a seleccionar ha de ser del tipus passat
     per paràmetre, és a dir, tipus 1 és ruta nacional, tipus 2 és ruta internacional,
     tipus 3 és ruta intercontinental i tipus 4 és ruta transoceànica.
     - Heu de fer servir els mètodes escaients d'aquesta classe per seleccionar 
     la ruta i el vol, i el mètode escaient de la classe Vol per afegir la ruta
     al vol seleccionat i actualitzar el tipus de ruta.
     - Si el vol no existeix, no s'afegirà cap ruta i li mostrarem a l'usuari
     el missatge "\nNo existeix aquest vol". En cas que no existeixi la ruta
     li mostrarem el missatge "\nNo existeix aquesta ruta"    
     Retorn: cap
     */
    public void afegirRutaVol(int tipus) {
        Vol volSel;
        int pos = seleccionarVol();

        if (pos >= 0) {

            volSel = getVols()[pos];

            switch (tipus) {
                case 1:
                    pos = seleccionarRutaNacional();
                    if (pos >= 0) {
                        volSel.setRuta(getRutesNacionals()[pos]);
                    }
                    break;
                case 2:
                    pos = seleccionarRutaInternacional();
                    if (pos >= 0) {
                        volSel.setRuta(getRutesInternacionals()[pos]);
                    }
                    break;
                case 3:
                    pos = seleccionarRutaIntercontinental();
                    if (pos >= 0) {
                        volSel.setRuta(getRutesIntercontinentals()[pos]);
                    }
                    break;
                default:
                    pos = seleccionarRutaTransoceanica();
                    if (pos >= 0) {
                        volSel.setRuta(getRutesTransoceaniques()[pos]);
                    }
                    break;
            }

            if (pos < 0) {
                System.out.println("\nNo existeix aquesta ruta");
            } else {
                volSel.setTipusRuta(tipus);
            }

        } else {
            System.out.println("\nNo existeix aquest vol");
        }
    }

    public int seleccionarComponent(int tipus, String id) {

        boolean trobat = false;
        int pos = -1;

        switch (tipus) {
            case 1:

                if (id == null) {
                    id = (String) demanarDades("\nQuin és el codi del Avio?", 2);
                }
                for (int i = 0; i < posicioComponents && !trobat; i++) {

                    if (components[i] instanceof Avio) {
                        Avio avio = (Avio) components[i];
                        if (avio.getCodi().equals(id)) {
                            pos = i;
                            trobat = true;
                        }
                    }
                }

                break;
            case 2:

                if (id == null) {
                    id = (String) demanarDades("\nQuin és el codi de la ruta?", 2);
                }
                for (int i = 0; i < posicioComponents && !trobat; i++) {

                    if (components[i] instanceof Ruta) {
                        Ruta ruta = (Ruta) components[i];
                        if (ruta.getCodi().equals(id)) {
                            pos = i;
                            trobat = true;
                        }
                    }
                }

                break;
            case 3:
                if (id == null) {
                    id = (String) demanarDades("\nQuin és el codi del Tripulant?", 2);
                }
                for (int i = 0; i < posicioComponents && !trobat; i++) {

                    if (components[i] instanceof Tripulant) {
                        Tripulant tripu = (Tripulant) components[i];
                        if (tripu.getPassaport().equals(id)) {
                            pos = i;
                            trobat = true;
                        }
                    }
                }
                break;

            case 4:
                if (id == null) {
                    id = (String) demanarDades("\nQuin és el codi del Vol?", 2);
                }
                for (int i = 0; i < posicioComponents && !trobat; i++) {

                    if (components[i] instanceof Vol) {
                        Vol vol = (Vol) components[i];
                        if (vol.getCodi().equals(id)) {
                            pos = i;
                            trobat = true;
                        }
                    }
                }
                break;

            default:

                break;
        }

        return pos;
    }

}
