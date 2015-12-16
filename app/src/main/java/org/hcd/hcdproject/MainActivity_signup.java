package org.hcd.hcdproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class MainActivity_signup extends AppCompatActivity {


    private EditText tv;
    private Firebase myFirebaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signup);
        tv  = (EditText) findViewById(R.id.editText_voucherID);
    }
    public void onButtonEnterClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity_signup1.class);
        intent.putExtra("voucher_number", tv.getText().toString());
        startActivity(intent);
    }


}
