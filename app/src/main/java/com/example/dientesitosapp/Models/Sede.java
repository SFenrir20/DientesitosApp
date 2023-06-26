package com.example.dientesitosapp.Models;

public class Sede {
    private int idsede;
    private String direccion;
    private String telefono;
    private String gerente;

    public Sede() {
    }

    public Sede(int idsede, String direccion, String telefono, String gerente) {
        this.idsede = idsede;
        this.direccion = direccion;
        this.telefono = telefono;
        this.gerente = gerente;
    }

    public int getIdsede() {
        return idsede;
    }

    public void setIdsede(int idsede) {
        this.idsede = idsede;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }
}
