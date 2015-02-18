package com.group10.arms;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	 ImageButton imageButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageButton =(ImageButton)findViewById(R.id.imageButton1);
	}

	public void Next(View view) { 
		//Intent intent= new Intent(getApplicationContext(),SmsReceiver.class);
		//startActivity(intent);
	}

}
