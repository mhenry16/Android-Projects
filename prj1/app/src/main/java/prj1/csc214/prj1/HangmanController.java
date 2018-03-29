package prj1.csc214.prj1;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Mike on 3/22/2018.
 */

public class HangmanController {

    HangmanModel theModel;
    String wordToGuess;
    String wordCurrent;
    int[] current;
    int[] next;
    int numBack;
    boolean replaceButtons;


    public HangmanController(){
        theModel = new HangmanModel();
        wordToGuess = theModel.getRandomWord();
        current = theModel.createArrayOfWord(wordToGuess);
        next = current;
        wordCurrent = theModel.convertArrayToString(current, wordToGuess);
        numBack = 0;
        replaceButtons = true;
    }

    public String update(char guess, TextView numStrikes, TextView word){
        Log.i("update", String.valueOf(theModel.checkP1EndTurn()));
        if(theModel.p1Done && theModel.oneReset){
            theModel.oneReset = false;
            theModel.playerTurn = false;
            reset(numStrikes, word);
            Log.i("Hang", "reset");
        }
        next = theModel.lettersGuessed(current, wordToGuess, guess);
        wordCurrent = theModel.convertArrayToString(next, wordToGuess);
        return wordCurrent;
    }

    public void reset(TextView numStrikes, TextView word){
        current = theModel.createArrayOfWord(wordToGuess);
        next = current;
        wordCurrent = theModel.convertArrayToString(current, wordToGuess);
        Log.i("HangC", wordCurrent + " during reset");
        numStrikes.setText("");
        word.setText(wordCurrent);

        if(theModel.p1NumWrongGuess<=9){
            theModel.p1NumWrongGuess-=1;
        }
    }

    public String isInWord(String string, char guess){
        Log.i("Hang", Integer.toString(wordToGuess.length()));
        if(theModel.isInWord(current, wordToGuess, guess)){
            Log.i("Hang", "should x");
            return string;
        }
        else{
            current = next;
            Log.i("Hang", "should not x");
            return string + "X";
        }
    }

    public void checkCorrect(){
        Log.i("checkCorrect", wordCurrent);
        if(wordToGuess.equals(wordCurrent) && !theModel.p1Done){
            Log.i("checkCorrect", "inside first int");
            theModel.p1Done = true;
        }
        else if(wordToGuess.equals(wordCurrent) && !theModel.p2Done){
            theModel.p2Done = true;
        }
    }

    public int checkOver(Button Q, Button W, Button E, Button RR, Button T, Button Y, Button U, Button I, Button O, Button P, Button A, Button S, Button D, Button F, Button G, Button H, Button J, Button K, Button L, Button Z, Button X, Button C, Button V, Button B, Button N, Button M){
        Log.i("over", String.valueOf(theModel.p1Done));
        Log.i("over", String.valueOf(theModel.p2Done));
        if(theModel.p1Done && replaceButtons){
            replaceButtons = false;
            Q.setVisibility(View.VISIBLE);
            W.setVisibility(View.VISIBLE);
            E.setVisibility(View.VISIBLE);
            RR.setVisibility(View.VISIBLE);
            T.setVisibility(View.VISIBLE);
            Y.setVisibility(View.VISIBLE);
            U.setVisibility(View.VISIBLE);
            I.setVisibility(View.VISIBLE);
            O.setVisibility(View.VISIBLE);
            P.setVisibility(View.VISIBLE);
            A.setVisibility(View.VISIBLE);
            S.setVisibility(View.VISIBLE);
            D.setVisibility(View.VISIBLE);
            F.setVisibility(View.VISIBLE);
            G.setVisibility(View.VISIBLE);
            H.setVisibility(View.VISIBLE);
            J.setVisibility(View.VISIBLE);
            K.setVisibility(View.VISIBLE);
            L.setVisibility(View.VISIBLE);
            Z.setVisibility(View.VISIBLE);
            X.setVisibility(View.VISIBLE);
            C.setVisibility(View.VISIBLE);
            V.setVisibility(View.VISIBLE);
            B.setVisibility(View.VISIBLE);
            N.setVisibility(View.VISIBLE);
            M.setVisibility(View.VISIBLE);
        }
        if(theModel.p1Done && theModel.p2Done){
            return theModel.endGame();
        }
        return 3;
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

    public void incrementNumBack(){
        numBack+=1;
    }
}
