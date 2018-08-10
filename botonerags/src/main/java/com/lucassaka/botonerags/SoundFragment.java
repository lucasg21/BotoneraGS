package com.lucassaka.botonerags;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

public class SoundFragment extends android.support.v4.app.Fragment {

    private SoundPlayer mSoundPlayer;
    private int groupId;
    static FirstPageFragmentListener firstPageListener;

    public SoundFragment(FirstPageFragmentListener listener) {
        firstPageListener = listener;
    }

    public SoundFragment(){

    }

    public void backPressed() {
        firstPageListener.onSwitchToNextFragment(groupId);
    }

    public static SoundFragment newInstance(int groupId, FirstPageFragmentListener listener) {
        SoundFragment newSoundFragment = new SoundFragment(listener);

        Bundle args = new Bundle();
        args.putInt("groupId", groupId);
        newSoundFragment.setArguments(args);

        return newSoundFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.groupId = getArguments().getInt("groupId", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View buttonsView= inflater.inflate(R.layout.activity_buttons, container, false);

        // Main component of the buttons view
        TableLayout soundsTable = (TableLayout) buttonsView.findViewById(R.id.buttonsTable);
        soundsTable.removeAllViews();
        TableRow buttonRow = (TableRow) inflater.inflate(R.layout.buttonrow, null);

        mSoundPlayer = new SoundPlayer(this.getContext());
        final Sound[] soundArray = SoundStore.getSounds(this.getContext());
        ArrayList<Sound> groupSounds = new ArrayList<>();
        for(Sound sound: soundArray){
            if (sound.getGroupId() == this.groupId){
                groupSounds.add(sound);
            }
        }

        for(int i=0; i < groupSounds.size(); i += 2){
            Sound leftButtonSound = groupSounds.get(i);
            Sound rightButtonSound = groupSounds.get(i+1);

            soundsTable.addView(this.getButtonsRow(leftButtonSound,rightButtonSound,buttonRow));

            //Reset buttonRow template layout
            buttonRow = (TableRow) inflater.inflate(R.layout.buttonrow,null);
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

    private TableRow getButtonsRow(Sound leftButtonSound, Sound rightButtonSound, TableRow buttonRow){
        Button leftButton;
        Button rightButton;

        leftButton = (Button) buttonRow.findViewById(R.id.leftButtonId);
        rightButton = (Button) buttonRow.findViewById(R.id.rightButtonId);

        leftButton.setText(leftButtonSound.getName());
        leftButton.setId(leftButtonSound.getButtonId());
        leftButton.setLongClickable(true);
        this.setClickListener(leftButton,leftButtonSound);
        this.setLongClickListener(leftButton,leftButtonSound);

        rightButton.setText(rightButtonSound.getName());
        rightButton.setId(rightButtonSound.getButtonId());
        rightButton.setLongClickable(true);
        this.setClickListener(rightButton,rightButtonSound);
        this.setLongClickListener(rightButton,rightButtonSound);

        return buttonRow;
    }
}