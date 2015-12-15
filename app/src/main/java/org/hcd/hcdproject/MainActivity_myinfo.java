package org.hcd.hcdproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity_myinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_myinfo);
    }

    public void onButtonGotoAddInfoClicked(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity_myinfo1.class);
        startActivity(intent);
    }

}
