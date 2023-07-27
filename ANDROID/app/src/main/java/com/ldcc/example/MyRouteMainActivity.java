package com.ldcc.example;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MyRouteMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routemain);

        Button btn1 = (Button) findViewById(R.id.btn1);
        ImageButton imagebtn1 = (ImageButton) findViewById(R.id.imageButton1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면전환
                Intent intent = new Intent(MyRouteMainActivity.this, MyRouteRegistrationActivity.class);
                startActivity(intent);
            }
        });

        imagebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }
}
