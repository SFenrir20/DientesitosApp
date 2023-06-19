package com.example.dientesitosapp.Models;

public class Paciente {
    private int Id_paciente;
    private String documento;
    private String nombre;
    private String contrasena;

    public Paciente() {
    }

    public Paciente(int id_paciente, String documento, String nombre, String contrasena) {
        Id_paciente = id_paciente;
        this.documento = documento;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public int getId_paciente() {
        return Id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        Id_paciente = id_paciente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
