package org.hcd.hcdproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.firebase.client.Firebase;

public class MainActivity_signup extends AppCompatActivity {

    private Firebase myFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signup);

    }
    public void onButtonEnterClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity_signup1.class);
        startActivity(intent);
    }


}
