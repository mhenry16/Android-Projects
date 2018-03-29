package prj1.csc214.prj1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static prj1.csc214.prj1.MainActivity.KEY_N;
import static prj1.csc214.prj1.MainActivity.KEY_TEST;

public class TestActivity extends AppCompatActivity {
    int score;

    TextView n;
    TextView s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        n = findViewById(R.id.test_name);
        s = findViewById(R.id.test_score);

        Intent intent = getIntent();
        score = intent.getIntExtra(KEY_TEST, 0);
        n.setText(intent.getStringExtra(KEY_N));
        s.setText(Integer.toString(intent.getIntExtra(KEY_TEST, 0)));
    }

    public void changeScore(View view) {
        score += 10;
        s.setText(Integer.toString(score));
    }

    public void returnToStartScreen(View view) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(KEY_TEST, score);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
