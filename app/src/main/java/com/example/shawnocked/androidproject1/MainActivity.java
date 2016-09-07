package com.example.shawnocked.androidproject1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView outputText = null;
    EditText numberInput = null;
    EditText baseFrom = null;
    EditText baseTo = null;
    Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI setup here
        numberInput = (EditText) findViewById(R.id.NumberInput);
        baseFrom = (EditText) findViewById(R.id.BaseFrom);
        baseTo = (EditText) findViewById(R.id.BaseTo);
        outputText = (TextView) findViewById(R.id.output);


        button = (Button) findViewById(R.id.button);

        // create a lick listener to the button
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                try{String output = BaseConversion(numberInput.getText().toString(),
                        Integer.parseInt(baseFrom.getText().toString()),
                        Integer.parseInt(baseTo.getText().toString()));

                    numberInput.setBackgroundColor(getResources().getColor(R.color.white));
                    baseFrom.setBackgroundColor(getResources().getColor(R.color.white));
                    baseTo.setBackgroundColor(getResources().getColor(R.color.white));
                    outputText.setText(output);
                    Toast.makeText(MainActivity.this, R.string.Calculating_now, Toast.LENGTH_SHORT).show();

                }
                catch(NumberFormatException e){
                    System.out.println("Number format exception occurred");
                    Toast.makeText(MainActivity.this, R.string.Number_format_exception_occurred_Please_check_your_input, Toast.LENGTH_SHORT).show();
                    numberInput.setBackgroundColor(getResources().getColor(R.color.red_error));
                    baseFrom.setBackgroundColor(getResources().getColor(R.color.red_error));
                    baseTo.setBackgroundColor(getResources().getColor(R.color.red_error));
                    outputText.setText(R.string.Error);
                }

            }
        });
    }


    // Conversion method
    public static String BaseConversion(String number, int inputBase, int outputBase){
        return Integer.toString(Integer.parseInt(number, inputBase), outputBase);
    }


}
