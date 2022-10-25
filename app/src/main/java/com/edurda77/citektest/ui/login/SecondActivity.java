package com.edurda77.citektest.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Application;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.edurda77.citektest.data.db.CacheDao;
import com.edurda77.citektest.data.db.CacheDb;
import com.edurda77.citektest.data.db.RepositoryDb;
import com.edurda77.citektest.data.model.User;
import com.edurda77.citektest.data.model.Users;
import com.edurda77.citektest.databinding.ActivitySecondBinding;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;
    TextView successConnect;
    EditText password;
    Spinner spinner;
    SecondActivityViewModel secondActivityViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        secondActivityViewModel = new ViewModelProvider(this).get(SecondActivityViewModel.class);
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
                Runnable task = () -> secondActivityViewModel.addUser(it);
                Thread thread = new Thread(task);
                thread.start();
            }
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, nameUser);
            spinner.setAdapter(adapter);
            int count = arguments.getInt("count");
            successConnect.setText("Количество успешных попыток: "+ count);

        }

    }

}