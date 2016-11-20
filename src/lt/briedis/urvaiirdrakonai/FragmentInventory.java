package lt.briedis.urvaiirdrakonai;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class FragmentInventory extends Fragment{
	
	private Button bListPrideti, bMaistas, bGinklaiSarvai, bMedziagos, bKnygos, bPots;
	
	private ListView lvList;
	private ArrayAdapter<String> arrayAdapter;
	private ArrayList<String> list;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
		View v = inflater.inflate(R.layout.fragment_inventory, container, false);
		
		
		bListPrideti = (Button) v.findViewById(R.id.b_inventory_add);
		bListPrideti.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				final Dialog dialog = new Dialog(getActivity());
				dialog.setContentView(R.layout.dialog_inventory_addnew);
				dialog.setTitle("Pridëti naujà");
				
					final Spinner spSpinner;
					final EditText etName, etDesc, etAmount;
					Button bAdd, bCancel;
					final LinearLayout llBookReadTotal, llAmount, llAssignStats;
					
					//Assign stats shite 
					llAssignStats = (LinearLayout) dialog.findViewById(R.id.dialog_inventory_layout_assignStats);
					llBookReadTotal = (LinearLayout) dialog.findViewById(R.id.dialog_inventory_layout_readbooks);
					llAmount = (LinearLayout) dialog.findViewById(R.id.dialog_inventory_layout_amount);
					
					/*** https://developer.android.com/guide/topics/ui/controls/spinner.html ***/
					final ArrayAdapter<CharSequence> spinnerArrayAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.inventoryDropdown_array, android.R.layout.simple_spinner_item);
					spSpinner = (Spinner) dialog.findViewById(R.id.dialog_inventory_sp_spinner);
					spSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
						@Override
						public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
							if (position == 0){//maistas
								llAmount.setVisibility(View.VISIBLE);
								llBookReadTotal.setVisibility(View.GONE);
								llAssignStats.setVisibility(View.GONE);
							}
							if (position == 1){//sarvai ir ginklai
								llAmount.setVisibility(View.GONE);
								llBookReadTotal.setVisibility(View.GONE);
								llAssignStats.setVisibility(View.VISIBLE);
							}
							if (position == 2){//medziagos
								llAmount.setVisibility(View.VISIBLE);
								llBookReadTotal.setVisibility(View.GONE);
								llAssignStats.setVisibility(View.GONE);
							}
							if (position == 3){//knygos
								llAmount.setVisibility(View.GONE);
								llBookReadTotal.setVisibility(View.VISIBLE);
								llAssignStats.setVisibility(View.GONE);
							}
							if (position == 4){//eleksyrai
								llAmount.setVisibility(View.VISIBLE);
								llBookReadTotal.setVisibility(View.GONE);
								llAssignStats.setVisibility(View.VISIBLE);
							}
							
						}
						@Override
						public void onNothingSelected(AdapterView<?> parent) {
							Toast.makeText(getActivity(), "Something went wrong?", Toast.LENGTH_LONG).show();
							
						}
					});
					spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					spSpinner.setAdapter(spinnerArrayAdapter);
					
					etName = (EditText) dialog.findViewById(R.id.dialog_inventory_et_Name);
					etDesc = (EditText) dialog.findViewById(R.id.dialog_inventory_et_Description);
					etAmount = (EditText) dialog.findViewById(R.id.dialog_inventory_et_Amount);
					
					
					
					bAdd = (Button) dialog.findViewById(R.id.dialog_inventory_b_Add);
					bAdd.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							/*
							String[] dropdownValues = {"Maistas", "Ðarvai ir Ginklai", "Medþiagos", "Knygos", "Eleksyrai"};
							for(int i = 0; i < dropdownValues.length; i++){
								if (spSpinner.getSelectedItem() == dropdownValues[0]){
									//ima maisto
								}
								if (spSpinner.getSelectedItem() == dropdownValues[1]){
									//ima sarva i ginklus
									if(!etAmount.getText().toString().isEmpty())
										Toast.makeText(getActivity(), "Kiekis ginklams ir ðarvams neskaièiuojamas, pridëkt po vienà.", Toast.LENGTH_SHORT).show();
									
									//add values to database
								}
								if (spSpinner.getSelectedItem() == dropdownValues[2]){
									//ima medziagas
								}
								if (spSpinner.getSelectedItem() == dropdownValues[3]){
									//ima knyga
									if(!etAmount.getText().toString().isEmpty())
										Toast.makeText(getActivity(), "Kiekis knygoms neskaièiuojamas, pridëkt po vienà.", Toast.LENGTH_SHORT).show();
								}
								if (spSpinner.getSelectedItem() == dropdownValues[4]){
									//ima potu
								}
							}*/
						}
					});
					bCancel = (Button) dialog.findViewById(R.id.dialog_inventory_b_Cancel);
					bCancel.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							dialog.dismiss();
						}
					});
				dialog.show();
			}
		});
		
		bMaistas = (Button) v.findViewById(R.id.b_inventory_maistas);
		bMaistas.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		
		return v;
	}
}
