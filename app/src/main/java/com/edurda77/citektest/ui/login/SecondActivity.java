package com.edurda77.citektest.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.edurda77.citektest.data.model.User;
import com.edurda77.citektest.data.model.Users;
import com.edurda77.citektest.databinding.ActivityLoginBinding;
import com.edurda77.citektest.databinding.ActivitySecondBinding;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;
    TextView successConnect;
    EditText password;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        successConnect = binding.success;
        password = binding.password;
        spinner = binding.dataSp;


        Bundle arguments = getIntent().getExtras();
        Users users;

        if(arguments!=null){
            users = (Users) arguments.getSerializable(Users.class.getSimpleName());
            List<User> dataUser = users.getUsers();
            List<String> nameUser = new ArrayList<>();
            for (User it: dataUser) {
                nameUser.add(it.getUserName());
            }
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, nameUser);
            spinner.setAdapter(adapter);
            int count = arguments.getInt("count");
            successConnect.setText("Количество успешных попыток: "+ count);
        }

    }

}