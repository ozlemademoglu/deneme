package com.farukunal.ornekler;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Deneme extends Activity {

	Button btnMyLine, btnMsjYolla;
	LinearLayout LLEnterText;
	int _intMyLineCount;
	EditText txtGonderilecekMsj;

	private List<EditText> editTextList = new ArrayList<EditText>();
	private List<TextView> textviewList = new ArrayList<TextView>();
	private List<LinearLayout> linearlayoutList = new ArrayList<LinearLayout>();

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deneme);
        _intMyLineCount=21;
        
        txtGonderilecekMsj = (EditText) findViewById(R.id.txtMesaj);
        LLEnterText=(LinearLayout) findViewById(R.id.LlTitle);
        btnMyLine=(Button) findViewById(R.id.btnMyLines);       

        btnMyLine.setOnClickListener(new OnClickListener() {        
            @Override
            public void onClick(View v) {                       
                    LLEnterText.addView(linearlayout(_intMyLineCount));
                    _intMyLineCount++;
                }
        }); 
        
        
        
        btnMsjYolla=(Button) findViewById(R.id.btnMsjGonder);       

        btnMsjYolla.setOnClickListener(new OnClickListener() {        
            @Override
            public void onClick(View v) {                       
                    LLEnterText.addView(linearlayoutFK2(_intMyLineCount));
                    _intMyLineCount++;
                    txtGonderilecekMsj.setText("");
                    txtGonderilecekMsj.setHint("Yeni msj");
                }
        }); 
        
        
        
    }

	private EditText editTextFK(int _intID) {
		EditText editText = new EditText(this);
		editText.setId(_intID);
		editText.setHint(txtGonderilecekMsj.getText().toString());
		editText.setWidth(180);
		editText.setText(txtGonderilecekMsj.getText().toString());
		editTextList.add(editText);
		return editText;
	}

	private TextView textViewFK(int _intID) {
		TextView txtviewAll = new TextView(this);
		txtviewAll.setId(_intID);
		txtviewAll.setText("Ozlem: ");
		txtviewAll.setTextColor(Color.RED);
		txtviewAll.setTypeface(Typeface.DEFAULT_BOLD);
		if(_intID%2==1)
			txtviewAll.setBackgroundColor(Color.GREEN);
		else
			txtviewAll.setBackgroundColor(Color.BLUE);
		textviewList.add(txtviewAll);
		return txtviewAll;
	}
	
	private TextView textViewFK2(int _intID) {
		TextView txtviewAll = new TextView(this);
		txtviewAll.setId(_intID);
		txtviewAll.setText(txtGonderilecekMsj.getText().toString());
		txtviewAll.setTextColor(Color.RED);
		txtviewAll.setTypeface(Typeface.DEFAULT_BOLD);
		if(_intID%2==1)
			txtviewAll.setBackgroundColor(Color.GREEN);
		else
			txtviewAll.setBackgroundColor(Color.BLUE);
		textviewList.add(txtviewAll);
		return txtviewAll;
	}

	private LinearLayout linearlayoutFK(int _intID) {
		LinearLayout LLMain = new LinearLayout(this);
		LLMain.setId(_intID);
		if(_intID%2==1)
			LLMain.setBackgroundColor(Color.GREEN);
		else
			LLMain.setBackgroundColor(Color.BLUE);
		LLMain.addView(textViewFK(_intID));
		LLMain.addView(editTextFK(_intID));
		LLMain.setOrientation(LinearLayout.HORIZONTAL);
		linearlayoutList.add(LLMain);
		return LLMain;

	}
	
	
	private LinearLayout linearlayoutFK2(int _intID) {
		LinearLayout LLMain = new LinearLayout(this);
		LLMain.setId(_intID);
		LLMain.addView(textViewFK(_intID));
		LLMain.addView(textViewFK2(_intID));
		LLMain.setOrientation(LinearLayout.HORIZONTAL);
		LLMain.setBackgroundResource(R.drawable.btnstyle);
		if(_intID%2==1)
			LLMain.setBackgroundColor(Color.GREEN);
		else
			LLMain.setBackgroundColor(Color.BLUE);
		
		linearlayoutList.add(LLMain);
		return LLMain;

	}

	public void ToastFK(String msj) {
		Toast.makeText(this, msj, Toast.LENGTH_SHORT).show();
		return;
	}

	private EditText editText(int _intID) {
		EditText editText = new EditText(this);
		editText.setId(_intID);
		editText.setHint("Seni Seviyorum" + _intID);
		editText.setWidth(180);
		editText.setBackgroundColor(Color.WHITE);
		editTextList.add(editText);
		return editText;
	}

	private TextView textView(int _intID) {
		TextView txtviewAll = new TextView(this);
		txtviewAll.setId(_intID);
		txtviewAll.setText("Faruk: ");
		txtviewAll.setTextColor(Color.RED);
		txtviewAll.setTypeface(Typeface.DEFAULT_BOLD);
		textviewList.add(txtviewAll);
		return txtviewAll;
	}

	private LinearLayout linearlayout(int _intID) {
		LinearLayout LLMain = new LinearLayout(this);
		LLMain.setId(_intID);
		LLMain.addView(textView(_intID));
		LLMain.addView(editText(_intID));
		LLMain.setOrientation(LinearLayout.HORIZONTAL);
		linearlayoutList.add(LLMain);
		return LLMain;

	}

}