package com.example.misitiomusical;

public class Lista_entrada_canciones {
	private String textoEncima; 
	private String textoDebajo; 
	  
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
	
}
