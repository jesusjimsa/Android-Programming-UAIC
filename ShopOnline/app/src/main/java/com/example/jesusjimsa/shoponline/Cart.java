package com.example.jesusjimsa.shoponline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Cart extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cart);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_shop, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;

		switch (item.getItemId()) {
			case R.id.products:
				intent = new Intent(Cart.this, Home.class);

				this.startActivity(intent);

				break;
			case R.id.cart:
				// Nothing, you are already there

				break;
			case R.id.settings:
				intent = new Intent(Cart.this, Settings.class);

				this.startActivity(intent);

				break;
			case R.id.preferences:
				intent = new Intent(Cart.this, Preferences.class);

				this.startActivity(intent);

				break;
			case R.id.sensors:
				intent = new Intent(Cart.this, SensorsDisplay.class);

				this.startActivity(intent);

				break;
			default:
				return super.onContextItemSelected(item);
		}

		return true;
	}
}
