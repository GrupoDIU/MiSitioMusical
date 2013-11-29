package com.example.misitiomusical;



import java.util.ArrayList;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.MenuItemCompat;
import android.text.AndroidCharacter;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TabHost.OnTabChangeListener;

public class GestionarCanciones extends Activity implements OnQueryTextListener{
	private static final int constant_tab_cancion = 0;
	private static final int constant_tab_album = 1;
	public static final String lista_canciones="listaCanciones";
	public static final String lista_albumes="listaAlbumes";
	private ListView lista; 
	private ListView listaAlbumes; 
	MediaPlayer mp=new MediaPlayer();
	TabHost tabHost;
	ArrayList<Lista_entrada_albumes> datos;
	ArrayList<Lista_entrada_canciones> datosCanciones;
	protected int posicionActual;
	SearchView searchView;
	String tabActual;
	ArrayList<Lista_entrada_canciones> todasLasCanciones;
	public ArrayList<Lista_entrada_albumes> todosLosAlbumes;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gestionar_canciones);
		tabHost=(TabHost)findViewById(android.R.id.tabhost);
		tabHost.setup();
	       tabHost.addTab(tabHost.newTabSpec("tabListaCanciones").setIndicator( 
	          "Canciones", null).setContent(R.id.tabListaCanciones));
	       tabHost.addTab(tabHost.newTabSpec("tabListaAlbumes").setIndicator( 
	          "Albumes", null).setContent(R.id.tabListaAlbumes));
	       
	       tabHost.setCurrentTab(constant_tab_cancion);
	       cargarListaCanciones();
	      
			tabHost.setOnTabChangedListener(new OnTabChangeListener() {
			    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
				@Override
			    public void onTabChanged(String tabId) {
			        if(tabId.equals("tabListaCanciones")){
			        	cargarListaCanciones();
			        	tabActual="tabListaCanciones";
			    		searchView.setQueryHint("Buscar cancion...");
			        	Log.i("AndroidTabsDemo", "Pulsada pestaña: " + tabId);
			        }
			        else if(tabId.equals("tabListaAlbumes")){
			        	cargarListaAlbumes();
			        	tabActual="tabListaAlbumes";
			        	searchView.setQueryHint("Buscar album...");
			        	Log.i("AndroidTabsDemo", "Pulsada pestaña: " + tabId);	
			        }
			    }
			});
		
	}

	protected void cargarListaAlbumes() {
		ArrayList<Lista_entrada_albumes> datos = new ArrayList<Lista_entrada_albumes>();  
		
		datos.add(new Lista_entrada_albumes(R.drawable.album_blink182, "somos adolescentes", "5 canciones"));
        datos.add(new Lista_entrada_albumes(R.drawable.album_nirvana, "nadar como bebes", "6 canciones"));
        datos.add(new Lista_entrada_albumes(R.drawable.album_libido, "somos locos", "10 canciones"));
        todosLosAlbumes=(ArrayList<Lista_entrada_albumes>) datos.clone();

        listaAlbumes = (ListView) findViewById(R.id.tabListaAlbumes);
        listaAlbumes.setAdapter(new Lista_adaptador(this, R.layout.modelo_album, datos){
			@Override
			public void onEntrada(Object entrada, View view) {
		        if (entrada != null) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior); 
		            if (texto_superior_entrada != null) 
		            	texto_superior_entrada.setText(((Lista_entrada_albumes) entrada).get_textoEncima()); 
		              
		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior); 
		            if (texto_inferior_entrada != null)
		            	texto_inferior_entrada.setText(((Lista_entrada_albumes) entrada).get_textoDebajo()); 
		              
		            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
		            if (imagen_entrada != null)
		            	imagen_entrada.setImageResource(((Lista_entrada_albumes) entrada).get_idImagen());
		        }
			}
		});
        
        listaAlbumes.setOnItemClickListener(new OnItemClickListener() { 
			@Override
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
				Lista_entrada_albumes elegido = (Lista_entrada_albumes) pariente.getItemAtPosition(posicion); 
                
                CharSequence texto = "Seleccionado: " + elegido.get_textoDebajo();
                Toast toast = Toast.makeText(GestionarCanciones.this, texto, Toast.LENGTH_LONG);
                toast.show();
			}
        });
	}

	protected void cargarListaCanciones() {
		datosCanciones = new ArrayList<Lista_entrada_canciones>();  
		
		datosCanciones.add(new Lista_entrada_canciones("una rosa en la playa", "Duracion: 3:00 min"));
        datosCanciones.add(new Lista_entrada_canciones( "estoy loco loco", "Duracion: 4:30 min"));
        datosCanciones.add(new Lista_entrada_canciones( "detras de un cristal", "Duracion: 4:00 min"));
        datosCanciones.add(new Lista_entrada_canciones( "entre tus alas", "Duracion: 3:30 min"));
        datosCanciones.add(new Lista_entrada_canciones( "foreword", "Duracion: 3:00 min"));
        datosCanciones.add(new Lista_entrada_canciones( "Te fuiste de aqui", "Duracion: 3:00 min"));
        todasLasCanciones=(ArrayList<Lista_entrada_canciones>) datosCanciones.clone();
        lista = (ListView) findViewById(R.id.tabListaCanciones);
        lista.setAdapter(new Lista_adaptador(this, R.layout.modelo_cancion, datosCanciones){
			@Override
			public void onEntrada(Object entrada, View view) {
		        if (entrada != null) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior_cancion); 
		            if (texto_superior_entrada != null) 
		            	texto_superior_entrada.setText(((Lista_entrada_canciones) entrada).get_textoEncima()); 
		              
		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior_cancion); 
		            if (texto_inferior_entrada != null)
		            	texto_inferior_entrada.setText(((Lista_entrada_canciones) entrada).get_textoDebajo()); 
		              
		           
		        }
			}
		});
        //lista.setTextFilterEnabled(true);
        lista.setOnItemClickListener(new OnItemClickListener() { 
			@Override
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
				Lista_entrada_canciones elegido = (Lista_entrada_canciones) pariente.getItemAtPosition(posicion); 
				//if(mp.isPlaying())
            	//	mp.stop();
				Intent i = new Intent(view.getContext(), reproductorAudio.class);
				if(elegido.get_textoEncima().equalsIgnoreCase("una rosa en la playa")){
					i.putExtra("direccion", "rosa_playa");
			        startActivity(i);
                	//mp = MediaPlayer.create(getApplicationContext(), R.raw.rosa_playa);
                    //mp.start();
                }
                else if(elegido.get_textoEncima().equalsIgnoreCase("estoy loco loco")){
                	i.putExtra("direccion", "locoloco");
			        startActivity(i);
                	//mp = MediaPlayer.create(getApplicationContext(), R.raw.locoloco);
                    //mp.start();
                }
                else if(elegido.get_textoEncima().equalsIgnoreCase("detras de un cristal")){
                	i.putExtra("direccion", "detras_de_un_cristal");
			        startActivity(i);
                	//mp = MediaPlayer.create(getApplicationContext(), R.raw.detras_de_un_cristal);
                    //mp.start();
                }
                else if(elegido.get_textoEncima().equalsIgnoreCase("entre tus alas")){
                	i.putExtra("direccion", "entre_tus_alas");
			        startActivity(i);
                	//mp = MediaPlayer.create(getApplicationContext(), R.raw.entre_tus_alas);
                   // mp.start();
                }
                else if(elegido.get_textoEncima().equalsIgnoreCase("foreword")){
                	i.putExtra("direccion", "foreword");
			        startActivity(i);
                	//mp = MediaPlayer.create(getApplicationContext(), R.raw.foreword);
                    //mp.start();
                }
                else if(elegido.get_textoEncima().equalsIgnoreCase("te fuiste de aqui")){
                	i.putExtra("direccion", "te_fuiste_de_aqui");
			        startActivity(i);
                	//mp = MediaPlayer.create(getApplicationContext(), R.raw.te_fuiste_de_aqui);
                    //mp.start();
                }
                CharSequence texto = "Seleccionado: " + elegido.get_textoDebajo();
                Toast toast = Toast.makeText(GestionarCanciones.this, texto, Toast.LENGTH_LONG);
                toast.show();
			}
        });
        /*lista.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View vista,
					int posicion, long id) {
				System.out.println("Long click");
				startActionMode(modeCallBack);
				vista.setSelected(true);
				posicionActual=posicion;
				return true;
			}
        	
		});*/
        registerForContextMenu(this.lista);
	}
	/*
	private ActionMode.Callback modeCallBack = new ActionMode.Callback() {
		   public boolean onPrepareActionMode(ActionMode mode, Menu menu){   
		    return false;
		   }
		  public void onDestroyActionMode(ActionMode mode) {
		    mode = null;  
		   }
		   public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			   mode.setTitle("Opciones");
			   mode.getMenuInflater().inflate(R.menu.menu_contextual_opciones_cancion, menu);
			   return true;
		   }
		   public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			   int id = item.getItemId();
			    switch (id) {
			      case R.id.gestionar_canciones_pausar: {
			        	mp.pause();
			        break;
			             }
			      case R.id.gestionar_canciones_eliminar: {
			    	  CharSequence texto = "Cancion Eliminada!!";
		              Toast toast = Toast.makeText(GestionarCanciones.this, texto, Toast.LENGTH_LONG);
		              toast.show();
		              datosCanciones.remove(posicionActual);
		              ((BaseAdapter)lista.getAdapter()).notifyDataSetChanged();
		              mode.finish();
			               break;
			            }
			        default:
			               return false;
			    }
			    return true;
		   }
		};

*/
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gestionar_canciones, menu);
		MenuItem searchItem=menu.findItem(R.id.action_buscar_rapido);
		searchView=(SearchView)searchItem.getActionView();
		searchView.setQueryHint("Buscar cancion...");
		searchView.setOnQueryTextListener(this);
	    return true;
	}
	
	

	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
	      case R.id.gestionar_canciones_pausar:
	        mp.pause();
	         return true;
	 
	      case R.id.gestionar_canciones_eliminar:
	    	  CharSequence texto = "Cancion Eliminada!!";
              Toast toast = Toast.makeText(GestionarCanciones.this, texto, Toast.LENGTH_LONG);
              toast.show();
              datosCanciones.remove(posicionActual);
              ((BaseAdapter)lista.getAdapter()).notifyDataSetChanged();
	         return true;
	 
	      default:
	         return super.onOptionsItemSelected(item);
	      }
	} 

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		if(v.getId()==R.id.tabListaCanciones){
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.menu_contextual_opciones_cancion, menu);
		}
	}


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
		  case R.id.action_salir1:
			  System.exit(0);
			  finish();
			  return true;
		  default:
			  return super.onOptionsItemSelected(item);
		}
		
	}

	private void busquedaAvanzada() {
		// TODO Auto-generated method stub
		Intent intent=new Intent(this,BusquedaAvanzadaActivity.class);
		Bundle bundle = new Bundle();
		
		//if(tabHost.getTabWidget().getTabCount()==0)
		bundle.putSerializable(lista_canciones, datosCanciones);
		bundle.putSerializable(lista_albumes, datos);
		intent.putExtras(bundle);
		startActivity(intent);
		/*Bundle getBundle = this.getIntent().getExtras();
		List<Channel> channelsList = getBundle.getParcelableArrayList("channel");*/
	}

	public void agregarCancion(){
		Intent intent =new Intent(this,AgregarCancionActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		System.out.println("onQueryTextChange----------");
		if(tabActual.equalsIgnoreCase("tabListaCanciones")){
			if (newText.toString().length() == 0){
	            datosCanciones.clear();
	            datosCanciones.addAll(todasLasCanciones);
	            ((BaseAdapter)lista.getAdapter()).notifyDataSetChanged();
	            return true;
	        }
	
			datosCanciones.clear();
	        datosCanciones.addAll(todasLasCanciones);
	        
	        ArrayList<Lista_entrada_canciones> toRemove = new ArrayList<Lista_entrada_canciones>();
	        for (Lista_entrada_canciones item : datosCanciones){
	            if (!item.get_textoEncima().contains(newText)){
	            	Log.i("TAG: ", newText);
	                    toRemove.add(item);
	            }
	        }
			
	        datosCanciones.removeAll(toRemove);
	        ((BaseAdapter)lista.getAdapter()).notifyDataSetChanged();
	        return true;
		}
		else
		{
			if (newText.toString().length() == 0){
	            datos.clear();
	            datos.addAll(todosLosAlbumes);
	            ((BaseAdapter)listaAlbumes.getAdapter()).notifyDataSetChanged();
	            return true;
	        }
	
			datos.clear();
	        datos.addAll(todosLosAlbumes);
	        
	        ArrayList<Lista_entrada_albumes> toRemove = new ArrayList<Lista_entrada_albumes>();
	        for (Lista_entrada_albumes item : datos){
	            if (!item.get_textoEncima().contains(newText)){
	            	Log.i("TAG: ", newText);
	                    toRemove.add(item);
	            }
	        }
			
	        datos.removeAll(toRemove);
	        ((BaseAdapter)listaAlbumes.getAdapter()).notifyDataSetChanged();
	        return true;
		}
	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		System.out.println("onQueryTextChange----------");
		 /*
		if (query.toString().length() == 0){
            datosCanciones.clear();
            datosCanciones.addAll(todasLasCanciones);
            ((BaseAdapter)lista.getAdapter()).notifyDataSetChanged();
            return true;
        }

		datosCanciones.clear();
        datosCanciones.addAll(todasLasCanciones);
        
        ArrayList<Lista_entrada_canciones> toRemove = new ArrayList<Lista_entrada_canciones>();
        for (Lista_entrada_canciones item : datosCanciones){
            if (item.get_textoEncima().contains(query)){
            	Log.i("TAG: ", query);
                    toRemove.add(item);
            }
        }
		
        datosCanciones.removeAll(toRemove);
        ((BaseAdapter)lista.getAdapter()).notifyDataSetChanged();*/
        return true;
	}
}
