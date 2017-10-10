package com.example.hirob.primeirotrabalho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class Main3Activity extends AppCompatActivity {
    ListView lista;
    Cartao cartao;
    CartaoDAO cartaoDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        cartaoDAO = new CartaoDAO(this);
        // Primeira coisa que precisamos fazer e buscar a intenção da nossa activity, pois é dentro dela que temos nossos parametros.
        Intent it = getIntent();
        lista = (ListView) findViewById(R.id.listView);
        if(!it.getStringExtra("bandeira").equals("NAO_TEM_NADA")) {
            String bandeira = it.getStringExtra("bandeira");
            String limite = it.getStringExtra("limite");
            String vencimento = it.getStringExtra("vencimento");
            String nome = it.getStringExtra("nome");



            cartao = new Cartao();
            cartao.setBandeira(bandeira);
            cartao.setLimite(limite);
            cartao.setVencimento(vencimento);
            cartao.setNome(nome);

            cartaoDAO.insert(cartao);
            //ArrayList listaCartao = retrieveContactList();
        }
        ArrayList<Cartao> listaCartao;
        //listaCartao.add(cartao);


        listaCartao = (ArrayList)cartaoDAO.getLista();




        ArrayList<String> listaString = arrumarLista(listaCartao);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listaString);

      lista.setAdapter(adapter);

    }

        private ArrayList<String> arrumarLista(ArrayList<Cartao> lca){
            ArrayList<String> strings = new ArrayList<>();
            //String nome;
            for(Cartao cartao1 : lca){
                strings.add(cartao1.getNome());
            }
            return strings;
        }
}
