package com.example.misitiomusical;

public class Lista_entrada_conciertos {
	private String numeroCanciones; 
	private String nombreConcierto;
	private int idImagen;
	private static String TAG = "** clase  Lista_entrada_CANCIONES **";

	public Lista_entrada_conciertos( String nombreConcierto, String numeroCanciones,int idImagen) { 
	    this.nombreConcierto = nombreConcierto; 
	    this.numeroCanciones = numeroCanciones; 
	    this.idImagen=idImagen;
	}
	public String getNombreConcierto() { 
	    return nombreConcierto; 
	}
	
	public String getNumeroCanciones() { 
	    return numeroCanciones; 
	}
	public int getIdImagen() {
		return idImagen;
	}

	
}
