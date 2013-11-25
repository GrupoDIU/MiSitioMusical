package com.example.misitiomusical;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class reproductorAudio extends Activity {
	String pista;
	MediaPlayer mp;
    //Button b1;
    int posicion = 0;
    TextView tit;
    boolean iniciado=false;
    
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reproduccionaudio);
		
		Bundle bundle = getIntent().getExtras();
        pista=bundle.getString("direccion");
        tit = (TextView) findViewById(R.id.tv1);
        tit.setText(pista);
        
	}
	
	
	//aqui configuro los botones del reproductor
	
	//Aca comienza el codigo para usar mi propio reproductor de audio
	
		public void destruir() {
	        if (mp != null)
	            mp.release();
	    }

	    public void iniciar(View v) {
	        destruir();
	        if(pista.equals("detras_de_un_cristal") && iniciado==false){
	        	iniciado=true;
	        	mp = MediaPlayer.create(this, R.raw.detras_de_un_cristal);
		        mp.start();
	        }else if(pista.equals("entre_tus_alas") && iniciado==false){
	        	iniciado=true;
	        	mp = MediaPlayer.create(this, R.raw.entre_tus_alas);
		        mp.start();
	        }else if(pista.equals("foreword") && iniciado==false){
	        	iniciado=true;
	        	mp = MediaPlayer.create(this, R.raw.foreword);
		        mp.start();	
	        }else if(pista.equals("te_fuiste_de_aqui") && iniciado==false){
	        	iniciado=true;
	        	mp = MediaPlayer.create(this, R.raw.te_fuiste_de_aqui);
		        mp.start();
	        }else if (mp != null && mp.isPlaying() == false && iniciado==true) {
	            mp.seekTo(posicion);
	            mp.start();
	        }
	        
	        
	       
	            mp.setLooping(false);
	        
	    }

	    public void pausar(View v) {
	    	
	        if (mp != null && mp.isPlaying()) {
	        	iniciado=true;
	            posicion = mp.getCurrentPosition();
	            mp.pause();
	        }
	    }

	    public void continuar(View v) {
	        if (mp != null && mp.isPlaying() == false) {
	            mp.seekTo(posicion);
	            mp.start();
	        }
	    }

	    public void detener(View v) {
	        if (mp != null) {
	        	iniciado=false;
	            mp.stop();
	            posicion = 0;
	        }
	    }

	   /* public void circular(View v) {
	        detener(null);
	        String op = b1.getText().toString();
	        if (op.equals("No reproducir en forma circular"))
	            b1.setText("reproducir en forma circular");
	        else
	            b1.setText("No reproducir en forma circular");
	    }  */
	    
	    //aqui termina el codigo para reproducir audio con mi propio reproductor
		

}
