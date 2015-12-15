package org.hcd.hcdproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Iterator;

public class MainActivity_login1 extends AppCompatActivity {

    private Firebase myFirebaseRef;

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

        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://hcd-firebase.firebaseio.com/");
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
        myFirebaseRef.child("CentreMatch").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.wtf("CHILDREN COUNT IS: ", Long.toString(dataSnapshot.getChildrenCount()));
                Iterator<DataSnapshot> ids = dataSnapshot.getChildren().iterator();
                DataSnapshot ds;

                Bundle extras = getIntent().getExtras();
                String tempString = null;
                if (extras != null){
                    tempString = extras.getString("VOUCHER_ID");
                }

                // SEARCH IF THE CENTRE HAS MADE A MATCH
                boolean match_found = false;
                for (ds = ids.next(); ids.hasNext(); ds = ids.next()){
                    if (ds.getKey().matches(tempString)){
                        match_found = true;
                        break;
                    }
                }
                if (ds.getKey().matches(tempString)){
                    match_found = true;
                }

                // SHOW APPROPRIATE SCREEN
                if (match_found == true){
                    Intent intent = new Intent(MainActivity_login1.this, MainActivity_match.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity_login1.this, MainActivity_waiting.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

}
