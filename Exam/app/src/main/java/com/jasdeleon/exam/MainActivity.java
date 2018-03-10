package com.jasdeleon.exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.userEditText);
        password = (EditText) findViewById(R.id.passwordEditText);
        Button access = (Button) findViewById(R.id.accessButton);

        access.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(String.valueOf(user.getText()).equals("usuario") && String.valueOf(password.getText()).equals("password")){
                    Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                    intent.putExtra("user", String.valueOf(user.getText()));
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,"usuario incorrect "+user.getText()+","+password.getText(),Toast.LENGTH_SHORT).show();}
            }
        });
    }
}
