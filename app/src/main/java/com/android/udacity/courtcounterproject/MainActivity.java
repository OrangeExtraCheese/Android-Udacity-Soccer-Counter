package com.android.udacity.courtcounterproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity
{
    int team = 0;
    int teamAscore = 0;
    int teamBscore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SwitchCompat switchTeam = (SwitchCompat) findViewById(R.id.switch_team);
        switchTeam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    team=1;
                } else
                    {
                    team=0;
                }
            }
        });

        if(savedInstanceState != null)
        {
            teamAscore = savedInstanceState.getInt("teamAscore");
            teamBscore = savedInstanceState.getInt("teamBscore");

            EditText edit1 = (EditText) findViewById(R.id.edit_text1);
            EditText edit2 = (EditText) findViewById(R.id.edit_text2);

            edit1.setText(savedInstanceState.getString("teamAname"));
            edit2.setText(savedInstanceState.getString("teamBname"));
        }

        displayTeamA(teamAscore);
        displayTeamB(teamBscore);
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("teamAscore", teamAscore);
        outState.putInt("teamBscore", teamBscore);

        EditText edit1 = (EditText) findViewById(R.id.edit_text1);
        EditText edit2 = (EditText) findViewById(R.id.edit_text2);
        outState.putString("teamAname", edit1.getText().toString());
        outState.putString("teamBname", edit2.getText().toString());
    }

    public void increaseScore(View view)
    {
        if(team==0)
        {
            teamAscore++;
            displayTeamA(teamAscore);
        }
        else
        {
            teamBscore++;
            displayTeamB(teamBscore);
        }
    }

    public void decreaseScore(View view)
    {

        if(team==0)
        {
            if(teamAscore>0)
            {
                teamAscore--;
                displayTeamA(teamAscore);
            }
        }
        else
        {
            if(teamBscore>0)
            {
                teamBscore--;
                displayTeamB(teamBscore);
            }
        }
    }

    public void resetScore(View view)
    {
        teamAscore = 0;
        teamBscore = 0;

        displayTeamA(teamAscore);
        displayTeamB(teamBscore);
    }

    public void displayTeamA(int teamAscore) {
        TextView scoreA = (TextView) findViewById(R.id.team_a_counter);
        scoreA.setText(""+ teamAscore);
    }

    public void displayTeamB(int teamBscore) {
        TextView scoreB = (TextView) findViewById(R.id.team_b_counter);
        scoreB.setText(""+ teamBscore);
    }
}