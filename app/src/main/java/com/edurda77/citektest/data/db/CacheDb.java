package com.edurda77.citektest.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.edurda77.citektest.data.model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class CacheDb extends RoomDatabase {
    public abstract CacheDao cacheDao();
}
