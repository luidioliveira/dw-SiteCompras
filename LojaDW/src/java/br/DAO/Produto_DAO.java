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

public class Produto_DAO {

    public void Inserir(Produto produto) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO PRODUTO (idcategoria, nome, descricao, valor) VALUES (?,UPPER(?),?,?)");
            sql.setInt(1, produto.getIdCategoria());
            sql.setString(2, produto.getNome());
            sql.setString(3, produto.getDescricao());
            sql.setDouble(4, produto.getValor());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Produto get(Produto produto) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM PRODUTO,CATEGORIA WHERE ID=? and PRODUTO.IDCATEGORIA = CATEGORIA.ID ");
            sql.setInt(1, produto.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    produto.setIdCategoria(resultado.getInt("IDCATEGORIA"));
                    produto.setNome(resultado.getString("NOME"));
                    produto.setDescricao(resultado.getString("DESCRICAO"));
                    produto.setValor(resultado.getDouble("VALOR"));
                }
            }
            return produto;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    public Produto get(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM PRODUTO WHERE ID = ? ");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            Produto produto = new Produto();
            if (resultado != null) {
                while (resultado.next()) {
                    produto.setId(resultado.getInt("ID"));
                    produto.setIdCategoria(resultado.getInt("IDCATEGORIA"));
                    produto.setNome(resultado.getString("NOME"));
                    produto.setDescricao(resultado.getString("DESCRICAO"));
                    produto.setValor(resultado.getDouble("VALOR"));
                }
            }
            return produto;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    public void Alterar(Produto produto) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE PRODUTO SET IDCATEGORIA = ?, NOME = ? , DESCRICAO = ? , VALOR = ? WHERE ID = ? ");
            sql.setInt(1, produto.getIdCategoria());
            sql.setString(2, produto.getNome());
            sql.setString(3, produto.getDescricao());
            sql.setDouble(4, produto.getValor());
            sql.setInt(5, produto.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Produto produto) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM PRODUTO WHERE ID = ? ");
            sql.setInt(1, produto.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Produto> Listar() {
        ArrayList<Produto> meusProdutos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM PRODUTO";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Produto produto;
                    produto = new Produto(Integer.parseInt(resultado.getString("id")),
                            Integer.parseInt(resultado.getString("IDCATEGORIA")),
                            resultado.getString("NOME"),
                            resultado.getString("DESCRICAO"),
                            Double.parseDouble(resultado.getString("VALOR")));
                    meusProdutos.add(produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;
	}
	
	public ArrayList<Produto> ListarEletrodomesticos() {
        ArrayList<Produto> meusProdutos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM PRODUTO p JOIN CATEGORIA c ON c.ID = p.IDCATEGORIA WHERE c.nmcategoria = 'Eletrodomesticos'";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Produto produto;
                    produto = new Produto(Integer.parseInt(resultado.getString("id")),
                            Integer.parseInt(resultado.getString("IDCATEGORIA")),
                            resultado.getString("NOME"),
                            resultado.getString("DESCRICAO"),
                            Double.parseDouble(resultado.getString("VALOR")));
                    meusProdutos.add(produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;	
	}
	
	public ArrayList<Produto> ListarInformatica() {
        ArrayList<Produto> meusProdutos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM PRODUTO p JOIN CATEGORIA c ON c.ID = p.IDCATEGORIA WHERE c.nmcategoria = 'Informatica'";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Produto produto;
                    produto = new Produto(Integer.parseInt(resultado.getString("id")),
                            Integer.parseInt(resultado.getString("IDCATEGORIA")),
                            resultado.getString("NOME"),
                            resultado.getString("DESCRICAO"),
                            Double.parseDouble(resultado.getString("VALOR")));
                    meusProdutos.add(produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;	
	}
	
	public ArrayList<Produto> ListarEletroportateis() {
        ArrayList<Produto> meusProdutos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM PRODUTO p JOIN CATEGORIA c ON c.ID = p.IDCATEGORIA WHERE c.nmcategoria = 'Eletroportateis'";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Produto produto;
                    produto = new Produto(Integer.parseInt(resultado.getString("id")),
                            Integer.parseInt(resultado.getString("IDCATEGORIA")),
                            resultado.getString("NOME"),
                            resultado.getString("DESCRICAO"),
                            Double.parseDouble(resultado.getString("VALOR")));
                    meusProdutos.add(produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;	
	}
	
	public ArrayList<Produto> ListarSmartphones() {
        ArrayList<Produto> meusProdutos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM PRODUTO p JOIN CATEGORIA c ON c.ID = p.IDCATEGORIA WHERE c.nmcategoria = 'Smartphones'";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Produto produto;
                    produto = new Produto(Integer.parseInt(resultado.getString("id")),
                            Integer.parseInt(resultado.getString("IDCATEGORIA")),
                            resultado.getString("NOME"),
                            resultado.getString("DESCRICAO"),
                            Double.parseDouble(resultado.getString("VALOR")));
                    meusProdutos.add(produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;	
	}

	public ArrayList<Produto> BuscarProduto(String nome) {
        ArrayList<Produto> meusProdutos = new ArrayList();
        Conexao conexao = new Conexao();
        try {			
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM PRODUTO WHERE NOME LIKE UPPER(?)");
            sql.setString(1, '%'+nome+'%');
			ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Produto produto;
                    produto = new Produto(Integer.parseInt(resultado.getString("id")),
                            Integer.parseInt(resultado.getString("IDCATEGORIA")),
                            resultado.getString("NOME"),
                            resultado.getString("DESCRICAO"),
                            Double.parseDouble(resultado.getString("VALOR")));
                    meusProdutos.add(produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;	
	}	

	public ArrayList<Produto> ListarComprados() {
        ArrayList<Produto> meusProdutos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM PRODUTO p JOIN COMPRA c ON p.ID = c.IDPRODUTO";
            /*selectSQL.setInt(1, idcliente);*/
			PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Produto produto;
                    produto = new Produto(Integer.parseInt(resultado.getString("id")),
                            Integer.parseInt(resultado.getString("IDCATEGORIA")),
                            resultado.getString("NOME"),
                            resultado.getString("DESCRICAO"),
                            Double.parseDouble(resultado.getString("VALOR")));
                    meusProdutos.add(produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;	
	}	

}
