<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Libro" %>
<html>
<head>
    <title>Bibliotecario</title>
    <!-- Agregar la referencia a Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            padding: 20px;
        }

        .exit-button {
            position: fixed;
            top: 10px;
            right: 10px;
        }

        .recibo {
            margin-top: 50px;
            border: 1px solid #ccc;
            padding: 20px;
            background-color: #f9f9f9;
        }

        .recibo h3 {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="mt-3">Catálogo de Libros</h2>

    <%
        List<Libro> listaLibros = (List<Libro>) session.getAttribute("listaLibros");
        List<Libro> listaLibrosAlquilados = (List<Libro>) session.getAttribute("listaLibrosUsuario");

        if (listaLibros != null && !listaLibros.isEmpty()) { %>
    <table class="table mt-3">
        <thead>
        <tr>
            <th>Título</th>
            <th>Autor</th>
            <th>Género</th>
            <th>ISBN</th>
            <th>Disponible</th>
        </tr>
        </thead>
        <tbody>
        <% for (Libro libro : listaLibros) { %>
        <tr>
            <td><%= libro.getTitulo() %></td>
            <td><%= libro.getAutor() %></td>
            <td><%= libro.getGenero() %></td>
            <td><%= libro.getIsbn() %></td>
            <td><%= libro.isDisponible() ? "disponible" : "prestado" %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p class="mt-3">No se encontraron libros</p>
    <% } %>

    <div class="mt-3">
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#alquilarLibroModal">Alquilar</button>
    </div>
</div>

<!-- Modals para Alquilar -->
<div class="modal fade" id="alquilarLibroModal" tabindex="-1" role="dialog" aria-labelledby="alquilarLibroModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="alquilarLibroModalLabel">Alquilar Libro</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="/alquilarLibro-controller" method="post">
                    <div class="form-group">
                        <label for="isbnAlquilar">ISBN:</label>
                        <input type="text" class="form-control" id="isbnAlquilar" name="isbn" placeholder="Ingrese el ISBN" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Alquilar Libro</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Sección para mostrar la lista de libros alquilados como recibo -->
<div class="recibo">
    <h3>Recibos</h3>
    <%-- Obtener la lista de libros alquilados de la sesión --%>

        <% if (listaLibrosAlquilados != null && !listaLibrosAlquilados.isEmpty()) { %>
    <ul>
        <% for (Libro libroAlquiladoUsuario : listaLibrosAlquilados) { %>
        <li><%= libroAlquiladoUsuario.getTitulo() %> - <%= libroAlquiladoUsuario.getIsbn() %></li>
        <% } %>
    </ul>
        <% } else { %>
    <p>No existen recibos</p>
        <% } %>
</div>

<!-- Agregar la referencia a Bootstrap JS y jQuery (opcional, pero necesario para algunos componentes de Bootstrap) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<a href="/index.jsp" class="btn btn-primary exit-button">Salir</a>
</body>
</html>
