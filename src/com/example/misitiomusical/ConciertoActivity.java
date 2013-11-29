package com.example.misitiomusical;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;

public class ConciertoActivity extends Activity implements OnClickListener{
	// Custom settings
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 30;
    private GestureDetector mGestureDetector;
    private View.OnTouchListener mGestureListener;
    private ImageView mImageView;
    private Integer[] mImagesList = { R.drawable.image1, R.drawable.image2,
            R.drawable.image3};
    private int mPhoto;
    private RelativeLayout mView;
    TextView informacionFoto;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.concierto);
		// Show the Up button in the action bar.
		setupActionBar();
		Bundle bundle=getIntent().getExtras();
		String fecha=bundle.getString(GestionarConciertos.txtFecha);
		String lugar=bundle.getString(GestionarConciertos.txtLugar);
		String concierto=bundle.getString(GestionarConciertos.txtConcierto);
		informacionFoto=(TextView)findViewById(R.id.textViewInformacionFoto);
		TextView nombreConcierto=(TextView)findViewById(R.id.textViewNombreConcierto);
		EditText fechaConcierto=(EditText)findViewById(R.id.editTextFechaConcierto);
		EditText lugarConcierto=(EditText)findViewById(R.id.editTextLugarConcierto);
		nombreConcierto.setText(concierto);
		fechaConcierto.setKeyListener(null);
		fechaConcierto.setText(fecha);
		fechaConcierto.setBackgroundColor(Color.GRAY);
		lugarConcierto.setKeyListener(null);
		lugarConcierto.setText(lugar);
		lugarConcierto.setBackgroundColor(Color.GRAY);
		mPhoto=0;
		int nroFoto=mPhoto+1;
		//Por defecto seteamos este valor
		informacionFoto.setText("Foto "+nroFoto+" de "+mImagesList.length);
		
		mView=(RelativeLayout)findViewById(R.id.relativeLayoutConcierto);
		mImageView=(ImageView)findViewById(R.id.imageViewConcierto);
		
		//Initialize with the first image
		mImageView.setImageResource(mImagesList[mPhoto]);
		
		//Gesture detection
		mGestureDetector=new GestureDetector(new MyGestureDetector());
		mGestureListener=new View.OnTouchListener() {
	

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return mGestureDetector.onTouchEvent(event);
			}
		};
		//Prevent the view to be touched
		mView.setOnClickListener(this);
		mView.setOnTouchListener(mGestureListener);
	}

	public class MyGestureDetector extends SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                float velocityY) {
            try {
                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                    return false;
                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    mPhoto = (mPhoto + 1) % mImagesList.length;
                    mImageView.setImageResource(mImagesList[mPhoto]);
                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    mPhoto = (mPhoto - 1) % mImagesList.length;
                    if (mPhoto < 0) {
                        mPhoto = 0;
                    }
                    mImageView.setImageResource(mImagesList[mPhoto]);
                    int duration = Toast.LENGTH_SHORT;
                    int nroFoto=mPhoto+1;
        	    	Toast toast = Toast.makeText(getApplicationContext(), "Foto "+nroFoto+" de "+mImagesList.length, duration);
        	    	toast.show();
                }
            } catch (Exception e) {
                Log.e("SwypeImagesActivity", "error on gesture detector");
            }
            return false;
        }
    }
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.concierto, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	}
	public void siguienteImagen(View view){
		int size=mImagesList.length;
		Log.i("Tamanio: ",size+"");
		
			mPhoto++;
			if(mPhoto==size)
				mPhoto=0;
			mImageView.setImageResource(mImagesList[mPhoto]);
			int nroFoto=mPhoto+1;
			informacionFoto.setText("Foto "+nroFoto+" de "+mImagesList.length);
			//Toast toast = Toast.makeText(getApplicationContext(), "Foto "+nroFoto+" de "+mImagesList.length, 3);
	    	//toast.show();
		
	}
	public void anteriorImagen(View view){
		int size=mImagesList.length;
		
		
		mPhoto--;
		if(mPhoto==-1)
			mPhoto=size-1;
		mImageView.setImageResource(mImagesList[mPhoto]);
		int nroFoto=mPhoto+1;
		informacionFoto.setText("Foto "+nroFoto+" de "+mImagesList.length);
		//Toast toast = Toast.makeText(getApplicationContext(), "Foto "+nroFoto+" de "+mImagesList.length, 3);
	    //toast.show();
		
	}

}
