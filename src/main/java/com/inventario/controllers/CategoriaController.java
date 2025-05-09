package com.inventario.controllers;

import com.inventario.dao.CategoriaDAO;
import com.inventario.models.Categoria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/categorias")
public class CategoriaController extends HttpServlet{
    
    private static final long serialVersionUID = 1L;
    private CategoriaDAO categoriaDAO;
    
    @Override
    public void init() throws ServletException {
        categoriaDAO = new CategoriaDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        List<Categoria> listarCategorias = categoriaDAO.listarCategorias();
        request.setAttribute("categorias", listarCategorias);
        
        request.getRequestDispatcher("categorias.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String accion = request.getParameter("accion");
        
        String id_categoria = request.getParameter("id_categoria");
        String descripcion_categoria = request.getParameter("descripcion_categoria");
        Categoria categoria = new Categoria(descripcion_categoria);
        
        switch (accion) {
            case "crear":{
                categoriaDAO.guardarCategoria(categoria);
                break;
            }
            case "editar":{
                categoria.setId_categoria(Integer.valueOf(id_categoria));
                categoriaDAO.editarCategoria(categoria);
                break;
            }
            case "eliminar":{
                categoria.setId_categoria(Integer.valueOf(id_categoria));
                categoriaDAO.eliminarCategoria(categoria);
                break;
            }
        }
        response.sendRedirect("categorias");
    }
}
