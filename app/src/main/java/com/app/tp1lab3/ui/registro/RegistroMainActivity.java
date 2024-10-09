package com.app.tp1lab3.ui.registro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.app.tp1lab3.R;
import com.app.tp1lab3.databinding.ActivityRegistroMainBinding;
import com.app.tp1lab3.ui.login.MainActivity;

public class RegistroMainActivity extends AppCompatActivity {
    private RegistroViewModel mv;
    private ActivityRegistroMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegistroMainBinding.inflate(getLayoutInflater());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroViewModel.class);
        setContentView(binding.getRoot());

        mv.getUsuarioM().observe(this, usuario -> {
            binding.etNombre.setText(usuario.getNombre());
            binding.etApellido.setText(usuario.getApellido());
            binding.etEmail.setText(usuario.getEmail());
            binding.etPass.setText(usuario.getPassword());
            binding.etDni.setText(String.valueOf(usuario.getDni()));
        });

        mv.getDatos(getIntent());

        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre, apellido, dni, email, password;
                nombre = binding.etNombre.getText().toString();
                apellido = binding.etApellido.getText().toString();
                dni = binding.etDni.getText().toString();
                email = binding.etEmail.getText().toString();
                password = binding.etPass.getText().toString();
                mv.registrar(nombre, apellido, dni, email, password);
            }
        });
    }
}

