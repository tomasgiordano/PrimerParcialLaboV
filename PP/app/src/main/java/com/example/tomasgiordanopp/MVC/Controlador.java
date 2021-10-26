package com.example.tomasgiordanopp.MVC;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Controlador implements View.OnClickListener{
    private Producto modelo;
    private Vista vista;
    private int Position;
    private ArrayList<Producto> ProductosList;

    public Controlador(Producto modelo,Vista vista,int position,ArrayList<Producto> productosList){
        this.modelo = modelo;
        this.vista = vista;
        this.Position = position;
        this.ProductosList = productosList;
    }

    @Override
    public void onClick(View view)
    {
        this.vista.cargarModelo();

        Log.d("Producto",this.modelo.toString());
        Toast.makeText(vista.activity,"Guardado", Toast.LENGTH_SHORT).show();
        this.ProductosList.set(Position,this.modelo);

        vista.returnToMain();
    }
}
