package com.edurda77.citektest.data.retrofit;

import com.edurda77.citektest.data.model.Users;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiCitek {
    @GET("hs/MobileClient/111111111111111/form/users")
    Call<Users> getUsers (@Header("Authorization") String autoHeader);
}
