package org.hcd.hcdproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void onButtonMyInfoClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity1.class);
        startActivity(intent);
    }

    public void onButtonChooseClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), ChooseActivity.class);
        startActivity(intent);
    }

    public void onButtonProgressClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), ProgressActivity.class);
        startActivity(intent);
    }

}
