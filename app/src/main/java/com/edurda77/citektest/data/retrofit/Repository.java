package com.edurda77.citektest.data.retrofit;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.edurda77.citektest.data.model.Users;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private static final String BASE_URL = "https://dev.sitec24.ru/UKA_TRADE/";
    MutableLiveData<Users> data = new MutableLiveData<>();
    OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
    private ApiCitek apiCitek () {


        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(ApiCitek.class);
    }

    public LiveData<Users> getaData(String uid, String pass) {

        String autoHeader = Credentials.basic(uid, pass);
        apiCitek().getUsers(autoHeader).enqueue(new Callback<Users>() {
            @Override
            public void onResponse(@NonNull Call<Users> call, @NonNull Response<Users> response) {
                if (response.body() != null) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Users> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

}
