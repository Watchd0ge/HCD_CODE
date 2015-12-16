package org.hcd.hcdproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity_signup extends AppCompatActivity {


    private EditText editText_voucherID;
    private Button sign_up_btn;
    private Firebase myFirebaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signup);
        // FIREBASE SETUP
        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://hcd-firebase.firebaseio.com/");
        initView();

    }

    private void initView(){
        editText_voucherID = (EditText) findViewById(R.id.editText_voucherID);
        sign_up_btn = (Button) findViewById(R.id.signup);
        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText_voucherID.getText().toString().matches("")) {
                    showError();
                } else {
                    myFirebaseRef.child("Profiles").child(editText_voucherID.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Log.wtf("IT WORKED", "[" + editText_voucherID.getText().toString() + "]");
                            if (dataSnapshot.exists()) {
                                Log.wtf("THERE IS SOMETHING", "WHOOP");
                                Intent intent = new Intent(MainActivity_signup.this, MainActivity_signup1.class);
                                intent.putExtra("VOUCHER_ID", editText_voucherID.getText().toString());
                                startActivity(intent);
                            } else {
                                showError();
                            }
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            showError();
                        }
                    });
                }
            }
        });

    }

    private void showError() {
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        editText_voucherID.setText("");
        editText_voucherID.startAnimation(shake);
        editText_voucherID.setError("바우처 ID가 유효하지 않습니다. 다시 시도해 주세요"); // KOREAN
    }
}
