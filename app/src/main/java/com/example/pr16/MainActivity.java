package com.example.pr16;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pr16.R;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText inputName, inputSurname, inputPhone, inputEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.inputName);
        inputSurname = findViewById(R.id.inputSurname);
        inputPhone = findViewById(R.id.inputPhone);
        inputEmail = findViewById(R.id.inputEmail);

        Button saveButton = findViewById(R.id.save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveContact();
            }
        });
    }

    private void saveContact() {
        String name = inputName.getText().toString();
        String surname = inputSurname.getText().toString();
        String phone = inputPhone.getText().toString();
        String email = inputEmail.getText().toString();

        String contactInfo = name + ";" + surname + ";" + phone + ";" + email;

        try {
            FileOutputStream fileOutputStream = openFileOutput("contactes.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(contactInfo.getBytes());
            fileOutputStream.close();
            // Clear the input fields if needed
            inputName.setText("");
            inputSurname.setText("");
            inputPhone.setText("");
            inputEmail.setText("");
            // Notify the user that the data has been saved if desired
            Toast.makeText(this, "Contact saved successfully", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }
}