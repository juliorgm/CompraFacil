package br.com.juliorgm.comprafacil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.juliorgm.comprafacil.model.ItemLista;
import br.com.juliorgm.comprafacil.model.Lista;

public class ItemAdapter extends BaseAdapter {

    Context context;
    List<ItemLista> itens;

    public ItemAdapter(Context context,List<ItemLista> itens) {
        this.context = context;
        this.itens = itens;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_listiview_itens,parent,false);
        ViewHolder holder = new ViewHolder(v);
        ItemLista item = itens.get(position);
        holder.nomeItem.setText(item.getNome());
        holder.quantidadeitem.setText(item.getQuantidade());
        holder.btExcluir.setTag(item);

        return null;
    }

}

class ViewHolder {

    final TextView nomeItem,quantidadeitem;
    final Button btExcluir;
    final ImageView icone;


    public ViewHolder(View view) {
        nomeItem = (TextView) view.findViewById(R.id.txtNomeItemTitulo);
        quantidadeitem = (TextView) view.findViewById(R.id.txtQuantidadeitem);
        btExcluir = (Button) view.findViewById(R.id.btnExcluir);
        icone = (ImageView) view.findViewById(R.id.icoItem);
    }
}
