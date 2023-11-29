import modelo.CatalogoLibros;
import modelo.Libro;

import java.util.List;

public class Main {

    public static void main(String [] ars){

        CatalogoLibros catalogo = new CatalogoLibros();
        List<Libro> libros = catalogo.getListaLibros();
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

}
