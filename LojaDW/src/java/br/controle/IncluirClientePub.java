/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Cliente;
import br.DAO.Cliente_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IncluirClientePub", urlPatterns = {"/IncluirClientePub"})
public class IncluirClientePub extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        String nome = request.getParameter("nome");
        try {
            String endereco = request.getParameter("endereco");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String cep = request.getParameter("cep");
            String estado = request.getParameter("uf");
            String referencia = request.getParameter("referencia");
            String cpf = request.getParameter("cpf");
            String ri = request.getParameter("ri");
            String telfixo = request.getParameter("telfixo");
            String celular = request.getParameter("celular");
            String cartaocred = request.getParameter("cartaocred");
            String bandeira = request.getParameter("bandeira");
            request.setAttribute("erro_nome", "");

            if ((nome.isEmpty())||(estado.isEmpty())||(bairro.isEmpty())||(cidade.isEmpty())||(cep.isEmpty())||(estado.isEmpty())||(referencia.isEmpty())||(cpf.isEmpty())||(ri.isEmpty())||(telfixo.isEmpty())||(celular.isEmpty())||(cartaocred.isEmpty())||(bandeira.isEmpty()) )// verifica os dados
            { 

                if (nome.isEmpty()) {
                    request.setAttribute("erro_nome", "O nome não pode ser vazio");
                }

                if (estado.isEmpty()) {
                    request.setAttribute("endereco", "O endereco não pode ser vazio");
                }
                
                if (bairro.isEmpty()) {
                    request.setAttribute("erro_bairro", "O bairro não pode ser vazio");
                }

                if (cidade.isEmpty()) {
                    request.setAttribute("erro_cidade", "A cidade não pode ser vazia");
                }
                
                if (cep.isEmpty()) {
                    request.setAttribute("erro_cep", "O cep não pode ser vazio");
                }

                if (estado.isEmpty()) {
                    request.setAttribute("erro_estado", "O estado não pode ser vazio");
                }
                
                if (referencia.isEmpty()) {
                    request.setAttribute("erro_referencia", "A referencia não pode ser vazia");
                }

                if (cpf.isEmpty()) {
                    request.setAttribute("erro_cpf", "O cpf não pode ser vazio");
                }
                
                if (ri.isEmpty()) {
                    request.setAttribute("erro_ri", "O RI não pode ser vazio");
                }

                if (telfixo.isEmpty()) {
                    request.setAttribute("erro_telfixo", "O telefone fixo não pode ser vazio");
                }
                
                if (celular.isEmpty()) {
                    request.setAttribute("erro_celular", "O celular não pode ser vazio");
                }

                if (cartaocred.isEmpty()) {
                    request.setAttribute("erro_cartaocred", "O cartao de credito não pode ser vazio");
                }
                
                if (bandeira.isEmpty()) {
                    request.setAttribute("erro_bandeira", "A bandeira do cartao não pode ser vazia");
                }
                
                RequestDispatcher rd = request.getRequestDispatcher("Form_ClientePub.jsp");
                rd.forward(request, response);
            } else {

                Cliente cliente = new Cliente(nome, endereco, bairro, cidade, cep, estado, referencia, cpf, ri, telfixo, celular, cartaocred,bandeira );
                Cliente_DAO cliente_dao = new Cliente_DAO();
                try {
                    cliente_dao.Inserir(cliente);
                    request.setAttribute("mensagem", "Compra efetuada com sucesso!");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta_ClientePub.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_nome", "O nome não pode ser vazio");
            request.setAttribute("erro_endereco", "O endereco não pode ser vazio");
            request.setAttribute("erro_bairro", "O bairro não pode ser vazio");
            request.setAttribute("erro_cidade", "A cidade não pode ser vazia");
            request.setAttribute("erro_cep", "O cep não pode ser vazio");
            request.setAttribute("erro_estado", "O estado não pode ser vazio");
            request.setAttribute("erro_referencia", "A referencia não pode ser vazia");
            request.setAttribute("erro_cpf", "O cpf não pode ser vazio");
            request.setAttribute("erro_ri", "O RI não pode ser vazio");
            request.setAttribute("erro_telfixo", "O telefone fixo não pode ser vazio");
            request.setAttribute("erro_celular", "O celular não pode ser vazio");
            request.setAttribute("erro_cartaocred", "O cartao de credito não pode ser vazio");
            request.setAttribute("erro_bandeira", "A bandeira do cartao não pode ser vazia");
            RequestDispatcher rd = request.getRequestDispatcher("Form_ClientePub.jsp");
            rd.forward(request, response);
        }

    }

}
