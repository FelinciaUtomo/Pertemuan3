package com.example.pertemuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.color.utilities.Score;

public class MainActivity extends AppCompatActivity {
    //private Question question1 = new Question(R.string.Q1,true);

    private Question[] QuestionBank = new Question[]{
                new Question(R.string.Q1,true),
                new Question(R.string.Q2,false),
                new Question(R.string.Q3,false),
                new Question(R.string.Q4,true),
                new Question(R.string.Q5,true),
                new Question(R.string.Q6,false),
    };
    private int current = 0;
    private TextView tv1, NilaiTV2;
    private Button bTrue;
    private Button bFalse;
    private Button bNext;
    private Button bResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView);
        NilaiTV2 = findViewById(R.id.textView3);
        bTrue = findViewById(R.id.bTrue);
        bFalse = findViewById(R.id.bFalse);
        bNext = findViewById(R.id.bNext);
        bResult = findViewById(R.id.bResult);

        bTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        bFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //current = (current + 1)%QuestionBank.length;
                current = current + 1;
                if (current>=QuestionBank.length){
                    Intent i = new Intent( getApplicationContext(), ResultActivity.class);
                    i.putExtra("info", "info from Main Activity");
                    i.putExtra("NilaiHasil", Score);
                    startActivity(i);
                }

                updateQuestion();
            }
        });
        bResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ResultActivity.class);
                i.putExtra("info","info dari Main Activity");
//                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.petra.ac.id"));
                i.putExtra("NilaiHasil", Score);
                startActivity(i);
            }
        });
        updateQuestion();
        //Toast.makeText(getApplicationContext(),R.string.welcome,Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(),QuestionBank[0].getResId(),Toast.LENGTH_LONG).show();
    }

    private void updateQuestion() {
        int Question = QuestionBank[current].getResId();
        tv1.setText(Question);

        TextView NilaiTV2 = findViewById(R.id.textView3);
        NilaiTV2.setText("Score:" + Score);
    }

    private void checkAnswer(boolean b) {
        boolean TrueAnswer = QuestionBank[current].getAnswer();
        if (TrueAnswer=b){
            Toast.makeText(getApplicationContext(),R.string.ResponseTrue,Toast.LENGTH_LONG).show();
            QuestionBank[current].setAnswer(true);
            Score++;
        }else {
            Toast.makeText(getApplicationContext(),R.string.ResponseFalse,Toast.LENGTH_LONG).show();
            QuestionBank[current].setAnswer(false);
        }
    }
}