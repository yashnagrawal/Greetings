package com.example.units;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private View editInput;
    private Button btnConvert;
    private TextView txtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editInput=findViewById(R.id.edit_input);
        btnConvert=findViewById(R.id.btn_convert);
        txtOutput=findViewById(R.id.txt_output);

        btnConvert.setOnClickListener(v->{
            double input = Double.parseDouble(editInput.getText().toString());
            double output = TempretureConverter.fahrenheitToCelcius(input);
            Log.i(TAG, "Input: "+input);
            txtOutput.setText(Double.toString(output));

        });
        
    }
}