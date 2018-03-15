package com.example.jesusjimsa.shoponline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.Menu;

public class Home extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		ListView listView = findViewById(R.id.list_albums);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long id){
				Intent intent = new Intent();
				String album_cover = "";
				String album_name = "";
				String album_info = "";

				switch(position){
					case 0:
						intent = new Intent(Home.this, detailed.class);
						album_cover = "please_please_me";
						album_name = "please_please_me";
						album_info = "please_please_me_desc";

						break;
					case 1:
						intent = new Intent(Home.this, detailed.class);
						album_cover = "with_the_beatles";
						album_name = "with_the_beatles";
						album_info = "with_the_beatles_desc";

						break;
					case 2:
						intent = new Intent(Home.this, detailed.class);
						album_cover = "a_hard_days_night";
						album_name = "a_hard_days_night";
						album_info = "a_hard_days_night_desc";

						break;
					case 3:
						intent = new Intent(Home.this, detailed.class);
						album_cover = "beatles_for_sale";
						album_name = "beatles_for_sale";
						album_info = "beatles_for_sale_desc";

						break;
					case 4:
						intent = new Intent(Home.this, detailed.class);
						album_cover = "help";
						album_name = "help";
						album_info = "help_desc";

						break;
					case 5:
						intent = new Intent(Home.this, detailed.class);
						album_cover = "rubber_soul";
						album_name = "rubber_soul";
						album_info = "rubber_soul_desc";

						break;
					case 6:
						intent = new Intent(Home.this, detailed.class);
						album_cover = "revolver";
						album_name = "revolver";
						album_info = "revolver_desc";

						break;
					case 7:
						intent = new Intent(Home.this, detailed.class);
						album_cover = "sgt_peppers_lonely_hearts_club_band";
						album_name = "sgt_peppers";
						album_info = "sgt_peppers_desc";

						break;
					case 8:
						intent = new Intent(Home.this, detailed.class);
						album_cover = "magical_mystery_tour";
						album_name = "magical_mystery_tour";
						album_info = "magical_mystery_tour_desc";

						break;
					case 9:
						intent = new Intent(Home.this, detailed.class);
						album_cover = "the_beatles";
						album_name = "the_beatles";
						album_info = "the_beatles_desc";

						break;
					case 10:
						intent = new Intent(Home.this, detailed.class);
						album_cover = "yellow_submarine";
						album_name = "yellow_submarine";
						album_info = "yellow_submarine_desc";

						break;
					case 11:
						intent = new Intent(Home.this, detailed.class);
						album_cover = "abbey_road";
						album_name = "abbey_road";
						album_info = "abbey_road_desc";

						break;
					case 12:
						intent = new Intent(Home.this, detailed.class);
						album_cover = "let_it_be";
						album_name = "let_it_be";
						album_info = "let_it_be_desc";

						break;
					default:
						break;
				}

				intent.putExtra("album_cover", album_cover);
				intent.putExtra("album_name", album_name);
				intent.putExtra("album_info", album_info);

				startActivity(intent);
			}
		});
	}

	@Override
	public void onStart(){
		// call the superclass method first
		super.onStart();
	}

	@Override
	public void onResume() {
		// Always call the superclass method first
		super.onResume();
	}

	@Override
	public void onPause() {
		// Always call the superclass method first
		super.onPause();
	}

	@Override
	protected void onStop() {
		// Always call the superclass method first
		super.onStop();
	}

	@Override
	public void onDestroy(){
		// Always call the superclass method first
		super.onDestroy();
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
				// Nothing, you are already there

				break;
			case R.id.cart:
				intent = new Intent(Home.this, Cart.class);

				this.startActivity(intent);

				break;
			case R.id.settings:
				intent = new Intent(Home.this, Settings.class);

				this.startActivity(intent);

				break;
			default:
				return super.onContextItemSelected(item);
		}

		return true;
	}
}
