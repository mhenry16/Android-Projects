package prj1.csc214.prj1;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import static android.app.Activity.RESULT_OK;
import static prj1.csc214.prj1.MainActivity.KEY_P1SCORE;
import static prj1.csc214.prj1.MainActivity.KEY_P2SCORE;

/**
 * Created by Mike on 3/21/2018.
 */

public class HotColdModel {
    int finalNum;
    int numP1Guess;
    int numP2Guess;
    int p1CurScore;
    int p2CurScore;
    int previousNum;
    int previousOff;

    public HotColdModel(){
        Random rand = new Random();
        finalNum = rand.nextInt(10)+1;
        numP1Guess = 0;
        numP2Guess = 0;
        previousNum = 0;
    }

    public int checkGuess(int guess){
        Log.i("HC", Integer.toString(finalNum));
        int off = Math.abs(guess-finalNum);
        if(previousNum==0){
            if(guess == finalNum){
                previousNum=0;
                return 2; //correct
            }
            else if(off<=3){
                previousOff = off;
                previousNum = guess;
                return 0; //warm
            }
            else{
                previousOff = off;
                previousNum = guess;
                return 3; //cold
            }
        }
        previousNum = guess;
        Log.i("HotCold", Integer.toString(finalNum));
        Log.i("HotCold", Integer.toString(guess));
        if(guess == finalNum){
            previousNum=0;
            return 2; //correct
        }
        else if(previousOff > off){
            previousOff = off;
            return 4; //warmer
        }
        else{
            previousOff = off;
            return 1; //colder
        }
    }

    public void increaseGuessCounter(int player){
        if(player == 0) {
            numP1Guess += 1;
        }
        else{
            numP2Guess += 1;
        }
    }

    public int getNumGuess(int player){
        if(player==0){
            return numP1Guess;
        }
        else{
            return numP2Guess;
        }
    }

    public void onRightAnswer(Button guessButton, EditText guessBox) {
        guessButton.setVisibility(View.INVISIBLE);
        guessBox.setVisibility(View.INVISIBLE);
    }

    public int endGame(){
        if(numP1Guess<numP2Guess){
            p1CurScore += (numP2Guess-numP1Guess)*100;
            return 0;
        }
        else{
            p2CurScore += (numP1Guess-numP2Guess)*100;
            return 1;
        }
    }

    public void setScores(int s1, int s2){
        p1CurScore = s1;
        p2CurScore = s2;
    }

    public int getP1CurScore() {
        return p1CurScore;
    }

    public int getP2CurScore() {
        return p2CurScore;
    }
}
