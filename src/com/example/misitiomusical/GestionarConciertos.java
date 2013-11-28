package com.example.misitiomusical;

import java.util.ArrayList;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class GestionarConciertos extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gestionar_conciertos);
		cargarListaConciertos();
	}

	public void cargarListaConciertos() {
		
		ArrayList<Lista_entrada_conciertos>datosConciertos = new ArrayList<Lista_entrada_conciertos>();  
		
		datosConciertos.add(new Lista_entrada_conciertos("Con los patas del alma", "5 fotos",R.drawable.concierto_1));
        datosConciertos.add(new Lista_entrada_conciertos( "Union de la amistad", "15 fotos",R.drawable.concierto_2));
        datosConciertos.add(new Lista_entrada_conciertos( "10 años de musica", "10 fotos",R.drawable.concierto_3));
        datosConciertos.add(new Lista_entrada_conciertos( "Reviviendo infancia", "8 fotos",R.drawable.concierto_4));
        datosConciertos.add(new Lista_entrada_conciertos( "Visita a Peru", "6 fotos",R.drawable.concierto_5));
        datosConciertos.add(new Lista_entrada_conciertos( "Tributo a Hector Lavoe", "7 fotos",R.drawable.concierto_6));
        ListView lista = (ListView) findViewById(R.id.lista_de_conciertos);
        
        lista.setAdapter(new Lista_adaptador(this, R.layout.modelo_concierto, datosConciertos){
			@Override
			public void onEntrada(Object entrada, View view) {
		        if (entrada != null) {
		            TextView nombreConcierto = (TextView) view.findViewById(R.id.nombre_concierto); 
		            if (nombreConcierto != null) 
		            	nombreConcierto.setText(((Lista_entrada_conciertos) entrada).getNombreConcierto()); 
		              
		            TextView numeroFotos = (TextView) view.findViewById(R.id.numero_fotos); 
		            if (numeroFotos != null)
		            	numeroFotos.setText(((Lista_entrada_conciertos) entrada).getNumeroCanciones()); 
		            ImageView imagen = (ImageView) view.findViewById(R.id.imagen_concierto); 
		            if (imagen != null)
		            	imagen.setImageResource(((Lista_entrada_conciertos) entrada).getIdImagen());
		           
		        }
			}
		});
        lista.setOnItemClickListener(new OnItemClickListener() { 
			@Override
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
				Intent intent =new Intent(view.getContext(),ConciertoActivity.class);
				startActivity(intent);
			}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gestionar_conciertos, menu);
		return true;
	}

}
