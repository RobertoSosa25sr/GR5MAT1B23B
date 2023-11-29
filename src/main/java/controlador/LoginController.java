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

        // Obtener los parámetros del formulario
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        // Verificar si el usuario y la contraseña son iguales
        if (usuario.equals(contrasena)) {
            // Dependiendo del tipo de usuario, redireccionar a la vista correspondiente
            if (esUsuario(usuario)) {
                response.sendRedirect("usuarioVista.jsp");
            } else if (esBibliotecario(usuario)) {
                response.sendRedirect("bibliotecarioVista.jsp");
            } else {
                // Manejar el caso en el que el usuario no sea ni usuario ni bibliotecario
                response.getWriter().println("Usuario no válido");
            }
        } else {
            // Manejar el caso en el que el usuario y la contraseña no coincidan
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

