package com.edurda77.citektest.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.edurda77.citektest.data.model.User;

import java.util.List;

@Dao
public interface CacheDao {
    @Insert (entity = User.class, onConflict = OnConflictStrategy.REPLACE)
    void addUser(User user);
    @Query("SELECT * FROM cache_user")
    List<User> getUsers();

}
