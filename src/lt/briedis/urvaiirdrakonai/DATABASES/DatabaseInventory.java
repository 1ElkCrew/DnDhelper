package lt.briedis.urvaiirdrakonai.DATABASES;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseInventory extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "DATABASEinventory";
	
	private static final String TABLE_FOOD = "Food";
	private static final String COLUMN_FOOD_COUNT = "FoodQuantity";
	private static final String COLUMN_FOOD_NAME = "FoodName";
	private static final String COLUMN_FOOD_DESC = "FoodDesc";
	
	private static final String TABLE_WEAPONSnARMOUR = "WeaponsAndArmour";
	private static final String COLUMN_WEAPONSnARMOUR = "WeaponNArmourName";
	
	private static final String TABLE_MATERIALS = "Materials";
	private static final String COLUMN_MATERIAL_NAME = "MaterialName";
	private static final String COLUMN_MATERIAL_COUNT= "MaterialCount";
	
	private static final String TABLE_BOOKS = "Books";
	private static final String COLUMN_BOOK_NAME = "BookName";
	private static final String COLUMN_BOOK_DESC = "BookDesc";
	private static final String COLUMN_BOOK_TIMETOREAD = "BookTotalTimeToRead";
	private static final String COLUMN_BOOK_ALREADYREAD = "BookAlreadyRead";
	
	private static final String TABLE_POTIONS = "Potion";
	private static final String COLUMN_POTION_COUNT = "PotionCount";
	private static final String COLUMN_POTION_NAME = "PotionName";
	private static final String COLUMN_POTION_DESC = "PotionDesc";
	
	public DatabaseInventory(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
