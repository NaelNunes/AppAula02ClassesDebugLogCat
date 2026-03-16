package com.example.appaula02classesdebuglogcat;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;


public class MainActivity extends AppCompatActivity {


    private TextView txtPessoa;
    private Button btnFabricarPessoa;
    private Button btnSair;
    Pessoa pessoa;
    int contador;

    int contadorDeCliques = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnFabricarPessoa = findViewById(R.id.btnFabricarPessoa);
        txtPessoa = findViewById(R.id.txtPessoa);
        btnSair = findViewById(R.id.btnSair);

        btnFabricarPessoa.setOnClickListener(v -> {
            Toast.makeText(this, "Botão Fabricar Pessoa Clicado", Toast.LENGTH_LONG).show();

            int idade = getIdade();
            pessoa = new Pessoa("Marco", idade);
            txtPessoa.setText(pessoa.toString());
        });

        btnSair.setOnClickListener(v ->
        {
            contador++;
            Log.d("eventos", "Botão Sair Clicado "+contador);
            finish();
        });


    }

    private static int getIdade() {
        Random idadeAleatoria = new Random();
        int min = 18;
        int max = 50;
        int idade = idadeAleatoria.nextInt(max - min + 1) + min;
        return idade;
    }
}