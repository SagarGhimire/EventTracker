package com.example.s525189.program5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
        TextView guess;
        TextView tv_attempt;
        TextView tv_reveal;
        ArrayAdapter<String> arrayAdapter;
        ListView listView;
        int attempt = 0;
        List<String> list;
        Button btn_reveal;
        CodeWord codeWord;
        int unicode = 0x1F302;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            tv_attempt = (TextView) findViewById(R.id.guessTV);
            tv_reveal = (TextView) findViewById(R.id.attempt);
            btn_reveal = (Button) findViewById(R.id.reset);
            guess = (TextView) findViewById(R.id.symbolTV);
            codeWord = new CodeWord(4);



            list = new ArrayList<String>(Arrays.asList(codeWord.getSymbols()));

            listView = (ListView) findViewById(R.id.gameList);
            arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list) {
            };
            listView.setAdapter(arrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                    TextView textView = (TextView) view;

                    codeWord.addSymbolsToGuess(adapterView.getItemAtPosition(pos).toString());
                    tv_attempt.setText(codeWord.getStatus());


                }

            });
        }

 int q =0;
        public void onAction(View view) {

                codeWord.reset();
                tv_attempt.setText("");
                q=1;
                tv_reveal.setText("");
                tv_attempt.setText(" ");
                guess.setText(" ");
            btn_reveal.setText("GetCode");


            if (q==1) {
               tv_attempt.setText(codeWord.getSecretCode());
               // btn_reveal.setText("HiddenCode");


            } else
                tv_reveal.setText("");
            btn_reveal.setText("GetCode");

        }
    }



