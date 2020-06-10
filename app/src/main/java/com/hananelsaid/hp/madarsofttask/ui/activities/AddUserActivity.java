package com.hananelsaid.hp.madarsofttask.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;
import com.hananelsaid.hp.madarsofttask.R;
import com.hananelsaid.hp.madarsofttask.model.UserData;
import com.hananelsaid.hp.madarsofttask.ui.AddUserViewModel;

public class AddUserActivity extends AppCompatActivity {
    TextInputEditText etName, etAge, etJobTitle;
    Button btnAddUser, btnViewUsers;
    String name, age, jobTitle, gender;
    private RadioGroup radioBtnGender;
    private final static String TAG = "MainActivity";

    private int checkedGenderRadioButtonId = -1;
    //view model
    AddUserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Add User");
        setViewsObjects();
        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = etName.getText().toString().trim();
                age = etAge.getText().toString().trim();
                jobTitle = etJobTitle.getText().toString().trim();

                checkInputs();
                if (!name.isEmpty() && !age.isEmpty() && !jobTitle.isEmpty() && gender != null&&
                Integer.parseInt(age)>0 && Integer.parseInt(age)<=100) {
                    UserData user = new UserData(name, age, jobTitle, gender);
                    Log.i(TAG, "onClick: " + gender);
                    addUserToDB(user);
                    openViewUsers();
                }
            }
        });
        btnViewUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewUsers();

            }
        });

    }

    void openViewUsers() {
        Intent openViewUsers = new Intent(AddUserActivity.this, ViewUsersActivity.class);
        startActivity(openViewUsers);
        this.finish();
    }

    private void addUserToDB(UserData user) {
        viewModel.insertUserToDB(user);
    }

    void setViewsObjects() {
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etJobTitle = findViewById(R.id.etJobTitle);
        btnAddUser = findViewById(R.id.btn_AddUser);
        btnViewUsers = findViewById(R.id.btn_ViewUsers);
        radioBtnGender = findViewById(R.id.checkerButtonGender);
        //view model object
        viewModel = ViewModelProviders.of(this).get(AddUserViewModel.class);
        viewModel.getContext(AddUserActivity.this);

    }

    private void checkInputs() {

        if (name.isEmpty()) {
            etName.setError("Please enter the name");
            etName.requestFocus();
        }
        if (checkedGenderRadioButtonId == -1) {
            // radioBtnGender.setError("Please enter the name");
            radioBtnGender.requestFocus();
        }


        if (age.isEmpty()) {

            etAge.setError("Please enter the age");
            etAge.requestFocus();
        }

        if (Integer.parseInt(age)<=0 || Integer.parseInt(age)>100){
            etAge.setError("Please enter valid age from 1 to 100 year");
            etAge.requestFocus();
        }
        if (jobTitle.isEmpty()) {

            etJobTitle.setError("Please enter the job title");
            etJobTitle.requestFocus();
        }
        checkedGenderRadioButtonId = radioBtnGender.getCheckedRadioButtonId();
        Log.i(TAG, "onClick: " + checkedGenderRadioButtonId);
        switch (checkedGenderRadioButtonId) {
            case R.id.radioBtnMall:
                gender = "Mall";
                break;
            case R.id.radioBtnFemal:
                gender = "Femal";
                break;

        }

    }

}
