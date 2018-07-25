/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Compra;
import br.DAO.Compra_DAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EditarCompra", urlPatterns = {"/EditarCompra"})
public class EditarCompra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Compra compra;
        Compra_DAO compra_dao = new Compra_DAO();
        try {
            compra = compra_dao.get(id);
            request.setAttribute("compra", compra);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Compra_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idcliente = Integer.parseInt(request.getParameter("idcliente"));
        int idproduto = Integer.parseInt(request.getParameter("idproduto"));
        int id = Integer.parseInt(request.getParameter("id"));

        Compra compra = new Compra( id, idcliente, idproduto);
        try {
            if ((idcliente==0)||(idproduto==0) )// verifica os dados
            {  // retorna para o formulario de contato

                if (idcliente == 0) {
                    request.setAttribute("erro_idcliente", "O ID cliente não pode ser zero");
                }

                if (idproduto == 0) {
                    request.setAttribute("erro_idproduto", "O ID produto não pode ser zero");
                }


                request.setAttribute("compra", compra);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Compra_Editar.jsp");
                rd.forward(request, response);
            } else {

                Compra_DAO compra_dao = new Compra_DAO();
                try {
                    compra_dao.Alterar(compra);
                    request.setAttribute("mensagem", "Alterado Com Sucesso");
                    request.setAttribute("retorna", "ListaCompra");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta_Compra.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_idcliente", "O ID cliente não pode ser zero");
            request.setAttribute("erro_idproduto", "O ID produto não pode ser zero");
            RequestDispatcher rd = request.getRequestDispatcher("Form_Compra.jsp");
            rd.forward(request, response);
        }

    }

}
