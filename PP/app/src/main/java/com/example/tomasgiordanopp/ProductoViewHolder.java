package com.example.tomasgiordanopp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

public class ProductoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView nombre;
    TextView cantidad;
    TextView precio;
    ProductoAdapter.OnProductoListener onProductoListener;

    public ProductoViewHolder(@NonNull View itemView, ProductoAdapter.OnProductoListener onProductoListener) {
        super(itemView);

        nombre = itemView.findViewById(R.id.tvNombre);
        cantidad = itemView.findViewById(R.id.tvCantidad);
        precio = itemView.findViewById(R.id.tvPrecio);

        this.onProductoListener = onProductoListener;
        //Click al objeto completo
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onProductoListener.onProductoClick(getAdapterPosition());
    }

}
