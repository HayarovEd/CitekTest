package com.edurda77.citektest.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.edurda77.citektest.data.model.User;

@Dao
public interface CacheDao {
    @Insert (entity = User.class, onConflict = OnConflictStrategy.REPLACE)
    void addUser(User user);

}
