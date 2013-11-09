package com.example.misitiomusical;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.text.AndroidCharacter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class GestionarCanciones extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gestionar_canciones);
		TabHost tabHost=(TabHost)findViewById(android.R.id.tabhost);
		tabHost.setup();
	       tabHost.addTab(tabHost.newTabSpec("tabListaCanciones").setIndicator( 
	          "Canciones", null).setContent(R.id.tabListaCanciones));
	       tabHost.addTab(tabHost.newTabSpec("tabListaAlbumes").setIndicator( 
	          "Albumes", null).setContent(R.id.tabListaAlbumes));
	       tabHost.setCurrentTab(0);
			
			tabHost.setOnTabChangedListener(new OnTabChangeListener() {
			    @Override
			    public void onTabChanged(String tabId) {
			        Log.i("AndroidTabsDemo", "Pulsada pestaña: " + tabId);
			    }
			});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gestionar_canciones, menu);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		  case R.id.action_agregar_cancion:
			  agregarCancion();
			  return true;
		  case R.id.action_busqueda_avanzada:
			  busquedaAvanzada();
			  return true;
		  default:
			  return super.onOptionsItemSelected(item);
		}
		
	}

	private void busquedaAvanzada() {
		// TODO Auto-generated method stub
		Intent intent=new Intent(this,BusquedaAvanzadaActivity.class);
		startActivity(intent);
	}

	public void agregarCancion(){
		Intent intent =new Intent(this,AgregarCancionActivity.class);
		startActivity(intent);
	}
}
