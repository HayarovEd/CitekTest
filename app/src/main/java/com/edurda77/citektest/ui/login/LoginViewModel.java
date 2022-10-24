package com.edurda77.citektest.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.edurda77.citektest.data.model.Users;
import com.edurda77.citektest.data.retrofit.Repository;

public class LoginViewModel extends ViewModel {
    private LiveData<Users> responseLiveData;
    Repository repository = new Repository();


    LiveData<Users> getData(String uid, String pass) {
        LiveData<Users> users = responseLiveData = repository.getaData(uid, pass);
        return users;
    }


}