package br.com.juliorgm.comprafacil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.juliorgm.comprafacil.helper.ItemHelper;
import br.com.juliorgm.comprafacil.model.ItemLista;
import br.com.juliorgm.comprafacil.model.Lista;

public class ItemListaActivity extends AppCompatActivity {
    Lista lista;
    Intent intent;
    ItemHelper helper;
    ItemLista item;
    private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_lista);

        intent = getIntent();
        lista = (Lista) intent.getSerializableExtra("LISTA");

        verificaLista();
        iniciaFirebase();
    }

    public void iniciaFirebase(){
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Lista");
    }

    private void verificaLista() {
        if(lista==null) finish();
        else helper = new ItemHelper(this,lista);
    }

    public void adicionaItem(View view){
        item = helper.pegaItem();
        reference.child(lista.getNomeLista()).child(item.getNome()).setValue(item);
        helper.limpaCampos();
    }
}
