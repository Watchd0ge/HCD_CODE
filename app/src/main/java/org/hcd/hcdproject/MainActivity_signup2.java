package org.hcd.hcdproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;

public class MainActivity_signup2 extends AppCompatActivity {

    private EditText et;
    private EditText addInfo;
    private Firebase myFirebaseRef;
    private String voucher_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signup2);
        voucher_number = getIntent().getStringExtra("VOUCHER_ID");
        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://hcd-firebase.firebaseio.com/");
        initView();
    }

    public void onButtonGotoMyInfoClicked(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity_signup1.class);
        intent.putExtra("VOUCHER_ID", et.getText().toString());
        startActivity(intent);
    }

    public void onButtonRegisterClicked(View v) {
        runDialog();
    }

    public void onButtonEnterClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity_signup1.class);
        intent.putExtra("VOUCHER_ID", et.getText().toString());
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
                        myFirebaseRef.child("Profiles").child(voucher_number).child("Description").setValue(addInfo.getText());
                        Intent intent = new Intent(MainActivity_signup2.this, MainActivity_login1.class);
                        intent.putExtra("VOUCHER_ID", voucher_number);
                        startActivity(intent);
                    }

                })
                .setPositiveButton("활동보조사 선택", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myFirebaseRef.child("Profiles").child(voucher_number).child("Description").setValue(addInfo.getText());
                        Intent intent = new Intent(MainActivity_signup2.this, MainActivity_choosehelper.class);
                        intent.putExtra("VOUCHER_ID", voucher_number);
                        startActivity(intent);
                    }

                })
                .show();
    }

    private void initView(){

        addInfo = (EditText) findViewById(R.id.addInfo);
        et = (EditText) findViewById(R.id.editText_voucherID);
        et.setText(voucher_number);
        et.setFocusable(false);
        myFirebaseRef.child("Profiles").child(voucher_number).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    HashMap hash = (HashMap) dataSnapshot.getValue();
                    addInfo.setText((String) hash.get("Description"));
                } else {
                    // DO NOTHING
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }
}
