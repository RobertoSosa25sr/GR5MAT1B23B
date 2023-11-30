package modelo;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLibros {

    private List<Libro> listaLibros;

    public CatalogoLibros() {

        listaLibros = new ArrayList<>();
        listaLibros.add(new Libro("El Señor de los Anillos", "J.R.R. Tolkien", "Fantasía", "978-84-450-7425-0", true));
        listaLibros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", "Realismo mágico", "978-84-376-0494-7", true));
        listaLibros.add(new Libro("1984", "George Orwell", "Ciencia ficción", "978-84-376-0494-8", true));
        listaLibros.add(new Libro("To Kill a Mockingbird", "Harper Lee", "Ficción clásica", "978-84-376-0497-7", true));

    }

    public static void main(String[] args) {

        CatalogoLibros catalogo = new CatalogoLibros();
        List<Libro> libros = catalogo.getListaLibros();
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }
}
