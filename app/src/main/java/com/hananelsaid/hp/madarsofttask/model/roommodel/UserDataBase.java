package com.hananelsaid.hp.madarsofttask.model.roommodel;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.hananelsaid.hp.madarsofttask.model.UserData;

@Database(entities = {UserData.class}, version = 3)
public abstract class UserDataBase extends RoomDatabase {

   /* public static UserDataBase getDBInstance(Context context) {

        UserDataBase db = Room.databaseBuilder(context, UserDataBase.class, "usersTable")
                .fallbackToDestructiveMigration().build();
        return db;
    }*/

    public abstract UserDao getUserDao();
}
