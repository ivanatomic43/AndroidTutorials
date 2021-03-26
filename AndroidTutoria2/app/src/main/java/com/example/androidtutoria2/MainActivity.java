    package com.example.androidtutoria2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ActionMode mActionMode;

    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback(){

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.context_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id. menu_cast:
                    Toast.makeText(MainActivity.this, "Cast",
                            Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id. menu_print:
                    Toast.makeText(MainActivity.this, "Print",
                            Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
                    mActionMode = null;
        }
    };

    private PopupMenu.OnMenuItemClickListener
            mOnMenuItemClickListener = new
            PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    // Handle menu selections
                    switch (item.getItemId()) {
                        case R.id.menu_reply:
                            Toast.makeText(MainActivity.this, "Reply",
                                    Toast.LENGTH_SHORT).show();
                            return true;
                        case R.id.menu_reply_all:
                            Toast.makeText(MainActivity.this,"Reply All",Toast.LENGTH_SHORT).show();
                            return true;
                        case R.id.menu_forward:
                            Toast.makeText(MainActivity.this,
                                    "Forward", Toast.LENGTH_SHORT).show();
                            return true;
                        default:
                            return false;
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView)findViewById(
                R.id.imageView);
        imageView.setOnLongClickListener(
                new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        if (mActionMode != null) return false;
                                mActionMode = startActionMode(mActionModeCallback);
                                return true;
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_settings){
            Toast.makeText(this, "Settings clicked!", Toast.LENGTH_LONG).show();
        } else if(item.getItemId() == R.id.menu_signin){
            Toast.makeText(this, "Sign in clicked!", Toast.LENGTH_LONG).show();
        }
        return true;
    }

    public void onClickListView(View view){
        Intent intent = new Intent(this, ListViewContext.class);
        startActivity(intent);
    }

    public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(
                MainActivity.this,view);
        popupMenu.inflate(R.menu.menu_popup);
        popupMenu.setOnMenuItemClickListener(
                mOnMenuItemClickListener);
        popupMenu.show();
    }



}