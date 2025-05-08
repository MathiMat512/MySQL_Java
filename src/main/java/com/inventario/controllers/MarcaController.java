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
}
