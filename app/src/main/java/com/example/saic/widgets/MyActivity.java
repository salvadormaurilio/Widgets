package com.example.saic.widgets;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends ActionBarActivity implements CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private EditText editText;
    private TextView textViewSeekBar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        editText = (EditText) findViewById(R.id.editText);

        Button buttonEditText = (Button) findViewById(R.id.buttonEditText);
        buttonEditText.setOnClickListener(this);

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(this);

        Switch aSwitch = (Switch) findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(this);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(this);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        startProgressBar(progressBar);

        textViewSeekBar = (TextView) findViewById(R.id.textViewSeekBar);
        textViewSeekBar.setText("0");
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button:
                Toast.makeText(this, "Esto es un botón", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonEditText:
                Toast.makeText(this, editText.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView:
                imageView.setImageResource(R.drawable.unam_mobile);
                break;
        }


    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        switch (compoundButton.getId()) {
            case R.id.checkBox:
                Toast.makeText(this, "CheckBox: " + b, Toast.LENGTH_SHORT).show();
                break;
            case R.id.switch1:
                Toast.makeText(this, "Switch: " + b, Toast.LENGTH_SHORT).show();
                break;
        }
    }


    private void startProgressBar(final ProgressBar progressBar) {

        final int totalProgressTime = 100;

        final Thread t = new Thread() {

            @Override
            public void run() {

                int jumpTime = 0;
                while (true) {
                    if (jumpTime < totalProgressTime) {
                        try {
                            sleep(200);
                            jumpTime += 5;
                            progressBar.setProgress(jumpTime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        jumpTime = 0;
                        progressBar.setProgress(jumpTime);
                    }
                }

            }
        };
        t.start();

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        textViewSeekBar.setText("" + i);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        switch (i) {
            case R.id.radioButton1:
                Toast.makeText(this, "Radio Button: 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton2:
                Toast.makeText(this, "Radio Button: 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton3:
                Toast.makeText(this, "Radio Button: 3", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
