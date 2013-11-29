package com.example.misitiomusical;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class RecuperaCuenta extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recupera_cuenta);
	}
	
	
	public void lanza4(View view){
					
			        Intent i = new Intent(this, MainActivity.class );
			        startActivity(i);
			
		}
		}


