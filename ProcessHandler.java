package interazione;

import java.io.Serializable;


import java.util.ArrayList;

import dominio.Categoria;
import dominio.Ricerca;
import dominio.RicercaPerAnnoPubblicazione;
import dominio.RicercaPerAttore;
import dominio.RicercaPerAutore;
import dominio.RicercaPerCasaEditrice;
import dominio.RicercaPerGenere;
import dominio.RicercaPerRegista;
import dominio.RicercaPerTitolo;
import dominio.Risorsa;
import dominio.SottoCategoria;
import logica.Archivio;
import logica.ArchivioPrestiti;

import logica.Utente;
import utility.Costanti;
import utility.InputDati;

public abstract class ProcessHandler implements Serializable
{  
	//private static final long serialVersionUID = 1L;
	
	//Gli attributi arc e ap sono stati resi private nel rispetto di OCP.
	//Nelle sottoclassi ProcessFruitoreHandler e ProcessOperatoreHandler vengono
	//utilizzati i getter per accedere a questi attributi.
	private Archivio arc;
    private ArchivioPrestiti ap;
    
   /*
    public ProcessHandler(Archivio arc, ArchivioPrestiti ap)
    {  
    	this.arc = arc;
    	this.ap = ap;
    }
    */
    
    public Archivio getArchivio()
    {
    	return arc;
    }
    
    public ArchivioPrestiti getArchivioPrestiti()
    {
    	return ap;
    }

    /*
    public abstract Utente accesso();
    
    public ArrayList <Risorsa> ricercaRisorsa(Utente ut)
    {
       	Categoria c = null;
       	
   	 	System.out.printf(Costanti.CONTENUTO_ARC, arc.stampaElencoCategorie());
   	 	
   	    int num1 = InputDati.leggiIntero(Costanti.INS_NUMERO_CAT_RICERCA, Costanti.NUM_MINIMO, (arc.getElencoCategorie()).size());
   	    c = (arc.getElencoCategorie()).get(num1-Costanti.NUM_MINIMO);
   	 		
   	 	if(c.getNome().equalsIgnoreCase("Libri"))
				return ricercaRisorsaLibri(ut, c);
   	 	else if(c.getNome().equalsIgnoreCase("Film"))
				return ricercaRisorsaFilm(ut, c);
   	 	else
   	 		return null;
    }
    */
    
    //Metodo modificato in seguito alle modifiche fatte sul metodo ricercaRisorsa in Categoria
    //e all'introduzione dell'interface Ricerca e delle classi che la implementano.
    public ArrayList <Risorsa> ricercaRisorsaLibri(Utente ut, Categoria c)
    {
   	    int numScelta = InputDati.leggiIntero(Costanti.AVVIO_RICERCA_LIBRI, Costanti.NUM_MINIMO, Costanti.NUM_MASSIMO_RICERCA);
   	    String s = "";
   	    Ricerca r = null;
   	
   	    switch(numScelta)
   	    {
	    	   case 1: s = InputDati.leggiStringa(Costanti.INS_PAROLA_TITOLO_RISORSA);
	    	           r = new RicercaPerTitolo(s);
	    			   break;
	    		
	    	   case 2: s = InputDati.leggiStringa(Costanti.INS_COGNOME_AUTORE_LIBRO); 
	    	           r = new RicercaPerAutore(s);
	    		       break;
	       
	    	   case 3: s = InputDati.leggiStringa(Costanti.INS_GENERE_RISORSA);
	    	           r = new RicercaPerGenere(s);
	    		       break;
	    	   
	    	   case 4: s = Integer.toString(InputDati.leggiIntero(Costanti.INS_ANNOPUB_RISORSA));
	    	           r = new RicercaPerAnnoPubblicazione(s);
	    	   		   break;
	    		
	    	   case 5: s = InputDati.leggiStringa(Costanti.INS_CASAED_LIBRO);
	    	           r = new RicercaPerCasaEditrice(s);
	    	   		   break;
   	    }  
	    
   	    return ut.ricercaRisorsa(c,r);
    }
   
    //Metodo modificato in seguito alle modifiche fatte su ricercaRisorsa in Categoria
    //e all'introduzione dell'interface Ricerca e delle classi che la implementano.
    public ArrayList <Risorsa> ricercaRisorsaFilm(Utente ut, Categoria c)
    {
   	    int numScelta = InputDati.leggiIntero(Costanti.AVVIO_RICERCA_FILM, Costanti.NUM_MINIMO, Costanti.NUM_MASSIMO_RICERCA);
   	    String s = "";
   	    Ricerca r = null;
   	
   	    switch(numScelta)
   	    {
   	     	case 1: s = InputDati.leggiStringa(Costanti.INS_PAROLA_TITOLO_RISORSA);
   	    			r = new RicercaPerTitolo(s);
	    			break;
	    		
   	      	case 2: s = InputDati.leggiStringa(Costanti.INS_COGNOME_REGISTA_FILM); 
   	                r = new RicercaPerRegista(s);
	    		    break;
	       
   	        case 3: s = InputDati.leggiStringa(Costanti.INS_COGNOME_ATTORE_FILM);
   	                r = new RicercaPerAttore(s);
	                break;
	    	   
   	      	case 4: s = Integer.toString(InputDati.leggiIntero(Costanti.INS_ANNOPUB_RISORSA));
   	                r = new RicercaPerAnnoPubblicazione(s);
	                break;
	    		
   	       	case 5: s = InputDati.leggiStringa(Costanti.INS_GENERE_RISORSA);
   	                r = new RicercaPerGenere(s);
   	    			break;
   	    }  
	    
   	    return ut.ricercaRisorsa(c, r);
    }
    
   /*
   public String valutazioneDisponibilita(Utente ut)
   {
     	ArrayList <Risorsa> risorseTrovate = ricercaRisorsa(ut);
	    String s = "";
     	System.out.println(stampaRisorseDaRicerca(risorseTrovate));
   	    
     	if(risorseTrovate.size() != Costanti.VUOTO)
     	{
     	   int num = InputDati.leggiIntero(Costanti.RICHIESTA_DIGITAZIONE_VALUTAZIONE, Costanti.NUM_MINIMO, risorseTrovate.size());
     	   Risorsa r = risorseTrovate.get(num-Costanti.NUM_MINIMO);
      	
  	       if(ut.valutazioneDisponibilita(ap, r))
     	        s += Costanti.RISORSA_DISPONIBILE;
     	   else
   		    s += Costanti.RISORSA_NON_DISPONIBILE;
     	}
     	else 
     	      s += Costanti.NO_VALUTAZIONE;
     	
     	return s;
   }
   
   public boolean richiestaLogout()
   {
      	if(InputDati.leggiUpperChar(Costanti.RICHIESTA_LOGOUT, "SN") == 'S')
    		     return true;
      	else
    		     return false;
   }
   */
   
   /*
   public String stampaRisorseDaRicerca(ArrayList <Risorsa> elencoRisorse)
   {
  	    StringBuffer ris = new StringBuffer();
  	    ris.append(Costanti.INTESTAZIONE_RICERCA_RISORSE);
  	    
  	    if(elencoRisorse.size() == Costanti.VUOTO)
  	    	    ris.append(Costanti.RICERCA_VUOTA);
  	    
		for(int i = 0; i < elencoRisorse.size(); i++)
		{
			Risorsa r = elencoRisorse.get(i);
			ris.append("\t\t" + (i+1) + ")" + r.toString());
		}
		
		return ris.toString();
   }
   */
   
   //Metodo spostato da Categoria in quanto serve a livello di ProcessHanler, nel
   //rispetto di SRP
   public String stampaElencoRisorse(Categoria c)
   {
      StringBuffer ris = new StringBuffer();
 	   
 	   for(int i = 0; i < c.getElencoRisorse().size(); i++)
 	   {
 		   Risorsa r = c.getElencoRisorse().get(i);
 		   ris.append(i+1 + ")"+ r.getTitolo() + "\n");
 	   }
 	   
 	   return ris.toString();
   }
   
   //Metodo spostato da Categoria in quanto serve a livello di ProcessHanler, nel
   //rispetto di SRP
   public String stampaElencoSottocategorie(Categoria c)
   {
	   StringBuffer ris = new StringBuffer();
	   
	   for(int i = 0; i < c.getElencoSottoCategorie().size(); i++)
	   {
		   SottoCategoria sc = c.getElencoSottoCategorie().get(i);
		   ris.append(i+1 + ")" + sc.getNome() + "\n");
	   }
	   
	   return ris.toString();
   }
    
}
