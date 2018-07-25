package br.DAO;

public class Cliente {

    private int id;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String cep;
    private String estado;
    private String referencia;
    private String cpf;
    private String ri;
    private String telfixo;
    private String celular;
    private String cartaocred;
    private String bandeira;

    public Cliente(String nome, String endereco, String bairro, String cidade, String cep, String estado, String referencia, String cpf, String ri, String telfixo, String celular, String cartaocred, String bandeira) {

        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
        this.referencia = referencia;
        this.cpf = cpf;
        this.ri = ri;
        this.telfixo = telfixo;
        this.celular = celular;
        this.cartaocred = cartaocred;
        this.bandeira = bandeira;
    }

    public Cliente(int id, String nome, String endereco, String bairro, String cidade, String cep, String estado, String referencia, String cpf, String ri, String telfixo, String celular, String cartaocred, String bandeira) {

        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
        this.referencia = referencia;
        this.cpf = cpf;
        this.ri = ri;
        this.telfixo = telfixo;
        this.celular = celular;
        this.cartaocred = cartaocred;
        this.bandeira = bandeira;
    }
   

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente() {
   
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }    
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }    
    
    public String getRi() {
        return ri;
    }

    public void setRi(String ri) {
        this.ri = ri;
    }

    public String getTelfixo() {
        return telfixo;
    }

    public void setTelfixo(String telfixo) {
        this.telfixo = telfixo;
    }
    
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }    
    
    public String getCartaocred() {
        return cartaocred;
    }

    public void setCartaocred(String cartaocred) {
        this.cartaocred = cartaocred;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }
}
