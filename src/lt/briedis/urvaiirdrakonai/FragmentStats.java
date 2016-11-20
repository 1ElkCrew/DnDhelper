package lt.briedis.urvaiirdrakonai;

import lt.briedis.urvaiirdrakonai.DATABASES.DatabaseSkills;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentStats extends Fragment {
	
	Button 	bAddSTR, bSubSTR,
			bAddAGI, bSubAGI,
			bAddVIT, bSubVIT,
			bAddINT, bSubINT,
			bAddWIS, bSubWIS,
			bAddLUK, bSubLUK;
	
	TextView 	tvBaseSTR, tvTotalSTR,
				tvBaseAGI, tvTotalAGI,
				tvBaseVIT, tvTotalVIT,
				tvBaseINT, tvTotalINT,
				tvBaseWIS, tvTotalWIS,
				tvBaseLUK, tvTotalLUK;
	
	private int bufferSTR, bufferAGI, bufferVIT, bufferINT, bufferWIS, bufferLUK;
	DatabaseSkills db;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
		View v = inflater.inflate(R.layout.fragment_stats, container, false);
		db = new DatabaseSkills(getActivity());
		tvBaseSTR = (TextView) v.findViewById(R.id.tv_baseSTR);
		tvTotalSTR = (TextView) v.findViewById(R.id.tv_totalSTR);
		
		tvBaseAGI = (TextView) v.findViewById(R.id.tv_baseAGI);
		tvTotalAGI = (TextView) v.findViewById(R.id.tv_totalAGI);
		
		tvBaseVIT = (TextView) v.findViewById(R.id.tv_baseVIT);
		tvTotalVIT = (TextView) v.findViewById(R.id.tv_totalVIT);
		
		tvBaseINT = (TextView) v.findViewById(R.id.tv_baseINT);
		tvTotalINT = (TextView) v.findViewById(R.id.tv_totalINT);
		
		tvBaseWIS = (TextView) v.findViewById(R.id.tv_baseWIS);
		tvTotalWIS = (TextView) v.findViewById(R.id.tv_totalWIS);
		
		tvBaseLUK = (TextView) v.findViewById(R.id.tv_baseLUK);
		tvTotalLUK = (TextView) v.findViewById(R.id.tv_totalLUK);
		
		bAddSTR = (Button) v.findViewById(R.id.b_addSTR);
		bAddSTR.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				bufferSTR++;
				guideEditBaseStats();
				getBaseStats();
			}
		});
		
		bSubSTR = (Button) v.findViewById(R.id.b_subSTR);
		bSubSTR.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(bufferSTR > 0){
					bufferSTR--;
					guideEditBaseStats();
					getBaseStats();
				}
			}
		});
		
		bAddAGI = (Button) v.findViewById(R.id.b_addAGI);
		bAddAGI.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				bufferAGI++;
				guideEditBaseStats();
				getBaseStats();
			}
		});
		
		bSubAGI = (Button) v.findViewById(R.id.b_subAGI);
		bSubAGI.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				bufferAGI--;
				guideEditBaseStats();
				getBaseStats();
			}
		});
		
		
		checkForNulls();
		getBaseStats();
		
		return v;
	}
	
	private void getBaseStats(){
		//spaghetti code here we go
		Cursor c = db.allBaseStats();
		if (c.moveToFirst()){
			do{
				if(c.getPosition() == 0){
					tvBaseSTR.setText(Integer.toString(c.getInt(0)));
					bufferSTR = c.getInt(0);
				}
				if(c.getPosition() == 1){
					tvBaseAGI.setText(Integer.toString(c.getInt(1)));
					bufferAGI = c.getInt(1);
				}
				if(c.getPosition() == 2){
					tvBaseVIT.setText(Integer.toString(c.getInt(2)));
					bufferVIT = c.getInt(2);
				}
				if(c.getPosition() == 3){
					tvBaseINT.setText(Integer.toString(c.getInt(3)));
					bufferINT = c.getInt(3);
				}
				if(c.getPosition() == 4){
					tvBaseWIS.setText(Integer.toString(c.getInt(4)));
					bufferWIS = c.getInt(4);
				}
				if(c.getPosition() == 5){
					tvBaseLUK.setText(Integer.toString(c.getInt(5)));
					bufferLUK = c.getInt(5);
				}
			}
			while (c.moveToNext());
		}
		
	}
	
	private void guideStats(){
		db.addNewBaseStats(bufferSTR, bufferAGI, bufferVIT, bufferINT, bufferWIS, bufferLUK);
	}
	private void guideEditBaseStats(){
		db.editBaseStats(bufferSTR, bufferAGI, bufferVIT, bufferINT, bufferWIS, bufferLUK);
	}
	
	/**	THIS CAN BE USED A LOT **/
	private void checkForNulls(){
		//spaghetti ifs here we go
		if (tvBaseSTR.getText().toString().isEmpty()){
			tvBaseSTR.setText("0");
			bufferSTR = 0;
		}
		if (tvBaseAGI.getText().toString().isEmpty()){
			tvBaseAGI.setText("0");
			bufferAGI = 0;
		}
		if (tvBaseVIT.getText().toString().isEmpty()){
			tvBaseVIT.setText("0");
			bufferVIT = 0;
		}
		if (tvBaseINT.getText().toString().isEmpty()){
			tvBaseINT.setText("0");
			bufferINT = 0;
		}
		if (tvBaseWIS.getText().toString().isEmpty()){
			tvBaseWIS.setText("0");
			bufferWIS = 0;
		}
		if (tvBaseLUK.getText().toString().isEmpty()){
			tvBaseLUK.setText("0");
			bufferLUK = 0;
		}
		guideStats();
	}
	
}
