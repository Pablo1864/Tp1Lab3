package com.app.tp1lab3.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.app.tp1lab3.modelo.Usuario;

public class ApiClient {

    private static SharedPreferences sp;

    private static SharedPreferences conectar(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences("datos", 0);
        }
        return sp;
    }

    public static void guardar(Context context, Usuario usuario) {
        SharedPreferences sp = conectar(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("dni", usuario.getDni());
        editor.putString("nombre", usuario.getNombre());
        editor.putString("apellido", usuario.getApellido());
        editor.putString("email", usuario.getEmail());
        editor.putString("password", usuario.getPassword());

        editor.commit();
    }

    public static Usuario leer(Context context) {
        SharedPreferences sp = conectar(context);
        long dni = sp.getLong("dni", 0);
        String nombre = sp.getString("nombre", "");
        String apellido = sp.getString("apellido", "");
        String email = sp.getString("email", "");
        String password = sp.getString("password", "");

        Usuario usuario = new Usuario(nombre, apellido, email, password, dni);
        return usuario;
    }

    public static Usuario login(Context context, String mail, String password) {
        Usuario usuario = null;
        SharedPreferences sp = conectar(context);
        Long dni = sp.getLong("dni", 0);
        String apellido = sp.getString("apellido", "");
        String nombre = sp.getString("nombre", "");
        String email = sp.getString("email", "");
        String pass = sp.getString("password", "");

        if (mail.equals(email) && password.equals(pass)) {
            usuario = new Usuario(nombre, apellido, email, pass, dni);
        }
        return usuario;

    }
}
