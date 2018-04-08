package br.com.juliorgm.comprafacil.model;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lista implements Serializable{
    private String nomeLista;
    private String dataCriacao;
    private List<ItemLista> listaDeItens;
    public Map<String, Boolean> stars = new HashMap<>();

    public Lista(){}

    public Lista(String nomeLista, String dataCriacao) {
        this.nomeLista = nomeLista;
        this.dataCriacao = dataCriacao;
        this.listaDeItens = null;
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

    public List<ItemLista> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(List<ItemLista> listaDeItens) {
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
