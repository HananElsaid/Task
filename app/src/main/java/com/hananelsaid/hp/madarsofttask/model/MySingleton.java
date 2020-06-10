package com.hananelsaid.hp.madarsofttask.model;

import android.content.Context;

import androidx.room.Room;

import com.hananelsaid.hp.madarsofttask.model.roommodel.UserDataBase;

public class MySingleton  {
    private static MySingleton mInstance;
    private UserDataBase itemDB;
    private static Context mCtx;

    private MySingleton(Context context) {
        mCtx = context;
        itemDB = getDB();
    }

    public static synchronized MySingleton initializeDB(Context context) {
        if (mInstance == null) {
            mInstance = new MySingleton(context);
        }
        return mInstance;
    }

    public static MySingleton getInstance() {
        return mInstance;
    }

    public UserDataBase getDB() {
        if (itemDB == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            itemDB = Room.databaseBuilder(mCtx,
                    UserDataBase.class, "usersTable").fallbackToDestructiveMigration().build();
        }
        return itemDB;
    }
}
