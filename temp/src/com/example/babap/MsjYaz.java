package com.example.babap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MsjYaz extends Activity {

	String url, driver, userName, password;
	String ipAdresi = "xxx.xxx.xxx.xxx", veriTabaniAdi = "xxxxxxx",
			kullaniciAdi = "xxxxxxx", sifre = "xxxxxxx";

	Button btnmsjGonder;
	EditText msjIcerik;
	EditText msjGonderenKisi;
	
	public void OnayToast()
	{
		Toast.makeText(this, "Msj Gonderildi",
				Toast.LENGTH_SHORT).show();	
	return;
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.msjyaz);
		msjIcerik=(EditText)findViewById(R.id.txtGonderilenMsj);
		msjGonderenKisi=(EditText)findViewById(R.id.txtGonderenKisi);
		btnmsjGonder=(Button)findViewById(R.id.btnGonder);
		btnmsjGonder.setOnClickListener(new View.OnClickListener() {
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
						stmt.executeUpdate("insert into androidMSJ VALUES ('"+msjGonderenKisi.getText()+": ','"+msjIcerik.getText()+"')");
						
						OnayToast();
						
					} catch (Exception e) {
						
					}
						

					// Iterate through the data in the result set and display it.

				} catch (Exception e) {
				}

				
				
				
			}
		});
		
	}

}
