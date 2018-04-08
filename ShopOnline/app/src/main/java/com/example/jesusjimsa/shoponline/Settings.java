package com.example.jesusjimsa.shoponline;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class Settings extends AppCompatActivity {

	public static final int GET_FROM_GALLERY = 3;
	protected static final int GET_FROM_CAMERA = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);

		Button empty_cart_button = findViewById(R.id.empty_cart);
		Button change_avatar_gallery = findViewById(R.id.change_avatar_gallery);
		Button change_avatar_camera = findViewById(R.id.change_avatar_camera);

		empty_cart_button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				Alert(v);
			}
		});

		change_avatar_gallery.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY);
			}
		});

		change_avatar_camera.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

				startActivityForResult(takePictureIntent, GET_FROM_CAMERA);
			}
		});


	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Bitmap bitmap;
		ImageView user_avatar = findViewById(R.id.avatar);

		if(resultCode == Activity.RESULT_OK){
			//Detects request codes
			switch (requestCode){
				case GET_FROM_GALLERY:
					Uri selectedImage = data.getData();

					try {
						bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);

						//converting bitmap object to show in avatar
						user_avatar.setImageBitmap(bitmap);
					}
					catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					catch (IOException e) {
						e.printStackTrace();
					}

					break;
				case GET_FROM_CAMERA:
					Bundle extras = data.getExtras();
					FileOutputStream image = null;
					try {
						image = openFileOutput("user_avatar.png", 'W');
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}

					bitmap = (Bitmap) extras.get("data");

					bitmap.compress(Bitmap.CompressFormat.PNG, 100, image);

					user_avatar.setImageBitmap(bitmap);

					try {
						image.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

					break;
			}
		}
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
			case R.id.preferences:
				intent = new Intent(Settings.this, Preferences.class);

				this.startActivity(intent);

				break;
			case R.id.sensors:
				intent = new Intent(Settings.this, SensorsDisplay.class);

				this.startActivity(intent);

				break;
			case R.id.camera:
				intent = new Intent(Settings.this, MyCamera.class);

				this.startActivity(intent);

				break;
			default:
				return super.onContextItemSelected(item);
		}

		return true;
	}
}
