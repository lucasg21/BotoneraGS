package com.lucassaka.botonerags;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Lucas on 30/07/2016.
 */
public class SearchableActivity extends ListActivity {
    ArrayAdapter<String> adapter;
    ArrayList<String> listItems=new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresults);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }
    }

    private void doMySearch(String query) {
        adapter=new ArrayAdapter<String>(this,
                R.layout.resultitem,R.id.nombreSonido,
                listItems);
        setListAdapter(adapter);

        final Sound[] soundArray = SoundStore.getSounds(this.getApplicationContext());

        for (int i=0;i< soundArray.length;i++){
            boolean containsSound;
            containsSound=soundArray[i].getName().toLowerCase().contains(query.toLowerCase());
            if(containsSound){
                listItems.add(soundArray[i].getName());
            }
        }
        adapter.notifyDataSetChanged();
    }
}
