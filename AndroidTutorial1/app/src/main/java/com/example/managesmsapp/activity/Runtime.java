package com.example.managesmsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;

import com.example.managesmsapp.R;

public class Runtime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TextView)findViewById(R.id.textView)).setText("ChangedOnRuntime");
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)view.getLayoutParams();
                params.leftMargin += 5;

            }
        });
    }
}