package org.hcd.hcdproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by user-11 on 2015-12-13.
 */
public class Pop extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pop);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout(  (int)(width*.8 ), (int)(height*.4 ) );
    }

    public void onButtonGotoHomeClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
    public void onButtonGotoChooseClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity_choosehelper.class);
        startActivity(intent);
    }
}
