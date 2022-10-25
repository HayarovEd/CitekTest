package com.edurda77.citektest.ui.login;

import androidx.lifecycle.ViewModel;

import com.edurda77.citektest.data.db.RepositoryDb;
import com.edurda77.citektest.data.model.User;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SecondActivityViewModel extends ViewModel {
    RepositoryDb repositoryDb;

    @Inject
    public SecondActivityViewModel(RepositoryDb repositoryDb) {
        this.repositoryDb = repositoryDb;
    }

    public void addUser (User user) {
        repositoryDb.addUser(user);
    }
}
