package br.com.juliorgm.comprafacil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.juliorgm.comprafacil.helper.ItemHelper;
import br.com.juliorgm.comprafacil.model.ItemLista;
import br.com.juliorgm.comprafacil.model.Lista;

public class ItemListaActivity extends AppCompatActivity {
    Lista lista;
    Intent intent;
    ItemHelper helper;
    ItemLista item;
    List<ItemLista> itens;
    private ListView listViewItemLista;
    private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_lista);

        intent = getIntent();
        lista = (Lista) intent.getSerializableExtra("LISTA");

        verificaLista();
        inicializarFirebase();
        atualizaLista();
    }
    public void carregaListaItens(){
        ItemAdapter adapter = new ItemAdapter(this,itens);

        listViewItemLista = findViewById(R.id.listViewItens);
        listViewItemLista.setAdapter(adapter);
    }

    public void atualizaLista(){

        reference.child("Lista").child(lista.getNomeLista()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
//                    List<ItemLista> list = new ArrayList<>();
//                    for (DataSnapshot child: dataSnapshot.getChildren()) {
//                        list.add(child.getValue(ItemLista.class));
//                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    void inicializarFirebase(){
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
    }

    private void verificaLista() {
        if(lista==null) finish();
        else helper = new ItemHelper(this,lista);
    }

    public void adicionaItem(View view){
        item = helper.pegaItem();
        reference.child("Lista").child(lista.getNomeLista()).child("listaDeItens").setValue(item);
        helper.limpaCampos();
    }
}
