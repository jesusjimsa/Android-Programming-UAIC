package com.example.jesusjimsa.shoponline;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
		EmptyDialog dialog = new EmptyDialog();

		dialog.show(fragment, "empty");
	}

//	public EmptyDialog onCreateDialog(){
//		// Use the Builder class for convenient dialog construction
//		AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//		builder.setMessage(R.string.sure)
//				.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
//					public void onClick(DialogInterface dialog, int id) {
//						// FIRE ZE MISSILES!
//					}
//				})
//				.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
//					public void onClick(DialogInterface dialog, int id) {
//						// User cancelled the dialog
//					}
//				});
//
//		// Create the AlertDialog object and return it
//		return builder.create();
//	}
}
