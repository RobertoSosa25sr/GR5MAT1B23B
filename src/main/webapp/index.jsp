<!-- index.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Inicio de Sesión</title>
  <!-- Agregar la referencia a Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
  <div class="col-md-6 offset-md-3">
    <h2 class="text-center">Inicio de Sesión</h2>

    <form action="LoginController" method="post">
      <div class="form-group">
        <label for="usuario">Usuario:</label>
        <input type="text" class="form-control" id="usuario" name="usuario" required>
      </div>

      <div class="form-group">
        <label for="contrasena">Contraseña:</label>
        <input type="password" class="form-control" id="contrasena" name="contrasena" required>
      </div>

      <button type="submit" class="btn btn-primary btn-block">Login</button>
    </form>
  </div>
</div>

<!-- Agregar la referencia a Bootstrap JS y jQuery (opcional, pero necesario para algunos componentes de Bootstrap) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
