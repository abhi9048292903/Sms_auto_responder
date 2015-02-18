package com.exampl.add;


import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	public String number;
	public static String no = " 5556";
	public static String one1 = " ";
	Button click;
	EditText one;
	
		@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 click = (Button) findViewById(R.id.button1);
		 one = (EditText) findViewById(R.id.Text1);
		
		 
		click.setOnClickListener(new View.OnClickListener() {		
			@Override	
			public void onClick(View v) {
				 one1 = one.getText().toString();
			ContentResolver cr = getContentResolver();
			Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
			if(cur.getCount()>0){
				while (cur.moveToNext()) {
					String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
					String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
					if(Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)))>0){
						Cursor pcur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?"  ,
								new String []{id}, null);
						while (pcur.moveToNext()) {
		                             					
							String peru = pcur.getString(pcur.getColumnIndex(Phone.DISPLAY_NAME));
							if (peru .equalsIgnoreCase(one1)) {
								 number = pcur.getString(pcur.getColumnIndex(Phone.NUMBER));	
							Toast.makeText(getApplicationContext(), number, Toast.LENGTH_LONG).show();
							}
							}		 
						pcur.close();
						
					}
					
				}
					}
			Send(0, number);
			}		        	
	});

		}

		public static void Send(int i, String phoneNumber2){
			String phoneNum = no;
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(phoneNum, null, one1 +"   " +phoneNumber2, null, null);

		}
}

