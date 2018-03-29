package prj1.csc214.prj1;

import android.util.Log;

import java.util.Random;

/**
 * Created by Mike on 3/22/2018.
 */

public class HangmanModel {
    int p1NumWrongGuess;
    int p2NumWrongGuess;
    String[] words = {"bat", "cat", "rat", "bobcat", "horse", "road", "red", "blue", "rain", "sun"};
    boolean playerTurn = true;
    boolean p1Done = false;
    boolean p2Done = false;
    boolean oneReset = true;
    int p1CurScore;
    int p2CurScore;

    public HangmanModel(){
        p1NumWrongGuess = 0;
        p2NumWrongGuess = 0;
    }

    public String getRandomWord(){
        Random rand = new Random();
        int index = rand.nextInt(10);
        Log.i("Hang", words[index]);
        return words[index];
    }

    public int[] createArrayOfWord(String word){
        int[] repString = new int[word.length()];
        for(int i = 0; i<repString.length; i++){
            repString[i]=0;
        }
        return repString;
    }

    public String convertArrayToString(int[] array, String string){
        String result = "";
        for(int i = 0;i<string.length();i++){
            if(array[i]==1){
                result = result + string.charAt(i);
            }
            else{
                result = result + "-";
            }
        }
        Log.i("Hang", result);
        return result;
    }

    public int[] lettersGuessed(int[] current, String word, char guess){
        for(int i = 0; i<word.length(); i++){
            if(word.charAt(i)==(guess)){
                current[i] = 1;
            }
        }
        return current;
    }

    public boolean isInWord(int[] current, String word, char guess){
        boolean result = false;
        for(int i = 0; i<current.length; i++){
            if(word.charAt(i)==(guess)){
                result = true;
            }
        }
        p1Done = !checkP1EndTurn();
        p2Done = checkP2End();
        if(!result){
            incrementNumStrikes();
        }
        return result;
    }

    public void incrementNumStrikes(){
        if(playerTurn){
            p1NumWrongGuess+=1;
        }
        else{
            p2NumWrongGuess+=1;
        }
        Log.i("Guess", Integer.toString(p1NumWrongGuess));
        Log.i("Guess", Integer.toString(p2NumWrongGuess));
    }

    public boolean checkP1EndTurn(){
        Log.i("checkP1", Integer.toString(p1NumWrongGuess) + " number 1");
        Log.i("checkP1", String.valueOf(playerTurn));
        if((p1NumWrongGuess==8 && playerTurn) || p1Done){
            Log.i("Hang", "ye");
            //playerTurn=false;
            return false;
        }
        else{
            Log.i("Hang", "should not reset");
            return true;
        }
    }

    public boolean checkP2End(){
        Log.i("checkP2", Integer.toString(p2NumWrongGuess) + " number 2");
        Log.i("checkP2", String.valueOf(playerTurn));
        if((p2NumWrongGuess==7 && !playerTurn) || p2Done){
            return true;
        }
        else{
            return false;
        }
    }

    public int endGame(){
        if(p1NumWrongGuess<p2NumWrongGuess){
            Log.i("HangM", Integer.toString(p1CurScore));
            p1CurScore += (p2NumWrongGuess-p1NumWrongGuess)*100;
            Log.i("HangM", Integer.toString(p1CurScore));
            return 0;
        }
        else if(p1NumWrongGuess>p2NumWrongGuess){
            Log.i("HangM", Integer.toString(p2CurScore));
            p2CurScore += (p1NumWrongGuess-p2NumWrongGuess)*100;
            Log.i("HangM", Integer.toString(p2CurScore));
            return 1;
        }
        else if(p1NumWrongGuess==p2NumWrongGuess && p1Done && p2Done){
            return 2;
        }
        else{
            return 3;
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
