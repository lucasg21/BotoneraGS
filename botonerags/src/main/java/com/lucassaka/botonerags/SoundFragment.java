package com.lucassaka.botonerags;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SoundFragment extends android.support.v4.app.Fragment {

    private SoundPlayer mSoundPlayer;
    public SoundFragment() {
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
        View buttonsView= inflater.inflate(R.layout.activity_buttons, container, false);

        mSoundPlayer = new SoundPlayer(this.getContext());
        final Sound[] soundArray = SoundStore.getSounds(this.getContext());

        for(Sound s:soundArray){
            Button aButton;
            aButton=(Button) buttonsView.findViewById(s.getButtonId());
            aButton.setLongClickable(true);
            this.setClickListener(aButton,s);
            this.setLongClickListener(aButton,s);
        }
        return buttonsView;
    }

    private void setClickListener(Button aButton,final Sound s) {
        aButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mSoundPlayer.playSound(s);
                MyApplication.getInstance().trackEvent("Sonido", "Play", s.getName());
            }
        });
    }

    private void setLongClickListener(Button aButton, final Sound s) {
        aButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
            Intent interactionIntent = new Intent(getContext(),SoundInteractionActivity.class);
            interactionIntent.putExtra("soundId",s.getResourceId());
            startActivity(interactionIntent);
            return true;
            }
        });
    }
}