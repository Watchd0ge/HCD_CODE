package org.hcd.hcdproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ChooseActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose1);
    }

    public void onButtonPreviousClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), ChooseActivity.class);
        startActivity(intent);
    }

    public void onButtonNextClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), ChooseActivity2.class);
        startActivity(intent);
    }

}
