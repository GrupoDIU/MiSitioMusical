package com.example.misitiomusical;

import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ContraOlvidada extends Activity {
	private EditText et1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contraseniaolvidada);
		et1=(EditText)findViewById(R.id.etCorreo1);
	}
	
	public void lanza3(View view){
		String email=et1.getText().toString();
		Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
		          "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
		          "\\@" +
		          "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
		          "(" +
		          "\\." +
		          "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
		          ")+"
		      );
		boolean correcto=EMAIL_ADDRESS_PATTERN.matcher(email).matches();
		if(email.equals("")){
        	Toast t = Toast.makeText(this, "Ingrese su correo",
                    Toast.LENGTH_SHORT);
            t.show();
		}else {
			if(correcto){
			        Intent i = new Intent(this, RecuperaCuenta.class );
			        startActivity(i);
			}
			else{
				Toast t = Toast.makeText(this, "Formato de Correo: correo@proveedor.dominio",
	                    Toast.LENGTH_SHORT);
	            t.show();
			}
			
			}
		
		}
		
	
	

}
