package com.example.contactsmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.example.contactsmanagerapp.databinding.ActivityAddNewContactBinding;

public class AddNewContactClickHandler {
    Contacts contact;
    Context context;
    MyViewModel viewModel;

    public AddNewContactClickHandler(Contacts contact, Context context, MyViewModel viewModel) {
        this.contact = contact;
        this.context = context;
        this.viewModel = viewModel; // passed from constructor because in order to be created you
                                    // need an Activity or Fragment
    }

    public void onSubmitClicked(View view){
         if(contact.getName() == null || contact.getEmail() == null){
             Toast.makeText(context,"Empty fields", Toast.LENGTH_SHORT).show();
         }else{
             Intent i = new Intent(context,MainActivity.class);
             Contacts newContact = new Contacts(contact.getName(), contact.getEmail());
             viewModel.addContact(newContact );
             context.startActivity(i);
         }
    }
}
