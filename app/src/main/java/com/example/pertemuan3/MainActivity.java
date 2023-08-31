package com.example.pertemuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //private Question question1 = new Question(R.string.Q1,true);

    private Question[] QuestionBank = new Question[]{
                new Question(R.string.Q1,true),
                new Question(R.string.Q2,true),
                new Question(R.string.Q3,true),
                new Question(R.string.Q4,true),
    };
    private int current = 0;
    private TextView tv1;
    private Button bTrue;
    private Button bFalse;
    private Button bNext;
    private Button bResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView);
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
                current = (current + 1)%QuestionBank.length;
                updateQuestion();
            }
        });
        bResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ResultActivity.class);
                i.putExtra("info","info dari Main Activity");
//                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.petra.ac.id"));
                startActivity(i);
            }
        });
        //Toast.makeText(getApplicationContext(),R.string.welcome,Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(),QuestionBank[0].getResId(),Toast.LENGTH_LONG).show();
    }

    private void updateQuestion() {
        int Question = QuestionBank[current].getResId();
        tv1.setText(QuestionBank[current].getResId());
    }

    private void checkAnswer(boolean b) {
        boolean TrueAnswer = QuestionBank[current].getAnswer();
        if (TrueAnswer=b){
            Toast.makeText(getApplicationContext(),R.string.ResponseTrue,Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),R.string.ResponseFalse,Toast.LENGTH_LONG).show();
        }
    }
}