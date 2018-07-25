package br.DAO;

public class Compra {

    private int id;
    private int idcliente;
    private int idproduto;

    public Compra(int idcliente, int idproduto) {

        this.idcliente = idcliente;
        this.idproduto = idproduto;
    }

    public Compra(int id, int idcliente, int idproduto) {
        this.id = id;
        this.idcliente = idcliente;
        this.idproduto = idproduto;
    }

    public Compra(int id) {
        this.id = id;
    }

    public Compra() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idcliente;
    }

    public void setIdCliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdProduto() {
        return idproduto;
    }

    public void setIdProduto(int idproduto) {
        this.idproduto = idproduto;
    }

}
