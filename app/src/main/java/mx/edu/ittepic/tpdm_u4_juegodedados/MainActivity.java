package mx.edu.ittepic.tpdm_u4_juegodedados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
EditText rondas, turnos, t1j1,t2j1,t3j1,t4j1,totalj1,
                         t1j2,t2j2,t3j2,t4j2,totalj2,
                         t1j3,t2j3,t3j3,t4j3,totalj3;
Button iniciar;

ImageView dado1, dado2;

Tirada tirada;

int ronda, turno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rondas = findViewById(R.id.rondas);
        turnos = findViewById(R.id.turnos);

        t1j1 = findViewById(R.id.t1j1);
        t2j1 = findViewById(R.id.t2j1);
        t3j1 = findViewById(R.id.t3j1);
        t4j1 = findViewById(R.id.t4j1);
        t1j2 = findViewById(R.id.t1j2);
        t2j2 = findViewById(R.id.t2j2);
        t3j2 = findViewById(R.id.t3j2);
        t4j2 = findViewById(R.id.t4j2);
        t1j3 = findViewById(R.id.t1j3);
        t2j3 = findViewById(R.id.t2j3);
        t3j3 = findViewById(R.id.t3j3);
        t4j3 = findViewById(R.id.t4j3);

        totalj1 = findViewById(R.id.totalj1);
        totalj2 = findViewById(R.id.totalj2);
        totalj3 = findViewById(R.id.totalj3);

        dado1 = findViewById(R.id.dado1);
        dado2 = findViewById(R.id.dado2);

        iniciar = findViewById(R.id.iniciar);

        ronda = 1;
        turno = 1;

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tirada = new Tirada(MainActivity.this);
                    tirada.execute();
                }
        });

    }
}
