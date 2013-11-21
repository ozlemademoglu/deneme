package com.example.babap;

import java.sql.*;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MsjOku extends Activity {

	String url, driver, userName, password;
	String ipAdresi = "xxx.xxx.xxx.xxx", veriTabaniAdi = "xxxxxxx",
			kullaniciAdi = "xxxxxxx", sifre = "xxxxxxx";

	TextView mesajlar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.msjoku);
		mesajlar = (TextView) findViewById(R.id.txtOku);

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

			ResultSet results = null;
			mesajlar.setText("Mesajlar: \r\n");
			try {
				Class.forName(driver).newInstance();
				Connection conn = DriverManager.getConnection(url, userName,
						password);
				Statement statement = conn.createStatement();
				results = statement.executeQuery("select * from androidMSJ");
				while (results.next()) {
					mesajlar.setText(mesajlar.getText()+results.getString(2)+" "+results.getString(3)+"\r\n");
				}
			} catch (Exception e) {
				Toast.makeText(this, "Hata : " + e.toString(), Toast.LENGTH_SHORT)
						.show();
			}
				

			// Iterate through the data in the result set and display it.

		} catch (Exception e) {
			Toast.makeText(MsjOku.this, "Hata2: " + e.toString(),
					Toast.LENGTH_SHORT).show();
		}

	}
}
