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

public class Compra_DAO {

    public void Inserir(Compra compra) throws Exception {
        Conexao conexao = new Conexao();
        try {
                PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO COMPRA (idcliente, idproduto) VALUES (?,?)");
            sql.setInt(1, compra.getIdCliente());
            sql.setInt(2, compra.getIdProduto());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Compra get(Compra compra) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM COMPRA WHERE ID = ? ");
            sql.setInt(1, compra.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    compra.setIdCliente(Integer.parseInt(resultado.getString("IDCLIENTE")));
                    compra.setIdProduto(Integer.parseInt(resultado.getString("IDPRODUTO")));
                }
            }
            return compra;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public Compra get(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM COMPRA WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            Compra compra = new Compra();
            if (resultado != null) {
                while (resultado.next()) {
                    compra.setId(resultado.getInt("ID"));
                    compra.setIdCliente(resultado.getInt("IDCLIENTE"));
                    compra.setIdProduto(resultado.getInt("IDPRODUTO"));
                }
            }
            return compra;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Compra compra) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE COMPRA SET idcliente = ?, idproduto = ?  WHERE ID = ? ");
            sql.setInt(1, compra.getIdCliente());
            sql.setInt(2, compra.getIdProduto());
            sql.setInt(3, compra.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Compra compra) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM COMPRA WHERE ID = ? ");
            sql.setInt(1, compra.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Compra> Listar() {
        ArrayList<Compra> minhasCompras = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM COMPRA";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Compra compra;
                    compra = new Compra(Integer.parseInt(resultado.getString("id")),
                            Integer.parseInt(resultado.getString("IDCLIENTE")),
                            Integer.parseInt(resultado.getString("IDPRODUTO")));
                    minhasCompras.add(compra);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return minhasCompras;

    }

	public void ExcluirPub(Compra compra) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM COMPRA WHERE ID = (SELECT MAX(ID) FROM COMPRA WHERE IDPRODUTO = ?)");
            sql.setInt(1, compra.getIdProduto());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }	
}

