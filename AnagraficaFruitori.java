package logica;

import java.io.Serializable;
import java.time.LocalDate;


public class AnagraficaFruitori extends Anagrafica implements Serializable
{
    private static final long serialVersionUID = 1L;
	
	public static final String INTESTAZIONE_ELENCO = "Elenco degli attuali fruitori: \n";
    public static final String ANAGRAFICA_VUOTA = "Al momento non sono presenti fruitori.\n";
	
    /**
     * @post : elenco != null
     */    
    public AnagraficaFruitori()
    {
   	    super();
    }
    
    /**
     * @pre: elenco != null
     */
    public Fruitore getFruitore(String usef)
    {
      	for(int i = 0; i < getElenco().size(); i++)
	    {
	    	  Fruitore f = (Fruitore) getElenco().get(i);
	    	  
	    	  if(f.getUsername().equals(usef))
	    			   return f;
	    }
	    
	    return null;
    }
    
    /**
     * @pre: (f != null) && !(elenco.contains(f))
     * @post : elenco.contains(f)
     */
    public void aggiungiFruitore(Fruitore f)  
    {
   	    getElenco().add(f);
    }
    
    /**
     * @pre : (elenco != null) && (dn != null)
     */
    public boolean verificaPresenza(String n, String c, LocalDate dn)
    {
    	   for(int i = 0; i < getElenco().size(); i++)
    	   {
    		   Fruitore f = (Fruitore) getElenco().get(i);
    		   
    		   if((f.getNome()).equalsIgnoreCase(n) && (f.getCognome().equalsIgnoreCase(c)) && (f.getDataDiNascita().isEqual(dn)))
                 return true;
    	   }
    	   
    	   return false;
    }
    
    /**
     * @pre : elenco != null
     */
    public boolean verificaStessoUsername(String u) 
    {
   	    for(int i = 0; i < getElenco().size() ; i++)
   	    {
   	       Fruitore f = (Fruitore) getElenco().get(i);
   	    	   
   	    	   if((f.getUsername()).equals(u))
   	    		      return true;
   	    }
   	    
   	    return false;
    }
   
    /**
     * @pre : (elenco != null) && (as != null)
     */
    public void decadenzaFruitore(ArchivioStorico as)
    {
   	 	for(int i = 0; i < getElenco().size() ; i++)
   	 	{
   	 		Fruitore f = (Fruitore) getElenco().get(i);	
   	 		
   	 	    if ((LocalDate.now().equals(f.getDataDiScadenza())) || (LocalDate.now().isAfter(f.getDataDiScadenza())))
   	 	    {
   	 	    	getElenco().remove(f);
   	 	      	as.getDecadenzeFruitoriStoriche().aggiungiFruitore(f);
   	 	    }
   	 	}
    }
    
    /** 
     * @pre : elenco != null
     */    
    public String toString()		
    {
   	    StringBuffer ris = new StringBuffer();
   	    
   	    if(getElenco().size() == 0)
   	    {
   	    	    ris.append(ANAGRAFICA_VUOTA);
   	    }
   	    else
   	    {
   	   	    ris.append(INTESTAZIONE_ELENCO);

   	   	    for(int i = 0; i < getElenco().size(); i++)
   	   	    {
   	   	    	    Fruitore f = (Fruitore) getElenco().get(i);
   	   	    	    ris.append(i+1 + ")" + f.toString() + "\n");
   	   	    }
   	    }

   	    return ris.toString();
    }
    
}