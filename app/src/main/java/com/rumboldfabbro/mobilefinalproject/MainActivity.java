package com.rumboldfabbro.mobilefinalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button profile, search, savedlist, about;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Database(this);

        db.insertCollege("Delaware College of Art and Design", "DE", "600 N. Market Street", 39.742097, -75.549831, "North", "N/A", 29167);
        db.insertCollege("Delaware State University", "DE", "1200 N. Dupont Highway", 39.187834, -75.541644, "North", "Division I: Mid-Eastern", 7532);
        db.insertCollege("Goldey-Beacom College", "DE", "4701 Limestone Road", 39.741787, -75.689544, "North", "N/A", 11700);
        db.insertCollege("University of Delaware", "DE", "175 The Green", 39.678776, -75.750611, "North", "Division I: Colonial Athletics Association", 11540);
        db.insertCollege("Wesley College", "DE", "120 N. State Street", 39.163501, -75.527760, "North", "Division III: Capital Athletics Conference", 25646);
        db.insertCollege("Wilmington University", "DE", "320 DuPont Highway", 39.682997, -75.586300, "North", "Division II: Central Athletics Collegiate Conference", 5310);

        profile = (Button) findViewById(R.id.menu_profile);
        search = (Button) findViewById(R.id.menu_search);
        savedlist = (Button) findViewById(R.id.menu_savedlist);
        about = (Button) findViewById(R.id.menu_about);

        profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //TODO activate ProfileActivity
            }
        });

        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //TODO activate SearchActivity
            }
        });

        savedlist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //TODO activate SavedListActivity
            }
        });

        about.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //TODO activate AboutActivity
            }
        });
    }
}
