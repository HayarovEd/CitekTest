package com.edurda77.citektest.data.db;

import com.edurda77.citektest.data.model.User;

import javax.inject.Inject;

public class RepositoryDb implements CacheDao {

    private final CacheDao cacheDao;

    @Inject
    public RepositoryDb(CacheDao cacheDao) {
        this.cacheDao = cacheDao;
    }

    @Override
    public void addUser(User user) {
        cacheDao.addUser(user);
    }
}
