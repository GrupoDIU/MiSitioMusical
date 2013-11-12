package com.example.misitiomusical;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class regmanager extends Activity {
	private Spinner spinner1;
	private EditText etNombreArtista,etUsuario2, etContra;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registromanager);
		etNombreArtista=(EditText)findViewById(R.id.etNombreArtistico);
		etUsuario2=(EditText)findViewById(R.id.etUsuario);
		etContra=(EditText)findViewById(R.id.etContra);
		
		spinner1 = (Spinner) findViewById(R.id.spinner1);
        String []opciones={"Seleccionar Genero", "Alternativo","Bachata", "Baladas", "Electronica", "Hip Hop", "Rock", "Salsa"};        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);
	}
	
	
	
	public void lanzarfinal(View view) {
		String Artista=etNombreArtista.getText().toString();
		String Usuario=etNombreArtista.getText().toString();
		String Contras=etNombreArtista.getText().toString();
		String selec=spinner1.getSelectedItem().toString();
		if(selec.equals("Seleccionar Genero")){
        	Toast t = Toast.makeText(this, "Falta seleccionar el genero",
                    Toast.LENGTH_SHORT);
            t.show();
		}else if(Artista.equals("")){
			Toast t = Toast.makeText(this, "Falta ingresar su grupo musical",
                    Toast.LENGTH_SHORT);
            t.show();
        } else if(Usuario.equals("")){
        	Toast t = Toast.makeText(this, "Falta ingresar su usuario",
                    Toast.LENGTH_SHORT);
            t.show();
        } else if(Contras.equals("")){
        	Toast t = Toast.makeText(this, "Falta ingresar su Contraseña",
                    Toast.LENGTH_SHORT);
            t.show();
        }
		else{
			
			/*Toast t = Toast.makeText(this, "Bienvenido a mi Sitio Musical",
                    Toast.LENGTH_SHORT);
            t.show();
			
         Intent i = new Intent(this, regfinal.class);
	     i.putExtra("cuenta", "manager");
	     startActivity(i); */
	     
	     Intent i = new Intent(this, MenuManagerActivity.class );
	        startActivity(i);
	     
        }
        }  
	
	
	
	
	
	
	/*public void lanzaratras(View view) {
        Intent i = new Intent(this, reg1.class );
        startActivity(i);
  }   */ 
	
	 

}
