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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IncluirCompra", urlPatterns = {"/IncluirCompra"})
public class IncluirCompra extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        int idcliente = Integer.parseInt(request.getParameter("idcliente"));
        try {
            int idproduto = Integer.parseInt(request.getParameter("idproduto"));
            request.setAttribute("erro_idcliente", "");

            if ((idcliente==0)||(idproduto==0)) // verifica os dados
            {  // retorna para o formulario de contato

                if (idcliente==0) {
                    request.setAttribute("erro_idcliente", "O ID cliente não pode ser vazio");
                }

                if (idproduto==0) {
                    request.setAttribute("erro_idproduto", "O ID produto não pode ser vazio");
                }
                
                RequestDispatcher rd = request.getRequestDispatcher("Form_Compra.jsp");
                rd.forward(request, response);
            } else {

                Compra compra = new Compra(idcliente, idproduto );
                Compra_DAO compra_dao = new Compra_DAO();
                try {
                    compra_dao.Inserir(compra);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
                    request.setAttribute("retorna", "ListaCompra");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta_Compra.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_idcliente", "O ID cliente não pode ser vazio");
            request.setAttribute("erro_idproduto", "O ID produto não pode ser vazio");
            RequestDispatcher rd = request.getRequestDispatcher("Form_Compra.jsp");
            rd.forward(request, response);
        }

    }

}
