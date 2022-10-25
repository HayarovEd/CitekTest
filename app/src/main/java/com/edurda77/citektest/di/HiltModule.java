package com.edurda77.citektest.di;

import android.app.Application;

import androidx.room.Room;

import com.edurda77.citektest.data.db.CacheDao;
import com.edurda77.citektest.data.db.CacheDb;
import com.edurda77.citektest.data.db.RepositoryDb;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
final  class HiltModule {

    @Provides
    static CacheDb provideDatabase(Application application) {
        return Room.databaseBuilder(application, CacheDb.class, "db")
                .build();
    }
    @Provides
    static CacheDao provideCacheDao (CacheDb db) {
        return db.cacheDao();
    }

    @Provides
    static RepositoryDb provideDb(CacheDao cacheDao) {
        return new RepositoryDb(cacheDao);
    }

}
