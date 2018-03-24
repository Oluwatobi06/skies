package com.skies.ajayioluwatobi.skies;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class Throw_Phone extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor gyroSensor;
    private double rate = 0;
    //private boolean ready = false;
    private HashMap<Double,Float> accToTime = new HashMap<Double,Float>();
    private long mLastTimestamp = System.nanoTime();
    private double secondsElapsed = 0;
    enum States {Start,Finish};
    private States state = States.Start;
    private int score= 100;
    private static final int MORE_MS = 25000000;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_throw__phone);
        final ImageView hand= findViewById(R.id.hand_image);
        final ImageView phone= findViewById(R.id.phone_image);
        final TextView spin_text= findViewById(R.id.spin_text);
        final TextView your_score= findViewById(R.id.your_score_text);
        final TextView score_text= findViewById(R.id.score_text);

        your_score.setVisibility(View.INVISIBLE);
        score_text.setVisibility(View.INVISIBLE);

        mSensorManager = (SensorManager) getSystemService(this.SENSOR_SERVICE);
        //mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        gyroSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        //gravity = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        mSensorManager.registerListener(Throw_Phone.this, gyroSensor, SensorManager.SENSOR_DELAY_NORMAL);
        //mSensorManager.registerListener(MainActivity.this, gravity, SensorManager.SENSOR_DELAY_NORMAL);
        //Declare the timer
        Timer t = new Timer();
        //Set the schedule function and rate
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        secondsElapsed += 0.25;
                        if(state == States.Finish){
                            hand.setVisibility(View.INVISIBLE);
                            phone.setVisibility(View.INVISIBLE);
                            your_score.setVisibility(View.VISIBLE);
                            score_text.setText(String.valueOf(rate));
                            score_text.setVisibility(View.VISIBLE);

                            Intent returnIntent = new Intent();
                            returnIntent.putExtra("rate",rate);
                            setResult(Activity.RESULT_OK,returnIntent);
                        }
                    }
                });
            }

        }, 0, 250);//0.25 seconds

    }
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(Throw_Phone.this);
    }
    protected void onResume(){
        super.onResume();
    }
    protected void onStop(){
        super.onStop();
        mSensorManager.unregisterListener(Throw_Phone.this);
    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public void onSensorChanged(SensorEvent event) {
        if(event.timestamp - mLastTimestamp < MORE_MS) return;
            TextView1(Math.abs(event.values[2]));
            if(event.values[2] > rate) {
                rate = Math.abs(event.values[2]);
                TextView2(rate);
            }
            if(secondsElapsed > 10) {
                mSensorManager.unregisterListener(Throw_Phone.this);
                state = States.Finish;
            }


        mLastTimestamp = event.timestamp;
    }

    public void TextView1(final double a) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
    public void TextView2(final double a) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
    public void update(final float a, final float b, final float c) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
