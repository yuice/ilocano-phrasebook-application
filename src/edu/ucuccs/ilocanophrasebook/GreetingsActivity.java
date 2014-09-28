package edu.ucuccs.ilocanophrasebook;

import java.util.ArrayList;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GreetingsActivity extends  ListActivity {
	
	 private static final String DB_NAME = "dbPhrases.sqlite3";
	
		private static final String TABLE_NAME = "tblPhrases";
		private static final String FRIEND_ID = "p_id";
		private static final String FRIEND_NAME = " p_phrase";
	    
		private SQLiteDatabase database;
		private ListView listView;
		private ArrayList<String> Friends;
		
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_greetings);
	        
	        
	        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(this, DB_NAME);
	        database = dbOpenHelper.openDataBase();
	        
	        fillFreinds();
	        setUpList();      
	    }

		private void setUpList() {
			
			setListAdapter(new ArrayAdapter<String>(this,
							android.R.layout.simple_list_item_1, Friends));
			listView = getListView();
			
			
			listView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view,
									int position,long id) {
					Toast.makeText(getApplicationContext(),
								((TextView) view).getText().toString(),
								 Toast.LENGTH_SHORT).show();				
				}
			});
		}
		
		
		private void fillFreinds() {
			Friends = new ArrayList<String>();
			Cursor friendCursor = database.query(TABLE_NAME,
												 new String[] 
												 {FRIEND_ID, FRIEND_NAME},
												 null, null, null, null
												 , FRIEND_NAME);
			friendCursor.moveToFirst();
			if(!friendCursor.isAfterLast()) {
				do {
					String name = friendCursor.getString(1);
					Friends.add(name);
				} while (friendCursor.moveToNext());
			}
			friendCursor.close();
		}
	}
