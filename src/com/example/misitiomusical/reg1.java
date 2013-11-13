package com.example.misitiomusical;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class reg1 extends Activity {
	private Spinner spinner1;
	private Spinner spinner2;
	private EditText et1,et2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registro);
		et1=(EditText)findViewById(R.id.etNombreUsuario);
        et2=(EditText)findViewById(R.id.etCorreo);
       
       
		
		spinner1 = (Spinner) findViewById(R.id.spinner1);
        String []opciones={"Seleccionar", "Publico","Manager"};        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);
        
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        String []opciones2={"Seleccionar", "M","F"};        
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones2);
        spinner2.setAdapter(adapter2);
	}
	
	public void lanzarmanager(View view) {
		String selec=spinner1.getSelectedItem().toString();
		String selec2=spinner2.getSelectedItem().toString();
		String v1=et1.getText().toString();
        String v2=et2.getText().toString();
       
		if(selec.equals("Seleccionar")){
        	Toast t = Toast.makeText(this, "Falta elegir el tipo de cuenta",
                    Toast.LENGTH_SHORT);
            t.show();
        }else if (selec2.equals("Seleccionar")){
        	Toast t = Toast.makeText(this, "Falta elegir el sexo",
                    Toast.LENGTH_SHORT);
            t.show();
        } else if(v1.equals("")){
        	Toast t = Toast.makeText(this, "Falta Ingresar su nombre",
                    Toast.LENGTH_SHORT);
            t.show();
        	} else if(v2.equals("")){
        		Toast t = Toast.makeText(this, "Falta Ingresar su Correo",
                        Toast.LENGTH_SHORT);
                t.show();
        	} else
		if (selec.equals("Manager")) {
			Intent i = new Intent(this, regmanager.class );
	        startActivity(i);
        } else
            if (selec.equals("Publico")) {
    	        Intent i = new Intent(this, regfinal.class);
    		    i.putExtra("cuenta", "publico");
    		    startActivity(i);
            }
        
  }    
	
	/*public void lanzarorigen(View view) {
        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);
  } */

}
