package controlador;

import jakarta.servlet.annotation.WebServlet;

import java.io.*;
import jakarta.servlet.http.*;


@WebServlet(name = "LoginController", value = "/login-controller")
public class LoginController extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        //TODO Método de verificación
        if (usuario.equals(contrasena)) {

            if (esUsuario(usuario)) {
                response.sendRedirect("Views/usuarioVista.jsp");
            } else if (esBibliotecario(usuario)) {
                response.sendRedirect("Views/bibliotecarioVista.jsp");
            } else {

                response.getWriter().println("Usuario no válido");
            }
        } else {

            response.getWriter().println("Credenciales incorrectas");
        }
    }

    private boolean esUsuario(String usuario) {
        // Implementar lógica para verificar si el usuario es un usuario normal
        // Devolver true si es un usuario, false de lo contrario
        return true; // Cambiar según tus requisitos
    }

    private boolean esBibliotecario(String usuario) {
        // Implementar lógica para verificar si el usuario es un bibliotecario
        // Devolver true si es un bibliotecario, false de lo contrario
        return false; // Cambiar según tus requisitos
    }
}

