package br.com.juliorgm.comprafacil.model;

import android.media.Image;

public class Categoria {
    private String nomeCategoria;
    private Image icone;

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Image getIcone() {
        return icone;
    }

    public void setIcone(Image icone) {
        this.icone = icone;
    }
}
