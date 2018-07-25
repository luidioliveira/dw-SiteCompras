/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Compra;
import br.DAO.Compra_DAO;
import br.DAO.Produto;
import br.DAO.Produto_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Carrinho", urlPatterns = {"/Carrinho"})
public class Carrinho extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
	{
        try 
		{
			//int idcliente = 1;/*Integer.parseInt(request.getParameter("idcliente"));*/
            //int idproduto = 3;/*Integer.parseInt(request.getParameter("idproduto"));*/

			//Compra compra = new Compra(idcliente, idproduto );
			//Compra_DAO compra_dao = new Compra_DAO();
			Produto_DAO produto_dao = new Produto_DAO();
			
			//compra_dao.Inserir(compra);
			
			/*ArrayList<Compra> minhasCompras = compra_dao.Listar();
			request.setAttribute("minhasCompras", minhasCompras);*/
			
			ArrayList<Produto> meusProdutos = produto_dao.ListarComprados();
			request.setAttribute("meusProdutos", meusProdutos);
			
			RequestDispatcher rd = request.getRequestDispatcher("ListaCompraViewPub.jsp");
			rd.forward(request, response);
        } 
		catch (Exception e) 
		{
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }

    }
}