package com.recarlin.java1project1;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText peonCount;
	EditText archerCount;
	EditText pikemenCount;
	EditText giantCount;
	EditText goldCount;
	TextView result;
	boolean affordable;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout lay = new LinearLayout(this);
		lay.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams par = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		lay.setLayoutParams(par);
		
		TextView title = new TextView(this);
		title.setText("Build your army!");
		title.setTextSize(40);
		
		LinearLayout.LayoutParams par2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		
		LinearLayout peonLay = new LinearLayout(this);
		peonLay.setOrientation(LinearLayout.HORIZONTAL);
		peonLay.setLayoutParams(par2);
		peonCount = new EditText(this);
		peonCount.setHint("Type quantity");
		TextView peon = new TextView(this);
		peon.setText("Peons");
		peon.setTextSize(25);
		peonLay.addView(peonCount);
		peonLay.addView(peon);
		
		LinearLayout archerLay = new LinearLayout(this);
		archerLay.setOrientation(LinearLayout.HORIZONTAL);
		archerLay.setLayoutParams(par2);
		archerCount = new EditText(this);
		archerCount.setHint("Type quantity");
		TextView archer = new TextView(this);
		archer.setText("Archers");
		archer.setTextSize(25);
		archerLay.addView(archerCount);
		archerLay.addView(archer);
		
		LinearLayout pikemenLay = new LinearLayout(this);
		pikemenLay.setOrientation(LinearLayout.HORIZONTAL);
		pikemenLay.setLayoutParams(par2);
		pikemenCount = new EditText(this);
		pikemenCount.setHint("Type quantity");
		TextView pikemen = new TextView(this);
		pikemen.setText("Pikemen");
		pikemen.setTextSize(25);
		pikemenLay.addView(pikemenCount);
		pikemenLay.addView(pikemen);
		
		LinearLayout giantLay = new LinearLayout(this);
		giantLay.setOrientation(LinearLayout.HORIZONTAL);
		giantLay.setLayoutParams(par2);
		giantCount = new EditText(this);
		giantCount.setHint("Type quantity");
		TextView giant = new TextView(this);
		giant.setText("Giants");
		giant.setTextSize(25);
		giantLay.addView(giantCount);
		giantLay.addView(giant);
		
		LinearLayout goldLay = new LinearLayout(this);
		goldLay.setOrientation(LinearLayout.HORIZONTAL);
		goldLay.setLayoutParams(par2);
		goldCount = new EditText(this);
		goldCount.setHint("Type quantity");
		TextView gold = new TextView(this);
		gold.setText("Current Gold");
		gold.setTextSize(25);
		goldLay.addView(goldCount);
		goldLay.addView(gold);
		
		Button checkButton = new Button(this);
		checkButton.setText("Do I Have Enough Gold?");
		checkButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				int peonCost = Integer.parseInt(peonCount.getText().toString()) * getResources().getInteger(R.integer.peon);
				int archerCost = Integer.parseInt(archerCount.getText().toString()) * getResources().getInteger(R.integer.archer);
				int pikemenCost = Integer.parseInt(pikemenCount.getText().toString()) * getResources().getInteger(R.integer.pikeman);
				int giantCost = Integer.parseInt(giantCount.getText().toString()) * getResources().getInteger(R.integer.giant);
				int goldAvailable = Integer.parseInt(goldCount.getText().toString());
				int total = peonCost + archerCost + pikemenCost + giantCost;
				
				if (goldAvailable < total) {
					affordable = false;
					finishHim();
				} else if (goldAvailable >= total) {
					affordable = true;
					finishHim();
				}
				
			}
		});
		
		result = new TextView(this);
		result.setText("Results Shown Here");
		result.setTextSize(25);
		
		lay.addView(title);
		lay.addView(peonLay);
		lay.addView(archerLay);
		lay.addView(pikemenLay);
		lay.addView(giantLay);
		lay.addView(goldLay);
		lay.addView(checkButton);
		lay.addView(result);
		setContentView(lay);
	}

	private void finishHim() {
		if (affordable == false) {
			result.setText("You cannot afford that army!");
		} else if (affordable == true) {
			String[] units = getResources().getStringArray(R.array.units);
			String loopyUnits = new String();
			for( int i = 0; i < units.length; i++) {
				if (i == 0) {
					loopyUnits = units[i];
				} else {
					loopyUnits = loopyUnits + " " + units[i];
				}
			}
			result.setText("You can afford your army of " + loopyUnits);
		};
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}