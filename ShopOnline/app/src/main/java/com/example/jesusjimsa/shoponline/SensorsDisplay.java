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

	private SensorManager sensor_manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	private TextView sensors_text = findViewById(R.id.sensor);
	private boolean accelerometer, ambient_temperature, geomagnetic, gravity, gyroscope;
	private boolean heart_beat, heart_rate, light, linear_acceleration, magnetic_field;
	private boolean motion_detect, orientation, pose, pressure, proximity, humidity;
	private boolean stationary_detect, step_counter, step_detector;
	private boolean loop;
	private Sensor accelerometer_sensor, ambient_temperature_sensor, geomagnetic_sensor, gravity_sensor;
	private Sensor gyroscope_sensor, heart_beat_sensor, heart_rate_sensor, light_sensor;
	private Sensor linear_acceleration_sensor, magnetic_field_sensor, motion_detect_sensor, pose_sensor;
	private Sensor pressure_sensor, proximity_sensor, humidity_sensor, stationary_detect_sensor;
	private Sensor step_counter_sensor, step_detector_sensor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensors_display);

		loop = true;
	}

	@Override
	protected void onStart(){
		super.onStart();

		checkSensors();
		displaySensorsInfo();
	}

	protected void checkSensors(){
		accelerometer = sensor_manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null;
		ambient_temperature = sensor_manager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null;
		geomagnetic = sensor_manager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR) != null;
		gravity = sensor_manager.getDefaultSensor(Sensor.TYPE_GRAVITY) != null;
		gyroscope = sensor_manager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null;
		heart_beat = sensor_manager.getDefaultSensor(Sensor.TYPE_HEART_BEAT) != null;
		heart_rate = sensor_manager.getDefaultSensor(Sensor.TYPE_HEART_RATE) != null;
		light = sensor_manager.getDefaultSensor(Sensor.TYPE_LIGHT) != null;
		linear_acceleration = sensor_manager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION) != null;
		magnetic_field = sensor_manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null;
		motion_detect = sensor_manager.getDefaultSensor(Sensor.TYPE_MOTION_DETECT) != null;
		orientation = true;		//SensorManager.getOrientation()
		pose = sensor_manager.getDefaultSensor(Sensor.TYPE_POSE_6DOF) != null;
		pressure = sensor_manager.getDefaultSensor(Sensor.TYPE_PRESSURE) != null;
		proximity = sensor_manager.getDefaultSensor(Sensor.TYPE_PROXIMITY) != null;
		humidity = sensor_manager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY) != null;
		stationary_detect = sensor_manager.getDefaultSensor(Sensor.TYPE_STATIONARY_DETECT) != null;
		step_counter = sensor_manager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null;
		step_detector = sensor_manager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null;
	}

	protected void setSensors(){
		accelerometer_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		ambient_temperature_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
		geomagnetic_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);
		gravity_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_GRAVITY);
		gyroscope_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
		heart_beat_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_HEART_BEAT);
		heart_rate_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_HEART_RATE);
		light_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_LIGHT);
		linear_acceleration_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
		magnetic_field_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
		motion_detect_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_MOTION_DETECT);
		pose_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_POSE_6DOF);
		pressure_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_PRESSURE);
		proximity_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		humidity_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
		stationary_detect_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_STATIONARY_DETECT);
		step_counter_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
		step_detector_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
	}

	protected void displaySensorsInfo(){
		String sensors_info;
		SensorEvent sensor_listener;

		setSensors();

		while(loop) {
			sensors_info = "";

			if (accelerometer) {
				sensors_info += "Accelerometer: ";
				// add sensor info
				sensor_manager.registerListener(this, accelerometer_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			if (ambient_temperature) {
				sensors_info += "Ambient temperature: ";
				// add sensor info
				sensor_manager.registerListener(this, ambient_temperature_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			if (geomagnetic) {
				sensors_info += "Geomagnetic rotation: ";
				// add sensor info
				sensor_manager.registerListener(this, geomagnetic_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			if (gravity) {
				sensors_info += "Gravity: ";
				// add sensor info
				sensor_manager.registerListener(this, gravity_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			if (gyroscope) {
				sensors_info += "Gyroscope: ";
				// add sensor info
				sensor_manager.registerListener(this, gyroscope_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			if (heart_beat) {
				sensors_info += "Heart beat: ";
				// add sensor info
				sensor_manager.registerListener(this, heart_beat_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			if (heart_rate) {
				sensors_info += "Heart rate: ";
				// add sensor info
				sensor_manager.registerListener(this, heart_rate_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			if (light) {
				sensors_info += "Light: ";
				// add sensor info
				sensor_manager.registerListener(this, light_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			if (linear_acceleration) {
				sensors_info += "Linear acceleration: ";
				// add sensor info
				sensor_manager.registerListener(this, linear_acceleration_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			if (magnetic_field) {
				sensors_info += "Magnetic field: ";
				// add sensor info
				sensor_manager.registerListener(this, magnetic_field_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			if (motion_detect) {
				sensors_info += "Motion detect: ";
				// add sensor info
				sensor_manager.registerListener(this, motion_detect_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			if (orientation) {
				sensors_info += "Orientation: ";
				// add sensor info
				float[] R = new float[4];
				float[] values = new float[3];

				sensor_manager.getOrientation(R, values);
				sensors_info += values[0] + ", " + values[1] + ", " + values[2];
				sensors_info += "\n";
			}

			if (pose) {
				sensors_info += "Pose: ";
				// add sensor info
				sensor_manager.registerListener(this, pose_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			if (pressure) {
				sensors_info += "Pressure: ";
				// add sensor info
				sensor_manager.registerListener(this, pressure_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			if (proximity) {
				sensors_info += "Proximity: ";
				// add sensor info
				sensor_manager.registerListener(this, proximity_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			if (humidity) {
				sensors_info += "Humidity: ";
				// add sensor info
				sensor_manager.registerListener(this, humidity_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			if (stationary_detect) {
				sensors_info += "Stationary detect: ";
				// add sensor info
				sensor_manager.registerListener(this, stationary_detect_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			if (step_counter) {
				sensors_info += "Step counter: ";
				// add sensor info
				sensor_manager.registerListener(this, step_counter_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			if (step_detector) {
				sensors_info += "Step detector: ";
				// add sensor info
				sensor_manager.registerListener(this, step_detector_sensor, SensorManager.SENSOR_DELAY_NORMAL);
				sensors_info += "\n";
			}

			sensors_text.setText(sensors_info);
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		sensor_manager.unregisterListener(this);
		loop = false;
	}

	@Override
	protected void onStop() {
		super.onStop();
		sensor_manager.unregisterListener(this);
		loop = false;
	}

	@Override
	protected void onResume() {
		super.onResume();
		sensor_manager.registerListener(this, accelerometer_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, ambient_temperature_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, geomagnetic_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, gravity_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, gyroscope_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, heart_beat_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, heart_rate_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, light_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, linear_acceleration_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, magnetic_field_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, motion_detect_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, pose_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, pressure_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, proximity_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, humidity_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, stationary_detect_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, step_counter_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, step_detector_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, accelerometer_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		loop = true;
	}

	@Override
	public void onSensorChanged(SensorEvent sensorEvent) {

	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int i) {

	}
}
