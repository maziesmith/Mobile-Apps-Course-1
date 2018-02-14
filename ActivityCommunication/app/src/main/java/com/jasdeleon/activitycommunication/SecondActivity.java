package com.jasdeleon.activitycommunication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private EditText name;
    private EditText age;
    private EditText height;
    private Button registerButton;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        height = (EditText) findViewById(R.id.height);
        registerButton = (Button) findViewById(R.id.register_button);
        result = (TextView) findViewById(R.id.result);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                i.putExtra("name", name.getText().toString());
                i.putExtra("age", Integer.parseInt(String.valueOf(age.getText())));
                i.putExtra("height", Float.parseFloat(String.valueOf(height.getText())));
                startActivity(i);
            }
        });

    }

}
