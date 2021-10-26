package com.example.tomasgiordanopp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.tomasgiordanopp.MVC.Producto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductoAdapter.OnProductoListener,Handler.Callback {

    MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myApplication = (MyApplication) this.getApplication();

        Handler handler = new Handler(this);
        EjecutarHTTP miHilo = new EjecutarHTTP(handler);
        miHilo.start();
    }

    @Override
    public void onProductoClick(int position) {
        Intent editarProducto = new Intent(this,EditProductoActivity.class);

        editarProducto.putExtra("producto",(this.myApplication.getProductosList().get(position)));
        editarProducto.putExtra("position",position);

        startActivity(editarProducto);
        finish();
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        ArrayList<Producto> lista = (ArrayList<Producto>)  msg.obj;

        if(myApplication.getProductosList().isEmpty())
            myApplication.setProductosList(lista);

        ProductoAdapter productosAdapter = new ProductoAdapter(myApplication.getProductosList(),this);
        RecyclerView rv = super.findViewById(R.id.rv);
        rv.setAdapter(productosAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(linearLayoutManager);

        return false;
    }
}