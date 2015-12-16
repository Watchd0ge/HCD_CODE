package org.hcd.hcdproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

//        int width = 510;
//        int height = 185;
//
//        ImageView mainimg02 = (ImageView) findViewById(R.id.mainimg02);
//        Bitmap orgImage0 = BitmapFactory.decodeResource(getResources(), R.drawable.mainimg02);
//        Bitmap resize0 = Bitmap.createScaledBitmap(orgImage0, 300, 300, true);
//        mainimg02.setImageBitmap(resize0);
//
//        ImageButton userlogin = (ImageButton) findViewById(R.id.userlogin);
//        Bitmap orgImage1 = BitmapFactory.decodeResource(getResources(), R.drawable.login_red);
//        Bitmap resize1 = Bitmap.createScaledBitmap(orgImage1, width, height, true);
//        userlogin.setImageBitmap(resize1);
//
//        ImageButton helperlogin = (ImageButton) findViewById(R.id.helperlogin);
//        Bitmap orgImage2 = BitmapFactory.decodeResource(getResources(), R.drawable.login_blue);
//        Bitmap resize2 = Bitmap.createScaledBitmap(orgImage2, width, height, true);
//        helperlogin.setImageBitmap(resize2);
//
//        ImageButton usersignup = (ImageButton) findViewById(R.id.usersignup);
//        Bitmap orgImage3 = BitmapFactory.decodeResource(getResources(), R.drawable.signup_red);
//        Bitmap resize3 = Bitmap.createScaledBitmap(orgImage3, width, height, true);
//        usersignup.setImageBitmap(resize3);
//
//        ImageButton helpersignup = (ImageButton) findViewById(R.id.helpersignup);
//        Bitmap orgImage4 = BitmapFactory.decodeResource(getResources(), R.drawable.signup_blue);
//        Bitmap resize4 = Bitmap.createScaledBitmap(orgImage4, width, height, true);
//        helpersignup.setImageBitmap(resize4);
    }

    public void onButtonUserLoginClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity_login.class);
        startActivity(intent);
    }
    public void onButtonHelperLoginClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity_signup.class);
        startActivity(intent);
    }
    public void onButtonUserSignupClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity_signup.class);
        startActivity(intent);
    }
    public void onButtonHelperSignupClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity_signup.class);
        startActivity(intent);
    }

    private void initViews(){
        Button card_btn = (Button) findViewById(R.id.button2);
        card_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity_choosehelper_cards.class);
                startActivity(intent);
            }
        });

    }

}
