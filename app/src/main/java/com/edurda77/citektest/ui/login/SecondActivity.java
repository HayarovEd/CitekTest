package com.edurda77.citektest.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.edurda77.citektest.databinding.ActivityLoginBinding;
import com.edurda77.citektest.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}