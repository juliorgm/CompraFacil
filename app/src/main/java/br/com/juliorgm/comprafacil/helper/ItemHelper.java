package br.com.juliorgm.comprafacil.helper;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.com.juliorgm.comprafacil.ItemListaActivity;
import br.com.juliorgm.comprafacil.R;
import br.com.juliorgm.comprafacil.model.ItemLista;
import br.com.juliorgm.comprafacil.model.Lista;

public class ItemHelper {
    private EditText campoAddItem;
    private TextView campoTituloNomeLista;
    private ListView listViewItemLista;


    public ItemHelper(ItemListaActivity activity, Lista lista) {
        this.campoAddItem = activity.findViewById(R.id.txtItemAdd);
        this.campoTituloNomeLista = activity.findViewById(R.id.txtItemNomeLista);
        this.listViewItemLista = activity.findViewById(R.id.listViewItens);

        campoTituloNomeLista.setText(lista.getNomeLista());
    }


    public void limpaCampos(){
        campoAddItem.setText(null);
    }


    public ItemLista pegaItem(){
        String item = campoAddItem.getText().toString();
        String[] quantidadeItem = item.split(" ");
        item = quantidadeItem[1];
        String quantidade = quantidadeItem[0];

        return new ItemLista(item,quantidade);
    }
}
