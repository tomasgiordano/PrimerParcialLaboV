package com.example.tomasgiordanopp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tomasgiordanopp.MVC.Producto;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoViewHolder> {

    List<Producto> productos;
    private ProductoAdapter.OnProductoListener onProductoListener;

    public ProductoAdapter(List<Producto> productos,OnProductoListener onProductoListener){
        this.productos = productos;
        this.onProductoListener = onProductoListener;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.producto,parent,false);
        return new ProductoViewHolder(v,onProductoListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto p = this.productos.get(position);

        holder.nombre.setText(p.getNombre());
        holder.cantidad.setText(String.valueOf(p.getCantidad()));
        holder.precio.setText(String.valueOf(p.getPrecio()));
    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }

    public interface OnProductoListener{
        void onProductoClick(int position);
    }
}
