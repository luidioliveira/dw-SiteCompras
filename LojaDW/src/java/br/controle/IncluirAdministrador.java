/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Administrador;
import br.DAO.Administrador_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IncluirAdministrador", urlPatterns = {"/IncluirAdministrador"})
public class IncluirAdministrador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        String login = request.getParameter("login");
        try {
            String senha = request.getParameter("senha");
            request.setAttribute("erro_login", "");

            if ((login.isEmpty())||(senha.isEmpty())) // verifica os dados
            {  // retorna para o formulario de contato

                if (login.isEmpty()) {
                    request.setAttribute("erro_login", "O login não pode ser vazio");
                }

                if (senha.isEmpty()) {
                    request.setAttribute("erro_senha", "A senha não pode ser vazia");
                }
                
                RequestDispatcher rd = request.getRequestDispatcher("Form_Administrador.jsp");
                rd.forward(request, response);
            } else {

                Administrador administrador = new Administrador(login, senha );
                Administrador_DAO administrador_dao = new Administrador_DAO();
                try {
                    administrador_dao.Inserir(administrador);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
                    request.setAttribute("retorna", "ListaAdministrador");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta_Administrador.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_login", "O login não pode ser vazio");
            request.setAttribute("erro_senha", "A senha não pode ser vazia");
            RequestDispatcher rd = request.getRequestDispatcher("Form_Administrador.jsp");
            rd.forward(request, response);
        }

    }

}
