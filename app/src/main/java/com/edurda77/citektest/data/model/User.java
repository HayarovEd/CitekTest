package com.edurda77.citektest.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


@Entity(tableName = "cache_user")
public class User implements Serializable {
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (defaultValue = "id")
    private Integer id;
    @ColumnInfo (defaultValue = "user")
    @SerializedName("User")
    private String userName;
    @SerializedName("Uid")
    @ColumnInfo (defaultValue = "uid")
    private String userUid;
    @SerializedName("Language")
    @ColumnInfo (defaultValue = "language")
    private String userLanguage;

    public User(String userName, String userUid, String userLanguage) {
        this.userName = userName;
        this.userUid = userUid;
        this.userLanguage = userLanguage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getUserLanguage() {
        return userLanguage;
    }

    public void setUserLanguage(String userLanguage) {
        this.userLanguage = userLanguage;
    }
}
