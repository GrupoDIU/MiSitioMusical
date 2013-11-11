package com.example.misitiomusical;



import java.util.ArrayList;

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
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TabHost.OnTabChangeListener;

public class GestionarCanciones extends Activity {
	private ListView lista; 
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
	       tabHost.setCurrentTab(1);
	       
	       ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();  
	        
	        datos.add(new Lista_entrada(R.drawable.im_buho, "BUHO", "Búho es el nombre común de aves de la familia Strigidae, del orden de las estrigiformes o aves rapaces nocturnas. Habitualmente designa especies que, a diferencia de las lechuzas, tienen plumas alzadas que parecen orejas."));
	        datos.add(new Lista_entrada(R.drawable.im_colibri, "COLIBRÍ", "Los troquilinos (Trochilinae) son una subfamilia de aves apodiformes de la familia Trochilidae, conocidas vulgarmente como colibríes, quindes, tucusitos, picaflores, chupamirtos, chuparrosas, huichichiquis (idioma nahuatl), mainumby (idioma guaraní) o guanumby. Conjuntamente con las ermitas, que pertenecen a la subfamilia Phaethornithinae, conforman la familia Trochilidae que, en la sistemática de Charles Sibley, se clasifica en un orden propio: Trochiliformes, independiente de los vencejos del orden Apodiformes. La subfamilia Trochilinae incluye más de 100 géneros que comprenden un total de 330 a 340 especies."));
	        datos.add(new Lista_entrada(R.drawable.im_cuervo, "CUERVO", "El cuervo común (Corvus corax) es una especie de ave paseriforme de la familia de los córvidos (Corvidae). Presente en todo el hemisferio septentrional, es la especie de córvido con la mayor superficie de distribución. Con el cuervo de pico grueso, es el mayor de los córvidos y probablemente la paseriforme más pesada; en su madurez, el cuervo común mide entre 52 y 69 centímetros de longitud y su peso varía de 0,69 a 1,7 kilogramos. Los cuervos comunes viven generalmente de 10 a 15 años pero algunos individuos han vivido 40 años. Los juveniles pueden desplazarse en grupos pero las parejas ya formadas permanecen juntas toda su vida, cada pareja defendiendo un territorio. Existen 8 subespecies conocidas que se diferencian muy poco aparentemente, aunque estudios recientes hayan demostrado diferencias genéticas significativas entre las poblaciones de distintas regiones."));
	        
	        lista = (ListView) findViewById(R.id.tabListaAlbumes);
	        lista.setAdapter(new Lista_adaptador(this, R.layout.modelo_album, datos){
				@Override
				public void onEntrada(Object entrada, View view) {
			        if (entrada != null) {
			            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior); 
			            if (texto_superior_entrada != null) 
			            	texto_superior_entrada.setText(((Lista_entrada) entrada).get_textoEncima()); 
			              
			            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior); 
			            if (texto_inferior_entrada != null)
			            	texto_inferior_entrada.setText(((Lista_entrada) entrada).get_textoDebajo()); 
			              
			            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
			            if (imagen_entrada != null)
			            	imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
			        }
				}
			});
	        
	        lista.setOnItemClickListener(new OnItemClickListener() { 
				@Override
				public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
					Lista_entrada elegido = (Lista_entrada) pariente.getItemAtPosition(posicion); 
	                
	                CharSequence texto = "Seleccionado: " + elegido.get_textoDebajo();
	                Toast toast = Toast.makeText(GestionarCanciones.this, texto, Toast.LENGTH_LONG);
	                toast.show();
				}
	        });
			tabHost.setOnTabChangedListener(new OnTabChangeListener() {
			    @Override
			    public void onTabChanged(String tabId) {
			        if(tabId.equals("tabListaCanciones")){
			        	cargarListaCanciones();
			        	Log.i("AndroidTabsDemo", "Pulsada pestaña: " + tabId);
			        }
			        else if(tabId.equals("tabListaAlbumes")){
			        	cargarListaAlbumes();
			        	Log.i("AndroidTabsDemo", "Pulsada pestaña: " + tabId);	
			        }
			    }
			});
		
	}

	protected void cargarListaAlbumes() {
		ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();  
        
        datos.add(new Lista_entrada(R.drawable.im_buho, "BUHO", "Búho es el nombre común de aves de la familia Strigidae, del orden de las estrigiformes o aves rapaces nocturnas. Habitualmente designa especies que, a diferencia de las lechuzas, tienen plumas alzadas que parecen orejas."));
        datos.add(new Lista_entrada(R.drawable.im_colibri, "COLIBRÍ", "Los troquilinos (Trochilinae) son una subfamilia de aves apodiformes de la familia Trochilidae, conocidas vulgarmente como colibríes, quindes, tucusitos, picaflores, chupamirtos, chuparrosas, huichichiquis (idioma nahuatl), mainumby (idioma guaraní) o guanumby. Conjuntamente con las ermitas, que pertenecen a la subfamilia Phaethornithinae, conforman la familia Trochilidae que, en la sistemática de Charles Sibley, se clasifica en un orden propio: Trochiliformes, independiente de los vencejos del orden Apodiformes. La subfamilia Trochilinae incluye más de 100 géneros que comprenden un total de 330 a 340 especies."));
        datos.add(new Lista_entrada(R.drawable.im_cuervo, "CUERVO", "El cuervo común (Corvus corax) es una especie de ave paseriforme de la familia de los córvidos (Corvidae). Presente en todo el hemisferio septentrional, es la especie de córvido con la mayor superficie de distribución. Con el cuervo de pico grueso, es el mayor de los córvidos y probablemente la paseriforme más pesada; en su madurez, el cuervo común mide entre 52 y 69 centímetros de longitud y su peso varía de 0,69 a 1,7 kilogramos. Los cuervos comunes viven generalmente de 10 a 15 años pero algunos individuos han vivido 40 años. Los juveniles pueden desplazarse en grupos pero las parejas ya formadas permanecen juntas toda su vida, cada pareja defendiendo un territorio. Existen 8 subespecies conocidas que se diferencian muy poco aparentemente, aunque estudios recientes hayan demostrado diferencias genéticas significativas entre las poblaciones de distintas regiones."));
        
        lista = (ListView) findViewById(R.id.tabListaAlbumes);
        lista.setAdapter(new Lista_adaptador(this, R.layout.modelo_album, datos){
			@Override
			public void onEntrada(Object entrada, View view) {
		        if (entrada != null) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior); 
		            if (texto_superior_entrada != null) 
		            	texto_superior_entrada.setText(((Lista_entrada) entrada).get_textoEncima()); 
		              
		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior); 
		            if (texto_inferior_entrada != null)
		            	texto_inferior_entrada.setText(((Lista_entrada) entrada).get_textoDebajo()); 
		              
		            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
		            if (imagen_entrada != null)
		            	imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
		        }
			}
		});
        
        lista.setOnItemClickListener(new OnItemClickListener() { 
			@Override
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
				Lista_entrada elegido = (Lista_entrada) pariente.getItemAtPosition(posicion); 
                
                CharSequence texto = "Seleccionado: " + elegido.get_textoDebajo();
                Toast toast = Toast.makeText(GestionarCanciones.this, texto, Toast.LENGTH_LONG);
                toast.show();
			}
        });
	}

	protected void cargarListaCanciones() {
		// TODO Auto-generated method stub
		
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
