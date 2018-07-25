/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Administrador;
import br.DAO.Administrador_DAO;
import br.DAO.Contato;
import br.DAO.Contato_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        String login = (String) request.getParameter("login");
        String senha = request.getParameter("senha");
        try {
            Administrador_DAO aDao = new Administrador_DAO();
            Administrador adm = aDao.get(login);
            if(adm!= null){
                if (senha.equals(adm.getSenha())){
                    RequestDispatcher rd = request.getRequestDispatcher("AreaRestrita.html");
                    rd.forward(request, response);
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }
                
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                rd.forward(request, response);
            }
                   
        } catch (Exception e) {
//            request.setAttribute("erro_nome", "O nome não pode ser vazio");
//            request.setAttribute("erro_idade", "A idade não pode ser menor que 18");
//            RequestDispatcher rd = request.getRequestDispatcher("Form_Contato.jsp");
//            rd.forward(request, response);
        }

    }

}
