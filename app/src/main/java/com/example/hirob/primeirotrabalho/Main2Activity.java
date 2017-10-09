package com.example.hirob.primeirotrabalho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText bandeira;
    EditText limite;
    EditText vencimeto;
    EditText nome;
    Button ok;
    Button cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ok = (Button) findViewById(R.id.buttonOk);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(Main2Activity.this, Main3Activity.class);
                bandeira = (EditText) findViewById(R.id.editTextBandeira);
                limite = (EditText) findViewById(R.id.editTextLimite);
                vencimeto = (EditText) findViewById(R.id.editTextVencimento);
                nome = (EditText) findViewById(R.id.editTextNome);

                String bandeiraT = bandeira.getText().toString();
                String limiteT = limite.getText().toString();
                String vencimentoT = vencimeto.getText().toString();
                String nomeT = nome.getText().toString();


                it.putExtra("bandeira", bandeiraT);
                it.putExtra("limite", limiteT);
                it.putExtra("vencimento", vencimentoT);
                it.putExtra("nome",nomeT);

                startActivity(it);
            }
        });

    }


}
