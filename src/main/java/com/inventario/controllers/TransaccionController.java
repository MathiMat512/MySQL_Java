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
    public void init() throws ServletException{
        transaccionDAO = new TransaccionDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Transaccion> listarTransacciones = transaccionDAO.listarTransacciones();
        request.setAttribute("transacciones", listarTransacciones);
        
        request.getRequestDispatcher("transacciones.jsp").forward(request, response);
    }
}
