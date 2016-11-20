package lt.briedis.urvaiirdrakonai;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentHP extends Fragment {
	
	int maxHP = 5; // TRAUKTI IS DUOMENU BAZES
	int currHP = 0;
	ProgressBar pbHP;
	TextView tvMaxHP, tvCurrentHP;
	EditText etAddHP, etSubHP;
	Button bAddHP, bSubHP;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
		View v = inflater.inflate(R.layout.fragment_hp, container, false);
		pbHP = (ProgressBar) v.findViewById(R.id.pb_HP);
		pbHP.setMax(maxHP);
		
		etAddHP = (EditText) v.findViewById(R.id.et_addHP);
		etSubHP = (EditText) v.findViewById(R.id.et_subHP);
		
		tvMaxHP = (TextView) v.findViewById(R.id.tv_maxHP);
		tvMaxHP.setText(Integer.toString(pbHP.getMax()));
		
		tvCurrentHP = (TextView) v.findViewById(R.id.tv_currentHP);
		tvCurrentHP.setText(Integer.toString(pbHP.getProgress()));
		
		bAddHP = (Button) v.findViewById(R.id.b_addHP);
		bAddHP.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(etAddHP.getText().toString() != "" && !etAddHP.getText().toString().isEmpty()){
					int addval = Integer.parseInt(etAddHP.getText().toString());
					if ((pbHP.getProgress() + addval) < maxHP){
						pbHP.setProgress(currHP + addval);
						tvCurrentHP.setText(Integer.toString(currHP + addval));
						currHP += addval;
						etAddHP.setText("");
					}
					else if ((pbHP.getProgress() + addval) >= maxHP){
						pbHP.setProgress(maxHP);
						tvCurrentHP.setText(Integer.toString(maxHP));
						Toast.makeText(getContext(), "FULL HP", Toast.LENGTH_SHORT).show();
						etAddHP.setText("");
					}
					else{
						Toast.makeText(getActivity(), "Problemos su matematika?", Toast.LENGTH_SHORT).show(); //ecks dee
					}
				}
			}
		});
		bSubHP = (Button) v.findViewById(R.id.b_subHP);
		return v;
	}
}
