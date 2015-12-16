package org.hcd.hcdproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity_choosehelper extends AppCompatActivity {
    private CheckBox morning, afternoon, midnight;
    private CheckBox weekdays, weekends;
    private CheckBox Social, Households, Physical;
    private CheckBox need, noneed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_choosehelper);
        initView();
    }
    public void onButtonNextClicked(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity_choosehelper1.class);
        if(safeToProceed())
            startActivity(intent);
        else
            Toast.makeText(getApplicationContext(), "꼼꼼히 체크해주세요!", Toast.LENGTH_SHORT).show();
    }

    private boolean safeToProceed() {
        return (morning.isChecked() | afternoon.isChecked() | midnight.isChecked() )
                & (weekends.isChecked() | weekdays.isChecked())
                & (Social.isChecked() | Households.isChecked() | Physical.isChecked())
                & (need.isChecked() | noneed.isChecked());
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
        morning = (CheckBox) findViewById(R.id.morning);
        afternoon = (CheckBox) findViewById(R.id.afternoon);
        midnight = (CheckBox) findViewById(R.id.midnight);
        weekdays = (CheckBox) findViewById(R.id.weekdays);
        weekends = (CheckBox) findViewById(R.id.weekends);
        Social = (CheckBox) findViewById(R.id.social);
        Households = (CheckBox) findViewById(R.id.households);
        Physical = (CheckBox) findViewById(R.id.physical);
        need = (CheckBox) findViewById(R.id.needcar);
        noneed = (CheckBox) findViewById(R.id.noneedcar);

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
