package com.example.dientesitosapp.Models;

public class Doctor {
    private int iddoctor;
    private String dni;
    private String especialidad;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String numeroColegioMedico;
    private String constrasena;

    public Doctor() {
    }

    public Doctor(int iddoctor, String dni, String especialidad, String nombre, String apellidoPaterno, String apellidoMaterno, String numeroColegioMedico, String constrasena) {
        this.iddoctor = iddoctor;
        this.dni = dni;
        this.especialidad = especialidad;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numeroColegioMedico = numeroColegioMedico;
        this.constrasena = constrasena;
    }

    public int getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(int iddoctor) {
        this.iddoctor = iddoctor;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNumeroColegioMedico() {
        return numeroColegioMedico;
    }

    public void setNumeroColegioMedico(String numeroColegioMedico) {
        this.numeroColegioMedico = numeroColegioMedico;
    }

    public String getConstrasena() {
        return constrasena;
    }

    public void setConstrasena(String constrasena) {
        this.constrasena = constrasena;
    }
}
