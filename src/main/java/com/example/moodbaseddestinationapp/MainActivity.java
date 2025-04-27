package com.example.moodbaseddestinationapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnHappy, btnSad, btnAdventurous, btnRomantic, btnRelaxed, btnBored, btnExcited;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHappy = findViewById(R.id.btnHappy);
        btnSad = findViewById(R.id.btnSad);
        btnAdventurous = findViewById(R.id.btnAdventurous);
        btnRomantic = findViewById(R.id.btnRomantic);
        btnRelaxed = findViewById(R.id.btnRelaxed);
        btnBored = findViewById(R.id.btnBored);
        btnExcited = findViewById(R.id.btnExcited);

        View.OnClickListener moodClickListener = new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DestinationActivity.class);

                int id = view.getId();  // get the view id

                if (id == R.id.btnHappy) {
                    intent.putExtra("mood", "Happy");
                } else if (id == R.id.btnSad) {
                    intent.putExtra("mood", "Sad");
                } else if (id == R.id.btnAdventurous) {
                    intent.putExtra("mood", "Adventurous");
                } else if (id == R.id.btnRomantic) {
                    intent.putExtra("mood", "Romantic");
                } else if (id == R.id.btnRelaxed) {
                    intent.putExtra("mood", "Relaxed");
                } else if (id == R.id.btnExcited) {
                    intent.putExtra("mood", "Excited");
                } else if (id == R.id.btnBored) {
                    intent.putExtra("mood", "Bored");
                }

                startActivity(intent);
            }


        };

        btnHappy.setOnClickListener(moodClickListener);
        btnSad.setOnClickListener(moodClickListener);
        btnAdventurous.setOnClickListener(moodClickListener);
        btnRomantic.setOnClickListener(moodClickListener);
        btnRelaxed.setOnClickListener(moodClickListener);
        btnBored.setOnClickListener(moodClickListener);
        btnExcited.setOnClickListener(moodClickListener);
    }
}
