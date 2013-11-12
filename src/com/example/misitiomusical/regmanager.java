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
	private EditText et1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registromanager);
		et1=(EditText)findViewById(R.id.editTextUsuario);
		
		spinner1 = (Spinner) findViewById(R.id.spinner1);
        String []opciones={"Seleccionar Genero", "Alternativo","Bachata", "Baladas", "Electronica", "Hip Hop", "Rock", "Salsa"};        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);
	}
	
	
	
	public void lanzarfinal(View view) {
		String v1=et1.getText().toString();
		String selec=spinner1.getSelectedItem().toString();
		if(selec.equals("Seleccionar Genero") || v1.equals("")){
        	Toast t = Toast.makeText(this, "por favor complete el formulario",
                    Toast.LENGTH_SHORT);
            t.show();
        }else{
        	 Intent i = new Intent(this, regfinal.class);
	     i.putExtra("cuenta", "manager");
	     startActivity(i);
	     
        }
        }    
	
	/*public void lanzaratras(View view) {
        Intent i = new Intent(this, reg1.class );
        startActivity(i);
  }   */ 
	
	 

}
