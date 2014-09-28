package edu.ucuccs.ilocanophrasebook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "dbPhrases";
	private static final String TABLE_PHRASES = "tblPhrases";

	private static final String FIELD_ID = "p_id";
	private static final String FIELD_CATEGORY = "p_category";
	private static final String FIELD_ENGLISH = "p_phrase";
	private static final String FIELD_ILOCANO = "p_equivalent";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_PHRASES_TABLE = "CREATE TABLE " + TABLE_PHRASES + "("
				+ FIELD_ID + " INTEGER PRIMARY KEY," + FIELD_CATEGORY + " TEXT"
				+ FIELD_ENGLISH + " TEXT" + FIELD_ILOCANO + " TEXT" + ")";
		db.execSQL(CREATE_PHRASES_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PHRASES);
		onCreate(db);
	}

}
