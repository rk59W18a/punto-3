package logica;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.ArrayList;

import dominio.*;


public class ArchivioPrestiti implements Serializable
{
	private static final long serialVersionUID = 1L;

	private ArrayList <Prestito> elencoPrestiti;
	
	public static final String INTESTAZIONE_ELENCO = "Elenco dei prestiti in corso: \n";
    
	
	/**
	 * @post: elencoPrestiti != null
	 */
	public ArchivioPrestiti()
	{
		elencoPrestiti = new ArrayList <Prestito> ();
	}
	
	public ArrayList <Prestito> getElencoPrestiti()
	{
		return elencoPrestiti;
	}
	
    /**
     * @pre: elencoPrestiti != null
     */
    public ArrayList <Prestito> getPrestiti(String usef)   
    {
    	ArrayList <Prestito> prestitiInCorso = new ArrayList <Prestito> ();
   	    
      	for(int i = 0; i < elencoPrestiti.size(); i++)
	    {
	    	    Prestito p = elencoPrestiti.get(i);
	    	  
	    	    if(((p.getFruitoreAssociato().getUsername().equals(usef))))
	    			    prestitiInCorso.add(p);
	    }
	    
		return prestitiInCorso;
    }
    
    /**
     * @pre: (r != null) && (elencoPrestiti != null)
     */
    public boolean verificaPresenza(Risorsa r, String usef)
    {
    	   for(int i = 0; i < elencoPrestiti.size(); i++)
    	   {
    		   Prestito p  = elencoPrestiti.get(i);
    		   
    		   if(p.getRisorsaInPrestito().equals(r) && (p.getFruitoreAssociato().getUsername()).equals(usef))
    		          return true;
    	   }
    	   
    	   return false;
    }
    
    /**
     * @pre: elencoPrestiti != null
     */
    public void scadenzaPrestito()
    {
      	for(int i = 0; i < elencoPrestiti.size() ; i++)
   	 	{
   	 		Prestito p = elencoPrestiti.get(i);	
   	 		
   	 	    if((LocalDate.now().equals(p.getDataDiScadenzaPrestito())) || (LocalDate.now().isAfter(p.getDataDiScadenzaPrestito())))
   	 		{
   	 			elencoPrestiti.remove(p);
   	 		}			
   	 	}  
    }
    
    /**
     * @pre: (p != null) && !(elencoPrestiti.contains(p))
     * @post: elencoRisorse.contains(p)
     */
	public void aggiungiPrestito(Prestito p)
	{
		elencoPrestiti.add(p);
	}
	
	/**
	 * @pre: (p != null) && (elencoRisorse.contains(p))
     * @post: !(elencoRisorse.contains(p))
     */
	public void rimuoviPrestito(Prestito p)
	{
		elencoPrestiti.remove(p);
	}
	
	/**
	 * Metodo che controlla che un fruitore abbia un numero di risorse in prestito relative ad una categoria
	 * inferiore al massimo numero di risorse in prestito fissato per quella categoria
	 * 
	 * @pre: (c != null) && (elencoPrestiti != null)
	 * 
	 * @param c: la categoria
	 * @param usef: lo username del fruitore
	 * @return boolean: true se il fruitore ha un numero di risorse relative ad una stessa categoria minore a quello consentito 
	 *         per la categoria stessa
	 */
	public boolean controlloPerUlteriorePrestito(Categoria c, String usef)
	{
		int num = 0;
		
      	for(int i = 0; i < elencoPrestiti.size(); i++)
	    {
	    	   Prestito p = elencoPrestiti.get(i);
	    	  
	    	   if(p.getCategoriaAssociata().equals(c) && (p.getFruitoreAssociato().getUsername()).equals(usef))
	    		  	 num++;
	    }
	    
	    if(c.getNumeroMaxRisorseInPrestito() > num)
	         return true;
	    else
	         return false;
	}
	
	/**
	 * @pre: (elencoPrestiti != null) && (r != null)
	 */
	public boolean controlloDisponibilitaRisorsa(Risorsa r)
	{
		int num = 0;
		
      	for(int i = 0; i < elencoPrestiti.size(); i++)
	    {
	    	   Prestito p = elencoPrestiti.get(i);
	    	  
	    	   if(p.getRisorsaInPrestito().equals(r))
	    		    	num++;
	    }
	    
	    if(r.getNumLicenze() > num)
	    	     return true;
	    else
	         return false;
	}
	
}