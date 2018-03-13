package com.example.jesusjimsa.shoponline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;

public class detailed extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detailed);

		Intent intent = getIntent();
		String album_cover = intent.getStringExtra("album_cover");
		String album_name = intent.getStringExtra("album_name");
		String album_info = intent.getStringExtra("album_info");

		ImageView img = findViewById(R.id.album_cover);
		int resourceID = getResources().getIdentifier(album_cover, "drawable", getPackageName());
		img.setImageResource(resourceID);

		TextView text_name = findViewById(R.id.album_name);
		resourceID = getResources().getIdentifier(album_name, "string", getPackageName());
		text_name.setText(resourceID);

		TextView text_info = findViewById(R.id.album_info);
		resourceID = getResources().getIdentifier(album_info, "string", getPackageName());
		text_info.setText(resourceID);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_shop, menu);
		return true;
	}
}
