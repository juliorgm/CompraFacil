package br.com.juliorgm.comprafacil.helper;

import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.juliorgm.comprafacil.MainActivity;
import br.com.juliorgm.comprafacil.R;
import br.com.juliorgm.comprafacil.model.Lista;


public class ListaHelper {
    private EditText campoNovaLista;
    private Lista lista;

    public ListaHelper(MainActivity activity) {
        this.campoNovaLista = (EditText) activity.findViewById(R.id.txtItemAdd);
    }

    public Lista novaLista(){
        lista = new Lista();
        lista.setNomeLista(campoNovaLista.getText().toString());
        Calendar hoje = Calendar.getInstance();
        hoje.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("dd / MM / yyyy");
        String formatted = format1.format(hoje.getTime());
        lista.setDataCriacao(formatted);

        return lista;
    }


}
