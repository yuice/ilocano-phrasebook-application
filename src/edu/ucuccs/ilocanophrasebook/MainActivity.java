package edu.ucuccs.ilocanophrasebook;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void clickFavorites(View v) {
		Intent gotoFavorites = new Intent(MainActivity.this,
				FavoritesActivity.class);
		startActivity(gotoFavorites);
	}

	public void clickGreetings(View v) {
		Intent gotoGreetings = new Intent(MainActivity.this,
				GreetingsActivity.class);
		startActivity(gotoGreetings);
	}

	public void clickPlaces(View v) {
		Intent gotoPlaces = new Intent(MainActivity.this, PlacesActivity.class);
		startActivity(gotoPlaces);
	}

	public void clickDirections(View v) {
		Intent gotoDirection = new Intent(MainActivity.this,
				DirectionsActivity.class);
		startActivity(gotoDirection);
	}

	public void clickColors(View v) {
		Intent gotoColors = new Intent(MainActivity.this, ColorsActivity.class);
		startActivity(gotoColors);
	}

	public void clickNumbers(View v) {
		Intent gotoNumbers = new Intent(MainActivity.this,
				NumbersActivity.class);
		startActivity(gotoNumbers);
	}

	public void clickHobbies(View v) {
		Intent gotoHobbies = new Intent(MainActivity.this,
				HobbiesActivity.class);
		startActivity(gotoHobbies);
	}

	public void clickEmergency(View v) {
		Intent gotoEmergency = new Intent(MainActivity.this,
				EmergencyActivity.class);
		startActivity(gotoEmergency);
	}

	public void clickRelatives(View v) {
		Intent gotoRelatives = new Intent(MainActivity.this,
				RelativesActivity.class);
		startActivity(gotoRelatives);
	}

	public void clickOccupation(View v) {
		Intent gotoOccupations = new Intent(MainActivity.this,
				OccupationActivity.class);
		startActivity(gotoOccupations);
	}

	public void clickWeather(View v) {
		Intent gotoWeather = new Intent(MainActivity.this,
				WeatherActivity.class);
		startActivity(gotoWeather);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.action_bar_menu, menu);

		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.action_search)
				.getActionView();
		searchView.setSearchableInfo(searchManager
				.getSearchableInfo(getComponentName()));

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case R.id.action_settings:
			startActivity(new Intent(getApplicationContext(), Preference.class));

			break;

		default:
			return onOptionsItemSelected(item);
		}
		return true;

	}

}