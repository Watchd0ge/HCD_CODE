package org.hcd.hcdproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity_signup1 extends AppCompatActivity {

    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signup1);

        String voucher_number = getIntent().getStringExtra("voucher_number");
        et = (EditText) findViewById(R.id.editText_voucherID);
        et.setText(voucher_number);
    }

    public void onButtonGotoAddInfoClicked(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity_signup2.class);
        intent.putExtra("voucher_number", et.getText().toString());
        startActivity(intent);
    }

    public void onButtonRegisterClicked(View v) {
        Intent intent = new Intent(MainActivity_signup1.this, Pop.class);
        startActivity(intent);
    }

    public void onButtonEnterClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity_signup1.class);
        intent.putExtra("voucher_number", et.getText().toString());
        startActivity(intent);
    }

}
