package model;

import android.graphics.Color;

import java.util.Observable;

/**
 * The model holds the implementation data for the app.

 * @author pate0304@AlgonquinCollege.com
 */
public class HSVModel extends Observable {

    // variables
    public static final Integer MAX_HUE= 359;
    public static final Integer MAX_SAT= 100;
    public static final Integer MAX_VAL= 100;
    public static final Integer MIN_HUE= 0;
    public static final Integer MIN_HSV=0;
    private float hue;
    private float saturation;
    private float value;

// constructors for the HSVModel
    public HSVModel()
    {
        this.hue= MAX_HUE;
        this.saturation= MAX_SAT;
        this.value= MAX_VAL;
    }
    //making methods for buttons to change colors on colorSwatch by button press
    public void asBlack() { this.setHSV( 0,0,0 ); }
    public void asRed() { this.setHSV( 0,100,100 ); }
    public void asLime() { this.setHSV( 120,100,100 ); }
    public void asBlue() { this.setHSV( 240,100,100 ); }
    public void asYellow() { this.setHSV( 60,100,100 ); }
    public void asCyan() { this.setHSV( 180,100,100 ); }
    public void asMagenta() { this.setHSV( 300,100,100 ); }
    public void asSilver() { this.setHSV( 0,0,75 ); }
    public void asGray() { this.setHSV( 0,0,50 ); }
    public void asMaroon() { this.setHSV( 0,100,50 ); }
    public void asOlive() { this.setHSV( 60,100,50 ); }
    public void asGreen() { this.setHSV( 120,100,50 ); }
    public void asPurple() { this.setHSV( 300,100,50 ); }
    public void asTeal() { this.setHSV( 180,100,50 ); }
    public void asNavy() { this.setHSV( 240,100,50 ); }

    // getters
    public float getHue()
    {
        return hue;
    }

    public float getSaturation()
    {
        return saturation;
    }

    public float getValue()
    {
        return value;
    }

    // setters
    public void setHue( float hue )
    {
        this.hue = hue;
        this.updateObservers();
    }

    public void setSaturation(float saturation)
    {
        this.saturation = saturation;
        this.updateObservers();
    }

    public void setValue(float value)
    {
        this.value = value;
        this.updateObservers();
    }

    // multiple args method to set HSV
    public void setHSV(float hue, float saturation, float value)
    {
        this.hue   = hue;
        this.saturation = saturation;
        this.value = value;
        this.updateObservers();
    }


    private void updateObservers()
    {
        this.setChanged();
        this.notifyObservers();
    }

}
