package com.example.greetings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView greeting=findViewById(R.id.greeting);
        greeting.setText(getResources().getString(R.string.Yash));
        greeting.setTextColor(getResources().getColor(R.color.red));
    }
}