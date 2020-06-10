package com.hananelsaid.hp.madarsofttask.model.roommodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.hananelsaid.hp.madarsofttask.model.UserData;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(UserData user);

    @Query("SELECT * FROM usersTable")
    LiveData<List<UserData>> getUsers();

    @Delete
    void delete(UserData user);


    @Update
    void updateUser(UserData user);
}

