package controlador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        //TODO Método de verificación
        if (usuario.equals(contrasena)) {

            if (esUsuario(usuario)) {
                response.sendRedirect("usuarioVista.jsp");
            } else if (esBibliotecario(usuario)) {
                response.sendRedirect("bibliotecarioVista.jsp");
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

