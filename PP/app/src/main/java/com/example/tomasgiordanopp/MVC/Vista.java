package com.example.tomasgiordanopp.MVC;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.tomasgiordanopp.MainActivity;
import com.example.tomasgiordanopp.R;

public class Vista {

    Producto modelo;
    Activity activity;
    EditText edtNombre;
    EditText edtCantidad;
    EditText edtPrecio;
    Button btnGuardar;
    Controlador controlador;

    public Vista(Producto modelo, Activity activity) {
        this.modelo = modelo;
        this.activity = activity;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        this.cargarElementos();
    }

    public void cargarElementos(){
        this.edtNombre = activity.findViewById(R.id.edtNombre);
        this.edtCantidad = activity.findViewById(R.id.edtCantidad);
        this.edtPrecio = activity.findViewById(R.id.edtPrecio);
        this.btnGuardar = activity.findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(this.controlador);

        this.edtNombre.setText(modelo.getNombre());
        this.edtCantidad.setText(String.valueOf(modelo.getCantidad()));
        this.edtPrecio.setText(String.valueOf(modelo.getPrecio()));
    }

    public void cargarModelo(){
        this.modelo.setNombre(edtNombre.getText().toString());
        this.modelo.setCantidad(Integer.parseInt(edtCantidad.getText().toString()));
        this.modelo.setPrecio(Double.parseDouble(edtPrecio.getText().toString()));
    }

    public void mostrarModelo(){
        edtNombre.setText(this.modelo.getNombre());
        edtCantidad.setText(String.valueOf(this.modelo.getCantidad()));
        edtPrecio.setText(String.valueOf(this.modelo.getPrecio()));
    }

    public void returnToMain()
    {
        Intent main = new Intent(activity, MainActivity.class);
        activity.startActivity(main);
        activity.finish();
    }
}
