package com.example.shifumi;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button rockButton, paperButton, scissorsButton;
    private ImageView computerChoiceImageView,playerChoiceImageView,playerChoiceImageView2;
    private TextView resultTextView, scoreTextView;
    private int playerScore, computerScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        rockButton = findViewById(R.id.rockButton);
        paperButton = findViewById(R.id.paperButton);
        scissorsButton = findViewById(R.id.scissorsButton);
        computerChoiceImageView = findViewById(R.id.computerChoiceImageView);
        playerChoiceImageView = findViewById(R.id.playerChoiceImageView);
        playerChoiceImageView2 = findViewById(R.id.playerChoiceImageView2);
        resultTextView = findViewById(R.id.resultTextView);
        scoreTextView = findViewById(R.id.scoreTextView);

        // Initialize scores
        playerScore = 0;
        computerScore = 0;
        updateScore();

        // Set button onClick listeners
        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playTurn("rock");
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playTurn("paper");
            }
        });

        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playTurn("scissors");
            }
        });
    }

    private void playTurn(String playerChoice) {
        // Generate computer's choice
        Random random = new Random();
        int computerChoiceIndex = random.nextInt(3);
        String[] choices = {"rock", "paper", "scissors"};
        String computerChoice = choices[computerChoiceIndex];

        // Update computer's choice image
        if (computerChoice.equals("rock")) {
            computerChoiceImageView.setImageResource(R.drawable.button_rock);
        } else if (computerChoice.equals("paper")) {
            computerChoiceImageView.setImageResource(R.drawable.button_paper);
        } else if (computerChoice.equals("scissors")) {
            computerChoiceImageView.setImageResource(R.drawable.button_cisor);
        }

        // Update player's choice image
        if (playerChoice.equals("rock")) {
            playerChoiceImageView.setImageResource(R.drawable.button_rock);
        } else if (playerChoice.equals("paper")) {
            playerChoiceImageView.setImageResource(R.drawable.button_paper);
        } else if (playerChoice.equals("scissors")) {
            playerChoiceImageView.setImageResource(R.drawable.button_cisor);
        }

        // Determine winner
        if (playerChoice.equals(computerChoice)) {
            // Tie
            resultTextView.setText("Tie!");
            playerChoiceImageView2.setImageResource(R.drawable.fair);

        } else if (playerChoice.equals("rock") && computerChoice.equals("scissors") ||
                playerChoice.equals("paper") && computerChoice.equals("rock") ||
                playerChoice.equals("scissors") && computerChoice.equals("paper")) {
            // Player wins
            playerScore++;
            resultTextView.setText("You win!");
            playerChoiceImageView2.setImageResource(R.drawable.player_win);
        } else {
            // Computer wins
            computerScore++;
            resultTextView.setText("Device wins!");
            playerChoiceImageView2.setImageResource(R.drawable.player_lose);
        }

        // Update scores
        updateScore();
    }

    private void updateScore() {
        scoreTextView.setText("Player: " + playerScore + "    Device: " + computerScore);
    }
}
