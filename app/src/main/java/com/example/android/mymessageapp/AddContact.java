package com.example.android.mymessageapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class AddContact extends AppCompatActivity  {
    Button button;
    Context context;
    EditText edit;
    String MobilePattern = "[0-9]{10}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        button=(Button)findViewById(R.id.button2);

        edit=(EditText)findViewById(R.id.editText2);

    }


    public void Add(View view) {
        try {
            if(edit.getText().toString().matches(MobilePattern)) {

                String data = edit.getText().toString() + "\n";

                FileOutputStream fileOutputStream = openFileOutput("contacts.txt", MODE_APPEND);
                fileOutputStream.write(data.getBytes());
                fileOutputStream.close();

                Toast.makeText(getApplicationContext(), "Contact" + " saved",
                        Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"Please enter the 10 digit number",Toast.LENGTH_LONG).show();
            }

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}


