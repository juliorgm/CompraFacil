package br.com.juliorgm.comprafacil;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import br.com.juliorgm.comprafacil.model.ItemLista;
import br.com.juliorgm.comprafacil.model.Lista;

public class ItemAdapter extends BaseAdapter {
    List<ItemLista> itens;

    public ItemAdapter(List<ItemLista> itens) {
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

        return null;
    }

    public class ViewHolder {
    }
}
