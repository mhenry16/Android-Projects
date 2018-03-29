package prj1.csc214.prj1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static prj1.csc214.prj1.MainActivity.KEY_P1NAME;
import static prj1.csc214.prj1.MainActivity.KEY_P1SCORE;
import static prj1.csc214.prj1.MainActivity.KEY_P2NAME;
import static prj1.csc214.prj1.MainActivity.KEY_P2SCORE;

public class HotColdActivity extends AppCompatActivity {

    TextView p1Name;
    TextView p2Name;
    TextView p1Score;
    TextView p2Score;
    TextView p1NumGuess;
    TextView p2NumGuess;
    EditText p1GuessBox;
    EditText p2GuessBox;
    Button p1GuessButton;
    Button p2GuessButton;
    Button endButton;
    Button goBack;
    HotColdController theController;
    Intent returnIntent;
    int s1;
    int s2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_cold);

        theController = new HotColdController();

        p1Name = findViewById(R.id.p1_name_hc);
        p1Score = findViewById(R.id.p1_score_hc);
        p2Name = findViewById(R.id.p2_name_hc);
        p2Score = findViewById(R.id.p2_score_hc);
        p1NumGuess = findViewById(R.id.numGuessP1);
        p2NumGuess = findViewById(R.id.numGuessP2);
        p1GuessButton = findViewById(R.id.p1_guess_button);
        p2GuessButton = findViewById(R.id.p2_guess_button);
        p1GuessBox = findViewById(R.id.p1_guess_box);
        p2GuessBox = findViewById(R.id.p2_guess_box);
//        endButton = findViewById(R.id.go_back);
        goBack = findViewById(R.id.back_to_home);


        Intent intent = getIntent();
        p1Name.setText(intent.getStringExtra(KEY_P1NAME).toString());
        p1Score.setText(Integer.toString(intent.getIntExtra(KEY_P1SCORE, 0)));
        p2Name.setText(intent.getStringExtra(KEY_P2NAME).toString());
        p2Score.setText(Integer.toString(intent.getIntExtra(KEY_P2SCORE, 0)));

        theController.setScores(intent.getIntExtra(KEY_P1SCORE, 0), intent.getIntExtra(KEY_P2SCORE, 0));

    }

    public void p1Guess(View view) {
        if(p1GuessBox.getText().toString().matches("")){
            Toast.makeText(HotColdActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
            return;
        }
        String popUp = theController.updateGuess(Integer.parseInt(p1GuessBox.getText().toString()), 0, p1NumGuess, p1GuessBox,  p1GuessButton);
        Toast.makeText(HotColdActivity.this, popUp, Toast.LENGTH_SHORT).show();
        theController.isOver(p1GuessBox, p2GuessBox, view);
    }

    public void p2Guess(View view) {
        if(p2GuessBox.getText().toString().matches("")){
            Toast.makeText(HotColdActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
            return;
        }
        String popUp = theController.updateGuess(Integer.parseInt(p2GuessBox.getText().toString()), 1, p2NumGuess, p2GuessBox, p2GuessButton);
        Toast.makeText(HotColdActivity.this, popUp, Toast.LENGTH_SHORT).show();
        theController.isOver(p1GuessBox, p2GuessBox, view);
    }

    public void endsTheActivity(int s1, int s2, int winner, View view){
        this.s1=s1;
        this.s2=s2;
        Log.i("HC", Integer.toString(this.s1) + "s1");
        Log.i("HC", Integer.toString(this.s2) + "s2");
    }

    public void returnToHome(View view) {
        Intent returnIntent = new Intent();
        Log.i("HC", Integer.toString(theController.getP2CurScore()) + "s2");
        returnIntent.putExtra(KEY_P1SCORE, theController.getP1CurScore());
        returnIntent.putExtra(KEY_P2SCORE, theController.getP2CurScore());
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
