package controlador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Libro;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EliminarLibroController", value = "/eliminarLibro-controller")
public class EliminarLibroControlador extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String isbn = req.getParameter("isbn");

        // Obtener la lista actual de libros de la sesión
        List<Libro> listaLibros = (List<Libro>) req.getSession().getAttribute("listaLibros");

        // Eliminar el libro por ISBN
        if (listaLibros != null && !listaLibros.isEmpty()) {
            for (Libro libro : listaLibros) {
                if (libro.getIsbn().equals(isbn)) {
                    listaLibros.remove(libro);
                    break;
                }
            }
        }

        // Actualizar la lista de libros en la sesión
        req.getSession().setAttribute("listaLibros", listaLibros);

        // Redirigir a la vista del bibliotecario
        resp.sendRedirect("/Views/bibliotecarioVista.jsp");
    }

}
