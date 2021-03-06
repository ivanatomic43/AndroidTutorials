package com.example.managesmsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.managesmsapp.MainActivity;
import com.example.managesmsapp.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView textView = (TextView)findViewById(R.id.textViewText);

        if(getIntent()!= null && getIntent().hasExtra(Intent.EXTRA_TEXT)){
            textView.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));
        }
    }

    public void onClickClose(View view) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(MainActivity.REQUEST_RESULT, 42);
        setResult(RESULT_OK, returnIntent);
        finish();
    }


}