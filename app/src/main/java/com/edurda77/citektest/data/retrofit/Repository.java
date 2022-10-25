package com.edurda77.citektest.data.retrofit;

import androidx.lifecycle.MutableLiveData;

import com.edurda77.citektest.data.model.NetworkData;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private static final String BASE_URL = "https://dev.sitec24.ru/UKA_TRADE/";
    MutableLiveData<NetworkData> data = new MutableLiveData<>();
    OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
    private ApiCitek apiCitek () {


        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(ApiCitek.class);
    }

    public void loginRemote(String uid, String pass, ILoginResponse loginResponse){
        String autoHeader = Credentials.basic(uid, pass);
        Call<NetworkData> initiateLogin = apiCitek().getUsers(autoHeader);


        initiateLogin.enqueue(new Callback<NetworkData>() {
            @Override
            public void onResponse(Call<NetworkData> call, Response<NetworkData> response) {
                if (response.isSuccessful()){
                    loginResponse.onResponse(response.body());
                } else {
                    assert response.errorBody() != null;
                    loginResponse.onFailure(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<NetworkData> call, Throwable t) {
                loginResponse.onFailure(t);
            }
        });

    }


    public interface ILoginResponse{
        void onResponse(NetworkData networkData);
        void onFailure(Throwable t);
    }
}
