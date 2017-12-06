package com.example.khalessi.machtbarkeitintents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //nicht public, für soll für das Packet sichtbar sein
    static final String KEY_BOTSCHAFT = "botschaft";
    static final int REQ_CODE = 2305;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * Startet 2. Activity der App
     *
     * @param view Die auflösende View
     */
    public void onStartSecondClick(View view) {
        Intent it = new Intent(this, SecondActivity.class);

        //Auftrag  (Intent) erstellen
        //  Intent it = new Intent();
        //   it.setClass(this, SecondActivity.class);

        it.putExtra(KEY_BOTSCHAFT, "Heute ist Nikolaustag");
        //neue Activity
        startActivityForResult(it, REQ_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE && resultCode == SecondActivity.RESULT_OK) {

            Bundle bnd = data.getExtras();
            String resultString = bnd.getString(SecondActivity.SEC_BOTSCHAFT);


            TextView tv = (TextView) findViewById(R.id.result);
            tv.setText(resultString);

        }
    }
}
