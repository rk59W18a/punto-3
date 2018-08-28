package dominio.parte2.punto3;

import java.util.ArrayList;

public class RicercaPerAutore implements Ricerca
{
    private String s;
	
	public RicercaPerAutore(String s)
	{
		this.s = s;
	}
	
	public ArrayList <Risorsa> ricercaRisorsa(ArrayList <Risorsa> elencoris) 
	{
		 ArrayList <Risorsa> risorseCercate = new ArrayList <>();
	   	    
	   	 for(int i = 0; i < elencoris.size(); i++)
	   	 {
	   	     Risorsa ris = elencoris.get(i);
	   	    	    
	   	     if(((Libro)ris).getAutore().toLowerCase().indexOf((s).toLowerCase()) > -1)
	              risorseCercate.add(ris);
	   	 }
	   	    	                    
	   	 return risorseCercate;
	}

}
