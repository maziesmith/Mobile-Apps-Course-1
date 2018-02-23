package com.jasdeleon.layoutsexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnRelativeLayoutOnClick(View v)
    {
        Intent intent = new Intent(this,EjemRelativeLayout.class);
        this.startActivity(intent);
    }

    public void btnLinearLayout1OnClick(View v)
    {
        Intent intent = new Intent(this,EjemLinearLayout1.class);
        this.startActivity(intent);
    }

    public void btnLinearLayout2OnClick(View v)
    {
        Intent intent = new Intent(this,EjemLinearLayout2.class);
        this.startActivity(intent);
    }

    public void btnTableLayoutOnClick(View v)
    {
        Intent intent = new Intent(this,EjemTableLayout.class);
        this.startActivity(intent);
    }

    public void btnGridLayoutOnClick(View v)
    {
        Intent intent = new Intent(this,EjemGridLayout.class);
        this.startActivity(intent);
    }

    public void btnFrameLayoutOnClick(View v)
    {
        Intent intent = new Intent(this,EjemFrameLayout.class);
        this.startActivity(intent);
    }

}
