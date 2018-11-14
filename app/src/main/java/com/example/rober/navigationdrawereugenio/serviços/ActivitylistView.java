package com.example.rober.navigationdrawereugenio.serviços;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.eloah.navigationdrawer.model.Aluno;
import com.example.eloah.navigationdrawer.services.InterfaceDeServicos;
import com.example.eloah.navigationdrawer.services.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitylistView extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estende_list_activity);

        imprimeLista();
    }

    private void imprimeLista() {

        InterfaceDeServicos services = RetrofitService.getServico();
        Call<List<Aluno>> call = services.webserviceNotasDeAlunos();

        call.enqueue(new Callback<List<Aluno>>() {
            @Override
            public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response) {
                List<Aluno> listaAlunosNotas = response.body();
                //O método setListAdapter foi herdado de ListActivity
                setListAdapter(new ListaAdapter(ActivitylistView.this, listaAlunosNotas));
            }

            @Override
            public void onFailure(Call<List<Aluno>> call, Throwable t) {
                Log.i("debug", t.getMessage());
            }
        });
    }
}
