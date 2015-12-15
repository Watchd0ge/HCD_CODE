package org.hcd.hcdproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


    public void onButtonEnterClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity1.class);
        startActivity(intent);
    }
    public void onButtonMineClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity1.class);
        startActivity(intent);
    }
    public void onButtonAddClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(intent);
    }

    public void onButtonCompleteClicked(View v) {
        Intent intent = new Intent(MainActivity2.this, Pop.class);
        startActivity(intent);
    }


}
