package com.example.misitiomusical;

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
		String v1=et1.getText().toString();
	
		if(v1.equals("")){
        	Toast t = Toast.makeText(this, "Ingrese su correo",
                    Toast.LENGTH_SHORT);
            t.show();
		}else {
			
			        Intent i = new Intent(this, RecuperaCuenta.class );
			        startActivity(i);
			
		}
		}
	
	

}
