/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Contato_DAO {

    public void Inserir(Contato contato) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO CONTATO (nome, idade) VALUES (?,?)");
            sql.setString(1, contato.getNome());
            sql.setInt(2, contato.getIdade());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Contato get(Contato contato) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM CONTATO WHERE ID = ? ");
            sql.setInt(1, contato.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    contato.setNome(resultado.getString("NOME"));
                    contato.setIdade(Integer.parseInt(resultado.getString("IDADE")));
                }
            }
            return contato;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Contato contato) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE CONTATO SET nome = ?, idade = ?  WHERE ID = ? ");
            sql.setString(1, contato.getNome());
            sql.setInt(2, contato.getIdade());
            sql.setInt(3, contato.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Contato contato) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM CONTATO WHERE ID = ? ");
            sql.setInt(1, contato.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Contato> Listar() {
        ArrayList<Contato> meusContatos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM CONTATO";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Contato contato;
                    contato = new Contato(Integer.parseInt(resultado.getString("id")),
                            resultado.getString("NOME"),
                            Integer.parseInt(resultado.getString("IDADE")));
                    meusContatos.add(contato);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusContatos;

    }

}
