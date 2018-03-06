package com.example.jesusjimsa.shoponline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		Button button1 = findViewById(R.id.button1);
		Button button2 = findViewById(R.id.button2);
		Button button3 = findViewById(R.id.button3);
		Button button4 = findViewById(R.id.button4);
		Button button5 = findViewById(R.id.button5);
		Button button6 = findViewById(R.id.button6);
		Button button7 = findViewById(R.id.button7);
		Button button8 = findViewById(R.id.button8);
		Button button9 = findViewById(R.id.button9);
		Button button10 = findViewById(R.id.button10);
		Button button11 = findViewById(R.id.button11);
		Button button12 = findViewById(R.id.button12);
		Button button13 = findViewById(R.id.button13);

		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent ppm = new Intent(Home.this, Please_Please_Me.class);
				startActivity(ppm);
			}
		});

		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent wtb = new Intent(Home.this, with_the_beatles.class);
				startActivity(wtb);
			}
		});

		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent ahdn = new Intent(Home.this, a_hard_days_night.class);
				startActivity(ahdn);
			}
		});

		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent bfs = new Intent(Home.this, beatles_for_sale.class);
				startActivity(bfs);
			}
		});

		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent h = new Intent(Home.this, help.class);
				startActivity(h);
			}
		});

		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent rs = new Intent(Home.this, rubber_soul.class);
				startActivity(rs);
			}
		});

		button7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent r = new Intent(Home.this, revolver.class);
				startActivity(r);
			}
		});

		button8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent splhcb = new Intent(Home.this, sgt_peppers_lonely_hearts_club_band.class);
				startActivity(splhcb);
			}
		});

		button9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent mmt = new Intent(Home.this, magical_mistery_tour.class);
				startActivity(mmt);
			}
		});

		button10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent tb = new Intent(Home.this, the_beatles.class);
				startActivity(tb);
			}
		});

		button11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent ys = new Intent(Home.this, yellow_submarine.class);
				startActivity(ys);
			}
		});

		button12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent ar = new Intent(Home.this, abbey_road.class);
				startActivity(ar);
			}
		});

		button13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent lib = new Intent(Home.this, let_it_be.class);
				startActivity(lib);
			}
		});
	}
}
