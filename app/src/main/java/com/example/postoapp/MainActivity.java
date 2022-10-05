package com.example.postoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected EditText gasolina;
    protected EditText etanol;
    protected Button calcular;
    protected TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gasolina = findViewById(R.id.editTextPrecoGasolina);
        etanol = findViewById(R.id.editTextPrecoAlcool);
        resultado = findViewById(R.id.textViewResultado);
        Button calcular = findViewById(R.id.Calcular);

        calcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.Calcular)
        {
            String prGasolina = gasolina.getText().toString();
            String prEtanol = etanol.getText().toString();
            if("".equals(prGasolina) && "".equals(prEtanol))
                Toast.makeText(this, R.string.informe_valor, Toast.LENGTH_LONG).show();
            else
            {
                double somaGasolina = Double.parseDouble(prGasolina);
                double somaEtanol = Double.parseDouble(prEtanol);
                if (somaEtanol/somaGasolina < 0.7 )
                    resultado.setText("Use Alcool");
                else {
                    resultado.setText("Use Gasolina");
                }
            }
        }
    }

}