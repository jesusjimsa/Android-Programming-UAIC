package com.example.jesusjimsa.shoponline;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);

		Button empty_cart_button = findViewById(R.id.empty_cart);

		empty_cart_button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				Alert(v);
			}
		});
	}

	public void Alert(View view){
		FragmentManager fragment = getFragmentManager();
		EmptyCartDialog dialog = new EmptyCartDialog();

		dialog.show(fragment, "empty");
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
				intent = new Intent(Settings.this, Home.class);

				this.startActivity(intent);

				break;
			case R.id.cart:
				intent = new Intent(Settings.this, Cart.class);

				this.startActivity(intent);

				break;
			case R.id.settings:
				// Nothing, you are already there

				break;
			default:
				return super.onContextItemSelected(item);
		}

		return true;
	}
}
