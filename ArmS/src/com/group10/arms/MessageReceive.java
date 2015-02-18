package com.group10.arms;

import com.group10.cotactfetch.ContactFetch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;

public class MessageReceive extends BroadcastReceiver{
	public static String Fullmessage = " ";
	public static String number= " ";
	 public	 String array[] = {"Good morning","Good night","Thank you","Same to you","Happy onam",
	 "Happy vishu"};
	

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		Bundle bundle = arg1.getExtras();
		Object messages[] = (Object[]) bundle.get("pdus");
		SmsMessage smsMessage[] = new SmsMessage[messages.length];
		for (int n = 0; n < messages.length; n++) {
		smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
	         number = smsMessage[n].getOriginatingAddress();
		}
		  Fullmessage = smsMessage[0].getMessageBody();
		  //String array[] = Fullmessage.split(" ");
		 // arg1(FetchContactNumber.class);
		  //arg1.putExtra(number,Fullmessage );  
         SendVariable(Fullmessage);
		
		 if (array[1].equalsIgnoreCase(Fullmessage)) {
			SendText(0, array[1]);}
		else if (array[0].equalsIgnoreCase(Fullmessage)) {
			SendText(0, array[0]);
			}
		else if (Fullmessage.equals("Happy birthday")) {
			SendText(0, array[2]);
		    }
		else if (array[4].equalsIgnoreCase(Fullmessage)) {
			SendText(0, array[3]);
		}
		else if (array[5].equalsIgnoreCase(Fullmessage)) {
			SendText(0, array[3]);
			
		}
		
	}

	public static void  SendText(int c , String text ) {
		SmsManager smsManager = SmsManager.getDefault();
		smsManager.sendTextMessage(number, null, text, null, null);
		
	}
	
	public void SendVariable(String Msg){
		Intent intent = new Intent();
	}
	
	
}
