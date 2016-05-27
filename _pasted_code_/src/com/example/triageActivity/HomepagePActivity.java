package com.example.triageActivity;

import com.example.triage.Patient;
import com.example.triage.Physician;
import com.example.triage.R;
import com.example.triage.R.layout;
import com.example.triage.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomepagePActivity extends Activity {

	private Physician physician;
	private Patient patient; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_homepage_p);
		
		// Gets intent passed from HomepagePActivity
		Intent intent = getIntent();

		// Uses "physicianKey" to get Physician object.
		Physician physician = (Physician) intent
				.getSerializableExtra("physicianKey");

		// Sets TextView to the Person's name.
		TextView newlyRegistered = (TextView) findViewById(R.id.physicianInfo);
		newlyRegistered.setText("Username");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.homepage, menu);