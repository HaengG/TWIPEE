package com.NSLB.TWIPEE.TripTalkView;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.NSLB.TWIPEE.R;


public class TripTalkDistribution extends AppCompatActivity {

    private TextView Seoul;
    private int PeopleN = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triptalkdistribution);
        setComp();
        getData(500);



    }

    private void setComp()
    {
        Seoul = (TextView)findViewById(R.id.Seoul_people);

    }

    private void getData(int people)
    {
        int PeopleN = 0;
        PeopleN = people;
        String PeopleInt= String.valueOf(PeopleN);
        Seoul.setText(PeopleInt);

    }

}
