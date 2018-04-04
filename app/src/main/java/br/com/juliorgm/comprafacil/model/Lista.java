package br.com.juliorgm.comprafacil.model;

import java.io.Serializable;
import java.util.List;

public class Lista implements Serializable{
    private String nomeLista;
    private String dataCriacao;
    private List<Item> listaDeItens;

    public Lista(){}

    public Lista(String nomeLista, String dataCriacao, List<Item> listaDeItens) {
        this.nomeLista = nomeLista;
        this.dataCriacao = dataCriacao;
        this.listaDeItens = listaDeItens;
    }

    public String getNomeLista() {
        return nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<Item> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(List<Item> listaDeItens) {
        this.listaDeItens = listaDeItens;
    }

    public int totalDeItens(){
        if (listaDeItens != null) {
            int total = listaDeItens.size();
            return total;
        }
        return 0;
    }

    @Override
    public String toString() {
        return nomeLista +" "+dataCriacao;
    }
}