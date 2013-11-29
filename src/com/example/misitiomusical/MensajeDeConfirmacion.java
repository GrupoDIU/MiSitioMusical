package com.example.misitiomusical;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MensajeDeConfirmacion extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mensaje_confirmacion);
	}
	
	
	public void lanzarfinal_2(View view) {
		Intent i = new Intent(this, MenuManagerActivity.class );
        startActivity(i);
	}
	
	

}
