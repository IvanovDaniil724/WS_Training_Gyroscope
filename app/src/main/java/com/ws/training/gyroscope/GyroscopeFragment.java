package com.ws.training.gyroscope;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class GyroscopeFragment extends Fragment implements SensorEventListener {

    ImageView arrow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gyroscope, container, false);

        SensorManager sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager.registerListener(this, sensor, SensorManager.AXIS_Z);

        arrow = root.findViewById(R.id.Gyroscope_ImageView);
        arrow.setImageResource(R.drawable.ic_home_black_24dp);
        return root;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.e("dsvdv", String.valueOf(event.values[2]));
        arrow.setRotation(event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}