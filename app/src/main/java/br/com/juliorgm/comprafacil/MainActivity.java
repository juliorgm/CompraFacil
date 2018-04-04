package br.com.juliorgm.comprafacil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.juliorgm.comprafacil.helper.ListaHelper;
import br.com.juliorgm.comprafacil.model.Lista;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="LISTA" ;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private ListaHelper helper;
    private Lista lista;
    private List<Lista> listaList;
    private ListView listViewCompras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new ListaHelper(this);

        inicializarFirebase();
        atualizaLista();
    }

    public void carregaListViewCompras(){
        listViewCompras = findViewById(R.id.listViewCompras);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,listaList);
        listViewCompras.setAdapter(adapter);
    }

    void cliqueLista(){
        listViewCompras.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lista = (Lista)listViewCompras.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this,ItemListaActivity.class);
                intent.putExtra("LISTA",lista);
                startActivity(intent);
            }
        });
    }

    public void atualizaLista(){
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listaList = new ArrayList<>();
                for (DataSnapshot obj: dataSnapshot.getChildren()){
                    Lista lista = obj.getValue(Lista.class);
                    listaList.add(lista);
                }
                carregaListViewCompras();
                cliqueLista();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        reference.child("Lista").addValueEventListener(postListener);
    }


    void inicializarFirebase(){
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
    }

    public void novaListaCompra(View view){
        lista = helper.novaLista();
        reference.child("Lista").child(lista.getNomeLista()).setValue(lista);
    }
}
