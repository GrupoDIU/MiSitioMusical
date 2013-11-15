package com.example.misitiomusical;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;

public class BusquedaAvanzadaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle=getIntent().getExtras();
		ArrayList<Lista_entrada_canciones> listaCanciones=(ArrayList<Lista_entrada_canciones>) bundle.getSerializable(GestionarCanciones.lista_canciones);
		Log.i(listaCanciones.get(0).get_textoEncima()," Resultado de listaCanciones");
		setContentView(R.layout.busqueda_avanzada);
		Spinner spinnerAlbumes = (Spinner) findViewById(R.id.spinnerAlbumesBuscar);
    	ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
    	        R.array.albumes_array, android.R.layout.simple_spinner_item);
    	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinnerAlbumes.setAdapter(adapter);
    	
    	Spinner spinnerGeneros = (Spinner) findViewById(R.id.SpinnerGeneroBuscar);
    	ArrayAdapter<CharSequence> adapterGeneros = ArrayAdapter.createFromResource(this,
    	        R.array.generos_array, android.R.layout.simple_spinner_item);
    	adapterGeneros.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinnerGeneros.setAdapter(adapterGeneros);
		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.busqueda_avanzada, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
