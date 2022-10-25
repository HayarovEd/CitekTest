package com.edurda77.citektest.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.edurda77.citektest.data.model.User;
import com.edurda77.citektest.data.model.Users;
import com.edurda77.citektest.databinding.ActivityLoginBinding;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    LoginViewModel loginViewModel;
    TextView messageTv;
    EditText userEv, passwordEv;
    Button bLogin;
    ProgressBar progressBar;
    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        messageTv = binding.message;
        userEv = binding.username;
        passwordEv = binding.password;
        bLogin = binding.login;
        progressBar = binding.loading;

        loginViewModel.getProgress().observe(this, visibility -> progressBar.setVisibility(visibility));
        loginViewModel.getShowLoginResult().observe(this, s -> messageTv.setText(s));
        loginViewModel.getLoginResult().observe(this, data -> {
            Users users = data.getUsers();
            if (users!=null) {
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra(Users.class.getSimpleName(), users);
                startActivity(intent);
            }
        });

        bLogin.setOnClickListener(v -> loginViewModel.login(userEv.getText().toString(), passwordEv.getText().toString()));
    }
}