package org.generation.italy;


public class MobilApp {

	private String nome, sistemaOperativo;
	private float prezzo, ricavoTotale;
	private int totaleValutazioni, numeroValutazioni;
    
	
    // costruttore
	public MobilApp(String nome, String sistemaOperativo, float prezzo) {

		this.nome = nome;
		this.sistemaOperativo = sistemaOperativo;
		this.prezzo = prezzo;
		
		totaleValutazioni=0;
		numeroValutazioni=0;
		ricavoTotale=0f;
	}


	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		if(!nome.isEmpty())
			this.nome = nome;
	}

	public String getSistemaOperativo() 
	{
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) 
	{
		if(!nome.isEmpty())
			this.sistemaOperativo = sistemaOperativo;
	}

	public float getPrezzo() 
	{
		return prezzo;
	}

	public boolean setPrezzo(float prezzo) 
	{
		boolean esito = false;
		if (prezzo>0)
		{
			this.prezzo = prezzo;
			esito=true;
		}
		return esito;
	}

	// metodo che permette di incrementare il ricavo complessivo dopo un singolo download
	public void downloadSingolo ()
	{
		this.ricavoTotale+=prezzo;
	}
	
	// metodo che permette di incrementare il ricavo complessivo dopo un download multiplo
	public boolean downloadMultilpo (int numeroDownload)
	{
		boolean esito = false;
		if (numeroDownload>0)
		{
			this.ricavoTotale+=prezzo*numeroDownload;
			esito = true;
		}
		
		return esito;	
	}
	
	public float getRicavoTot ()
	{
		return ricavoTotale;
	}
	
	// metodo per la valutazione dell'applicazione
	public boolean eseguiValutazione (int numeroStelle)
	{
		boolean esito = false;
		if (numeroStelle>1 && numeroStelle<5)
		{
			this.totaleValutazioni+=numeroStelle;
			this.numeroValutazioni+=1;
			esito=true;
		}
		return esito;
	}
    
	// restituisce la valutazione media ricevuta finora
	public float valutazioneMedia ()
	{
		float valutazioneMedia = (float) totaleValutazioni/numeroValutazioni;
		return valutazioneMedia;
	}
}
