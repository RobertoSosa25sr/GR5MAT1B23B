package controlador;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import modelo.CatalogoLibros;
import modelo.Libro;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LibroController", value = "/libro-controller")
public class LibroController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // Obtener los parámetros del formulario para agregar libro
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String genero = request.getParameter("genero");
        String isbn = request.getParameter("isbn");
        boolean disponible = request.getParameter("disponible") != null;

        // Crear un nuevo libro con los parámetros proporcionados
        Libro nuevoLibro = new Libro(titulo, autor, genero, isbn, disponible);

        // Obtener el catálogo actual de libros
        CatalogoLibros catalogo = new CatalogoLibros();
        List<Libro> libros = catalogo.getListaLibros();

        // Agregar el nuevo libro al catálogo
        libros.add(nuevoLibro);

        // Redirigir de vuelta a la vista del bibliotecario
        response.sendRedirect("Views/bibliotecarioVista.jsp");
    }
}

