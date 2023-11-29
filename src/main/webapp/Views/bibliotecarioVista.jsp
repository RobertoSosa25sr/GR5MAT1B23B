<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Libro" %>
<%@ page import="modelo.CatalogoLibros" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Bibliotecario</title>
</head>
<body>

<h2>Catálogo de Libros</h2>

<%-- Mostrar la lista actual de libros --%>
<table border="1">
    <tr>
        <th>Titulo</th>
        <th>Autor</th>
        <th>Género</th>
        <th>ISBN</th>
        <th>Disponible</th>
    </tr>
    <% CatalogoLibros catalogo = new CatalogoLibros();
        List<Libro> libros = catalogo.getListaLibros();
        for (Libro libro : libros) { %>
    <tr>
        <td><%= libro.getTitulo() %></td>
        <td><%= libro.getAutor() %></td>
        <td><%= libro.getGenero() %></td>
        <td><%= libro.getIsbn() %></td>
        <td><%= libro.isDisponible() ? "Sí" : "No" %></td>
    </tr>
    <% } %>
</table>

<%-- Formulario para agregar libro --%>
<h3>Agregar Libro</h3>
<form action="/libro-controller" method="post">
    <label for="titulo">Título:</label>
    <input type="text" id="titulo" name="titulo" required><br>
    <label for="autor">Autor:</label>
    <input type="text" id="autor" name="autor" required><br>
    <label for="genero">Género:</label>
    <input type="text" id = "genero" name="genero" required><br>
    <label for="isbn">ISBN:</label>
    <input type="text" id = "isbn" name="isbn" required><br>
    <label for="disponible">Disponible:</label>
    <input type="checkbox" id = "disponible" name="disponible"><br>
    <input type="submit" value="Agregar Libro">
</form>

<%-- Otros formularios para editar y eliminar libros --%>

</body>
</html>
