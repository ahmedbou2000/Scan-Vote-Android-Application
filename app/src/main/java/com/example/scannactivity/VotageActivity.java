package com.example.scannactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class VotageActivity extends AppCompatActivity {

    Button btnEnregistrer,btnReturnScan, btnAffichVotes;
    RadioButton rdbA, radiobtnRef;
    EditText txtDescription;
    String txtChoix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votage);
        txtChoix ="Accepté";
        btnReturnScan = (Button)findViewById(R.id.btnReturnScan);
        btnEnregistrer =(Button)findViewById(R.id.btnEnregistrer);
        btnAffichVotes = (Button)findViewById(R.id.btnAffichVotes);
        radiobtnRef =(RadioButton) findViewById(R.id.radiobtnRef);
        txtDescription = (EditText) findViewById(R.id.txtDescription);
        rdbA = (RadioButton) findViewById(R.id.radiobtnAccp);
        Bundle b = getIntent().getExtras();
        String reference = b.getString("ref");




        rdbA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtChoix="Accepté";
            }
        });
        radiobtnRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtChoix="Refusé";
            }
        });

        btnReturnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VotageActivity.this, ScannerActivity.class);
                startActivity(i);
            }
        });

        // Passer vers la list des vote (Details):
        btnAffichVotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VotageActivity.this, Detail_VotesActivity.class);
                startActivity(i);
            }
        });

        btnEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = DatabaseHelper.getInctance(getApplicationContext()).getWritableDatabase();
                db.execSQL("INSERT INTO votes (ref, choix,description) VALUES (?,?,?)",
                        new String[]{
                                reference,
                                txtChoix.toString(),
                                txtDescription.getText().toString()
                        });
                txtDescription.setText(null);
                rdbA.setChecked(true);
                txtChoix="Accepté";
            }
        });


    }






}