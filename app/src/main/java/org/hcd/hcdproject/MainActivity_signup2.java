package org.hcd.hcdproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity_signup2 extends AppCompatActivity {

    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signup2);

        String voucher_number = getIntent().getStringExtra("voucher_number");
        et = (EditText) findViewById(R.id.editText_voucherID);
        et.setText(voucher_number);
    }

    public void onButtonGotoMyInfoClicked(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity_signup1.class);
        intent.putExtra("voucher_number", et.getText().toString());
        startActivity(intent);
    }

    public void onButtonRegisterClicked(View v) {
        runDialog();
    }

    public void onButtonEnterClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity_signup1.class);
        intent.putExtra("voucher_number", et.getText().toString());
        startActivity(intent);
    }

    private void runDialog(){

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("등록 완료!")
                .setMessage("자신에게 맞는 활동보조사를 찾아보세요!")
                .setNegativeButton("홈 화면으로", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity_signup2.this, MainActivity_login1.class);
                        startActivity(intent);
                    }

                })
                .setPositiveButton("활동보조사 선택", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity_signup2.this, MainActivity_choosehelper.class);
                        startActivity(intent);
                    }

                })
                .show();
    }
}
