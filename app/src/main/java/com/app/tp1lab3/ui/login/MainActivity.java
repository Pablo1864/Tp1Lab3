package com.app.tp1lab3.ui.login;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.app.tp1lab3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private LoginActivityViewModel mv;
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  mv = new LoginActivityViewModel(getApplication());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginActivityViewModel.class);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

binding.btnIngresar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        mv.verificarUsuario(binding.etUsuario.getText().toString(), binding.etPass.getText().toString());
    }
});

    binding.btnRegistrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mv.registrarUsuario();
        }
    });
    }


}