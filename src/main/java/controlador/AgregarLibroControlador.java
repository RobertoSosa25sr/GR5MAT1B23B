package controlador;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import modelo.Libro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AgregarLibroController", value = "/agregarLibro-controller")
public class AgregarLibroControlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String titulo = req.getParameter("titulo");
        String autor = req.getParameter("autor");
        String genero = req.getParameter("genero");
        String isbn = req.getParameter("isbn");
        boolean disponible = req.getParameter("disponible") != null;

        // Crear un nuevo libro con los datos del formulario
        Libro nuevoLibro = new Libro(titulo, autor, genero, isbn, disponible);

        // Obtener la lista actual de libros de la sesión
        List<Libro> listaLibros = (List<Libro>) req.getSession().getAttribute("listaLibros");

        // Agregar el nuevo libro a la lista
        if (listaLibros == null) {
            listaLibros = new ArrayList<>();
        }
        listaLibros.add(nuevoLibro);

        // Actualizar la lista de libros en la sesión
        req.getSession().setAttribute("listaLibros", listaLibros);

        // Redirigir a la vista del bibliotecario
        resp.sendRedirect("/Views/bibliotecarioVista.jsp");
    }
}
