package com.example.android.floorballmatchcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.floorballmatchcounter.R.id.team_a_face_off;
import static com.example.android.floorballmatchcounter.R.id.team_a_free_hit;
import static com.example.android.floorballmatchcounter.R.id.team_a_goal;
import static com.example.android.floorballmatchcounter.R.id.team_b_face_off;
import static com.example.android.floorballmatchcounter.R.id.team_b_free_hit;
import static com.example.android.floorballmatchcounter.R.id.team_b_goal;


public class MainActivity extends AppCompatActivity {

    //Stored scores in integers for both teams.
    static final String GOALA = "team_a_goal";
    static final String FREEHITA = "team_a_free_hit";
    static final String FACEOFFA = "team_a_face_off";
    static final String GOALB = "team_b_goal";
    static final String FREEHITB = "team_b_free_hit";
    static final String FACEOFFB = "team_b_face_off";
    //Tracks the scores (goal, free hit, face off) for Team A
    int goalTeamA = 0;
    int freeHitTeamA = 0;
    int faceOffTeamA = 0;
    //Tracks the scores (goal, free hit, face off) for Team B
    int goalTeamB = 0;
    int freeHitTeamB = 0;
    int faceOffTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Shows who is the actual winner team or is that a draw in a toast message on the screen.
     */

    public void updateWinningTeam() {
        // The following 2 lines get out the text from the edittext fields to use it for toasts.
        EditText teamA = (EditText)findViewById(R.id.team_a_name);
        EditText teamB = (EditText)findViewById(R.id.team_b_name);
        if (goalTeamA > goalTeamB) {
            Toast.makeText(this, getText(R.string.winner) + " " + teamA.getText().toString(), Toast.LENGTH_SHORT).show();
        } else if (goalTeamB > goalTeamA) {
            Toast.makeText(this, getText(R.string.winner) + " " + teamB.getText().toString(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.draw), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * @param savedInstanceState stores scores for both teams before application stops.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(GOALA, goalTeamA);
        savedInstanceState.putInt(FREEHITA, freeHitTeamA);
        savedInstanceState.putInt(FACEOFFA, faceOffTeamA);
        savedInstanceState.putInt(GOALB, goalTeamB);
        savedInstanceState.putInt(FREEHITB, freeHitTeamB);
        savedInstanceState.putInt(FACEOFFB, faceOffTeamB);
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Restore and display scores from savedInstanceState after application stopped.
     * For changing rotation between portrait and landscape mode.
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        goalTeamA = savedInstanceState.getInt(GOALA);
        freeHitTeamA = savedInstanceState.getInt(FREEHITA);
        faceOffTeamA = savedInstanceState.getInt(FACEOFFA);
        goalTeamB = savedInstanceState.getInt(GOALB);
        freeHitTeamB = savedInstanceState.getInt(FREEHITB);
        faceOffTeamB = savedInstanceState.getInt(FACEOFFB);
        displayGoalForTeamA(goalTeamA);
        displayFreeHitForTeamA(freeHitTeamA);
        displayFaceOffForTeamA(faceOffTeamA);
        displayGoalForTeamB(goalTeamB);
        displayFreeHitForTeamB(freeHitTeamB);
        displayFaceOffForTeamB(faceOffTeamB);
    }

    /**
     * Increase the goal score for Team A by 1 point.
     */
    public void addGoalForTeamA(View v) {
        goalTeamA = goalTeamA + 1;
        displayGoalForTeamA(goalTeamA);
        updateWinningTeam();
    }

    /**
     * Increase the free hit score for Team A by 1 point.
     */
    public void addFreeHitForTeamA(View v) {
        freeHitTeamA = freeHitTeamA + 1;
        displayFreeHitForTeamA(freeHitTeamA);
    }

    /**
     * Increase the face off score for Team A by 1 point.
     */
    public void addFaceOffForTeamA(View v) {
        faceOffTeamA = faceOffTeamA + 1;
        displayFaceOffForTeamA(faceOffTeamA);
    }

    /**
     * Increase the goal score for Team B by 1 point.
     */
    public void addGoalForTeamB(View v) {
        goalTeamB = goalTeamB + 1;
        displayGoalForTeamB(goalTeamB);
        updateWinningTeam();
    }

    /**
     * Increase the free hit score for Team B by 1 point.
     */
    public void addFreeHitForTeamB(View v) {
        freeHitTeamB = freeHitTeamB + 1;
        displayFreeHitForTeamB(freeHitTeamB);
    }

    /**
     * Increase the face off score for Team B by 1 point.
     */
    public void addFaceOffForTeamB(View v) {
        faceOffTeamB = faceOffTeamB + 1;
        displayFaceOffForTeamB(faceOffTeamB);
    }

    /**
     * Reset the scores for both teams back to 0 and status of winner team textview.
     */
    public void resetScores(View v) {
        goalTeamA = 0;
        freeHitTeamA = 0;
        faceOffTeamA = 0;
        goalTeamB = 0;
        freeHitTeamB = 0;
        faceOffTeamB = 0;

        displayGoalForTeamA(goalTeamA);
        displayFreeHitForTeamA(freeHitTeamA);
        displayFaceOffForTeamA(faceOffTeamA);
        displayGoalForTeamB(goalTeamB);
        displayFreeHitForTeamB(freeHitTeamB);
        displayFaceOffForTeamB(faceOffTeamB);
    }

    /**
     * Displays the goals for Team A.
     */
    public void displayGoalForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(team_a_goal);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the free hits for Team A.
     */
    public void displayFreeHitForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(team_a_free_hit);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the face offs for Team A.
     */
    public void displayFaceOffForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(team_a_face_off);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the goals for Team B.
     */
    public void displayGoalForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(team_b_goal);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the free hits for Team B.
     */
    public void displayFreeHitForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(team_b_free_hit);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the face offs for Team B.
     */
    public void displayFaceOffForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(team_b_face_off);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays rules under the button when it's clicked.
     */
    public void showRules(View v) {
        TextView rules = (TextView) findViewById(R.id.rulesText);
        rules.setText(R.string.rules);
        rules.setBackgroundColor(getResources().getColor(R.color.semiTransparentBackground));
    }
}
