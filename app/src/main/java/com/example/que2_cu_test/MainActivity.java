package com.example.que2_cu_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int MAX_NUMBER = 1000;
    public static final Random RANDOM = new Random();
    private TextView tv;
    private EditText Et;
    private Button Check;
    private int numberToFind, numberTries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv =  findViewById(R.id.msg);
        Et =  findViewById(R.id.numberEnteredEt);
        Check = findViewById(R.id.validate);
        Check.setOnClickListener(this);

        newGame();

    }
    

    private void newGame() {
        numberToFind = RANDOM.nextInt(MAX_NUMBER) + 1;
        tv.setText(R.string.start_msg);
        Et.setText("");
        numberTries = 0;

    }

    @Override
    public void onClick(View v) {
        if (v == Check) {
            validate();
        }

    }

    private void validate() {

        int n = Integer.parseInt(Et.getText().toString());
        numberTries++;

        if (n == numberToFind) {
            Toast.makeText(this, "Congratulations ! You found the number " + numberToFind +
                    " in " + numberTries + " tries", Toast.LENGTH_SHORT).show();
            newGame();
        } else if (n > numberToFind) {
            Toast.makeText(this, "Too High", Toast.LENGTH_SHORT).show();
        } else if (n < numberToFind) {
            Toast.makeText(this, "Too Low", Toast.LENGTH_SHORT).show();
        }
    }
}
