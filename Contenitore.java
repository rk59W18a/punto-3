package dominio.parte2.punto3;

import java.util.ArrayList;

/*
 * E' stata creata la classe astratta Contenitore che raccoglie i metodi
 * comuni alle due sottoclassi Categoria e SottoCategoria, nel rispetto 
 * del principio di Liskov.
 */
public abstract class Contenitore 
{
	 private String nomeCategoria;
	 private ArrayList <Risorsa> elencoRisorse;
	 
	 public Contenitore(String n)
	 {
		 this.nomeCategoria = n;
	 }
	 
	 public void inizializzaElencoRisorse()
	 {
		   elencoRisorse = new ArrayList <Risorsa> ();
	 }
	 
	 public String getNome()
	 {
		   return nomeCategoria;
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
	   
	 public abstract ArrayList <Risorsa> ricercaRisorsa(Ricerca ricerca);
	  
	 public abstract String toString();
}
