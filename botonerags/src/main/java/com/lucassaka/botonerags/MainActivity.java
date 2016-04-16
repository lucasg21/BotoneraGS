/*
 * Copyright (C) 2016 Lucas Gilone
 *
 *Licensed under the Apache License, Version 2.0 (the "License");
 *you may not use this file except in compliance with the License.
 *You may obtain a copy of the License at
 *
 *http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing, software
 *distributed under the License is distributed on an "AS IS" BASIS,
 *WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *See the License for the specific language governing permissions and
 *limitations under the License.
 */

package com.lucassaka.botonerags;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
//import android.os.StrictMode;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.kobakei.ratethisapp.RateThisApp;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = MainActivity.class.getSimpleName();

    //private final static boolean DEVELOPER_MODE = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar mToolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Custom criteria: 3 days and 10 launches
        RateThisApp.Config config = new RateThisApp.Config(3, 10);
        // Custom title and message
        config.setTitle(R.string.califica_title);
        config.setMessage(R.string.califica_body);
        RateThisApp.init(config);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.appbar_title);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("395F39CE8F56D34CBE41785D5F12B2C7")
                .addTestDevice("7C0CAD91C1F4E71ABF3D62F98FCD84D7") //S6 6.0 en Genymotion
                .build();

        mAdView.loadAd(adRequest);
        /*if (DEVELOPER_MODE) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .penaltyLog()
                    .penaltyFlashScreen()
                    .build());
        }*/
    }

    private void sendFeedback() {
        final Intent _Intent = new Intent(android.content.Intent.ACTION_SEND);
        _Intent.setType("text/mail");
        _Intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{getString(R.string.mail_feedback_email)});
        _Intent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.mail_feedback_subject));
        startActivity(Intent.createChooser(_Intent, getString(R.string.title_send_feedback)));
    }

    @Override
    public void onPause() {
        super.onPause();
        //mSoundPlayer.release();
    }

    @Override
    public void onStart() {
        super.onStart();
        RateThisApp.onStart(this);
        RateThisApp.showRateDialogIfNeeded(this);

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            sendFeedback();
            return true;
        }
        else{
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Usando los sonidos")
                    .setMessage("Si queres compartir el audio, " +
                            "mantené el boton apretado por unos segundos, selecciona la opción Compartir y elegí tu app de mensajería preferida. "+
                            "Además, podes guardarlo como ringtone!")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setIcon(R.drawable.ic_info_black_24dp)
                    .show();
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SoundFragment(), "Sonidos");
        adapter.addFragment(new SongFragment(), "Canciones");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
