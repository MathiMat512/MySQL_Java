package com.inventario.controllers;

import com.inventario.dao.UsuarioDAO;
import com.inventario.models.Rol;
import com.inventario.models.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/usuarios")
public class UsuarioController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> listarUsuarios = usuarioDAO.listarUsuarios();
        request.setAttribute("usuarios", listarUsuarios);

        int totalUsuarios = usuarioDAO.totalUsuarios();
        request.setAttribute("Usuarios_totales", totalUsuarios);

        List<Rol> listarRoles = usuarioDAO.listarRoles();
        request.setAttribute("roles", listarRoles);

        request.getRequestDispatcher("usuarios.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");

        String id_user = request.getParameter("id_user");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        Integer id_rol = parseIntegerOrDefault(request.getParameter("id_rol"), null);
        
        Usuario usuario = new Usuario(username,password,nombre,apellido,id_rol);
    }
    
    private Date parseDateOrDefault(String value, Date defaultValue) {
        try {
            return (value != null && !value.trim().isEmpty()) ? Date.valueOf(value) : defaultValue;
        } catch (IllegalArgumentException e) {
            return defaultValue;
        }
    }

    private Integer parseIntegerOrDefault(String param, Integer defaultValue) {
        if (param != null && !param.trim().isEmpty()) {
            try {
                return Integer.valueOf(param);
            } catch (NumberFormatException e) {
                // Puedes agregar un log aquí si es necesario
                return defaultValue;  // Devuelve el valor predeterminado si no se puede convertir
            }
        }
        return defaultValue;  // Devuelve el valor predeterminado si el parámetro es null o vacío
    }
}
