package dominio.parte2.punto3;

import java.io.Serializable;
import java.util.ArrayList;

public class SottoCategoria implements Serializable, ICategoria
{
	private static final long serialVersionUID = 1L;

	private String nomeSottoC;
	private ArrayList <Risorsa> elencoRisorse = new ArrayList <Risorsa> ();
    
    public static final String DESCRIZIONE_SOTTOCATEGORIA = "Nome sottocategoria: %s\n\t";
    public static final String ELENCO_RISORSE_VUOTO = "Al momento non sono presenti risorse\n";
    public static final String INTESTAZIONE_RISORSE = "Risorse in essa contenute:\n";
   
    public SottoCategoria(String ns)
    {
    	super();
    	this.nomeSottoC= ns;
    	inizializzaElencoRisorse();
    }
    
	public void inizializzaElencoRisorse()
   {
	   elencoRisorse = new ArrayList <Risorsa> ();
   }
	   
    public String getNome()
    {
    	return nomeSottoC;
    }
	
	public ArrayList <Risorsa> getElencoRisorse()  
	{
		return elencoRisorse;
	}
	
	public Risorsa getRisorsa(String t)
	{
		for(int i = 0; i < elencoRisorse.size(); i++)
		{
			Risorsa r = elencoRisorse.get(i);
			if(r.getTitolo().equalsIgnoreCase(t))
				return r;
		}
		   
		return null;
	}
	
	public void aggiungiRisorsa(Risorsa r)  
	{
		elencoRisorse.add(r);
	}
	 
	public void rimuoviRisorsa(Risorsa r)  
	{
		elencoRisorse.remove(r);
	}
	
	public ArrayList <Risorsa> ricercaRisorsa(Ricerca ricerca)
	{
		ArrayList <Risorsa> risorseCercate = new ArrayList <>();

		risorseCercate = ricerca.ricercaRisorsa(elencoRisorse);
		   
		return risorseCercate;
	}
    
    public String toString()
    {
 	   StringBuffer ris = new StringBuffer();
 	   ris.append(String.format(DESCRIZIONE_SOTTOCATEGORIA, nomeSottoC));
 	   
 	   if(getElencoRisorse().size() == 0)
 		   ris.append(ELENCO_RISORSE_VUOTO);
 	   else
 	   {
 	      ris.append(INTESTAZIONE_RISORSE);
 	      
 		  for(int i = 0; i < getElencoRisorse().size(); i++)
 	      {
 		     Risorsa r = getElencoRisorse().get(i);
 		     ris.append("\t\t" + (i+1) + ")"+ r.toString());
 	      }  
 	   }
 	   
 	   return ris.toString();
    }  
}