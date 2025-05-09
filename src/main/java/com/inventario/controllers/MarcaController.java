package com.inventario.controllers;

import com.inventario.dao.MarcaDAO;
import com.inventario.models.Marca;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/marcas")
public class MarcaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private MarcaDAO marcaDAO;

    @Override
    public void init() throws ServletException {
        marcaDAO = new MarcaDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Marca> listarMarcas = marcaDAO.listarMarcas();
        request.setAttribute("marcas", listarMarcas);

        request.getRequestDispatcher("marcas.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        String id_marca = request.getParameter("id_marca");
        String descripcion_marca = request.getParameter("descripcion_marca");
        Marca marca = new Marca(descripcion_marca);

        switch (accion) {
            case "crear": {
                marcaDAO.crearMarca(marca);
                break;
            }
            case "editar": {
                marca.setId_marca(Integer.valueOf(id_marca));
                marcaDAO.editarMarca(marca);
                break;
            }
            case "eliminar": {
                marca.setId_marca(Integer.valueOf(id_marca));
                marcaDAO.eliminarMarca(marca);
                break;
            }
        }
        response.sendRedirect("marcas");
    }
}
