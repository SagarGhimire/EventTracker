package com.example.s525189.program5;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by s525189 on 2/28/2018.


*/
public class CodeWord {
    String[] symbols;
    int count;
    String[] code;
    String[] guess;
    int onSymbol;
    int attempts;
    String status;
    int unicod= 0x1FF789;
    String secretCode="";


    public CodeWord(int count) {
        onSymbol = 0;
        attempts = 0;
        status = "";
        this.count = count;
        symbols = new String[count];
        code=new String[count];
        code=generateRandom(count);
        guess = new String[count];
        symbols[0] ="A";
        symbols[1] ="B";
        symbols[2] ="C";
        symbols[3] ="D";


    }

    public String[] getSymbols() {
        return symbols;
    }

    public void setSymbols(String[] symbols) {
        this.symbols = symbols;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String[] getCode() {
        return code;
    }

    public void setCode(String[] code) {
        this.code = code;
    }

    public String[] getGuess() {
        return guess;
    }

    public void setGuess(String[] guess) {
        this.guess = guess;
    }

    public int getOnSymbol() {
        return onSymbol;
    }

    public void setOnSymbol(int onSymbol) {
        this.onSymbol = onSymbol;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addSymbolsToGuess(String s) {
        if (onSymbol < count) {

            guess[onSymbol] = s;
            if(s!=null) {
                onSymbol++;
            }
            if (onSymbol == count) {
                onSymbol = 0;
                attempts++;
                status = "\n The Guess " +getCurrentGuess()+" "+" \n"+"Attempts "+ getAttempts()+ " Guess  Completed " + countNumber()+" correct";
            }
            else
                {
                status = "\n The Guess " + getCurrentGuess() + " " + " \n" + "Attempts " + getAttempts() + " Guess  " + countNumber() + " correct";

            }

        }


    }


    public String getCurrentGuess() {
        String c = "";

        // String s = "";
        //  int lettersCountt=0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] != null) {
                c += guess[i];

            }


        }
        return c;
    }


    public boolean getGuessMatch() {
        if (countNumber() == getGuess().length) {

            return true;
        }
        return false;
    }

    public int countNumber() {

        int lettersCount = 0;

        for (int i = 0; i < getCode().length; i++) {

            if (code[i] == (guess[i])) {
                lettersCount++;
            }
        }
        return lettersCount;
    }


    public  String[] generateRandom(int length) {
        String[] code = new String[length];
        int count=0;
        ArrayList<Integer> vector = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        while (vector.size() < getCode().length) {
            int random = randomGenerator.nextInt(length);
            if (!vector.contains(random)) {
                vector.add(random);
                code[count]=symbols[random];
                count++;

            }
        }
        return code;
    }
    public  void reset(){
        code =generateRandom(count);
        setStatus("");
        setOnSymbol(0);
    }
    public String getSecretCode(){

        for(int i=0;i<getCode().length;i++){
            secretCode+=getCode()[i];
        }
        return secretCode;
    }

    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

}

