package org.hcd.hcdproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity_choosehelper extends AppCompatActivity {
//    private CheckBox need, noneed;
//    private CheckBox morning, afternoon, midnight;
//    private Che
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_choosehelper);
        initView();
    }
    public void onButtonNextClicked(View v){
        startActivity(new Intent(getApplicationContext(), MainActivity_choosehelper1.class));
    }


//    public void onMorningClicked(View v) {
//        RadioButton morning = (RadioButton) findViewById(R.id.morning);
////        morning.setChecked(!morning.toggle(););
//    }
//    public void onAfternoonClicked(View v) {
//        RadioButton afternoon = (RadioButton) findViewById(R.id.afternoon);
//        afternoon.setChecked( !afternoon.isChecked() );
//    }
//
    private void initView(){
        final CheckBox need = (CheckBox) findViewById(R.id.needcar);
        final CheckBox noneed = (CheckBox) findViewById(R.id.noneedcar);
        need.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(noneed.isChecked())
                    noneed.setChecked(false);
            }
        });
        noneed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(need.isChecked())
                    need.setChecked(false);
            }
        });
    }

}
