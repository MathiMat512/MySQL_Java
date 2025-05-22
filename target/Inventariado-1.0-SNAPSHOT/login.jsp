<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <link href="styles.css" rel="stylesheet">
    </head>
    <body class="bg-light d-flex justify-content-center align-items-center vh-100">
        <div class="card shadow-lg p-4" style="width: 100%; max-width: 400px;">
            <div class="text-center mb-4">
                <i class="bi bi-person-circle" style="font-size: 4rem; color: #0d6efd;"></i>
                <h3 class="mt-2 text-primary">Iniciar Sesión</h3>
            </div>
            <form method="POST" action="login">
                <input type="hidden" name="opcionPost" value="validarUsuario">
                <div class="mb-3">
                    <label for="email" class="form-label">Nombre de usuario</label>
                    <input type="text" class="form-control" name="username" id="email" placeholder="Ingrese su correo" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Contraseña</label>
                    <input type="password" class="form-control" name="password" id="password" placeholder="Ingrese su contraseña" required>
                </div>
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Entrar</button>
                </div>
            </form>
                        <%
                            String mensaje = (String) request.getAttribute("mensaje");
                            if (mensaje != null) {
                        %>
                            <div class="alert alert-danger mt-3 text-center">
                                <%= mensaje %>
                            </div>
                        <%
                            }
                        %>
        </div>
    </body>

</html>
