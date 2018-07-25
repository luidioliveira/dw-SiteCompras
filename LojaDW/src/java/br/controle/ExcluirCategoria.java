/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Categoria;
import br.DAO.Categoria_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ExcluirCategoria", urlPatterns = {"/ExcluirCategoria"})
public class ExcluirCategoria extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Categoria categoria;
        Categoria_DAO categoria_dao = new Categoria_DAO();
        try {
            categoria = categoria_dao.get(id);
            request.setAttribute("categoria", categoria);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Categoria_Excluir.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Categoria categoria = new Categoria(id);
        try {
                Categoria_DAO categoria_dao = new Categoria_DAO();
                try {
                    categoria_dao.Excluir(categoria);
                    request.setAttribute("mensagem", "Exclusão Com Sucesso");
                    request.setAttribute("retornacategoria", "ListaCategoria");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta_Categoria.jsp");
                    rd.forward(request, response);
                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }

    }
}
