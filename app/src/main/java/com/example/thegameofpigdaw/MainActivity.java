package com.example.thegameofpigdaw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int jugador = 1;
    private int acumulador1 = 0;
    private int acumulador2 = 0;
    private int random1 = 0;
    private int random2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dado(View view) {
        TextView dado = (TextView) findViewById(R.id.dado);
        TextView acum1 = (TextView) findViewById(R.id.acum1);
        TextView acum2 = (TextView) findViewById(R.id.acum2);
        TextView flecha1 = (TextView) findViewById(R.id.flecha1);
        TextView flecha2 = (TextView) findViewById(R.id.flecha2);
        int num = ((int) (Math.random()*6)+1);
        dado.setText(String.valueOf(num));
        if  (jugador == 1) {
            flecha2.setText("");
            flecha1.setText("<---");
            if (num == 1) {
                acumulador1=0;
                acum1.setText(String.valueOf(acumulador1));
                dado.setText("");
                jugador = 2;
                flecha1.setText("");
                flecha2.setText("--->");
            } else {
                acumulador1 += num;
                acum1.setText(String.valueOf(acumulador1));
            }
        } else if (jugador == 2) {
            flecha1.setText("");
            flecha2.setText("--->");
            if (num == 1) {
                acumulador2=0;
                acum2.setText(String.valueOf(acumulador2));
                dado.setText("");
                jugador = 1;
                flecha2.setText("");
                flecha1.setText("<---");
            } else {
                acumulador2 += num;
                acum2.setText(String.valueOf(acumulador2));
            }
        }
    }
    public void rendirse(View view) {
        TextView acum1 = (TextView) findViewById(R.id.acum1);
        TextView acum2 = (TextView) findViewById(R.id.acum2);
        TextView res1 = (TextView) findViewById(R.id.resultado1);
        TextView res2 = (TextView) findViewById(R.id.resultado2);
        TextView ganador = (TextView) findViewById(R.id.ganador);
        TextView flecha1 = (TextView) findViewById(R.id.flecha1);
        TextView flecha2 = (TextView) findViewById(R.id.flecha2);
        if (jugador == 1) {
            random1 += acumulador1;
            res1.setText(String.valueOf(random1));
            if (random1 >= 100) {
                ganador.setText("Gana el jugador 1");
                flecha2.setText("");
                flecha1.setText("");
            }
            acumulador1 = 0;
            acum1.setText("0");
            jugador = 2;
            flecha1.setText("");
            flecha2.setText("--->");
        } else if (jugador == 2){
            random2 += acumulador2;
            res2.setText(String.valueOf(random2));
            if (random2 >= 100) {
                ganador.setText("Gana el jugador 2");
                flecha2.setText("");
                flecha1.setText("");
            }
            acumulador2 = 0;
            acum2.setText("0");
            jugador = 1;
            flecha2.setText("");
            flecha1.setText("<---");
        }
    }
    public void reiniciar(View view) {
        TextView acum1 = (TextView) findViewById(R.id.acum1);
        TextView acum2 = (TextView) findViewById(R.id.acum2);
        TextView res1 = (TextView) findViewById(R.id.resultado1);
        TextView res2 = (TextView) findViewById(R.id.resultado2);
        TextView ganador = (TextView) findViewById(R.id.ganador);
        TextView dado = (TextView) findViewById(R.id.dado);
        TextView flecha1 = (TextView) findViewById(R.id.flecha1);
        TextView flecha2 = (TextView) findViewById(R.id.flecha2);
        acumulador1=0;
        acumulador2=0;
        random1=0;
        random2=0;
        acum1.setText("0");
        acum2.setText("0");
        res1.setText("0");
        res2.setText("0");
        ganador.setText("");
        dado.setText("");
        ganador.setText("");
        flecha1.setText("");
        flecha2.setText("");
    }
}