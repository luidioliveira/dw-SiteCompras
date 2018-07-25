package br.DAO;

public class Categoria {

    public int id;
    public String nmcategoria;
    
    public Categoria(String nmcategoria) {

        this.nmcategoria = nmcategoria;
    }

    public Categoria(int id, String nmcategoria) {
        this.id = id;
        this.nmcategoria = nmcategoria;
    }

    public Categoria(int id) {
        this.id = id;
    }

    Categoria() {
        
    }

    public int getIdCategoria() {
        return id;
    }

    public void setIdCategoria(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return nmcategoria;
    }

    public void setCategoria(String nmcategoria) {
        this.nmcategoria = nmcategoria;
    }
}
