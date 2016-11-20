package lt.briedis.urvaiirdrakonai;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	
	private Button bInventory, bHP, bStats;
	private Fragment fragmentHP, fragmentStats, fragmentInventory;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bInventory = (Button) findViewById(R.id.b_inventory);
		bInventory.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				fragmentInventory = new FragmentInventory();
				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				transaction.replace(R.id.layout_fragmentplace, fragmentInventory);
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
		
		bStats = (Button) findViewById(R.id.b_stats);
		bStats.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				fragmentStats = new FragmentStats();
				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				transaction.replace(R.id.layout_fragmentplace, fragmentStats);
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
		
		bHP = (Button) findViewById(R.id.b_hp);
		bHP.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				fragmentHP = new FragmentHP();
				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				transaction.replace(R.id.layout_fragmentplace, fragmentHP);
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
	}

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
