package com.example.managesmsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.managesmsapp.activity.LayoutActivity;
import com.example.managesmsapp.activity.ListView;
import com.example.managesmsapp.activity.LoginActivity;
import com.example.managesmsapp.activity.Runtime;

public class MainActivity extends AppCompatActivity {

    public static final String REQUEST_RESULT="REQUEST_RESULT";
    static final String KEY_COUNTER = "COUNTER";
    private int mCounter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchIntent(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.ittutorijali.net/"));
        startActivity(intent);
    }

    public void onClickSwitchActivity(View view) {
        EditText editText = (EditText)findViewById(R.id.editTextData);
        String text = editText.getText().toString();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Toast.makeText(this, Integer.toString(data.getIntExtra(REQUEST_RESULT, 0)),
                    Toast.LENGTH_LONG).show();
        }
    }

    public void onClickCounter(View view) {
        mCounter++;
        ((TextView)findViewById(R.id.textViewCounter)).setText(
                "Counter: " + Integer.toString(mCounter));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER,mCounter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCounter=savedInstanceState.getInt(KEY_COUNTER);
    }

    public void onClickRelative(View view){
        Intent intent = new Intent(this, LayoutActivity.class);
        startActivity(intent);

    }

    public void onClickListView(View view){
        Intent intent = new Intent(this, ListView.class);
        startActivity(intent);
    }

    public void onClickRuntime(View view){
        Intent intent = new Intent(this, Runtime.class);
        startActivity(intent);
    }

}