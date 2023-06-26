package com.example.dientesitosapp.Models;

public class Tratamiento {
    private int idtratamiento;
    private String nombre;
    private String descripcion;
    private int duracion;
    private double precio;

    public Tratamiento() {
    }

    public Tratamiento(int idtratamiento, String nombre, String descripcion, int duracion, double precio) {
        this.idtratamiento = idtratamiento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.precio = precio;
    }

    public int getIdtratamiento() {
        return idtratamiento;
    }

    public void setIdtratamiento(int idtratamiento) {
        this.idtratamiento = idtratamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
