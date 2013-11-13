package com.example.misitiomusical;

import android.app.Activity;
import android.os.Bundle;
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
	
	void lanza3(){
		String v1=et1.getText().toString();
	
		if(v1.equals("")){
        	Toast t = Toast.makeText(this, "Ingrese su correo",
                    Toast.LENGTH_SHORT);
            t.show();
		}else {
			Toast t = Toast.makeText(this, "Se ha enviado su contraseña a su correo",
                    Toast.LENGTH_SHORT);
            t.show();
			
		}
		}
	
	

}
