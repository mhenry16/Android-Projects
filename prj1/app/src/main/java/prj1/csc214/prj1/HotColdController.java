package prj1.csc214.prj1;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static prj1.csc214.prj1.MainActivity.KEY_P1SCORE;
import static prj1.csc214.prj1.MainActivity.KEY_P2SCORE;

/**
 * Created by Mike on 3/21/2018.
 */

public class HotColdController {
    HotColdModel theModel;
    HotColdActivity theView;

    public HotColdController(){
        theModel = new HotColdModel();
        theView = new HotColdActivity();
    }

    public String updateGuess(int guess, int player, TextView curGuess, EditText guessBox, Button guessButton){
//        theView.p1NumGuess.setText();
        Log.i("HotCold", "in the controller");
        int result = theModel.checkGuess(guess);
        theModel.increaseGuessCounter(player);
        Log.i("HotCold", Integer.toString(theModel.getNumGuess(player))+"num");
        curGuess.setText(Integer.toString(theModel.getNumGuess(player)));
        Log.i("HotCold", Integer.toString(result));
        guessBox.setText("");
        Log.i("HC", Integer.toString(result));
        if(result == 0){
            return "warm";
        }
        else if(result == 1){
            return "colder";
        }
        else if(result == 2){
            theModel.onRightAnswer(guessButton, guessBox);
            return "correct";
        }
        else if(result == 3){
            return "cold";
        }
        else{
            return "warmer";
        }
    }

    public void isOver(EditText guessBox, EditText guessBox2, View view){
        Log.i("HC", "inOver");
        if(guessBox.getVisibility()!=View.VISIBLE && guessBox2.getVisibility()!=View.VISIBLE){
            Log.i("HC", "inIf");
            int winner = theModel.endGame();
            theView.endsTheActivity(theModel.getP1CurScore(), theModel.getP2CurScore(), winner, view);
        }
    }

    public void setScores(int s1, int s2){
        theModel.setScores(s1, s2);
    }

    public int getP1CurScore(){
        return theModel.getP1CurScore();
    }
    public int getP2CurScore(){
        return theModel.getP2CurScore();
    }
}
