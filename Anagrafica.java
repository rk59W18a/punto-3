package logica.parte2.punto3;

import java.io.Serializable;

import java.util.*;

public class Anagrafica implements Serializable
{
    //private static final long serialVersionUID = 1L;
	
	//L'attributo elenco è stato reso private nel rispetto di OCP.
	//Nella sottoclasse AnagraficaFruitore viene utilizzato il getter per accedere 
	//a questo attributo.
	private ArrayList <Utente> elenco;
    
	/*
    public Anagrafica()
    {
    	   elenco = new ArrayList <Utente> ();
    }
    
    public ArrayList <Utente> getElenco()
    {
    	   return elenco;
    }
    
    public Utente getUtente(String u, String p)
    {
      	for(int i = 0; i < elenco.size(); i++)
	    {
	    	  Utente ut = elenco.get(i);
	    	  
	    	  if((ut.getUsername()).equals(u) && (ut.getPassword().equals(p)))
	    			   return ut;
	    }
	    
	    return null;
    }
    
    public boolean accedi(String u, String p)
    {
    	    for(int i = 0; i < elenco.size(); i++)
    	    {
    	    	  Utente ut = elenco.get(i);
    	    	  
    	    	  if((ut.getUsername()).equals(u) && (ut.getPassword().equals(p)))
    	    			   return true;
    	    }
    	    
    	    return false;
    }
    */ 
}