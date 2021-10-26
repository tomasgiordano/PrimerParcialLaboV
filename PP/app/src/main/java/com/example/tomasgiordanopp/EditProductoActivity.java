package com.example.tomasgiordanopp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tomasgiordanopp.MVC.Controlador;
import com.example.tomasgiordanopp.MVC.Producto;
import com.example.tomasgiordanopp.MVC.Vista;

import java.util.ArrayList;

public class EditProductoActivity extends AppCompatActivity {

    Producto modelo;
    MyApplication myApplication;
    Vista vista;
    Controlador controlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_producto);

        this.modelo = getIntent().getParcelableExtra("producto");
        int position = getIntent().getIntExtra("position",-1);

        myApplication = (MyApplication) this.getApplication();
        ArrayList<Producto> productosList = myApplication.getProductosList();

        vista = new Vista(modelo,this);
        controlador = new Controlador(modelo,vista,position,productosList);

        vista.setControlador(controlador);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        vista.returnToMain();
        return super.onOptionsItemSelected(item);
    }

}