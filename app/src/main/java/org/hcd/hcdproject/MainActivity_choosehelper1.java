package org.hcd.hcdproject;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_choosehelper1 extends AppCompatActivity implements View.OnClickListener {

    private static final int DIALOG_BEGIN_DATE = 0;
    private static final int DIALOG_END_DATE = 1;

    private Button pickBeginDate;
    private Button pickEndDate;
    private TextView dash;

    private CheckBox longterm;
    private CheckBox shortterm;
    private boolean check_shortterm1 = false, check_shortterm2 = false;

    private DatePickerDialog.OnDateSetListener beginDateListener =
            new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    pickBeginDate.setText(year + "년 " + (monthOfYear + 1) + "월 " + dayOfMonth + "일");
                    check_shortterm1 = true;
                }
            };
    private DatePickerDialog.OnDateSetListener endDateListener =
            new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    pickEndDate.setText(year + "년 " + (monthOfYear + 1) + "월 " + dayOfMonth + "일");
                    check_shortterm2 = true;
                }
            };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_choosehelper1);

        pickBeginDate = (Button) findViewById(R.id.pickBeginDate);
        pickEndDate = (Button) findViewById(R.id.pickEndDate);
        dash = (TextView) findViewById(R.id.swungdash);
        pickBeginDate.setOnClickListener(this);
        pickEndDate.setOnClickListener(this);

        pickBeginDate.setVisibility(View.INVISIBLE);
        pickEndDate.setVisibility(View.INVISIBLE);
        dash.setVisibility(View.INVISIBLE);

        longterm = (CheckBox) findViewById(R.id.morning);
        shortterm = (CheckBox) findViewById(R.id.afternoon);
        initView();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.pickBeginDate:
                showDialog(DIALOG_BEGIN_DATE);
                break;
            case R.id.pickEndDate:
                showDialog(DIALOG_END_DATE);
                break;
        }
    }

    @Override
    protected Dialog onCreateDialog(int id){
        switch(id){
            case DIALOG_BEGIN_DATE:
                return new DatePickerDialog(this, beginDateListener, 2015, 11, 16);
            case DIALOG_END_DATE:
                return new DatePickerDialog(this, endDateListener, 2015, 11, 16);
        }
        return null;
    }


    private void initView(){
//        final CheckBox longterm = (CheckBox) findViewById(R.id.longterm);
//        final CheckBox shortterm = (CheckBox) findViewById(R.id.shortterm);
        longterm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shortterm.isChecked()) {
                    shortterm.setChecked(false);
                }
                pickBeginDate.setVisibility(View.INVISIBLE);
                pickEndDate.setVisibility(View.INVISIBLE);
                dash.setVisibility(View.INVISIBLE);
            }
        });
        shortterm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (longterm.isChecked()) {
                    longterm.setChecked(false);
                }
                pickBeginDate.setVisibility(View.VISIBLE);
                pickEndDate.setVisibility(View.VISIBLE);
                dash.setVisibility(View.VISIBLE);
            }
        });
    }

    public void onButtonCompleteClicked (View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity_choosehelper_cards.class);
        if(longterm.isChecked() | (shortterm.isChecked() & check_shortterm1 & check_shortterm2 ))
            startActivity(intent);
        else
            Toast.makeText(getApplicationContext(), "꼼꼼히 체크해주세요!", Toast.LENGTH_SHORT).show();
    }
    public void onButtonPrevClicked (View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity_choosehelper.class);
        startActivity(intent);
    }


}
