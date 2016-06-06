package com.example.xoff.formulariocontacto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;


public class ConfirmarDatos extends AppCompatActivity {

    private String nombre;
    private int year;
    private int month;
    private int day;
    private String telefono;
    private String email;
    private String descripcion;

    private EditText tvNombre;
    private EditText tvFecha;
    private EditText tvTelefono;
    private EditText tvEmail;
    private EditText tvDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);



        Bundle parametros = getIntent().getExtras();

        nombre = parametros.getString("Nombre");
        year = parametros.getInt("Year");
        month = parametros.getInt("Month") + 1;
        day = parametros.getInt("Day");
        telefono = parametros.getString("Telefono");
        email = parametros.getString("Email");
        descripcion = parametros.getString("Descripcion");



        tvNombre    = (EditText) findViewById(R.id.tvNombre);
        tvFecha    = (EditText) findViewById(R.id.tvFecha);
        tvTelefono    = (EditText) findViewById(R.id.tvTelefono);
        tvEmail    = (EditText) findViewById(R.id.tvEmail);
        tvDescripcion    = (EditText) findViewById(R.id.tvDescripcion);


        tvNombre.setText(nombre);
        String fecha = day  + "/" + month + "/" + year;
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);

        tvDescripcion.setText(descripcion);




    }

    public void volverMain(View view) {


        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(getResources().getString(R.string.nombre), nombre);
        intent.putExtra(getResources().getString(R.string.year), year);
        intent.putExtra(getResources().getString(R.string.month), month - 1);
        intent.putExtra(getResources().getString(R.string.day), day);
        intent.putExtra(getResources().getString(R.string.telefono), telefono);
        intent.putExtra(getResources().getString(R.string.email), email);
        intent.putExtra(getResources().getString(R.string.descripcion), descripcion);
        startActivity(intent);
        finish();
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

}



