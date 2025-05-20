package com.inventario.controllers;

import com.inventario.dao.TransaccionDAO;
import com.inventario.models.Transaccion;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/transacciones")
public class TransaccionController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TransaccionDAO transaccionDAO;

    @Override
    public void init() throws ServletException {
        transaccionDAO = new TransaccionDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Valor por defecto
        int limite = 10;

        try {
            String limiteParam = request.getParameter("limite");
            if (limiteParam != null && !limiteParam.isEmpty()) {
                limite = Math.min(100, Math.max(1, Integer.parseInt(limiteParam)));
            }
        } catch (NumberFormatException e) {
            // Mantener valor por defecto
        }

        List<Transaccion> listarTransacciones = transaccionDAO.listarTransacciones(limite);
        request.setAttribute("transacciones", listarTransacciones);

        request.getRequestDispatcher("transacciones.jsp").forward(request, response);
    }
}
