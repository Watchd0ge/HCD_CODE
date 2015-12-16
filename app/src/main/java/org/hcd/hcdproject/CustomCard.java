package org.hcd.hcdproject;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by DOGE on 16/12/15.
 */
public class CustomCard extends Card {

    protected ImageButton profilePic;
    protected TextView nameSpace;
    protected TextView ageSpace;
    protected ImageView checkBtn;
    protected ImageButton experienceYears;
    protected ImageButton activity;
    protected ImageButton week;
    protected boolean checked = false;

    /**
     * Constructor with a custom inner layout
     * @param context
     */
    public CustomCard(Context context) {
        this(context, R.layout.inner_content);
        init();
    }

    /**
     *
     * @param context
     * @param innerLayout
     */
    public CustomCard(Context context, int innerLayout) {
        super(context, innerLayout);
        init();
    }

    /**
     * Init
     */
    private void init(){

        //No Header

        //Set a OnClickListener listener
        setOnClickListener(new OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(getContext(), "Click Listener card=", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        profilePic      = (ImageButton)     parent.findViewById(R.id.profile_picture);
        nameSpace       = (TextView)        parent.findViewById(R.id.name_space);
        ageSpace        = (TextView)        parent.findViewById(R.id.age_space);
        experienceYears = (ImageButton)     parent.findViewById(R.id.experience);
        activity        = (ImageButton)     parent.findViewById(R.id.activity);
        week            = (ImageButton)     parent.findViewById(R.id.week);
        checkBtn        = (ImageButton)     parent.findViewById(R.id.choice_check);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checked) {
                    checked = false;
                    checkBtn.setBackgroundResource(R.drawable.ic_checkbox_marked_circle_outline_black_48dp);
                } else {
                    checked = true;
                    checkBtn.setBackgroundResource(R.drawable.ic_checkbox_marked_circle_black_48dp);
                }

            }
        });


    }

    public void setName (){
        ageSpace.setText("LOL");
    }

    public boolean isSelected (){
        return checked;
    }
}
