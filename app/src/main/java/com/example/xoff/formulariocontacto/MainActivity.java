package com.example.xoff.formulariocontacto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editNombre;
    private DatePicker dpFecha;
    private EditText editTelefono;
    private EditText editEmail;
    private EditText editDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (getIntent().getExtras() != null) {

            Bundle parametros = getIntent().getExtras();

            String nombre = parametros.getString(getResources().getString(R.string.nombre));
            int year = parametros.getInt(getResources().getString(R.string.year));
            int month = parametros.getInt(getResources().getString(R.string.month));
            int day = parametros.getInt(getResources().getString(R.string.day));
            String telefono = parametros.getString(getResources().getString(R.string.telefono));
            String email = parametros.getString(getResources().getString(R.string.email));
            String descripcion = parametros.getString(getResources().getString(R.string.descripcion));

            editNombre = (EditText) findViewById(R.id.editNombre);
            editTelefono = (EditText) findViewById(R.id.editTelefono);
            editEmail = (EditText) findViewById(R.id.editEmail);
            editDescripcion = (EditText) findViewById(R.id.editDescripcion);
            dpFecha  = (DatePicker) findViewById(R.id.dpFecha);

            editNombre.setText(nombre);
            editTelefono.setText(telefono);
            editEmail.setText(email);
            editDescripcion.setText(descripcion);
            dpFecha.updateDate(year,month,day);


        }

    }

    public void confirmarDatos(View view) {


        editNombre      = (EditText) findViewById(R.id.editNombre);
        editTelefono    = (EditText) findViewById(R.id.editTelefono);
        editEmail       = (EditText) findViewById(R.id.editEmail);
        editDescripcion = (EditText) findViewById(R.id.editDescripcion);
        dpFecha         = (DatePicker) findViewById(R.id.dpFecha);

        int year        = dpFecha.getYear();
        int month       = dpFecha.getMonth();
        int day         = dpFecha.getDayOfMonth();


        // editFecha       = (DatePicker) findViewById(R.id.editFecha);

        Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class );

        intent.putExtra("Nombre",editNombre.getText().toString());
        intent.putExtra("Year",year);
        intent.putExtra("Month",month);
        intent.putExtra("Day",day);
        intent.putExtra("Telefono", editTelefono.getText().toString());
        intent.putExtra("Email", editEmail.getText().toString());
        intent.putExtra("Descripcion", editDescripcion.getText().toString());
        startActivity(intent);
        finish();


    };







}


