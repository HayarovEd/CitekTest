package com.edurda77.citektest.ui.login;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.edurda77.citektest.data.model.NetworkData;
import com.edurda77.citektest.data.model.Users;
import com.edurda77.citektest.data.retrofit.Repository;

public class LoginViewModel extends ViewModel {
    Repository repository;

    MutableLiveData<Integer> mProgressMutableData = new MutableLiveData<>();
    MutableLiveData<NetworkData> mLoginResultMutableData = new MutableLiveData<>();
    MutableLiveData<String> mLoginShowMutableData = new MutableLiveData<>();
    MutableLiveData<Users> resultUserData = new MutableLiveData<>();

    public LoginViewModel() {
        mProgressMutableData.postValue(View.INVISIBLE);
        mLoginShowMutableData.postValue("Готов к коннекту");
        mLoginResultMutableData.postValue(null);
        repository = new Repository();
    }

    public void login(String userName, String userPassword){
        mProgressMutableData.postValue(View.VISIBLE);
        mLoginShowMutableData.postValue("Проверка");
        repository.loginRemote(userName, userPassword, new Repository.ILoginResponse() {
            @Override
            public void onResponse(NetworkData networkData) {
                mProgressMutableData.postValue(View.INVISIBLE);
                mLoginShowMutableData.postValue("Успешный коннект");
                mLoginResultMutableData.postValue(networkData);
            }

            @Override
            public void onFailure(Throwable t) {
                mProgressMutableData.postValue(View.INVISIBLE);
                mLoginShowMutableData.postValue("Login failure: " + t.getLocalizedMessage());
            }
        });
    }

    public LiveData<NetworkData> getLoginResult(){
        return mLoginResultMutableData;
    }

    public LiveData<String> getShowLoginResult(){
        return mLoginShowMutableData;
    }

    public LiveData<Integer> getProgress(){
        return mProgressMutableData;
    }

}