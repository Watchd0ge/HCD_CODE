package org.hcd.hcdproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.ViewToClickToExpand;
import it.gmariotti.cardslib.library.recyclerview.internal.CardArrayRecyclerViewAdapter;
import it.gmariotti.cardslib.library.recyclerview.view.CardRecyclerView;

public class MainActivity_choosehelper_cards extends AppCompatActivity {

    private Button confirm_btn;
    private ArrayList<Card> cards;
    private CardArrayRecyclerViewAdapter mCardArrayAdapter;
    private Boolean changeOrNot = false;
    private AlertDialog ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_choosehelper_cards);
        initViews();
    }

    private void initViews() {
        setButton();
        cards = new ArrayList<>();

        // Create a Card
        CustomCard card0 = new CustomCard(this, R.layout.inner_content);
        CustomCard card1 = new CustomCard(this, R.layout.inner_content1);
        CustomCard card2 = new CustomCard(this, R.layout.inner_content2);
        CustomCard card3 = new CustomCard(this, R.layout.inner_content3);
        CustomCard card4 = new CustomCard(this, R.layout.inner_content4);

        cards.add(card0);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);


        mCardArrayAdapter = new CardArrayRecyclerViewAdapter(this, cards);

        //Staggered grid view
        CardRecyclerView mRecyclerView = (CardRecyclerView) findViewById(R.id.list_cardId);
        mRecyclerView.setHasFixedSize(false);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);


        //Set the empty view
        if (mRecyclerView != null) {
            mRecyclerView.setAdapter(mCardArrayAdapter);
        }
    }

    private void setButton(){
        confirm_btn = (Button) findViewById(R.id.choice_confirm);
        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int x = 0; x < cards.size(); x++) {
                    if (((CustomCard) cards.get(x)).isSelected()) {
                        Log.wtf("card was :", "SELECTED");
                    } else {
                        Log.wtf("card was :", "NOT SELECTED");
                    }
                }
                runDialog();
            }
        });
    }

    private void runDialog(){
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Confirm Selection")
                .setMessage("Are you happy with your choices?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        changeOrNot = true;
                        Intent intent = new Intent(MainActivity_choosehelper_cards.this, MainActivity_waiting.class);
                        startActivity(intent);
                    }

                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        changeOrNot = false;
                    }

                })
                .show();
    }
}
