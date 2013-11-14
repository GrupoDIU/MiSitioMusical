package com.example.misitiomusical;


import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Lista_entrada_canciones implements Parcelable{
	private String textoEncima; 
	private String textoDebajo; 
	private static String TAG = "** clase  Lista_entrada_CANCIONES **";

	public Lista_entrada_canciones ( String textoEncima, String textoDebajo) { 
	    this.textoEncima = textoEncima; 
	    this.textoDebajo = textoDebajo; 
	}
	
	public String get_textoEncima() { 
	    return textoEncima; 
	}
	
	public String get_textoDebajo() { 
	    return textoDebajo; 
	}

	@Override
	public int describeContents() {
		
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(textoEncima);
		dest.writeString(textoDebajo);
		Log.d(TAG,"ESCRIBIENDO A Parcel");
		
	}
	
}
