//Nadezda Zolotareva    Higher Or Lower  02/05/2020

package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randNumber; //the generated random number

    @Override
    protected void onCreate(Bundle savedInstanceState) { //creates the activity
        super.onCreate(savedInstanceState); //saves the instance of activity
        setContentView(R.layout.activity_main); //sets the layout of the activity

        generateRandomNumber(); //calls for the random number to be generated

        final EditText eText = (EditText) findViewById(R.id.editText); //initialize the edit text
        Button btn = (Button) findViewById(R.id.button); //initialize the button

        btn.setOnClickListener(new View.OnClickListener() { //method that executes when the button is pressed
            public void onClick(View v) {
                int input = Integer.parseInt(eText.getText().toString()); //stores the input entered by the user
                if (input == randNumber){
                    Toast.makeText( getApplicationContext(), "You guessed it!\nTry again!", Toast.LENGTH_SHORT).show(); //shows a toast message to the user
                    generateRandomNumber(); //generates a new random number
                } else if (input > randNumber) {
                    Toast.makeText( getApplicationContext(), "Lower!", Toast.LENGTH_SHORT).show(); //shows a toast message to the user
                } else if (input < randNumber) {
                    Toast.makeText( getApplicationContext(), "Higher!", Toast.LENGTH_SHORT).show(); //shows a toast message to the user
                }
            }
        });
    }

    public void generateRandomNumber(){
        Random rand = new Random(); //instance of random class
        randNumber = rand.nextInt(20) + 1; //generates a random number between 1 and 20
    }
}
