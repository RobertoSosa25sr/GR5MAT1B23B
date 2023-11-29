package modelo;

public class Libro {

    private String titulo;
    private String autor;
    private String genero;
    private String isbn;
    private boolean disponibilidad;

    public Libro(String titulo, String autor, String genero, String isbn, boolean disponibilidad) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.isbn = isbn;
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\nAutor: " + autor + "\nGénero: " + genero + "\nISBN: " + isbn + "\nDisponibilidad: " + disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
