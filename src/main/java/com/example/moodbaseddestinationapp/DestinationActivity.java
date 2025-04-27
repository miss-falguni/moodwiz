package com.example.moodbaseddestinationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        // Get the mood value passed from MainActivity
        Intent intent = getIntent();
        String mood = intent.getStringExtra("mood");

        // Check if mood is null or empty
        if (mood != null && !mood.isEmpty()) {
            suggestDestination(mood);
        } else {
            Toast.makeText(this, "No mood selected!", Toast.LENGTH_SHORT).show();
        }
    }

    private void suggestDestination(String mood) {
        String destination;
        int backgroundColor;
        int textStyle;

        switch (mood) {
            case "Happy":
                destination = "1. Bali, Indonesia\n" +
                        "2. Barcelona, Spain\n" +
                        "3. Amsterdam, Netherlands";
                backgroundColor = getResources().getColor(R.color.colorHappy);
                textStyle = R.style.RelaxedTextStyle;
                break;
            case "Sad":
                destination = "1. Kyoto, Japan\n" +
                        "2. Reykjavik, Iceland\n" +
                        "3. Zurich, Switzerland";
                backgroundColor = getResources().getColor(R.color.colorSad);
                textStyle = R.style.ExcitedTextStyle;
                break;
            case "Adventurous":
                destination = "1. Mount Everest, Nepal\n" +
                        "2. Queenstown, New Zealand\n" +
                        "3. Costa Rica (Rainforests)";
                backgroundColor = getResources().getColor(R.color.colorAdventurous);
                textStyle = R.style.RomanticTextStyle;  // You can create a new style for Adventurous mood
                break;
            case "Romantic":
                destination = "1. Paris, France\n" +
                        "2. Venice, Italy\n" +
                        "3. Santorini, Greece";
                backgroundColor = getResources().getColor(R.color.colorRomantic);
                textStyle = R.style.RelaxedTextStyle;  // Create more styles as needed
                break;
            case "Relaxed":
                destination = "1. Maldives\n" +
                        "2. Bali, Indonesia\n" +
                        "3. Seychelles";
                backgroundColor = getResources().getColor(R.color.colorRelaxed);
                textStyle = R.style.HappyTextStyle;
                break;
            case "Excited":
                destination =  "1. Las Vegas, USA\n" +
                        "2. Tokyo, Japan\n" +
                        "3. Rio de Janeiro, Brazil";
                backgroundColor = getResources().getColor(R.color.colorExcited);
                textStyle = R.style.BoredTextStyle;
                break;
            case "Bored":
                destination = "1. Prague, Czech Republic\n" +
                        "2. Edinburgh, Scotland\n" +
                        "3. Lisbon, Portugal";
                backgroundColor = getResources().getColor(R.color.colorBored);
                textStyle = R.style.SadTextStyle;
                break;
            default:
                destination = "Please select a valid mood!";
                backgroundColor = getResources().getColor(R.color.white);
                textStyle = R.style.SadTextStyle;
                break;
        }

        // Find the TextView and set the text and background color dynamically
        TextView destinationTextView = findViewById(R.id.destinationTextView);
        destinationTextView.setText(destination);
        destinationTextView.setBackgroundColor(backgroundColor);
        destinationTextView.setTextAppearance(this, textStyle);  // Apply the style dynamically
    }
}
