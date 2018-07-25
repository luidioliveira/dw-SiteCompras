/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Compra;
import br.DAO.Compra_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaCompra", urlPatterns = {"/ListaCompra"})
public class ListaCompra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Compra_DAO compra_dao = new Compra_DAO();
        ArrayList<Compra> minhasCompras= compra_dao.Listar();
        request.setAttribute("minhasCompras", minhasCompras);
        RequestDispatcher rd = request.getRequestDispatcher("ListaCompraView.jsp");
        rd.forward(request, response);

    }

}
