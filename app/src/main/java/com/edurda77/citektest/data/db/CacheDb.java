package com.edurda77.citektest.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.edurda77.citektest.data.model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class CacheDb extends RoomDatabase {
    public abstract CacheDao cacheDao();

    /*private static volatile CacheDb INSTANCE;

    static CacheDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CacheDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    CacheDb.class, "cache_Db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }*/


}
