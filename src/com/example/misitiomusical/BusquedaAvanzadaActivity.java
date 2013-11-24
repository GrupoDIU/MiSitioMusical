package com.example.misitiomusical;

import java.util.ArrayList;
import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class BusquedaAvanzadaActivity extends Activity {
	private TextView fechaDesde;    
    private int mYear;    
    private int mMonth;    
    private int mDay;    
    static final int DATE_DIALOG_ID = 0;
    ArrayList<Lista_entrada_canciones> lista_canciones;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle=getIntent().getExtras();
		lista_canciones=(ArrayList<Lista_entrada_canciones>) bundle.getSerializable(GestionarCanciones.lista_canciones);
		Log.i(lista_canciones.get(0).get_textoEncima()," Resultado de lista de canciones");
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
		
    	// capture our View elements        
    	fechaDesde = (TextView) findViewById(R.id.etUsuario);        
    	fechaDesde.setKeyListener(null);
    	// get the current date        
    	final Calendar c = Calendar.getInstance();        
    	mYear = c.get(Calendar.YEAR);        
    	mMonth = c.get(Calendar.MONTH);        
    	mDay = c.get(Calendar.DAY_OF_MONTH);        
    	// display the current date (this method is below)        
    	updateDisplay();    
    	
    	
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
	 // updates the date in the TextView    
    private void updateDisplay() {        
    	fechaDesde.setText(            
    			new StringBuilder()                    
    			// Month is 0 based so add 1                    
    			.append(mMonth + 1).append("-")                    
    			.append(mDay).append("-")                    
    			.append(mYear).append(" "));    
    }
    
    
    @Override
    protected Dialog onCreateDialog(int id) {    
    	switch (id) {   
    		case DATE_DIALOG_ID:        
    			return new DatePickerDialog(this,                    
    					mDateSetListener,                    
    					mYear, mMonth, mDay);    
    			}    
    	return null;
    	}
    
    // the callback received when the user "sets" the date in the dialog    
    private DatePickerDialog.OnDateSetListener mDateSetListener =            
    	new DatePickerDialog.OnDateSetListener() {                
    	public void onDateSet(DatePicker view, int year,                                       
    			int monthOfYear, int dayOfMonth) {                    
    		mYear = year;                    
    		mMonth = monthOfYear;                    
    		mDay = dayOfMonth;                    
    		updateDisplay();                
    		}            
    	};
    public  void cambiarFecha(View view){
    	showDialog(DATE_DIALOG_ID);  
    }
    public void buscarCanciones(View view){
    	
    	Intent intent=new Intent(this,GestionarCanciones.class);
    	Bundle bundle = new Bundle();
    	bundle.putSerializable(GestionarCanciones.lista_canciones,lista_canciones);
    	intent.putExtras(bundle);
    	startActivity(intent);
    }
}
