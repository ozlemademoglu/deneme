package com.example.babap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	String url, driver, userName, password;
	String ipAdresi = "xxx.xxx.xxx.xxx", veriTabaniAdi = "xxxxxxx",
			kullaniciAdi = "xxxxxxx", sifre = "xxxxxxx";

	public void OnayToast()
	{
		Toast.makeText(this, "msjlar silindi",
				Toast.LENGTH_SHORT).show();	
	return;
	}
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		Button btn = (Button) findViewById(R.id.btnGonder);
		
		Button btnSifirla = (Button) findViewById(R.id.btnSifirla);
		
		
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.babap.GIRIS"));
			}
		});
		
		
		btnSifirla.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				

				try {

					// Load the SQLServerDriver class, build the
					// connection string, and get a connection
					System.out.println("1");

					url = "jdbc:jtds:sqlserver://" + ipAdresi + ";databaseName="
							+ veriTabaniAdi + "";

					/*driver = "net.sourceforge.jtds.jdbc.Driver";*/
					/* com.microsoft.sqlserver.jdbc.SQLServerDriver */
					
					driver = "net.sourceforge.jtds.jdbc.Driver";
					
					userName = kullaniciAdi;
					password = sifre;

					try {
						Class.forName(driver).newInstance();
						Connection conn = DriverManager.getConnection(url, userName,
								password);
						Statement stmt = conn.createStatement();
						stmt.executeUpdate("DELETE androidMSJ");
						
						OnayToast();
						
					} catch (Exception e) {
						
					}
						

					// Iterate through the data in the result set and display it.

				} catch (Exception e) {
				}

				
				
				
				
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
