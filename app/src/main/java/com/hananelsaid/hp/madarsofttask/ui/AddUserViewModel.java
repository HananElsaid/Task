package com.hananelsaid.hp.madarsofttask.ui;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hananelsaid.hp.madarsofttask.model.MySingleton;
import com.hananelsaid.hp.madarsofttask.model.UserData;
import com.hananelsaid.hp.madarsofttask.model.roommodel.UserDao;
import com.hananelsaid.hp.madarsofttask.model.roommodel.UserDataBase;

import java.util.List;

public class AddUserViewModel extends ViewModel {
    Context context;
    UserDataBase userDataBase;


    public void getContext(Context context) {
        if (this.context == null)
            this.context = context;
        userDataBase = MySingleton.getInstance().getDB();
    }

    public void insertUserToDB(final UserData user) {

        Thread t = new Thread() {
            public void run() {

                userDataBase.getUserDao().insert(user);

            }
        };
        t.start();
        Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
    }


}
