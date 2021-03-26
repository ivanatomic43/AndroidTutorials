package com.example.androidtutoria2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewContext extends ListActivity {

    AbsListView.MultiChoiceModeListener
            mMultiChoiceModeListener = new
            AbsListView.MultiChoiceModeListener() {
                @Override
                public void onItemCheckedStateChanged(ActionMode mode,
                                                      int position, long id, boolean checked) {
                }

                @Override
                public boolean onCreateActionMode(ActionMode mode, Menu
                        menu) {
                    // Podizanje menija za CAB
                    MenuInflater inflater = mode.getMenuInflater();
                    inflater.inflate(R.menu.batch_context_menu, menu);
                    return true;
                }

                @Override
                public boolean onPrepareActionMode(ActionMode mode,
                                                   Menu menu) {
                    return false;
                }

                @Override
                public boolean onActionItemClicked(ActionMode mode,
                                                   MenuItem item) {
                    // Rukovanje odabirom menija
                    switch (item.getItemId()) {
                        case R.id.menu_move:
                            Toast.makeText(ListViewContext.this, "Move",
                                    Toast.LENGTH_SHORT).show();
                            mode.finish();
                            return true;
                        case R.id.menu_delete:
                            Toast.makeText(ListViewContext.this, "Delete",
                                    Toast.LENGTH_SHORT).show();
                            mode.finish();
                            return true;
                        default:
                            return false;
                    }
                }

                @Override
                public void onDestroyActionMode(ActionMode mode) {
                }

        };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_view_context);

        String[] countries = new String[]{"China", "France",
                "Germany", "India", "Russia", "United Kingdom",
                "United States"};
        ListAdapter countryAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_checked,
                countries);
        setListAdapter(countryAdapter);
        getListView().setChoiceMode(
                ListView.CHOICE_MODE_MULTIPLE_MODAL);
        getListView().setMultiChoiceModeListener(
                mMultiChoiceModeListener);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View
                        view, int position, long id) {
                    ((ListView)parent).setItemChecked(position,
                            true);
                }
        });



    }
}