package com.example.valotracker1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(intent);
            }
        });
    }

    public void onAgentClick(View view) {
        Intent intent = new Intent(MainActivity3.this, BrimLineup.class);
        startActivity(intent);
    }
    public void onAgentClick2(View view) {
        Intent intent = new Intent(MainActivity3.this, ViperLineup.class);
        startActivity(intent);
    }
    public void onAgentClick3(View view) {
        Intent intent = new Intent(MainActivity3.this, KilljoyLineup.class);
        startActivity(intent);
    }
    public void onAgentClick4(View view) {
        Intent intent = new Intent(MainActivity3.this, LineupSova.class);
        startActivity(intent);
    }
    public void onAgentClick5(View view) {
            Intent intent = new Intent(MainActivity3.this, PhoenixLineup.class);
        startActivity(intent);
    }
    public void onAgentClick6(View view) {
        Intent intent = new Intent(MainActivity3.this, KayLineup.class);
        startActivity(intent);
    }
}
