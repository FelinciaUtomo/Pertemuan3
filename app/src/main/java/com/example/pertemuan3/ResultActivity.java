package com.example.pertemuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.color.utilities.Score;

public class ResultActivity extends AppCompatActivity {
    private TextView TextScore

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextScore = findViewById(R.id.textView2);

        Bundle extras = getIntent().getExtras();
        String info extras.getString("info");

        Toast.makeText(getApplicationContext(),info,Toast.LENGTH_LONG).show();

        int nilai = getIntent().getIntExtra("Nilai", 0);
        TextScore.setText("Score:" + Score);
    }
}