package br.com.juliorgm.comprafacil.model;

public class ItemLista {
    private String nome;
    private String quantidade;
    private boolean status; // true para pego

    public ItemLista (){}

    public ItemLista(String nome, String quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.status = false;//
        this.categoria = null;//precisará implementar posteriormente
    }

    private Categoria categoria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
