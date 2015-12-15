package org.hcd.hcdproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_login1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login1);

        ImageButton main_myinfo = (ImageButton) findViewById(R.id.main_myinfo);
        Bitmap orgImage1 = BitmapFactory.decodeResource(getResources(), R.drawable.main_myinfo);
        Bitmap resize1 = Bitmap.createScaledBitmap(orgImage1, 330, 125, true);
        main_myinfo.setImageBitmap(resize1);

        ImageButton main_choose = (ImageButton) findViewById(R.id.main_choose);
        Bitmap orgImage2 = BitmapFactory.decodeResource(getResources(), R.drawable.main_choosehelper);
        Bitmap resize2 = Bitmap.createScaledBitmap(orgImage2, 440, 125, true);
        main_choose.setImageBitmap(resize2);

        ImageButton main_progress = (ImageButton) findViewById(R.id.main_progress);
        Bitmap orgImage3 = BitmapFactory.decodeResource(getResources(), R.drawable.main_progress);
        Bitmap resize3 = Bitmap.createScaledBitmap(orgImage3, 330, 125, true);
        main_progress.setImageBitmap(resize3);
    }

    public void onButtonMyInfoClicked(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity_myinfo.class);
        startActivity(intent);
    }

    public void onButtonChooseClicked(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity_choosehelper.class);
        startActivity(intent);
    }

    public void onButtonProgressClicked(View v){
        // referencing has to be implemented
        // for now, it is set true
        boolean matched = true;

        Intent waiting = new Intent(getApplicationContext(), MainActivity_waiting.class);
        Intent match = new Intent(getApplicationContext(), MainActivity_match.class);
        startActivity( matched? match : waiting);
    }


}
