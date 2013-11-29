package com.example.misitiomusical;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class reproductorAudio extends Activity implements OnClickListener{
	
	
	SeekBar seek_bar;
    ImageButton play_button, pause_button;
    MediaPlayer player;
    TextView text_shown;
    private Handler seekHandler = new Handler();
    
   
	
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
		getInit();
        seekUpdation();
		
		
		
		
		
        
	}
	
	
	
	//cambios
	public void getInit() {
        seek_bar = (SeekBar) findViewById(R.id.seek_bar);
        play_button = (ImageButton) findViewById(R.id.play_button);
        pause_button = (ImageButton) findViewById(R.id.pause_button);
        text_shown = (TextView) findViewById(R.id.text_shown);
        play_button.setOnClickListener(this);
        pause_button.setOnClickListener(this);
        if(pista.equals("detras_de_un_cristal")){
        	player = MediaPlayer.create(this, R.raw.detras_de_un_cristal);
        }else if(pista.equals("entre_tus_alas")){       	
        	player = MediaPlayer.create(this, R.raw.entre_tus_alas);	        
        }else if(pista.equals("foreword")){        	
        	player = MediaPlayer.create(this, R.raw.foreword);	       
        }else if(pista.equals("te_fuiste_de_aqui")){        	
        	player = MediaPlayer.create(this, R.raw.te_fuiste_de_aqui);	       
        }
        else if(pista.equals("locoloco")){        	
        	player = MediaPlayer.create(this, R.raw.locoloco);	       
        }
        else if(pista.equals("rosa_playa")){        	
        	player = MediaPlayer.create(this, R.raw.rosa_playa);	       
        }

        
        seek_bar.setMax(player.getDuration());
 
    }
	
	Runnable run = new Runnable() {
		 
        @Override
        public void run() {
            seekUpdation();
        }
    };


    public void seekUpdation() {
    	 
        seek_bar.setProgress(player.getCurrentPosition());
       
        seekHandler.postDelayed(run, 1000);
    }
	
	

		@Override
		public void onClick(View view) {
			switch (view.getId()) {
	        case R.id.play_button:
	            text_shown.setText("Tocando");
	            player.start();
	            break;
	        case R.id.pause_button:
	            player.pause();
	            text_shown.setText("Pausado");
	        }
			
		}

	
		

}
