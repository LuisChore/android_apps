package com.example.contactsmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.contactsmanagerapp.databinding.ActivityAddNewContactBinding;

public class AddNewContactActivity extends AppCompatActivity {
    private ActivityAddNewContactBinding binding;
    private AddNewContactClickHandler handler;
    private  Contacts contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);


        // View Model
        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        contact = new Contacts();
        binding = DataBindingUtil.setContentView(this,R.layout.activity_add_new_contact);
        binding.setContact(contact);

        handler = new AddNewContactClickHandler(contact,this,viewModel);
        binding.setClickHandler(handler);

    }
}