package com.example.hirob.primeirotrabalho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botaoTela;
    private Button botaoLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoTela = (Button) findViewById(R.id.buttonCadastrar);

        botaoLista = (Button) findViewById(R.id.buttonListar);

        botaoTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

        botaoLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(MainActivity.this, Main3Activity.class);
                it.putExtra("bandeira", "NAO_TEM_NADA");
                startActivity(it);
               // startActivity(new Intent(MainActivity.this, Main3Activity.class));
            }
        });
    }
}
