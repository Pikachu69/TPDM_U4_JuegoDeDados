package mx.edu.ittepic.tpdm_u4_juegodedados;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;

public class Tirada extends AsyncTask<Void, Integer, Integer> {
    MainActivity puntero;

    public Tirada(MainActivity ventana) {
        puntero = ventana;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        puntero.iniciar.setClickable(false);
        int[] dado1 = new int[25];
        int[] dado2 = new int[25];
        int suma = 0;

        for (int i=0;i<dado1.length;i++){
            int n = generarNumero();
            int m = generarNumero();
            publishProgress(n,m);
            dado1[i]=n;
            dado2[i]=m;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        suma = dado1[24]+dado2[24];

        return suma;
    }

    private int generarNumero() {
        return (int) (Math.random()*6+1);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        switch (values[0]){
            case 1:
                puntero.dado1.setImageResource(R.drawable.uno);
                break;
            case 2:
                puntero.dado1.setImageResource(R.drawable.dos);
                break;
            case 3:
                puntero.dado1.setImageResource(R.drawable.tres);
                break;
            case 4:
                puntero.dado1.setImageResource(R.drawable.cuatro);
                break;
            case 5:
                puntero.dado1.setImageResource(R.drawable.cinco);
                break;
            case 6:
                puntero.dado1.setImageResource(R.drawable.seis);
                break;
        }
        switch (values[1]){
            case 1:
                puntero.dado2.setImageResource(R.drawable.uno);
                break;
            case 2:
                puntero.dado2.setImageResource(R.drawable.dos);
                break;
            case 3:
                puntero.dado2.setImageResource(R.drawable.tres);
                break;
            case 4:
                puntero.dado2.setImageResource(R.drawable.cuatro);
                break;
            case 5:
                puntero.dado2.setImageResource(R.drawable.cinco);
                break;
            case 6:
                puntero.dado2.setImageResource(R.drawable.seis);
                break;
        }
    }

    @Override
    protected void onPostExecute(Integer suma) {
        super.onPostExecute(suma);
        if (puntero.ronda==1) {
            if (puntero.turno == 1) {
                puntero.t1j1.setText("" + suma);
                puntero.totalj1.setText(""+suma);
                puntero.turno++;
                puntero.turnos.setText("Jugador 2");
            } else if (puntero.turno == 2) {
                puntero.t1j2.setText("" + suma);
                puntero.totalj2.setText(""+suma);
                puntero.turno++;
                puntero.turnos.setText("Jugador 3");
            } else if (puntero.turno == 3) {
                puntero.t1j3.setText("" + suma);
                puntero.totalj3.setText(""+suma);
                puntero.turno = 1;
                puntero.turnos.setText("Jugador 1");
                puntero.ronda++;
                puntero.rondas.setText("2");
            }
        } else if (puntero.ronda==2) {
            if (puntero.turno == 1) {
                puntero.t2j1.setText("" + suma);
                puntero.totalj1.setText(""+(Integer.parseInt(puntero.totalj1.getText().toString())+suma));
                puntero.turno++;
                puntero.turnos.setText("Jugador 2");
            } else if (puntero.turno == 2) {
                puntero.t2j2.setText("" + suma);
                puntero.totalj2.setText(""+(Integer.parseInt(puntero.totalj2.getText().toString())+suma));
                puntero.turno++;
                puntero.turnos.setText("Jugador 3");
            } else if (puntero.turno == 3) {
                puntero.t2j3.setText("" + suma);
                puntero.totalj3.setText(""+(Integer.parseInt(puntero.totalj3.getText().toString())+suma));
                puntero.turno = 1;
                puntero.turnos.setText("Jugador 1");
                puntero.ronda++;
                puntero.rondas.setText("3");
            }
        } else if (puntero.ronda==3) {
            if (puntero.turno == 1) {
                puntero.t3j1.setText("" + suma);
                puntero.totalj1.setText(""+(Integer.parseInt(puntero.totalj1.getText().toString())+suma));
                puntero.turno++;
                puntero.turnos.setText("Jugador 2");
            } else if (puntero.turno == 2) {
                puntero.t3j2.setText("" + suma);
                puntero.totalj2.setText(""+(Integer.parseInt(puntero.totalj2.getText().toString())+suma));
                puntero.turno++;
                puntero.turnos.setText("Jugador 3");
            } else if (puntero.turno == 3) {
                puntero.t3j3.setText("" + suma);
                puntero.totalj3.setText(""+(Integer.parseInt(puntero.totalj3.getText().toString())+suma));
                puntero.turno = 1;
                puntero.turnos.setText("Jugador 1");
                puntero.ronda++;
                puntero.rondas.setText("4");
            }
        } else if (puntero.ronda==4) {
            if (puntero.turno == 1) {
                puntero.t4j1.setText("" + suma);
                puntero.totalj1.setText(""+(Integer.parseInt(puntero.totalj1.getText().toString())+suma));
                puntero.turno++;
                puntero.turnos.setText("Jugador 2");
            } else if (puntero.turno == 2) {
                puntero.t4j2.setText("" + suma);
                puntero.totalj2.setText(""+(Integer.parseInt(puntero.totalj2.getText().toString())+suma));
                puntero.turno++;
                puntero.turnos.setText("Jugador 3");
            } else if (puntero.turno == 3) {
                puntero.t4j3.setText("" + suma);
                puntero.totalj3.setText(""+(Integer.parseInt(puntero.totalj3.getText().toString())+suma));
                ganador();
            }
        }
        puntero.iniciar.setClickable(true);
    }

    private void ganador() {
        int j1,j2,j3;
        String ganador;
        j1 = Integer.parseInt(puntero.totalj1.getText().toString());
        j2 = Integer.parseInt(puntero.totalj2.getText().toString());
        j3 = Integer.parseInt(puntero.totalj3.getText().toString());

        if (j1>j2){
            if (j1>j3) {
                ganador = "Jugador 1";
            }else ganador = "Jugador 3";
        }else if (j2>j3){
            ganador = "Jugador 2";
        } else ganador = "Jugador 3";

        mensaje(ganador);
    }

    private void mensaje(String ganador) {
        AlertDialog.Builder alert = new AlertDialog.Builder(puntero);
        alert.setTitle("¡Felicidades!")
                .setMessage("¡A Ganado el "+ganador+"! :)")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        puntero.t1j1.setText("0");
                        puntero.t2j1.setText("0");
                        puntero.t3j1.setText("0");
                        puntero.t4j1.setText("0");
                        puntero.totalj1.setText("0");

                        puntero.t1j2.setText("0");
                        puntero.t2j2.setText("0");
                        puntero.t3j2.setText("0");
                        puntero.t4j2.setText("0");
                        puntero.totalj2.setText("0");

                        puntero.t1j3.setText("0");
                        puntero.t2j3.setText("0");
                        puntero.t3j3.setText("0");
                        puntero.t4j3.setText("0");
                        puntero.totalj3.setText("0");

                        puntero.turno = 1;
                        puntero.turnos.setText("Jugador 1");
                        puntero.ronda=1;
                        puntero.rondas.setText("1");
                    }
                }).show();
    }
}
