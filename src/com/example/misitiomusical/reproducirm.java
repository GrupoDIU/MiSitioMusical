package com.example.misitiomusical;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class reproducirm extends Activity {
	
	
    private ListView lv;
     
    // Listview Adapter
    ArrayAdapter<String> adapter;
     
    // Search EditText
    EditText inputSearch;
     
     
    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reproducirmusic);
		Resources res = getResources();
		
		TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
		tabs.setup();
		 
		TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
		spec.setContent(R.id.tab1);
		spec.setIndicator("Inicio",
		    res.getDrawable(android.R.drawable.ic_btn_speak_now));
		tabs.addTab(spec);
		 
		spec=tabs.newTabSpec("mitab2");
		spec.setContent(R.id.tab2);
		spec.setIndicator("Historial",
		    res.getDrawable(android.R.drawable.ic_dialog_map));
		tabs.addTab(spec);
		
		spec=tabs.newTabSpec("mitab3");
		spec.setContent(R.id.tab3);
		spec.setIndicator("Buscar",
		    res.getDrawable(android.R.drawable.btn_star_big_off));
		tabs.addTab(spec);
		 
		tabs.setCurrentTab(0);
		
		tabs.setOnTabChangedListener(new OnTabChangeListener() {
		    @Override
		    public void onTabChanged(String tabId) {
		        Log.i("AndroidTabsDemo", "Pulsada pestaña: " + tabId);
		    }
		});
		
		//aqui comienza el codigo para implementar la busqueda
		
        // Listview Data
        String products[] = {"A ti", "A volar", "A ciegas", "A quien tu decidiste amar", "Alive",
                                "A contra luz", "A cada paso", "Baby Baby", "Baby Eyes", "Caballito",
                                "Celos", "Daisy", "Dale", "Dale Caliente", "Detras de un Cristal", "Enamorarse",
                                "Entre tus alas", "Foreword", "Gone", "Gracias", "Imaginate", "Mar de amor", 
                                "Mi pobre corazon", "Te fuiste de aqui", "Regalame un beso", "Si tu me quisieras",
                                "Yo solo quiero", "Ya no", "Ya te amo", "Yo te sigo queriendo", "Veo", "Zun DaDa"};
         
        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
         
        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, products);
        lv.setAdapter(adapter);
         
        /**
         * Enabling Search Filter
         * */
        inputSearch.addTextChangedListener(new TextWatcher() {
             
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                reproducirm.this.adapter.getFilter().filter(cs);   
            }
             
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                    int arg3) {
                // TODO Auto-generated method stub
                 
            }
             
            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub                          
            }
        });
		
		
		

}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/*
	 //Aqui intento reproducir los archivos con el mismo android
	
	public void ejecutarAlex(View v) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
        Uri data = Uri.parse("file:///sdcard" + "/detras_de_un_cristal.mp3");
        intent.setDataAndType(data, "audio/mp3");
        startActivity(intent);
    }
	
	public void ejecutarCamila(View v) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
        Uri data = Uri.parse("file:///sdcard" + "/entre_tus_alas.mp3");
        intent.setDataAndType(data, "audio/mp3");
        startActivity(intent);
    }
	
	public void ejecutarLinking(View v) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
        Uri data = Uri.parse("file:///sdcard" + "/foreword.mp3");
        intent.setDataAndType(data, "audio/mp3");
        startActivity(intent);
    }
	
	public void ejecutarReik(View v) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
        Uri data = Uri.parse("file:///sdcard" + "/te_fuiste_de_aqui.mp3");
        intent.setDataAndType(data, "audio/mp3");
        startActivity(intent);
    }
	
	
	
	*/
	
    
    //Aqui intento pasar parametros a otra actividad
    
    public void lanzarAlex(View view) {
    	 Intent i = new Intent(this, reproductorAudio.class);
         i.putExtra("direccion", "detras_de_un_cristal");
         startActivity(i);
  }    
    
    public void lanzarCamila(View view) {
   	 Intent i = new Intent(this, reproductorAudio.class);
        i.putExtra("direccion", "entre_tus_alas");
        startActivity(i);
 }    
    
    public void lanzarLinking(View view) {
   	 Intent i = new Intent(this, reproductorAudio.class);
        i.putExtra("direccion", "foreword");
        startActivity(i);
 }    
    
    
    public void lanzarReik(View view) {
   	 Intent i = new Intent(this, reproductorAudio.class);
        i.putExtra("direccion", "te_fuiste_de_aqui");
        startActivity(i);
 }    
	
}
