package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9, restart;
    TextView result;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int count = 0, flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        init();
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartgame();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // method to find id's of views
    void init(){
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        restart = findViewById(R.id.restart);
        result = findViewById(R.id.result);
    }

    //method for all buttons
    public void check(View view){

       Button buttonCurr = (Button)view;

       if(buttonCurr.getText().toString().isEmpty()){

       // To alternatively print X and O

        if (flag == 0){
           buttonCurr.setText("X");
           count ++;
           flag = 1;
        }else{
            buttonCurr.setText("O");
            count++;
            flag = 0;
        }

        // To check for winner

        if(count > 4){
            b1 = btn1.getText().toString();
            b2 = btn2.getText().toString();
            b3 = btn3.getText().toString();
            b4 = btn4.getText().toString();
            b5 = btn5.getText().toString();
            b6 = btn6.getText().toString();
            b7 = btn7.getText().toString();
            b8 = btn8.getText().toString();
            b9 = btn9.getText().toString();

            //condition for rows
            if(b1.equals(b2)&&b2.equals(b3)&& !b1.isEmpty()){
                result.setText(b1+"Wins!!");
            }
            else if(b4.equals(b5)&&b5.equals(b6)&& !b4.isEmpty()){
                result.setText(b4+"Wins!!");
            }
            else if(b7.equals(b8)&&b8.equals(b9)&& !b7.isEmpty()){
                result.setText(b7+"Wins!!");
            }
            //condition for columns
            else if(b1.equals(b4)&&b4.equals(b7)&& !b1.isEmpty()){
                result.setText(b1+"Wins!!");
            }
            else if(b2.equals(b5)&&b5.equals(b8)&& !b2.isEmpty()){
                result.setText(b2+"Wins!!");
            }
            else if(b3.equals(b6)&&b6.equals(b9)&& !b3.isEmpty()){
                result.setText(b3+"Wins!!");
            }
            //condition for diagonals
            else if(b1.equals(b5)&&b5.equals(b9)&& !b1.isEmpty()){
                result.setText(b1+"Wins!!");
            }
            else if(b3.equals(b5)&&b5.equals(b7)&& !b7.isEmpty()){
                result.setText(b3+"Wins!!");
            } else if (count ==9) {
                result.setText("Draw!");
            }
        }
    }
    }

    //method to restart game
    public void restartgame(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        flag=0;
        count=0;
        result.setText("");
    }
}