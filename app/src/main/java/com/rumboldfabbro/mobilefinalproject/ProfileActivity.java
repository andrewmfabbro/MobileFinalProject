package com.rumboldfabbro.mobilefinalproject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by erikarumbold on 12/3/16.
 */

public class ProfileActivity extends Activity {
    private EditText name, school;
    private Spinner major;
    private Button saved_list;
    private SharedPreferences.Editor myEd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = (EditText) findViewById(R.id.profile_name);
        school = (EditText) findViewById(R.id.profile_school);
        major = (Spinner) findViewById(R.id.profile_major);
        saved_list = (Button) findViewById(R.id.profile_savedlist);
        final SharedPreferences userPref = getApplicationContext().getSharedPreferences("MyPreferences", MODE_PRIVATE);


        loadSpinnerData();

        myEd = userPref.edit();

        name.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                //TODO change user's name in saved preferences
                myEd.putString("name", name.getText().toString());
            }
        });

        school.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                //TODO change user's high school in saved preferences
                myEd.putString("school", school.getText().toString());
            }
        });

        saved_list.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //TODO activate AboutActivity
                //save list to preferences
                myEd.commit();

            }
        });
    }



    public void loadSpinnerData() {
        Database db = new Database(getApplicationContext());
        ArrayList<String> majors = db.listMajors();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, majors);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        major.setAdapter(adapter);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        String major = parent.getItemAtPosition(position).toString();
        //TODO change user's intended major in saved preferences

        //what do we use to get a string from the spinner?
        myEd.putString("major", major);

    }

}
