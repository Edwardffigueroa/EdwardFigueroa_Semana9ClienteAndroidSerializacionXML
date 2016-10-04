package com.talleresicesi.edwardfigueroa_semana9colorpicketxml;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Observable;
import java.util.Observer;
import contenido.Bolita;

public class MainActivity extends AppCompatActivity implements Observer{

    private int red, green, blue;


    EditText posicionX;
    EditText posicionY;
    EditText diametro;
    SeekBar r;
    SeekBar g;
    SeekBar b;
    Button enviar;
    Comunicacion com;
    private ImageView colorpik;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posicionX = (EditText) findViewById(R.id.inputx);
        posicionY = (EditText) findViewById(R.id.inputy);
        diametro = (EditText) findViewById(R.id.inputdiam);
        r = (SeekBar) findViewById(R.id.r);
        g = (SeekBar) findViewById(R.id.g);
        b = (SeekBar) findViewById(R.id.b);
        enviar= (Button) findViewById(R.id.enviar);
        com.getInstance().addObserver(this);
        colorpik = (ImageView) findViewById(R.id.color);

        r.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red = progress;
                colorpik.setBackgroundColor(Color.argb(255,red,green,blue));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        g.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green = progress;
                colorpik.setBackgroundColor(Color.argb(255,red,green,blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        b.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue = progress;
                colorpik.setBackgroundColor(Color.argb(255,red,green ,blue));


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

    public void enviar(View v){

        String posX = posicionX.getText().toString();
        String posY = posicionY.getText().toString();
        String tamano = diametro.getText().toString();


        int x= Integer.parseInt(posX);
        int y= Integer.parseInt(posY);
        int diam= Integer.parseInt(tamano);
        int rr=red;
        int gg= green;
        int bb=blue;

        Bolita bol = new Bolita(x, y, diam, rr, gg, bb);



        com.getInstance().sendMessage(bol, com.getInstance().MULTI_GROUP_ADDRESS, com.getInstance().DEFAULT_PORT);




    }

    @Override
    public void update(Observable observable, Object o) {

    }



}
