package org.hcd.hcdproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity_login extends AppCompatActivity {

    private Firebase myFirebaseRef;
//    private SQLiteDatabase localDB;
    private Button login_btn;
    private EditText voucher_id_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        // FIREBASE SETUP
        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://hcd-firebase.firebaseio.com/");

        // SQLITE SETUP
//        localDB = new DictionaryOpenHelper(this).getReadableDatabase();
        initViews();

    }

    public void onButtonEnterClicked(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity_login1.class);
        startActivity(intent);
    }

    private void initViews(){
        login_btn = (Button) findViewById(R.id.login_btn);
        voucher_id_txt = (EditText) findViewById(R.id.voucher_id);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (voucher_id_txt.getText().toString().matches("")) {
                    showError();
                } else {
                    myFirebaseRef.child("Profiles").child(voucher_id_txt.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Log.wtf("IT WORKED", "[" + voucher_id_txt.getText().toString() + "]");
                            if (dataSnapshot.exists()){
                                Log.wtf("THERE IS SOMETHING", "WHOOP");
//                                ContentValues temp = new ContentValues(1);
//                                temp.put("KEY", "voucher_id");
//                                temp.put("VALUE", voucher_id_txt.getText().toString());
//                                localDB.insert("dictionary", null, temp);
                                Intent intent = new Intent(MainActivity_login.this, MainActivity_login1.class);
                                intent.putExtra("VOUCHER_ID", voucher_id_txt.getText().toString());
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
        voucher_id_txt.setText("");
        voucher_id_txt.startAnimation(shake);
        voucher_id_txt.setError("Your voucher ID is incorrect."); // KOREAN
    }

}
