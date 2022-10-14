package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var imageDice: ImageView;
    lateinit var imageDice2: ImageView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById<Button>(R.id.roll_button);
        rollButton.setOnClickListener { rollDice() };

        val countUpButton: Button = findViewById(R.id.countup_button);
        countUpButton.setOnClickListener { countUp() };

        val resetButton: Button = findViewById(R.id.reset_button);
        resetButton.setOnClickListener { reset() };

        imageDice = findViewById(R.id.dice_image)
        imageDice.setImageResource(R.drawable.empty_dice)

        imageDice2 = findViewById(R.id.dice_image2)
        imageDice2.setImageResource(R.drawable.empty_dice)
    }

    private fun rollDice(){
        /*Toast.makeText(this, "button clicked",
            Toast.LENGTH_SHORT).show();*/

        var randomInt = (1..6).random();
        var imageDrawer = when (randomInt){
            1 -> R.drawable.dice_1;
            2 -> R.drawable.dice_2;
            3 -> R.drawable.dice_3;
            4 -> R.drawable.dice_4;
            5 -> R.drawable.dice_5;
            else -> R.drawable.dice_6;
        }
        imageDice.setImageResource(imageDrawer);

        randomInt = (1..6).random();
        imageDrawer = when (randomInt){
            1 -> R.drawable.dice_1;
            2 -> R.drawable.dice_2;
            3 -> R.drawable.dice_3;
            4 -> R.drawable.dice_4;
            5 -> R.drawable.dice_5;
            else -> R.drawable.dice_6;
        }

        imageDice2.setImageResource(imageDrawer);

    }

    private fun countUp(){
        val resultText: TextView = findViewById<TextView>(R.id.result_text);
        if (resultText.text.toString().equals("Hello World!")){
            resultText.setText("1");
        }
        else if (resultText.text.toString().equals("6")){ }
        else{
            var textNumber: Int = resultText.text.toString().toInt();
            textNumber++;
            resultText.setText(textNumber.toString());
        }
    }

    private fun reset(){
        val resultText: TextView = findViewById(R.id.result_text);
        resultText.setText("0");
        imageDice.setImageResource(R.drawable.empty_dice);
        imageDice2.setImageResource(R.drawable.empty_dice);
    }
}