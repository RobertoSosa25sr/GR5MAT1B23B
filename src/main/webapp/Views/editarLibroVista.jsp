<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Libro" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<html>
<head>
    <title>Editar Libro</title>
    <!-- Agregar la referencia a Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            padding: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="mt-3">Editar Libro</h2>

    <%

        String isbnEditar = (String) session.getAttribute("isbnEditar");
        List<Libro> listaLibros = (List<Libro>) session.getAttribute("listaLibros");
        System.out.println(isbnEditar);
        // Buscar el libro por ISBN
        Libro libroEditar = null;
        if (listaLibros != null && !listaLibros.isEmpty()) {
            for (Libro libro : listaLibros) {

                if (libro.getIsbn().equals(isbnEditar)) {
                    libroEditar = libro;
                    break;
                }
            }
        }
    %>

    <form action="/editarLibro-controller" method="post">
        <div class="form-group">
            <label for="titulo">Título:</label>
            <input type="text" class="form-control" id="titulo" name="titulo" value="<%= libroEditar.getTitulo() %>" required>
        </div>
        <div class="form-group">
            <label for="autor">Autor:</label>
            <input type="text" class="form-control" id="autor" name="autor" value="<%= libroEditar.getAutor() %>" required>
        </div>
        <div class="form-group">
            <label for="genero">Género:</label>
            <input type="text" class="form-control" id="genero" name="genero" value="<%= libroEditar.getGenero() %>" required>
        </div>
        <div class="form-group">
            <label for="isbn">ISBN:</label>
            <input type="text" class="form-control" id="isbn" name="isbn" value="<%= libroEditar.getIsbn() %>" readonly>
        </div>
        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="disponible" name="disponible" <%= libroEditar.isDisponible() ? "checked" : "" %>>
            <label class="form-check-label" for="disponible">Disponible</label>
        </div>
        <button type="submit" class="btn btn-primary mt-3">Guardar Cambios</button>
    </form>

</div>

<!-- Agregar la referencia a Bootstrap JS y jQuery (opcional, pero necesario para algunos componentes de Bootstrap) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
