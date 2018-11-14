package com.example.rober.navigationdrawereugenio.serviços;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eloah.navigationdrawer.R;
import com.example.eloah.navigationdrawer.model.Aluno;

import java.util.List;

class ListaAdapter extends BaseAdapter {

    private Context contexto;
    private List<Aluno> lista;

    public ListaAdapter(Context contexto, List<Aluno> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Aluno aluno = lista.get(position);
        View linha = LayoutInflater.from(contexto).inflate(R.layout.layout_da_linha_do_listview, null);

        /*preenchimento*/
        ImageView imagem = (ImageView) linha.findViewById(R.id.imageViewCirculo);
        TextView nomeAluno = (TextView) linha.findViewById(R.id.textViewNome);
        TextView notaAluno = (TextView) linha.findViewById(R.id.textViewNota);

        if (aluno.getNota() < 6)
            imagem.setImageResource(R.drawable.vermelho);
        else
            imagem.setImageResource(R.drawable.azul);
        nomeAluno.setText(aluno.getNome());
        notaAluno.setText(aluno.getNota()+"");
        Log.i("nome: ", aluno.getNome());
        return linha;
    }
}