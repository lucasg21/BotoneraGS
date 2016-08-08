package com.lucassaka.botonerags;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class SearchableActivity extends ListActivity {
    ArrayList<Sound> listSounds = new ArrayList<>();
    ArrayAdapter<Sound> soundAdapter;
    private SoundPlayer mSoundPlayer;
    TextView tituloTextView;

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
                .addTestDevice("6EC3AE8CA7007D6A0C8F4D37A740630C")
                .build();

        mAdView.loadAd(adRequest);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            tituloTextView= (TextView)findViewById(R.id.tituloBusqueda);
            tituloTextView.setText("Resultados para: " + query);
            doMySearch(query);
            MyApplication.getInstance().trackEvent("Otros","Busqueda",query);
        }

        ListView lv = (ListView) findViewById(android.R.id.list);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int pos, long id) {
                Sound longClickedSound = (Sound) getListAdapter().getItem(pos);
                Intent interactionIntent = new Intent(SearchableActivity.this,SoundInteractionActivity.class);
                interactionIntent.putExtra("soundId",longClickedSound.getResourceId());
                startActivity(interactionIntent);
                return true;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int pos, long id) {
                Sound selectedSound = (Sound) getListAdapter().getItem(pos);
                mSoundPlayer.playSound(selectedSound);
            }
        });
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
}
