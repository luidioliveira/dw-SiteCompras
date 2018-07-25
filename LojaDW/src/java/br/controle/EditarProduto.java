/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Produto;
import br.DAO.Produto_DAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EditarProduto", urlPatterns = {"/Editar_Produto"})
public class EditarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Produto produto;
        Produto_DAO produto_dao = new Produto_DAO();
        try {
            produto = produto_dao.get(id);
            request.setAttribute("produto", produto);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Produto_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idcategoria = Integer.parseInt(request.getParameter("idcategoria"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        Double valor = Double.parseDouble(request.getParameter("valor"));
        int id = Integer.parseInt(request.getParameter("id"));

        Produto produto = new Produto( id, idcategoria, nome, descricao, valor);
        try {
            if ((nome.isEmpty())||(descricao.isEmpty()) )// verifica os dados
            {  // retorna para o formulario de contato

                if (nome.isEmpty()) {
                    request.setAttribute("erro_nome", "O nome não pode ser vazio");
                }

                if (descricao.isEmpty()) {
                    request.setAttribute("erro_descricao", "A descrição não pode ser vazia");
                }


                request.setAttribute("produto", produto);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Produto_Editar.jsp");
                rd.forward(request, response);
            } else {

                Produto_DAO produto_dao = new Produto_DAO();
                try {
                    produto_dao.Alterar(produto);
                    request.setAttribute("mensagem", "Alterado Com Sucesso");
                    request.setAttribute("retorna", "ListaProduto");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta_Produto.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_nome", "O nome não pode ser vazio");
            request.setAttribute("erro_descricao", "A descrição não pode ser vazia");
            RequestDispatcher rd = request.getRequestDispatcher("Form_Produto.jsp");
            rd.forward(request, response);
        }

    }

}
