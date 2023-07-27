package com.ldcc.example;

import com.ldcc.example.MyRouteMainActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면전환
                Intent intent = new Intent(MainActivity.this, MyRouteMainActivity.class);
                startActivity(intent);
            }
        });
    }
}