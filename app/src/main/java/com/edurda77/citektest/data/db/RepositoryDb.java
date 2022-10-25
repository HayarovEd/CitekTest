package com.edurda77.citektest.data.db;

import com.edurda77.citektest.data.model.User;

public class RepositoryDb implements CacheDao {

    private CacheDao cacheDao;



    @Override
    public void addUser(User user) {
        cacheDao.addUser(user);
    }
}
