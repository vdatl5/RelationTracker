package com.example.relationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class addPerson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        configureAddButton(); //add person functionality

        configureCancelButton(); //add the cancel button

    }

    private void configureAddButton(){
        final Button addPersonButton = (Button) findViewById(R.id.add_person);
        addPersonButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                EditText firstName = (EditText) findViewById(R.id.first_name);
                EditText lastName = (EditText) findViewById(R.id.last_name);

                int gender = 1;
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_gender);
                int selectedGender_Id = radioGroup.getCheckedRadioButtonId();

                RadioButton selectedGender = (RadioButton) findViewById(selectedGender_Id);

                if(selectedGender.getText() == "Male") {
                    gender = 1;
                }else if(selectedGender.getText() == "Female"){
                    gender = 0;
                }

                Person newPerson = new Person(firstName.getText().toString(), lastName.getText().toString(), gender);

                Toast.makeText(addPerson.this,
                        "Welcome " + newPerson.getFirstName(), Toast.LENGTH_SHORT).show();

            }    } );

    }

    private void configureCancelButton(){
        //get the button
        final Button cancelButton = (Button) findViewById(R.id.cancel_add_person);
        //on click, go back to Main Activity
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent backToMain = new Intent(addPerson.this, MainActivity.class);
                startActivity(backToMain);
            }
        });

    }


}
