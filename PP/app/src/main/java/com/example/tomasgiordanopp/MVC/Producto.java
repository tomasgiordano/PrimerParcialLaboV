package com.example.tomasgiordanopp.MVC;

import android.os.Parcel;
import android.os.Parcelable;

public class Producto implements Parcelable {
    private String Nombre;
    private int Cantidad;
    private double Precio;

    public Producto()
    {

    }

    public Producto(String nombre, int cantidad, double precio) {
        Nombre = nombre;
        Cantidad = cantidad;
        Precio = precio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    protected Producto(Parcel parcel) {
        Nombre = parcel.readString();
        Cantidad = parcel.readInt();
        Precio = parcel.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Nombre);
        parcel.writeInt(Cantidad);
        parcel.writeDouble(Precio);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Producto> CREATOR = new Parcelable.Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel parcel) {
            return new Producto(parcel);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };
}
