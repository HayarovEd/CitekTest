package com.edurda77.citektest.ui.login;

import android.app.Activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.edurda77.citektest.R;
import com.edurda77.citektest.data.model.Users;
import com.edurda77.citektest.data.retrofit.Repository;
import com.edurda77.citektest.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    //private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;
    Repository repository = new Repository();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        repository.getaData("http", "http1");

        //loginViewModel.getData("http", "http");

    }
}