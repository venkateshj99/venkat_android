package com.example.File.Handle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FileHandleActivity extends Activity {
	EditText editfield; 
	Button read, write;
	FileInputStream fip;
    FileOutputStream fop;
	File a = new File(Environment.getExternalStorageDirectory()+"/Myfile.txt");
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        editfield = (EditText)findViewById(R.id.editText1);
        read = (Button)findViewById(R.id.button1);
        write = (Button)findViewById(R.id.button2);
         
        write.setOnClickListener(new OnClickListener() {
			 //Set Listener for write button
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String type = editfield.getText().toString(); //get string value in 'type'
				try {
				fop = new FileOutputStream(a); 
				byte b[] = type.getBytes(); //convert string as byte 
				fop.write(b);			// set byte value
				Toast.makeText(getApplicationContext(), "File Written", 2500).show();
			}
				catch(FileNotFoundException e) {
					e.printStackTrace();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
        
        read.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				 //TODO Auto-generated method stub
				int typelength;
				try {
				fip = new FileInputStream(a); //set input to file
				String disp =" ";		// get empty string first
				while((typelength=fip.read())!=-1) {	 //to confirm the string has checked all char -1
					disp = disp+(char)typelength; 
				}
					editfield.setText(null); 
					editfield.setText(disp); //Display the string value written from file
				
					Toast.makeText(getApplicationContext(), "Read", 2500).show();
				} catch(FileNotFoundException e) {
					e.printStackTrace();
				} catch(IOException e) {
				e.printStackTrace();	
				}
				}
				});
			}
    }
