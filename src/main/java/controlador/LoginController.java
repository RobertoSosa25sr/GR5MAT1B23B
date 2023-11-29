package controlador;

import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.*;
import modelo.CatalogoLibros;
import modelo.Libro;


@WebServlet(name = "LoginController", value = "/login-controller")
public class LoginController extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        HttpSession session = request.getSession();

        // Verificar si ya hay una sesión activa
        if (session.getAttribute("listaLibros") == null) {
            CatalogoLibros catalogoLibros = new CatalogoLibros();
            List<Libro> listaLibros = catalogoLibros.getListaLibros();

            List<Libro> listaLibrosUsuario = new ArrayList<>();

            session.setAttribute("listaLibros", listaLibros);
            session.setAttribute("listaLibrosUsuario", listaLibrosUsuario);
        }

        //TODO Método de verificación

        if (esUsuario(usuario)) {
            response.sendRedirect("Views/usuarioVista.jsp");
        } else if (esBibliotecario(usuario)) {
            response.sendRedirect("Views/bibliotecarioVista.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    private boolean esUsuario(String usuario) {
        return usuario.equals("usuario");
    }

    private boolean esBibliotecario(String usuario) {
        return usuario.equals("bibliotecario");
    }
}

