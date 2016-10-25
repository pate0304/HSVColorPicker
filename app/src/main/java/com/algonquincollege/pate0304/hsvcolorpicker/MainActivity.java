package com.algonquincollege.pate0304.hsvcolorpicker;
/**
 *  HSV color picker for Android
 *  @author Jay Patel (pate0304@algonquinlive.com)
 */

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;


import model.HSVModel;


public class MainActivity extends AppCompatActivity implements Observer, SeekBar.OnSeekBarChangeListener {
    //Variables declaration for class
    private static final String ABOUT_DIALOG_TAG;
    private AboutDialogFragment mAboutDialog;

    static {
        ABOUT_DIALOG_TAG = "About Dialog";
    }

    private TextView mColorSwatch;
    private HSVModel mModel;
    private SeekBar mHueSB;
    private SeekBar mSatSB;
    private SeekBar mValSB;
    private TextView mHueVal;
    private TextView mSatVal;
    private TextView mValVal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAboutDialog = new AboutDialogFragment();

        // creating instance of HSVModel mModel
        mModel = new HSVModel();
        //defining HSV to min values for black colorSwatch
        mModel.setHue(HSVModel.MIN_HSV);
        mModel.setSaturation(HSVModel.MIN_HSV);
        mModel.setValue(HSVModel.MIN_HSV);
        mModel.addObserver(this);

        // get the views in member variables
        mColorSwatch = (TextView) findViewById(R.id.colorSwatch);
        mHueSB = (SeekBar) findViewById(R.id.hueBar);
        mSatSB = (SeekBar) findViewById(R.id.saturationBar);
        mValSB = (SeekBar) findViewById(R.id.valueBar);
        mHueVal = (TextView) findViewById(R.id.hueVal);
        mSatVal = (TextView) findViewById(R.id.satVal);
        mValVal = (TextView) findViewById(R.id.valVal);

        mHueSB.setMax(HSVModel.MAX_HUE);
        mSatSB.setMax(HSVModel.MAX_SAT);
        mValSB.setMax(HSVModel.MAX_VAL);

        mHueSB.setOnSeekBarChangeListener(this);
        mSatSB.setOnSeekBarChangeListener(this);
        mValSB.setOnSeekBarChangeListener(this);
        // update the model view
        this.updateView();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {

            mAboutDialog.show(getFragmentManager(), ABOUT_DIALOG_TAG);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //to get toast on click on colorswatch
    public void showHsvvalue(View view){
        if(view.getId()==R.id.colorSwatch){
             float a=mModel.getHue();
            float b=mModel.getSaturation();
            float c=mModel.getValue();
            Toast.makeText(this, "HUE: "+a+"\t\tSATURATION: "+b+"\t\tVALUE: "+c, Toast.LENGTH_SHORT).show();
        }
    }

    //changing colorSwatch color by buttons from horizontal scroll
    public void changeColor(View view) {


        switch (view.getId()) {

            //using case to change color and making toast of color name
            case R.id.blackButton:
                Toast.makeText(this, "Black", Toast.LENGTH_SHORT).show();
                mModel.asBlack();
                break;

            case R.id.redButton:
                Toast.makeText(this, "Red", Toast.LENGTH_SHORT).show();
                mModel.asRed();
                break;

            case R.id.limeButton:
                Toast.makeText(this, "Lime", Toast.LENGTH_SHORT).show();
                mModel.asLime();
                break;

            case R.id.blueButton:
                Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show();
                mModel.asBlue();
                break;

            case R.id.yellowButton:
                Toast.makeText(this, "Yellow", Toast.LENGTH_SHORT).show();
                mModel.asYellow();
                break;

            case R.id.cyanButton:
                Toast.makeText(this, "Cyan", Toast.LENGTH_SHORT).show();
                mModel.asCyan();
                break;

            case R.id.magentaButton:
                Toast.makeText(this, "Magenta", Toast.LENGTH_SHORT).show();
                mModel.asMagenta();
                break;

            case R.id.silverButton:
                Toast.makeText(this, "Silver", Toast.LENGTH_SHORT).show();
                mModel.asSilver();
                break;

            case R.id.grayButton:
                Toast.makeText(this, "Gray", Toast.LENGTH_SHORT).show();
                mModel.asGray();
                break;

            case R.id.maroonButton:
                Toast.makeText(this, "Maroon", Toast.LENGTH_SHORT).show();
                mModel.asMaroon();
                break;

            case R.id.oliveButton:
                Toast.makeText(this, "Olive", Toast.LENGTH_SHORT).show();
                mModel.asOlive();
                break;

            case R.id.greenButton:
                Toast.makeText(this, "Green", Toast.LENGTH_SHORT).show();
                mModel.asGreen();
                break;

            case R.id.purpleButton:
                Toast.makeText(this, "Purple", Toast.LENGTH_SHORT).show();
                mModel.asPurple();
                break;

            case R.id.tealButton:
                Toast.makeText(this, "Teal", Toast.LENGTH_SHORT).show();
                mModel.asTeal();
                break;

            case R.id.navyButton:
                Toast.makeText(this, "Navy", Toast.LENGTH_SHORT).show();
                mModel.asNavy();
                break;
        }


    }


    //updating view


    private void updateColorSwatch() {
        //updating colorSwatch color from the  seekbar values
        int theColor = Color.HSVToColor(new float[]{mModel.getHue(), mModel.getSaturation() / 100, mModel.getValue() / 100});
        mColorSwatch.setBackgroundColor(theColor);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // Did the user cause this event?
        // YES > continue
        // NO  > leave this method
        if ( fromUser == false ) {
            return;
        }
        // Determine which <SeekBark> caused the event (switch + case)
        // GET the SeekBar's progress, and SET the model to it's new value
        switch (seekBar.getId()) {
            case R.id.hueBar:
                mModel.setHue((float) progress);
                mHueVal.setText(getResources().getString(R.string.hueValue, progress).toUpperCase());
                break;

            case R.id.saturationBar:
                mModel.setSaturation((float) progress);
                mSatVal.setText(getResources().getString(R.string.satValue, progress).toUpperCase());
                break;

            case R.id.valueBar:
                mModel.setValue((float) progress);
                mValVal.setText(getResources().getString(R.string.valValue, progress).toUpperCase());
                break;

        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void update(Observable observable, Object data) {
        this.updateView();
    }

    public void updateView() {
        this.updateColorSwatch();
    }
}
