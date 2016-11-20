package lt.briedis.urvaiirdrakonai.DATABASES;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseSkills extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "DATABASEskills";
	
	/** BASE **/
	private static final String TABLE_BASE_STATS = "BaseStatsTable";
	
	private static final String STATS_STR_BASE = "Strength"; 	//0
	private static final String STATS_AGI_BASE = "Agility";		//1
	private static final String STATS_VIT_BASE = "Vitality";	//2
	private static final String STATS_INT_BASE = "Intellect";	//3
	private static final String STATS_WIS_BASE = "Wisdom";		//4
	private static final String STATS_LUK_BASE = "Luck";		//5
	
	/** TOTAL **/
	private static final String TABLE_TOTAL_STATS = "TotalStatsTable";
	
	private static final String STATS_STR_TOTAL = "StrengthTotal"; 	//0
	private static final String STATS_AGI_TOTAL = "AgilityTotal";	//1
	private static final String STATS_VIT_TOTAL = "VitalityTotal";	//2
	private static final String STATS_INT_TOTAL = "IntellectTotal";	//3
	private static final String STATS_WIS_TOTAL = "WisdomTotal";	//4
	private static final String STATS_LUK_TOTAL = "LuckTotal";		//5
	
	public DatabaseSkills(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		String CREATE_DATABASE_BASE_STATS = 
			"CREATE TABLE " 
			+TABLE_BASE_STATS+" ("
			+STATS_STR_BASE+" INTEGER, "
			+STATS_AGI_BASE+" INTEGER, "
			+STATS_VIT_BASE+" INTEGER, "
			+STATS_INT_BASE+" INTEGER, "
			+STATS_WIS_BASE+" INTEGER, "
			+STATS_LUK_BASE+" INTEGER)";
		db.execSQL(CREATE_DATABASE_BASE_STATS);
		
		String CREATE_DATABASE_TOTAL_STATS = 
				"CREATE TABLE "
				+TABLE_TOTAL_STATS+"( "
				+STATS_STR_TOTAL+" INTEGER, "
				+STATS_AGI_TOTAL+" INTEGER, "
				+STATS_VIT_TOTAL+" INTEGER, "
				+STATS_INT_TOTAL+" INTEGER, "
				+STATS_WIS_TOTAL+" INTEGER, "
				+STATS_LUK_TOTAL+" INTEGER)";
		db.execSQL(CREATE_DATABASE_TOTAL_STATS);
	}
	
	/** BASE **/
	public void addNewBaseStats(int STR, int AGI, int VIT, int INT, int WIS, int LUK){		
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues val = new ContentValues();
		val.put(STATS_STR_BASE, STR);
		val.put(STATS_AGI_BASE, AGI);
		val.put(STATS_VIT_BASE, VIT);
		val.put(STATS_INT_BASE, INT);
		val.put(STATS_WIS_BASE, WIS);
		val.put(STATS_LUK_BASE, LUK);
		db.insert(TABLE_BASE_STATS, null, val);
		db.close();
	}
	public void editBaseStats(int STR, int AGI, int VIT, int INT, int WIS, int LUK){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues val = new ContentValues();
		val.put(STATS_STR_BASE, STR);
		val.put(STATS_AGI_BASE, AGI);
		val.put(STATS_VIT_BASE, VIT);
		val.put(STATS_INT_BASE, INT);
		val.put(STATS_WIS_BASE, WIS);
		val.put(STATS_LUK_BASE, LUK);
		db.update(TABLE_BASE_STATS, val, null, null);
		db.close();
	}
	
	/** TOTAL **/
	public void addNewTotalStats(int STR, int AGI, int VIT, int INT, int WIS, int LUK){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues val = new ContentValues();
		val.put(STATS_STR_TOTAL, STR);
		val.put(STATS_AGI_TOTAL, AGI);
		val.put(STATS_VIT_TOTAL, VIT);
		val.put(STATS_INT_TOTAL, INT);
		val.put(STATS_WIS_TOTAL, WIS);
		val.put(STATS_LUK_TOTAL, LUK);
		db.insert(TABLE_TOTAL_STATS, null, val);
		close();
	}
	public void editTotalStats(int STR, int AGI, int VIT, int INT, int WIS, int LUK){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues val = new ContentValues();
		val.put(STATS_STR_TOTAL, STR);
		val.put(STATS_AGI_TOTAL, AGI);
		val.put(STATS_VIT_TOTAL, VIT);
		val.put(STATS_INT_TOTAL, INT);
		val.put(STATS_WIS_TOTAL, WIS);
		val.put(STATS_LUK_TOTAL, LUK);
		db.update(TABLE_TOTAL_STATS, val, null, null);
		close();
	}

	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		db.execSQL("DROP TABLES IF EXISTS " + TABLE_BASE_STATS);
		db.execSQL("DROP TABLES IF EXISTS " + TABLE_TOTAL_STATS);
		onCreate(db);
	}
	
	public Cursor allBaseStats(){
		SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor c = sqLiteDatabase.query(TABLE_BASE_STATS, null, null, null, null, null, null, null);
		return c;
	}
	public Cursor allTotalStats(){
		SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor c = sqLiteDatabase.query(TABLE_TOTAL_STATS, null, null, null, null, null, null, null);
		return c;
	}
}
