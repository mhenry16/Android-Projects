package prj1.csc214.prj1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_TEST = "mobappdev.project1.TEST";
    public static final String KEY_N = "mobappdev.project1.N";
    public static final String KEY_P1NAME = "mobappdev.project1.P1NAME";
    public static final String KEY_P1SCORE = "mobappdev.project1.P1SCORE";
    public static final String KEY_P2NAME = "mobappdev.project1.P2NAME";
    public static final String KEY_P2SCORE = "mobappdev.project1.P2SCORE";



    TextView p1Name;
    TextView p1Score;
    TextView p2Name;
    TextView p2Score;
    EditText p1NameChange;
    EditText p2NameChange;

    int p1CurrentScore = 0;
    int p2CurrentScore = 0;
    String p1CurrentName = "P1 Name";
    String p2CurrentName = "P2 Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1Name = findViewById(R.id.p1_name);
        p2Name = findViewById(R.id.p2_name);
        p1Score = findViewById(R.id.p1_score);
        p2Score = findViewById(R.id.p2_score);
        p1NameChange = findViewById(R.id.change_name1);
        p2NameChange = findViewById(R.id.change_name2);

    }

    public void changeP1Name(View view) {
        p1CurrentName = p1NameChange.getText().toString();
        p1Name.setText(p1CurrentName);
    }

    public void changeP2Name(View view) {
        p2CurrentName = p2NameChange.getText().toString();
        p2Name.setText(p2CurrentName);
    }

    public void startGame1(View view) {
        Intent intent = new Intent(MainActivity.this, HotColdActivity.class);
        intent.putExtra(KEY_P1SCORE, p1CurrentScore);
        intent.putExtra(KEY_P1NAME, p1CurrentName);
        intent.putExtra(KEY_P2SCORE, p2CurrentScore);
        intent.putExtra(KEY_P2NAME, p2CurrentName);
        startActivityForResult(intent, 1);
        Log.i("Main", "after return");
    }

    public void startGame2(View view) {
        Intent intent = new Intent(MainActivity.this, HangmanActivity.class);
        intent.putExtra(KEY_P1SCORE, p1CurrentScore);
        intent.putExtra(KEY_P1NAME, p1CurrentName);
        intent.putExtra(KEY_P2SCORE, p2CurrentScore);
        intent.putExtra(KEY_P2NAME, p2CurrentName);
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("Main", "in the end");
        if (requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                p1CurrentScore = data.getIntExtra(KEY_P1SCORE, 0);
                p1Score.setText(Integer.toString(p1CurrentScore));
                p2CurrentScore = data.getIntExtra(KEY_P2SCORE, 0);
                p2Score.setText(Integer.toString(p2CurrentScore));
            }
        }
        else if (requestCode == 2){
            if(resultCode == Activity.RESULT_OK){
                p1CurrentScore = data.getIntExtra(KEY_P1SCORE, 0);
                p1Score.setText(Integer.toString(p1CurrentScore));
                p2CurrentScore = data.getIntExtra(KEY_P2SCORE, 0);
                p2Score.setText(Integer.toString(p2CurrentScore));
            }
        }
    }
}
