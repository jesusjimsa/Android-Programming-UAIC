package com.example.jesusjimsa.shoponline;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SensorsDisplay extends AppCompatActivity implements SensorEventListener, LocationListener {

	private SensorManager sensor_manager;
	private TextView accelerometer_text, light_text, proximity_text;
	private Sensor light_sensor, proximity_sensor, accelerometer_sensor;

	private LocationManager locationManager;
	TextView location_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensors_display);

		sensor_manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		accelerometer_text = findViewById(R.id.accelerometer_sensor);
		light_text = findViewById(R.id.light_sensor);
		proximity_text = findViewById(R.id.proximity_sensor);

		light_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_LIGHT);
		proximity_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		accelerometer_sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

		location_text = findViewById(R.id.location);

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		LocationListener locationListener = new LocationListener() {
			@Override
			public void onLocationChanged(Location location) {
				String location_string = "Location changed: Lat: " + location.getLatitude() + " Lng: " + location.getLongitude();

				location_text.setText(location_string);
			}

			@Override
			public void onStatusChanged(String s, int i, Bundle bundle) {

			}

			@Override
			public void onProviderEnabled(String s) {

			}

			@Override
			public void onProviderDisabled(String s) {

			}
		};

		if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			// TODO: Consider calling
			//    ActivityCompat#requestPermissions
			// here to request the missing permissions, and then overriding
			//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
			//                                          int[] grantResults)
			// to handle the case where the user grants the permission. See the documentation
			// for ActivityCompat#requestPermissions for more details.
			//return;
		}

		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, locationListener);
	}

	@Override
	protected void onStart(){
		super.onStart();


		sensor_manager.registerListener(this, light_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, proximity_sensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensor_manager.registerListener(this, accelerometer_sensor, SensorManager.SENSOR_DELAY_NORMAL);
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
		sensor_manager.registerListener(this, accelerometer_sensor, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	public void onSensorChanged(SensorEvent sensorEvent) {
		int sensorType = sensorEvent.sensor.getType();
		float currentValue = sensorEvent.values[0];
		float current_acc2 = sensorEvent.values[1];
		float current_acc3 = sensorEvent.values[2];

		switch (sensorType) {
			case Sensor.TYPE_LIGHT:
				light_text.setText(getResources().getString(R.string.light, currentValue));

				break;
			case Sensor.TYPE_PROXIMITY:
				proximity_text.setText(getResources().getString(R.string.proximity, currentValue));

				break;
			case Sensor.TYPE_ACCELEROMETER:
				accelerometer_text.setText(getResources().getString(R.string.accelerometer, currentValue, current_acc2, current_acc3));

				break;
			default:
				// Nothing

				break;
		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int i) {

	}


	@Override
	public void onLocationChanged(Location location) {
		String location_string = "Location changed: Lat: " + location.getLatitude() + " Lng: " + location.getLongitude();

		location_text.setText(location_string);
	}

	@Override
	public void onStatusChanged(String s, int i, Bundle bundle) {

	}

	@Override
	public void onProviderEnabled(String s) {

	}

	@Override
	public void onProviderDisabled(String s) {

	}
}
