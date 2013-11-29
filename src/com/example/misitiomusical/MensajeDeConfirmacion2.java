package com.example.misitiomusical;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MensajeDeConfirmacion2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mensaje_confirmacion2);
	}
	
	
	public void lanzarfinal_3(View view) {
		Intent i = new Intent(this, reproducirm.class );
        startActivity(i);
	}

}
