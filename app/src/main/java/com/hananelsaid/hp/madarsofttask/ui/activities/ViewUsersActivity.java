package com.hananelsaid.hp.madarsofttask.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hananelsaid.hp.madarsofttask.R;
import com.hananelsaid.hp.madarsofttask.model.MySingleton;
import com.hananelsaid.hp.madarsofttask.model.UserData;
import com.hananelsaid.hp.madarsofttask.ui.UserAdapter;
import com.hananelsaid.hp.madarsofttask.ui.ViewUsersViewModel;

import java.util.List;

public class ViewUsersActivity extends AppCompatActivity {
    //rec
    private UserAdapter adapterClass;
    private RecyclerView recyclerView;

    //view model
    ViewUsersViewModel viewModel;
    private FloatingActionButton floatbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);
        setTitle("Users");
        MySingleton.initializeDB(getApplicationContext());
        recyclerView = findViewById(R.id.recyclerView);
        floatbtn = findViewById(R.id.floatbtn);
        viewModel = ViewModelProviders.of(this).get(ViewUsersViewModel.class);
        setAdapter();

        floatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddUser();
            }
        });


    }
    void openAddUser() {
        Intent openViewUsers = new Intent(ViewUsersActivity.this, AddUserActivity.class);
        startActivity(openViewUsers);
        this.finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.getDataFromRoom().observe(this, new Observer<List<UserData>>() {

            @Override
            public void onChanged(List<UserData> users) {
                adapterClass.setData(users);
                // Log.i("TAG", "onChanged: " + users.get(0).getAge());

            }
        });


    }

    private void setAdapter() {

        LinearLayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
        adapterClass = new UserAdapter();
        recyclerView.setAdapter(adapterClass);

    }

}
