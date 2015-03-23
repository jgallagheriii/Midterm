package com.example.midterm;

import java.text.NumberFormat;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	
	private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	private static final NumberFormat doubleFormat = NumberFormat.getNumberInstance();
	private static final NumberFormat integerFormat = NumberFormat.getIntegerInstance();
	
	private int mpgAmount = 25;
	private double gasPriceAmount = 2.50;
	private int milesDriven = 0;
	private TextView mpgDisplayText;
	private TextView gasPriceDisplayText;
	private TextView milesDrivenDisplayText;
	private TextView totalDisplayText;
	private ImageView car;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mpgDisplayText = (TextView) findViewById(R.id.mpgDisplayText);
		gasPriceDisplayText = (TextView ) findViewById(R.id.gasPriceDisplayText);
		milesDrivenDisplayText = (TextView) findViewById(R.id.milesDrivenDisplayText);
		totalDisplayText = (TextView) findViewById(R.id.totalDisplayText);
		
		mpgDisplayText.setText(integerFormat.format(mpgAmount));
		gasPriceDisplayText.setText(doubleFormat.format(gasPriceAmount));
		milesDrivenDisplayText.setText(integerFormat.format(milesDriven));
		
		updateStandard();
		
		EditText mpgEditText = (EditText) findViewById(R.id.mpgEditText);
		mpgEditText.addTextChangedListener(mpgEditTextWatcher);
		
		EditText gasPriceEditText = (EditText) findViewById(R.id.gasPriceEditText);
		gasPriceEditText.addTextChangedListener(gasPriceEditTextWatcher);
		
		EditText milesDrivenEditText = (EditText)findViewById(R.id.milesDrivenEditText);
		milesDrivenEditText.addTextChangedListener(milesDrivenEditTextWatcher);
		
		ImageView carView = (ImageView)findViewById(R.id.carView);
		
		
		
	}
	
	private void updateStandard()
	{
		double gallons = milesDriven / mpgAmount;
		double total = gallons * gasPriceAmount;
		totalDisplayText.setText(integerFormat.format(total));
		milesDrivenDisplayText.setText(integerFormat.format(milesDriven));
		gasPriceDisplayText.setText(integerFormat.format(gasPriceAmount));
		mpgDisplayText.setText(integerFormat.format(mpgAmount));
		
	}
	
	private TextWatcher mpgEditTextWatcher = new TextWatcher()
	{
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count)
		{
			try
			{
				if(Integer.parseInt(s.toString())>=10 && Integer.parseInt(s.toString())<= 50)
				{
					gasPriceAmount = Integer.parseInt(s.toString());
				}
			}
			catch (NumberFormatException e)
			{
				mpgAmount = 25;
			}
			mpgDisplayText.setText(integerFormat.format(mpgAmount));
			updateStandard();
		}
		@Override
		public void afterTextChanged(Editable s)
		{
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after)
		{
		}
	};
	private TextWatcher gasPriceEditTextWatcher = new TextWatcher()
	{
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count)
		{
			try
			{
				if(Double.parseDouble(s.toString())/100>=1.00 && Double.parseDouble(s.toString())/100<= 4.00)
						{
					gasPriceAmount = Integer.parseInt(s.toString())/100;
						}
			}
			catch (NumberFormatException e)
			{
				gasPriceAmount = 2.50;
			}
			mpgDisplayText.setText(currencyFormat.format(gasPriceAmount));
			updateStandard();
		}
		@Override
		public void afterTextChanged(Editable s)
		{
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after)
		{
		}
	};
	private TextWatcher milesDrivenEditTextWatcher = new TextWatcher()
	{
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count)
		{
			try
			{
					milesDriven = Integer.parseInt(s.toString());
			}
			catch (NumberFormatException e)
			{
				milesDriven = 0;
			}
			milesDrivenDisplayText.setText(integerFormat.format(mpgAmount));
			updateStandard();
		}
		@Override
		public void afterTextChanged(Editable s)
		{
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after)
		{
		}
	};
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
