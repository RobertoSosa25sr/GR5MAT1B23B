package controlador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Libro;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditarLibroController", value = "/editarLibro-controller")
public class EditarLibroControlador extends  HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titulo = req.getParameter("titulo");
        String autor = req.getParameter("autor");
        String genero = req.getParameter("genero");
        String isbn = req.getParameter("isbn");
        boolean disponible = req.getParameter("disponible") != null;

        // Obtener la lista actual de libros de la sesión
        List<Libro> listaLibros = (List<Libro>) req.getSession().getAttribute("listaLibros");

        // Buscar el libro por ISBN y actualizar los datos
        if (listaLibros != null && !listaLibros.isEmpty()) {
            for (Libro libro : listaLibros) {
                if (libro.getIsbn().equals(isbn)) {
                    libro.setTitulo(titulo);
                    libro.setAutor(autor);
                    libro.setGenero(genero);
                    libro.setDisponible(disponible);
                    break;
                }
            }
        }


        // Actualizar la lista de libros en la sesión
        req.getSession().setAttribute("listaLibros", listaLibros);

        // Redirigir a la vista del bibliotecario
        resp.sendRedirect("/Views/bibliotecarioVista.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String isbn = req.getParameter("isbn");
        // Establecer la variable de sesión isbnEditar
        req.getSession().setAttribute("isbnEditar", isbn);

        // Redirigir a la vista de edición
        resp.sendRedirect("/Views/editarLibroVista.jsp");

    }
}
