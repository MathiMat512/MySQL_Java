package com.inventario.controllers;

import com.inventario.dao.AreaDAO;
import com.inventario.models.Area;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/areas")
public class AreaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AreaDAO areaDAO;

    @Override
    public void init() throws ServletException {
        areaDAO = new AreaDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Area> listarAreas = areaDAO.listarAreas();
        request.setAttribute("areas", listarAreas);
        
        request.getRequestDispatcher("areas.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String accion = request.getParameter("accion");
        
        String id_area = request.getParameter("id_area");
        String descripcion_area = request.getParameter("descripcion_area");
        Area area = new Area(descripcion_area);
     
        switch (accion) {
            case "crear":{
                areaDAO.crearArea(area);
                break;
            }
            case "editar":{
                area.setId_area(Integer.valueOf(id_area));
                areaDAO.editarArea(area);
                break;
            }
            case "eliminar":{
                area.setId_area(Integer.valueOf(id_area));
                areaDAO.eliminarArea(area);
                break;
            }
        }
        response.sendRedirect("areas");
    }
}
