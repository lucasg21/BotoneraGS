package com.lucassaka.botonerags;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;


public class SoundGroupFragment extends android.support.v4.app.Fragment {

    public SoundGroupFragment() {
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

        // Main component of the buttons view
        TableLayout groupsTable = (TableLayout) buttonsView.findViewById(R.id.buttonsTable);
        TableRow buttonRow = (TableRow) inflater.inflate(R.layout.buttonrow, null);

        final SoundGroup[] soundGroupArray = SoundGroupStore.getSoundGroups(this.getContext());

        for(int i=0; i < soundGroupArray.length; i += 2){
            SoundGroup leftButtonSoundGroup = soundGroupArray[i];
            SoundGroup rightButtonSoundGroup = soundGroupArray[i+1];

            groupsTable.addView(this.getButtonsRow(leftButtonSoundGroup,rightButtonSoundGroup,
                    buttonRow));

            //Reset buttonRow template layout
            buttonRow = (TableRow) inflater.inflate(R.layout.buttonrow,null);
        }

        return buttonsView;
    }

    private void setClickListener(Button aButton,final SoundGroup s) {
        aButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent soundIntent = new Intent(getContext(),SoundFragment.class);
                soundIntent.putExtra("groupId",s.getGroupId());
                startActivity(soundIntent);
                MyApplication.getInstance().trackEvent("Grupo", "Click", s.getName());
            }
        });
    }

    private TableRow getButtonsRow(SoundGroup leftButtonGroupSound,
                                   SoundGroup rightButtonGroupSound,
                                   TableRow buttonRow){
        Button leftButton;
        Button rightButton;

        leftButton = (Button) buttonRow.findViewById(R.id.leftButtonId);
        rightButton = (Button) buttonRow.findViewById(R.id.rightButtonId);

        leftButton.setText(leftButtonGroupSound.getName());
        leftButton.setId(leftButtonGroupSound.getButtonId());
        leftButton.setBackgroundResource(leftButtonGroupSound.getResourceId());
        this.setClickListener(leftButton,leftButtonGroupSound);

        rightButton.setText(rightButtonGroupSound.getName());
        rightButton.setId(rightButtonGroupSound.getButtonId());
        rightButton.setBackgroundResource(rightButtonGroupSound.getResourceId());
        this.setClickListener(rightButton,rightButtonGroupSound);

        return buttonRow;
    }
}
