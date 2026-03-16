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

    private Button btnFabricarPessoa;
    private Button btnSair;
    private Button btnCriarPessoa;
    private TextView txtPessoa;
    private TextView txtNome;
    private TextView txtIdade;
    Pessoa pessoa;
    int contador;

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

        iniciarComponentesDeLayout();

        btnFabricarPessoa.setOnClickListener(v -> {
            metodoFabricarUmaPessoa();
        });

        btnSair.setOnClickListener(v ->
        {
            sairDoAplicativo();
        });

        btnCriarPessoa.setOnClickListener(v -> {
            metodoParaCriarPessoa();s
        });
    }

    private void metodoParaCriarPessoa() {
        pessoa = new Pessoa();
        pessoa.setNome("Marco");
        pessoa.setIdade(getIdade());

        txtPessoa.setText(pessoa.toString());
        txtNome.setText(pessoa.getNome());
        txtIdade.setText(String.valueOf(pessoa.getIdade()));

        Toast.makeText(this, "Botão Criar Pessoa Clicado", Toast.LENGTH_LONG).show();

        contador++;
        Log.d("eventos", "Botão Criar Pessoa Clicado "+contador);
        Log.i("eventos", "Nova pessoa criada: "+pessoa.toString());
        Log.w("eventos", "Nome da pessoa: "+pessoa.getNome());
        Log.v("eventos", "Idade da pessoa: "+pessoa.getIdade());
    }
    private void metodoFabricarUmaPessoa() {
        Toast.makeText(this, "Botão Fabricar Pessoa Clicado", Toast.LENGTH_LONG).show();
        int idade = getIdade();
        pessoa = new Pessoa("Marco", idade);
        txtPessoa.setText(pessoa.toString());
    }
    private void iniciarComponentesDeLayout() {
        btnFabricarPessoa = findViewById(R.id.btnFabricarPessoa);
        btnSair = findViewById(R.id.btnSair);
        btnCriarPessoa = findViewById(R.id.btnCriarPessoa);
        txtPessoa = findViewById(R.id.txtPessoa);
        txtNome = findViewById(R.id.txtNome);
        txtIdade = findViewById(R.id.txtIdade);
    }
    private void sairDoAplicativo() {
        contador++;
        Log.d("eventos", "Botão Sair Clicado "+contador);
        finish();
    }
    private static int getIdade() {
        Random idadeAleatoria = new Random();
        int min = 18;
        int max = 50;
        int idade = idadeAleatoria.nextInt(max - min + 1) + min;
        return idade;
    }
}