package com.edurda77.citektest.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NetworkData implements Serializable {
    @SerializedName("Users")
    Users users;

    public Users getUsers() {
        return users;
    }
}
