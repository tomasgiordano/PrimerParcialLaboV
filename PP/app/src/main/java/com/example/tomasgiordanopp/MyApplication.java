package com.example.tomasgiordanopp;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tomasgiordanopp.MVC.Producto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application  {
    private ArrayList<Producto> productosList = new ArrayList<Producto>();

    public MyApplication(){

    }

    public void fillListProductos()
    {
        Producto p0 = new Producto("Nombre1",1,20.0);
        Producto p1 = new Producto("Nombre2",1,20.0);
        Producto p2 = new Producto("Nombre3",1,20.0);
        Producto p3 = new Producto("Nombre4",1,20.0);
        Producto p4 = new Producto("Nombre5",1,20.0);
        Producto p5 = new Producto("Nombre6",1,20.0);
        Producto p6 = new Producto("Nombre7",1,20.0);
        Producto p7 = new Producto("Nombre8",1,20.0);
        Producto p8 = new Producto("Nombre9",1,20.0);
        Producto p9 = new Producto("Nombre10",1,20.0);

        productosList.addAll(Arrays.asList(new Producto[] { p0, p1, p2, p3, p4, p5, p6, p7, p8, p9}));
    }

    public void setProductosList(ArrayList<Producto> productos)
    {
        this.productosList = productos;
    }

    public ArrayList<Producto> getProductosList()
    {
        return productosList;
    }
}
