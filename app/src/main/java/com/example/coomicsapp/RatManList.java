package com.example.coomicsapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RatManList extends AppCompatActivity {

    private static final String TAG = "RatManList";

    DBHrm mDbh;

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);
        mListView = (ListView) findViewById(R.id.listView);
        mDbh = new DBHrm(this);
        populateListView();
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying in the listView.");

        Cursor data = mDbh.getData();
        final ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            listData.add(data.getString(1));
        }
        final ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String name = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You clicked on " + name);

                final Cursor data = mDbh.getItemID(name);
                int itemID = -1;
                while(data.moveToNext()){
                    itemID = data.getInt(0);
                }

                if(itemID > -1){
                    Log.d(TAG, "onItemClick: The ID is " + itemID);
                    Intent editScreenIntent = new Intent(RatManList.this, EditDataActivityRm.class);
                    editScreenIntent.putExtra("id", itemID);
                    editScreenIntent.putExtra("name", name);
                    startActivity(editScreenIntent);
                }else{
                    toastMessage("No ID associated with that name");
                }

                Button buttonSort = findViewById(R.id.button_sort);
                buttonSort.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Collections.sort(listData, new Comparator<String>() {
                            @Override
                            public int compare(String s, String t1) {
                                return s.compareTo(t1);
                            }
                        });
                        ((ArrayAdapter) adapter).notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
