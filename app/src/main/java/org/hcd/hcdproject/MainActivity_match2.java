package org.hcd.hcdproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class MainActivity_match2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_match2);

        ImageView allinone = (ImageView) findViewById(R.id.matched_allinone);
        Bitmap orgImage = BitmapFactory.decodeResource(getResources(), R.drawable.matched_allinone);
        Bitmap resize = Bitmap.createScaledBitmap(orgImage, 1000, 3000, true);
        allinone.setImageBitmap(resize);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .8));
    }

}
