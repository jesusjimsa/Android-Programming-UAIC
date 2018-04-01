package com.example.jesusjimsa.shoponline;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SensorsDisplay extends AppCompatActivity implements SensorEventListener {

	private SensorManager sensor_manager;
	private TextView sensors_text;
	private Sensor light_sensor, proximity_sensor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensors_display);

		sensor_manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sensors_text = findViewById(R.id.sensor);

		light_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_LIGHT);
		proximity_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
	}

	@Override
	protected void onStart(){
		super.onStart();

		sensor_manager.registerListener(this, light_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, light_sensor, SensorManager.SENSOR_DELAY_NORMAL);
	}


	@Override
	protected void onPause() {
		super.onPause();

		sensor_manager.unregisterListener(this);
	}

	@Override
	protected void onStop() {
		super.onStop();

		sensor_manager.unregisterListener(this);
	}

	@Override
	protected void onResume() {
		super.onResume();

		sensor_manager.registerListener(this, light_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, proximity_sensor, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	public void onSensorChanged(SensorEvent sensorEvent) {
		int sensorType = sensorEvent.sensor.getType();
		float currentValue = sensorEvent.values[0];
		String sensors_info_l = "", sensors_info_p = "", sensors_info_o = "";
		String sensors_info;

		switch (sensorType) {
			case Sensor.TYPE_LIGHT:
				sensors_info_l += "Light: ";
				sensors_info_l += currentValue;
				sensors_info_l += "\n";

				break;
			case Sensor.TYPE_PROXIMITY:
				sensors_info_p += "Proximity: ";
				sensors_info_p += currentValue;
				sensors_info_p += "\n";

				break;
			default:
				sensors_info_o += "Orientation: ";
				// add sensor info
				float[] R = new float[4];
				float[] values = new float[3];

				sensor_manager.getOrientation(R, values);
				sensors_info_o += values[0] + ", " + values[1] + ", " + values[2];
				sensors_info_o += "\n";

				break;
		}

		sensors_info = sensors_info_l + sensors_info_p + sensors_info_o;

		sensors_text.setText(sensors_info);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int i) {

	}
}
