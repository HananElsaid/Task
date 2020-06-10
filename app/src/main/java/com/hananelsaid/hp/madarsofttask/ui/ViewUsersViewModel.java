package com.hananelsaid.hp.madarsofttask.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hananelsaid.hp.madarsofttask.model.MySingleton;
import com.hananelsaid.hp.madarsofttask.model.UserData;
import com.hananelsaid.hp.madarsofttask.model.roommodel.UserDataBase;

import java.util.List;

public class ViewUsersViewModel extends ViewModel {

    UserDataBase userDataBase;
    public LiveData<List<UserData>> userLiveData = new MutableLiveData<List<UserData>>();



   public LiveData<List<UserData>> getDataFromRoom() {
       userDataBase = MySingleton.getInstance().getDB();
        userLiveData=  userDataBase.getUserDao().getUsers();
        return userLiveData;

    }



}
