package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView output;

    Button b0;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;

    Button bplus;
    Button bmin;
    Button bmul;
    Button bdiv;
    Button bequal;

    Button bc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.output);
        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);

        bplus = findViewById(R.id.bplus);
        bmin = findViewById(R.id.bmin);
        bmul = findViewById(R.id.bmul);
        bdiv = findViewById(R.id.bdiv);

        bequal = findViewById(R.id.bequal);

        bc = findViewById(R.id.bc);




        View.OnClickListener blistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputText;
                switch (v.getId()) {
                    case R.id.b0:
                        outputText = output.getText().toString();
                        outputText += "0";
                        output.setText(outputText);
                        return;
                    case R.id.b1:
                        outputText = output.getText().toString();
                        outputText += "1";
                        output.setText(outputText);
                        return;
                    case R.id.b2:
                        outputText = output.getText().toString();
                        outputText += "2";
                        output.setText(outputText);
                        return;
                    case R.id.b3:
                        outputText = output.getText().toString();
                        outputText += "3";
                        output.setText(outputText);
                        return;
                    case R.id.b4:
                        outputText = output.getText().toString();
                        outputText += "4";
                        output.setText(outputText);
                        return;
                    case R.id.b5:
                        outputText = output.getText().toString();
                        outputText += "5";
                        output.setText(outputText);
                        return;
                    case R.id.b6:
                        outputText = output.getText().toString();
                        outputText += "6";
                        output.setText(outputText);
                        return;
                    case R.id.b7:
                        outputText = output.getText().toString();
                        outputText += "7";
                        output.setText(outputText);
                        return;
                    case R.id.b8:
                        outputText = output.getText().toString();
                        outputText += "8";
                        output.setText(outputText);
                        return;
                    case R.id.b9:
                        outputText = output.getText().toString();
                        outputText += "9";
                        output.setText(outputText);
                        return;

                    case R.id.bplus:
                        outputText = output.getText().toString();
                        outputText += "+";
                        output.setText(outputText);
                        return;

                    case R.id.bmin:
                        outputText = output.getText().toString();
                        outputText += "-";
                        output.setText(outputText);
                        return;

                    case R.id.bmul:
                        outputText = output.getText().toString();
                        outputText += "*";
                        output.setText(outputText);
                        return;

                    case R.id.bdiv:
                        outputText = output.getText().toString();
                        outputText += "/";
                        output.setText(outputText);
                        return;

                    case R.id.bc:
                        outputText = output.getText().toString();
                        if (outputText.length() > 0) {
                            outputText = outputText.substring(0, outputText.length() - 1);
                            output.setText(outputText);
                        }
                        return;

                    case R.id.bequal:
                        outputText = output.getText().toString();
                        if (outputText.length() > 0) {
                            Calculator _calc = new Calculator();
                            double answer = _calc.calc(outputText);
                            outputText = Double.toString(answer);
                            //String _text = _calc.openBrackets(outputText);
                            output.setText(outputText);
                        }
                        return;

                    default:
                        return;
                }
            }
        };
        b0.setOnClickListener(blistener);
        b1.setOnClickListener(blistener);
        b2.setOnClickListener(blistener);
        b3.setOnClickListener(blistener);
        b4.setOnClickListener(blistener);
        b5.setOnClickListener(blistener);
        b6.setOnClickListener(blistener);
        b7.setOnClickListener(blistener);
        b8.setOnClickListener(blistener);
        b9.setOnClickListener(blistener);

        bplus.setOnClickListener(blistener);
        bmin.setOnClickListener(blistener);
        bmul.setOnClickListener(blistener);
        bdiv.setOnClickListener(blistener);

        bequal.setOnClickListener(blistener);

        bc.setOnClickListener(blistener);


    }
    public String removeLastChar(String str) {
        if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == 'x') {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}