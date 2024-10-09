package com.app.tp1lab3.modelo;

public class Usuario {
    private long dni;
    private String nombre;
    private String apellido;
    private String email;
    private String password;


    public Usuario(){

    }

    public Usuario(String nombre, String apellido, String email, String password, long dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public long getDni() {
        return dni;
    }
}
