package com.inventario.controllers;

import com.inventario.dao.LoginDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LoginDAO loginDAO;

    @Override
    public void init() throws ServletException {
        loginDAO = new LoginDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("opcionPost");
        switch (opcion) {
            case "validarUsuario": {
                try {
                    validarUsuario(request, response);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
            break;

        }
    }

    private void validarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (loginDAO.validarUsuario(username, password)) {
            response.sendRedirect("productos");
        } else {
            request.setAttribute("mensaje", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
