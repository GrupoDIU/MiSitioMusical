package com.example.misitiomusical;


import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Lista_entrada_canciones implements Serializable{
	private String textoEncima; 
	private String textoDebajo; 
	private static String TAG = "** clase  Lista_entrada_CANCIONES **";

	public Lista_entrada_canciones ( String textoEncima, String textoDebajo) { 
	    this.textoEncima = textoEncima; 
	    this.textoDebajo = textoDebajo; 
	}
	/*
	public Lista_entrada_canciones(Parcel source){
        Log.v(TAG, "ParcelData(Parcel source): time to put back parcel data");
        textoEncima=source.readString();
        textoDebajo=source.readString();
	}
	
	public class MyCreator implements Parcelable.Creator<Lista_entrada_canciones> {
	      public Lista_entrada_canciones createFromParcel(Parcel source) {
	            return new Lista_entrada_canciones(source);
	      }
	      public Lista_entrada_canciones[] newArray(int size) {
	            return new Lista_entrada_canciones[size];
	      }
	}*/
	public String get_textoEncima() { 
	    return textoEncima; 
	}
	
	public String get_textoDebajo() { 
	    return textoDebajo; 
	}
/*
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
	*/
}
