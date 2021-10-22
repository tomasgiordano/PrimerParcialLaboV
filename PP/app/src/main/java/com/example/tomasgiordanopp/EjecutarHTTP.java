package com.example.tomasgiordanopp;

import android.os.Message;

import com.example.tomasgiordanopp.MVC.Producto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class EjecutarHTTP extends Thread{
    public Handler handler;

    public EjecutarHTTP(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run(){
        ConexionHTTP con = new ConexionHTTP();

        String json = con.obtenerRespuesta("http://192.168.0.203:3000/productos");

        Message mensaje = new Message();
        try {
            mensaje.obj = generarListaString(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        this.handler.sendMessage(mensaje);
    }

    private List<Producto> generarListaString(String json) throws JSONException {
        List<Producto> productos = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);

        for(int i=0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);

            Producto producto = new Producto();

            producto.setNombre((object.getString("nombre")));
            producto.setCantidad((object.getInt("cantidad")));
            producto.setPrecio((object.getDouble("precio")));

            productos.add(producto);
        }
        return productos;
    }
}
