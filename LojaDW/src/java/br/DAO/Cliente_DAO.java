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

public class Cliente_DAO {

    public void Inserir(Cliente cliente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO CLIENTE (nome, endereco, bairro, cidade, cep, estado, referencia, cpf, ri, telfixo, celular, cartaocred, bandeira ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            sql.setString(1, cliente.getNome());
            sql.setString(2, cliente.getEndereco());
            sql.setString(3, cliente.getBairro());
            sql.setString(4, cliente.getCidade());
            sql.setString(5, cliente.getCep());
            sql.setString(6, cliente.getEstado());
            sql.setString(7, cliente.getReferencia());
            sql.setString(8, cliente.getCpf());
            sql.setString(9, cliente.getRi());
            sql.setString(10, cliente.getTelfixo());
            sql.setString(11, cliente.getCelular());
            sql.setString(12, cliente.getCartaocred());
            sql.setString(13, cliente.getBandeira());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Cliente get(Cliente cliente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM CLIENTE WHERE ID = ? ");
            sql.setInt(1, cliente.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    cliente.setId(resultado.getInt("ID"));
                    cliente.setNome(resultado.getString("NOME"));
                    cliente.setEndereco(resultado.getString("ENDERECO"));
                    cliente.setBairro(resultado.getString("BAIRRO"));
                    cliente.setCidade(resultado.getString("CIDADE"));
                    cliente.setCep(resultado.getString("CEP"));
                    cliente.setEstado(resultado.getString("ESTADO"));
                    cliente.setReferencia(resultado.getString("REFERENCIA"));
                    cliente.setCpf(resultado.getString("CPF"));
                    cliente.setRi(resultado.getString("RI"));
                    cliente.setTelfixo(resultado.getString("TELFIXO"));
                    cliente.setCelular(resultado.getString("CELULAR"));
                    cliente.setCartaocred(resultado.getString("CARTAOCRED"));
                    cliente.setBandeira(resultado.getString("BANDEIRA"));
                }
            }
            return cliente;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public Cliente get(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM CLIENTE WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            Cliente cliente = new Cliente();
            if (resultado != null) {
                while (resultado.next()) {
                    cliente.setId(resultado.getInt("ID"));
                    cliente.setNome(resultado.getString("NOME"));
                    cliente.setEndereco(resultado.getString("ENDERECO"));
                    cliente.setBairro(resultado.getString("BAIRRO"));
                    cliente.setCidade(resultado.getString("CIDADE"));
                    cliente.setCep(resultado.getString("CEP"));
                    cliente.setEstado(resultado.getString("ESTADO"));
                    cliente.setReferencia(resultado.getString("REFERENCIA"));
                    cliente.setCpf(resultado.getString("CPF"));
                    cliente.setRi(resultado.getString("RI"));
                    cliente.setTelfixo(resultado.getString("TELFIXO"));
                    cliente.setCelular(resultado.getString("CELULAR"));
                    cliente.setCartaocred(resultado.getString("CARTAOCRED"));
                    cliente.setBandeira(resultado.getString("BANDEIRA"));
                    
                }
            }
            return cliente;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Cliente cliente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE CLIENTE SET nome = ?, endereco = ?, bairro = ?, cidade = ?, cep = ?, estado = ?, referencia = ?, cpf = ?, ri = ?, telfixo = ?, celular = ?, cartaocred = ?, bandeira = ?    WHERE ID = ? ");
            sql.setString(1, cliente.getNome());
            sql.setString(2, cliente.getEndereco());
            sql.setString(3, cliente.getBairro());
            sql.setString(4, cliente.getCidade());
            sql.setString(5, cliente.getCep());
            sql.setString(6, cliente.getEstado());
            sql.setString(7, cliente.getReferencia());
            sql.setString(8, cliente.getCpf());
            sql.setString(9, cliente.getRi());
            sql.setString(10, cliente.getTelfixo());
            sql.setString(11, cliente.getCelular());
            sql.setString(12, cliente.getCartaocred());
            sql.setString(13, cliente.getBandeira());
            sql.setInt(14, cliente.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Cliente cliente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM CLIENTE WHERE ID = ? ");
            sql.setInt(1, cliente.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Cliente> Listar() {
        ArrayList<Cliente> meusClientes = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM CLIENTE";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Cliente cliente;
                    cliente = new Cliente(Integer.parseInt(resultado.getString("id")),
                            resultado.getString("NOME"),
                            resultado.getString("ENDERECO"),
                            resultado.getString("BAIRRO"),
                            resultado.getString("CIDADE"),
                            resultado.getString("CEP"),
                            resultado.getString("ESTADO"),
                            resultado.getString("REFERENCIA"),
                            resultado.getString("CPF"),
                            resultado.getString("RI"),
                            resultado.getString("TELFIXO"),
                            resultado.getString("CELULAR"),
                            resultado.getString("CARTAOCRED"),
                            resultado.getString("BANDEIRA"));
                    meusClientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusClientes;

    }

  

}
