package com.talleresicesi.edwardfigueroa_semana9colorpicketxml;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Observable;
import java.util.Observer;
import contenido.Bolita;

public class MainActivity extends AppCompatActivity implements Observer{


    EditText posicionX;
    EditText posicionY;
    EditText diametro;
    EditText r;
    EditText g;
    EditText b;
    Button enviar;
    Comunicacion com;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posicionX = (EditText) findViewById(R.id.inputx);
        posicionY = (EditText) findViewById(R.id.inputy);
        diametro = (EditText) findViewById(R.id.inputdiam);
        r = (EditText) findViewById(R.id.r);
        g = (EditText) findViewById(R.id.g);
        b = (EditText) findViewById(R.id.b);
        enviar= (Button) findViewById(R.id.enviar);
        com.getInstance().addObserver(this);



    }

    public void enviar(View v){

        String posX = posicionX.getText().toString();
        String posY = posicionY.getText().toString();
        String tamano = diametro.getText().toString();
        String colorR= r.getText().toString();
        String colorG= g.getText().toString();
        String colorB= b.getText().toString();

        int x= Integer.parseInt(posX);
        int y= Integer.parseInt(posY);
        int diam= Integer.parseInt(tamano);
        int rr=Integer.parseInt(colorR);
        int gg= Integer.parseInt(colorG);
        int bb=Integer.parseInt(colorB);

        Bolita bol = new Bolita(x, y, diam, rr, gg, bb);



        com.getInstance().sendMessage(bol, com.getInstance().MULTI_GROUP_ADDRESS, com.getInstance().DEFAULT_PORT);

        //MyTask mk= new MyTask();
        //mk.execute(bol);




    }

    @Override
    public void update(Observable observable, Object o) {

    }


    private class MyTask extends AsyncTask<Bolita, Integer, String> {


        DatagramPacket packet;
        DatagramSocket soc;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();



        }

        private byte[] serializar(Object data) {
            byte[] bytes = null;
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(data);
                bytes = baos.toByteArray();

                // Close streams
                oos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return bytes;
        }


        @Override
        protected String doInBackground(Bolita... params) {


            return "this string is passed to onPostExecute";
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);


        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);


        }
    }


}
