package org.hcd.hcdproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity_myinfo1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_myinfo1);
    }

    public void onButtonMyInfoClicked(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity_myinfo.class);
        startActivity(intent);
    }

}
