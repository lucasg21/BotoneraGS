package com.lucassaka.botonerags;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.net.URISyntaxException;

/**
 * Created by Lucas on 23/03/2016.
 */
public class SongFragment extends Fragment{
    public SongFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View SongsView=inflater.inflate(R.layout.activity_playlist,container,false);

        PackageManager pm = this.getContext().getPackageManager();
        final boolean isSpotifyInstalled = isPackageInstalled("com.spotify.music", pm);

        ImageButton spotifyBtn;
        spotifyBtn=(ImageButton)SongsView.findViewById(R.id.spotifyButton);
        spotifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSpotifyInstalled) {
                    MyApplication.getInstance().trackEvent("Cancion", "Play", "Playlist Spotify");
                    final Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
                    intent.setData(Uri.parse("spotify:user:1249145867:playlist:60HSSD4sVZFAR4ha5wF2NV:play"));
                    intent.setPackage("com.spotify.music");
                    startActivity(intent);
                }
                else{
                    MyApplication.getInstance().trackEvent("Cancion", "Play", "Spotify uninstalled");
                    Toast.makeText(getContext(),"Instala Spotify para poder escuchar la playlist",Toast.LENGTH_LONG).show();
                    final String appPackageName = "com.spotify.music";
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
                    }
                }
            }
        });

        return SongsView;
    }

    private boolean isPackageInstalled(String packagename, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}



