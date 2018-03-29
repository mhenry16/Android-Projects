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

import java.nio.file.WatchEvent;

import static prj1.csc214.prj1.MainActivity.KEY_P1NAME;
import static prj1.csc214.prj1.MainActivity.KEY_P1SCORE;
import static prj1.csc214.prj1.MainActivity.KEY_P2NAME;
import static prj1.csc214.prj1.MainActivity.KEY_P2SCORE;

public class HangmanActivity extends AppCompatActivity {
    HangmanController theController;

    TextView p1Name;
    TextView p1Score;
    TextView p2Name;
    TextView p2Score;
    TextView numStrikes;
    EditText guessBox;
    TextView word;
    Button guessButton;
    TextView instructions;
    Button Q,W,E,RR,T,Y,U,I,O,P,A,S,D,F,G,H,J,K,L,Z,X,C,V,B,N,M;
    Button triggerChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        p1Name = findViewById(R.id.p1_name_hc);
        p1Score = findViewById(R.id.p1_score_hc);
        p2Name = findViewById(R.id.p2_name_hc);
        p2Score = findViewById(R.id.p2_score_hc);
        numStrikes = findViewById(R.id.num_of_strikes);
        //guessBox = findViewById(R.id.guessBox);
        word = findViewById(R.id.word);
        //guessButton = findViewById(R.id.guessButton);
        //instructions = findViewById(R.id.instructions);
        triggerChange = findViewById(R.id.change_user);

        Q = findViewById(R.id.Q);
        W = findViewById(R.id.W);
        E = findViewById(R.id.E);
        RR = findViewById(R.id.R);
        T = findViewById(R.id.T);
        Y = findViewById(R.id.Y);
        U = findViewById(R.id.U);
        I = findViewById(R.id.I);
        O = findViewById(R.id.O);
        P = findViewById(R.id.P);
        A = findViewById(R.id.A);
        S = findViewById(R.id.S);
        D = findViewById(R.id.D);
        F = findViewById(R.id.F);
        G = findViewById(R.id.G);
        H = findViewById(R.id.H);
        J = findViewById(R.id.J);
        K = findViewById(R.id.K);
        L = findViewById(R.id.L);
        Z = findViewById(R.id.Z);
        X = findViewById(R.id.X);
        C = findViewById(R.id.C);
        V = findViewById(R.id.V);
        B = findViewById(R.id.B);
        N = findViewById(R.id.N);
        M = findViewById(R.id.M);


        Intent intent = getIntent();
        p1Name.setText(intent.getStringExtra(KEY_P1NAME).toString());
        p1Score.setText(Integer.toString(intent.getIntExtra(KEY_P1SCORE, 0)));
        p2Name.setText(intent.getStringExtra(KEY_P2NAME).toString());
        p2Score.setText(Integer.toString(intent.getIntExtra(KEY_P2SCORE, 0)));

        theController = new HangmanController();

        word.setText(theController.wordCurrent);
        theController.setScores(intent.getIntExtra(KEY_P1SCORE, 0), intent.getIntExtra(KEY_P2SCORE, 0));
    }

    public void guessClicked(View view, Button letter) {
//        if(guessBox.getText().toString().matches("")){
        if(letter.getText().toString().matches("")){
            Toast.makeText(HangmanActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
            return;
        }
//        numStrikes.setText(theController.isInWord(numStrikes.getText().toString(), (guessBox.getText().toString()).charAt(0)));
//        word.setText(theController.update((guessBox.getText().toString()).charAt(0), numStrikes, word));
        numStrikes.setText(theController.isInWord(numStrikes.getText().toString(), (letter.getText().toString()).charAt(0)));
        word.setText(theController.update((letter.getText().toString()).charAt(0), numStrikes, word));
        theController.checkCorrect();
        int winner = theController.checkOver(Q,W,E,RR,T,Y,U,I,O,P,A,S,D,F,G,H,J,K,L,Z,X,C,V,B,N,M);
        if(winner==0){
            makeButtonsDissapear();
            Toast.makeText(HangmanActivity.this, p1Name.getText().toString() + " won and has a new point total of " + theController.getP1CurScore(), Toast.LENGTH_LONG).show();
            p1Score.setText(Integer.toString(theController.getP1CurScore()));

//            guessBox.setVisibility(View.GONE);
//            guessButton.setVisibility(View.GONE);
//            instructions.setVisibility(View.GONE);
        }
        else if(winner==1){
            makeButtonsDissapear();
            Toast.makeText(HangmanActivity.this, p2Name.getText().toString() + " won and has a new point total of " + theController.getP2CurScore(), Toast.LENGTH_LONG).show();
            p2Score.setText(Integer.toString(theController.getP2CurScore()));
//            guessBox.setVisibility(View.GONE);
//            guessButton.setVisibility(View.GONE);
//            instructions.setVisibility(View.GONE);
        }
        else if(winner==2){
            makeButtonsDissapear();
            Toast.makeText(HangmanActivity.this, "Draw, no points awarded", Toast.LENGTH_LONG).show();
//            guessBox.setVisibility(View.GONE);
//            guessButton.setVisibility(View.GONE);
//            instructions.setVisibility(View.GONE);
        }
//        guessBox.setText("");
    }

    public void goBackToHome(View view) {
        if(theController.numBack==0){
            Toast.makeText(HangmanActivity.this, "Are you sure you want to quit?", Toast.LENGTH_SHORT).show();
            theController.incrementNumBack();
        }
        else {
            Intent returnIntent = new Intent();
            returnIntent.putExtra(KEY_P1SCORE, theController.getP1CurScore());
            returnIntent.putExtra(KEY_P2SCORE, theController.getP2CurScore());
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }
    }

    public void clickQ(View view) {
        Q.setVisibility(View.INVISIBLE);
        guessClicked(view, Q);
    }

    public void clickW(View view) {
        W.setVisibility(View.INVISIBLE);
        guessClicked(view, W);
    }

    public void clickE(View view) {
        E.setVisibility(View.INVISIBLE);
        guessClicked(view, E);
    }

    public void clickR(View view) {
        RR.setVisibility(View.INVISIBLE);
        guessClicked(view, RR);
    }

    public void clickT(View view) {
        T.setVisibility(View.INVISIBLE);
        guessClicked(view, T);
    }

    public void clickY(View view) {
        Y.setVisibility(View.INVISIBLE);
        guessClicked(view, Y);
    }

    public void clickU(View view) {
        U.setVisibility(View.INVISIBLE);
        guessClicked(view, U);
    }

    public void clickI(View view) {
        I.setVisibility(View.INVISIBLE);
        guessClicked(view, I);
    }

    public void clickO(View view) {
        O.setVisibility(View.INVISIBLE);
        guessClicked(view, O);
    }

    public void clickP(View view) {
        P.setVisibility(View.INVISIBLE);
        guessClicked(view, P);
    }

    public void clickZ(View view) {
        Z.setVisibility(View.INVISIBLE);
        guessClicked(view, Z);
    }

    public void clickX(View view) {
        X.setVisibility(View.INVISIBLE);
        guessClicked(view, X);
    }

    public void clickC(View view) {
        C.setVisibility(View.INVISIBLE);
        guessClicked(view, C);
    }

    public void clickV(View view) {
        V.setVisibility(View.INVISIBLE);
        guessClicked(view, V);
    }

    public void clickB(View view) {
        B.setVisibility(View.INVISIBLE);
        guessClicked(view, B);
    }

    public void clickN(View view) {
        N.setVisibility(View.INVISIBLE);
        guessClicked(view, N);
    }

    public void clickM(View view) {
        M.setVisibility(View.INVISIBLE);
        guessClicked(view, M);
    }

    public void clickA(View view) {
        A.setVisibility(View.INVISIBLE);
        guessClicked(view, A);
    }

    public void clickS(View view) {
        S.setVisibility(View.INVISIBLE);
        guessClicked(view, S);
    }

    public void clickD(View view) {
        D.setVisibility(View.INVISIBLE);
        guessClicked(view, D);
    }

    public void clickF(View view) {
        F.setVisibility(View.INVISIBLE);
        guessClicked(view, F);
    }

    public void clickG(View view) {
        G.setVisibility(View.INVISIBLE);
        guessClicked(view, G);
    }

    public void clickH(View view) {
        H.setVisibility(View.INVISIBLE);
        guessClicked(view, H);
    }

    public void clickJ(View view) {
        J.setVisibility(View.INVISIBLE);
        guessClicked(view, J);
    }

    public void clickK(View view) {
        K.setVisibility(View.INVISIBLE);
        guessClicked(view, K);
    }

    public void clickL(View view) {
        L.setVisibility(View.INVISIBLE);
        guessClicked(view, L);
    }

    public void makeButtonsDissapear(){
        Q.setVisibility(View.INVISIBLE);
        W.setVisibility(View.INVISIBLE);
        E.setVisibility(View.INVISIBLE);
        RR.setVisibility(View.INVISIBLE);
        T.setVisibility(View.INVISIBLE);
        Y.setVisibility(View.INVISIBLE);
        U.setVisibility(View.INVISIBLE);
        I.setVisibility(View.INVISIBLE);
        O.setVisibility(View.INVISIBLE);
        P.setVisibility(View.INVISIBLE);
        A.setVisibility(View.INVISIBLE);
        S.setVisibility(View.INVISIBLE);
        D.setVisibility(View.INVISIBLE);
        F.setVisibility(View.INVISIBLE);
        G.setVisibility(View.INVISIBLE);
        H.setVisibility(View.INVISIBLE);
        J.setVisibility(View.INVISIBLE);
        K.setVisibility(View.INVISIBLE);
        L.setVisibility(View.INVISIBLE);
        Z.setVisibility(View.INVISIBLE);
        X.setVisibility(View.INVISIBLE);
        C.setVisibility(View.INVISIBLE);
        V.setVisibility(View.INVISIBLE);
        B.setVisibility(View.INVISIBLE);
        N.setVisibility(View.INVISIBLE);
        M.setVisibility(View.INVISIBLE);
    }

    public void triggerUserChange(View view) {
        guessClicked(view, triggerChange);
        triggerChange.setVisibility(View.INVISIBLE);
    }
}
