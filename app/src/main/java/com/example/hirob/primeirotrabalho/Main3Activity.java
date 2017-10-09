package com.example.hirob.primeirotrabalho;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

        String bandeira = it.getStringExtra("bandeira");
        String limite = it.getStringExtra("limite");
        String vencimento = it.getStringExtra("vencimento");
        String nome = it.getStringExtra("nome");

        lista = (ListView) findViewById(R.id.listView);

        cartao = new Cartao();
        cartao.setBandeira(bandeira);
        cartao.setLimite(limite);
        cartao.setVencimento(vencimento);
        cartao.setNome(nome);

        //ArrayList listaCartao = retrieveContactList();
        ArrayList<Cartao> listaCartao;
        //listaCartao.add(cartao);

        cartaoDAO.insert(cartao);
        listaCartao = (ArrayList)cartaoDAO.getLista();









        ArrayList<String> listaString = arrumarLista(listaCartao);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listaString);

      lista.setAdapter(adapter);

    }

    //Salvando
//    private void saveContactList(ArrayList<Cartao> listaDeContatos){
//        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        Set<String> contactSet = new HashSet<>();
//        contactSet.addAll(listaDeContatos);
//
//        editor.putStringSet("lista", contactSet);
//        editor.commit();
//    }

//    //Recuperando
//    private ArrayList<Cartao> retrieveContactList(){
//        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
//        Set<String> listaSet = sharedPreferences.getStringSet("lista", null);
//
//        return new ArrayList<Cartao>(listaSet);
//
//        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
//        String restoredText = prefs.getString("lista", null);
//        if (restoredText != null) {
//            String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
//            int idName = prefs.getInt("idName", 0); //0 is the default value.
//    }
        private ArrayList<String> arrumarLista(ArrayList<Cartao> lca){
            ArrayList<String> strings = new ArrayList<>();
            //String nome;
            for(Cartao cartao1 : lca){
                strings.add(cartao1.getNome());
            }
            return strings;
        }
}
