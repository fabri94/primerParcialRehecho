
package parcialrehecho;

import Entidades.Artista;
import Entidades.Escultura;
import Entidades.MaterialEscultura;
import Entidades.Museo;
import Entidades.Pintura;
import Entidades.TecnicaPintura;

/**
 *
 * @author Fabri
 */
public class ParcialRehecho {

    public static void main(String[] args) {
        Museo miMuseo = new Museo(5);
        Artista a = new Artista("Gian Lorenzo", "Bernini");
        Artista b = new Artista("Vincent", "Van Gogh");
        Pintura p1 = new Pintura("Loneliness of Autumn", 5990, "Leonid", "Afremov", TecnicaPintura.OLEO);
        Escultura e1 = new Escultura("El Angel", 6300.5, a, MaterialEscultura.MARMOL);
        Pintura p2 = new Pintura("Diego y yo", 299.50, "Frida", "Kahlo", TecnicaPintura.ACRILICO);
        Escultura e2 = new Escultura("Medusa", 205, a, MaterialEscultura.BRONCE);
        Escultura e3 = new Escultura("David", 98, a, MaterialEscultura.MARMOL);
        Pintura p3 = new Pintura("La Noche", 7050, "Miguel","Angel", TecnicaPintura.OLEO);
        miMuseo.agregar(p1);
        // YA INGRESADA
        miMuseo.agregar(p1);
        miMuseo.agregar(e1);
        miMuseo.agregar(p2);
        miMuseo.agregar(e2);
        miMuseo.agregar(e3);
        // SIN LUGAR
        miMuseo.agregar(p3);
        System.out.println("");
        // TRUE
        System.out.println(p1.equals(p1));
        // FALSE
        System.out.println(p1.equals("Leonid Afremov"));
        // FALSE
        System.out.println(p1.equals(p2));
        // TRUE
        System.out.println(e1.equals(e1));
        // FALSE
        System.out.println(e1.equals(e2));
        // FALSE
        System.out.println(e1.equals(p3));
        //8146.4
        //9884.75
        System.out.println("");
        miMuseo.ordenar();
        System.out.println(Museo.mostrar(miMuseo));
    }
    
}
