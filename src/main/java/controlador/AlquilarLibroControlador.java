package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Libro;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AlquilarLibroControlador", value = "/alquilarLibro-controller")
public class AlquilarLibroControlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String isbn = req.getParameter("isbn");

        // Obtener la lista actual de libros de la sesión
        List<Libro> listaLibros = (List<Libro>) req.getSession().getAttribute("listaLibros");

        // Buscar el libro por ISBN y actualizar la disponibilidad
        if (listaLibros != null && !listaLibros.isEmpty()) {
            for (Libro libro : listaLibros) {
                if (libro.getIsbn().equals(isbn)) {
                    libro.setDisponible(false);
                    break;
                }
            }
        }

        // Actualizar la lista de libros en la sesión
        req.getSession().setAttribute("listaLibros", listaLibros);
        resp.sendRedirect("/Views/usuarioVista.jsp");
    }
}
