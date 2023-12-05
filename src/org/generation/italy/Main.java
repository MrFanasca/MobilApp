package org.generation.italy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*Scrivere una classe MobileApp contenente i seguenti attributi:
		    -nome: stringa
		    -sistemaOperativo: stringa
		    -prezzo: float
		    -totaleValutazioni: intero
		    -numeroValutazioni: intero
		    -ricavoTotale: float
		  e i seguenti metodi:
		    -MobileApp(String nome, String sistemaOperativo, float prezzo)
			  (costruttore della classe: inizializza gli attributi nome, sistemaOperativo, prezzo in base ai parametri 
			  passati; inizializza totaleValutazioni, numeroValutazioni, ricavoTotale a 0)
		    -download(): incrementa il ricavoTotale del valore del prezzo
		    -download(int numeroDownload): incrementa il ricavoTotale del valore del prezzo*numeroDownload
		    -riceviValutazione(int numeroStelle): l'app riceve una valutazione da 1 a 5 stelle, e si aggiornano gli attributi 
		   	  totaleValutazioni e numeroValutazioni
		    -float valutazioneMedia(): restituisce la valutazione media ricevuta finora
		  Nella classe Main:
			-chiedere all'utente di inserire nome,  sistemaOperativo,  prezzo dell'app
			-creare un oggetto della classe MobileApp passando al costruttore i parametri inseriti dall'utente
			-creare un menu con le seguenti voci:
			 *download singolo
			 *download multiplo (in questo caso chiedere all'utente il numero di download da effettuare)
			 *ricevi valutazione (in questo caso chiedere all'utente il numero di stelle da assegnare - da 1 a 5)
			 *esci
			-dopo ogni chiamata ad una voce di menu visualizzare i dati della mobile app (valutazione media, ricavo totale)*/
		
		Scanner sc = new Scanner(System.in);
		
		String nome, OS, risposta;
		int quantità;
		float prezzo;
		
		System.out.println("_*_*_*_BENVENUTO IN APPTRACK_*_*_*_");
		System.out.println("Inserisci il nome dell'app");
		nome = sc.nextLine();
		System.out.println("Inserisci il sistema operativo");
		OS = sc.nextLine();
		System.out.println("Inserisci il prezzo dell'app");
		prezzo = Float.parseFloat(sc.nextLine());
		MobilApp m = new MobilApp(nome, OS, prezzo);
		do
		{
			System.out.println("\n\n1 - Downoad singolo");
			System.out.println("2 - Downoad multiplo");
			System.out.println("3 - Ricevi valutazioni");
			System.out.println("4 - Esci");
			System.out.println("Seleziona una delle seguenti voci");
			risposta=sc.nextLine();
			switch (risposta)
			{
				case "1":// Downoad singolo          (valutazione media, ricavo totale)
					m.downloadSingolo();
					System.out.println("\n------------------------------");
					System.out.println("Valutazione media: " + m.valutazioneMedia() + "\tRicavo totale: " + m.getRicavoTot());
					System.out.println("Vuoi fare altro? (s/n)");
					risposta=sc.nextLine();
					break;
					
				case "2":// Downoad multiplo
					System.out.println("\n------------------------------");
					System.out.println("Inserisci la quantità di download");
					quantità=Integer.parseInt(sc.nextLine());
					m.downloadMultilpo(quantità);
					if (m.downloadMultilpo(quantità))
					{
						System.out.println("Valutazione media: " + m.valutazioneMedia() + "\tRicavo totale: " + m.getRicavoTot());
					}
					else
						System.out.println("Inserimento non valido");
					System.out.println("Vuoi fare altro? (s/n)");
					risposta=sc.nextLine();
					break;
					
				case "3":// Ricevi valutazioni
					System.out.println("\n------------------------------");
					System.out.println("Valuta l'app inserendo il numero di stelle");
					quantità=Integer.parseInt(sc.nextLine());
					m.eseguiValutazione(quantità);
					if (m.eseguiValutazione(quantità))
					{
						System.out.println("Valutazione media: " + m.valutazioneMedia() + "\tRicavo totale: " + m.getRicavoTot());
					}
					else
						System.out.println("Inserimento non valido");
					System.out.println("Vuoi fare altro? (s/n)");
					risposta=sc.nextLine();
					break;
					
				case "4":// Esci
					System.out.println("\n------------------------------");
					System.out.println("Premi Enter per uscire");
					risposta=sc.nextLine();
					break;
					
				default:
					System.out.println("\nInserimento non valido");
					System.out.println("Vuoi fare altro? (s/n)");
					risposta=sc.nextLine();
					break;	
			}
		}	while (risposta.equalsIgnoreCase("s"));
		
		sc.close();
	}

}
