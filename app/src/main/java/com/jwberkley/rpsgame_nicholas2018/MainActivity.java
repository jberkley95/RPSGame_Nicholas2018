package com.jwberkley.rpsgame_nicholas2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn_rock, btn_paper, btn_scissors;
    ImageView iv_cpu, iv_user;
    TextView tv_results;

    int wins, losses, ties;

    String userChoice, cpuChoice, result;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wins = 0;
        losses = 0;
        ties = 0;

        r = new Random();

        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_user = (ImageView) findViewById(R.id.iv_user);

        tv_results = (TextView) findViewById(R.id.tv_results);

        btn_rock = (Button) findViewById(R.id.btn_rock);
        btn_paper = (Button) findViewById(R.id.btn_paper);
        btn_scissors = (Button) findViewById(R.id.btn_scissors);

        btn_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userChoice = "rock";
                iv_user.setImageResource(R.drawable.rock);
                getCpuChoice();
                updateWLT();
                showWinner();
            }
        });
        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userChoice = "paper";
                iv_user.setImageResource(R.drawable.paper);
                getCpuChoice();
                updateWLT();
                showWinner();
            }
        });
        btn_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userChoice = "scissors";
                iv_user.setImageResource(R.drawable.scissors);
                getCpuChoice();
                updateWLT();
                showWinner();
            }
        });

    }

    public void getCpuChoice() {
        int cpu = r.nextInt(3);

        if (cpu == 0) {
            cpuChoice = "rock";
            iv_cpu.setImageResource(R.drawable.rock);
        } else if (cpu == 1) {
            cpuChoice = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        } else {
            cpuChoice = "scissors";
            iv_cpu.setImageResource(R.drawable.scissors);
        }
    }

    public void showWinner() {
        if (userChoice.equals(cpuChoice)) {
            result = "Draw!";
            ties++;
        } else if (userChoice.equals("rock") && cpuChoice.equals("paper")) {
            result = "Lose :(";
            losses++;
        } else if (userChoice.equals("rock") && cpuChoice.equals("scissors")) {
            result = "Win!!";
            wins++;
        } else if (userChoice.equals("paper") && cpuChoice.equals("rock")) {
            result = "Win!!";
            wins++;
        } else if (userChoice.equals("paper") && cpuChoice.equals("scissors")) {
            result = "Lose :(";
            losses++;
        } else if (userChoice.equals("scissors") && cpuChoice.equals("rock")) {
            result = "Lose :(";
            losses++;
        } else {
            result = "Win!!";
            wins++;
        }

        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
    }

    public void updateWLT() {
        tv_results.setText("Wins: " + wins + " Losses: " + losses + " Ties: " +ties);
    }
}
