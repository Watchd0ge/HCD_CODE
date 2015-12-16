package org.hcd.hcdproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity_waiting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_waiting);
    }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), MainActivity_login1.class));
    }

    public void onClick(View v){
        startActivity(new Intent(getApplicationContext(), MainActivity_login1.class));
    }

}
