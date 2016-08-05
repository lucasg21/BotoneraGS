package com.lucassaka.botonerags;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

/**
 * Created by Lucas on 30/07/2016.
 */
public class SearchableActivity extends ListActivity {
    ArrayList<Sound> listSounds = new ArrayList<>();
    ArrayAdapter<Sound> soundAdapter;
    private SoundPlayer mSoundPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresults);

        mSoundPlayer = new SoundPlayer(this.getApplicationContext());

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("395F39CE8F56D34CBE41785D5F12B2C7")
                .addTestDevice("7C0CAD91C1F4E71ABF3D62F98FCD84D7") //S6 6.0 en Genymotion
                .build();

        mAdView.loadAd(adRequest);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }
    }

    private void doMySearch(String query) {
        soundAdapter= new ArrayAdapter<>(this,R.layout.resultitem,R.id.nombreSonido,listSounds);
        setListAdapter(soundAdapter);

        final Sound[] soundArray = SoundStore.getSounds(this.getApplicationContext());

        for (int i=0;i< soundArray.length;i++){
            boolean containsSound;
            containsSound=soundArray[i].getName().toLowerCase().contains(query.toLowerCase());
            if(containsSound){
                listSounds.add(soundArray[i]);
            }
        }
        soundAdapter.notifyDataSetChanged();
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Sound selectedSound = (Sound) getListAdapter().getItem(position);
        mSoundPlayer.playSound(selectedSound);
    }
}
