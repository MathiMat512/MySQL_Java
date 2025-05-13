package com.inventario.controllers;

import com.inventario.dao.ActividadDAO;
import com.inventario.models.Actividad;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/actividades")
public class ActividadController extends HttpServlet{
    
    private static final long serialVersionUID = 1L;
    private ActividadDAO actividadDAO;
    
    @Override
    public void init() throws ServletException {
        actividadDAO = new ActividadDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        List<Actividad> listarActividades = actividadDAO.listarActividades();
        request.setAttribute("actividades", listarActividades);
        
        request.getRequestDispatcher("actividades.jsp").forward(request, response);
    }
}
