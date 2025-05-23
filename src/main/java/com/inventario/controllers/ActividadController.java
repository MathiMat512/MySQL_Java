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
public class ActividadController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ActividadDAO actividadDAO;

    @Override
    public void init() throws ServletException {
        actividadDAO = new ActividadDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int limite = 10; // Valor por defecto
        int pagina = 1;  // Página por defecto

        try {
            limite = Integer.parseInt(request.getParameter("limite"));
        } catch (NumberFormatException e) {
        }

        try {
            pagina = Integer.parseInt(request.getParameter("pagina"));
        } catch (NumberFormatException e) {
        }

        int totalActividades = actividadDAO.totalActividades();
        int totalPaginas = (int) Math.ceil((double) totalActividades / limite);

        List<Actividad> listarActividades = actividadDAO.listarActividadesPaginadas(limite, pagina);

        request.setAttribute("actividades", listarActividades);
        request.setAttribute("totalActividades", totalActividades);
        request.setAttribute("totalPaginas", totalPaginas);
        request.setAttribute("paginaActual", pagina);
        request.setAttribute("limiteActual", limite);

        request.getRequestDispatcher("actividades.jsp").forward(request, response);
    }

}
