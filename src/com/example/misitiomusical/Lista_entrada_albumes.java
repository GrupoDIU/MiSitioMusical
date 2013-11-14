package com.example.misitiomusical;


import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Lista_entrada_albumes implements Parcelable{
	private int idImagen; 
	private String textoEncima; 
	private String textoDebajo; 
	private static String TAG = "** clase  Lista_entrada_albumes **";
	public Lista_entrada_albumes (int idImagen, String textoEncima, String textoDebajo) { 
	    this.idImagen = idImagen; 
	    this.textoEncima = textoEncima; 
	    this.textoDebajo = textoDebajo; 
	}
	
	public String get_textoEncima() { 
	    return textoEncima; 
	}
	
	public String get_textoDebajo() { 
	    return textoDebajo; 
	}
	
	public int get_idImagen() {
	    return idImagen; 
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(textoEncima);
		dest.writeString(textoDebajo);
		dest.writeInt(idImagen);
		Log.d(TAG,"ESCRIBIENDO A Parcel");
	} 
}
