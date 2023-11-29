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

