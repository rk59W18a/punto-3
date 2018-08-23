package logica.parte2.punto3;

import java.io.Serializable;

import dominio.parte2.punto3.*;


public class Operatore extends Utente implements Serializable
{
	private static final long serialVersionUID = 1L;

    public Operatore(String n, String c, String u, String p)
    {
   	     super(n, c, u, p);
    }
    
    /**
     * @pre : e != null
     */
    public String visualizzaElencoFruitori(AnagraficaFruitori e)
    {
   	   return e.toString();
    }
    
    /**
     * Metodo che permette l'aggiunta di una risorsa ad una (sotto)categoria dell'archivio
     * 
     * @pre: (r != null) && (s != null) && !(r in s) 
     * @post: r in s
     */
    public void aggiungiRisorsaCategoria(Risorsa r, Categoria s)
    {
    	 s.aggiungiRisorsa(r);
    }
    
    /**
     * Metodo che permette la rimozione di una risorsa da una (sotto)categoria dell'archivio
     * 
     * @pre: (r != null) && (s != null) && (r in s)
     * @post: !(r in s)
     */
    public void rimuoviRisorsaCategoria(Risorsa r, Categoria s)
    {
    	 s.rimuoviRisorsa(r);
    }
    
    /**
     * @pre: a != null
     */
    public String visualizzaArchivio(Archivio a)
    {
    	 return a.toString();
    }
    
    /**
     * @pre: as != null
     */
    public int numeroPrestitiPerAnno(ArchivioStorico as, int anno)
    {
    	 return as.numeroPrestitiPerAnno(anno);
    }
    
    /**
     * @pre: as != null
     */
    public int numeroProroghePerAnno(ArchivioStorico as, int anno)
    {
	     return as.numeroProroghePerAnno(anno);
    }
    
    /**
     * @pre: as != null
     */
    public String risorsaPiuRichiesta(ArchivioStorico as, int anno)
    {
    	 return as.risorsaPiuRichiesta(anno);
    }
    
    /**
     * @pre: (as != null) && (f != null)
     */
    public int numeroPrestitiPerFruitorePerAnno(ArchivioStorico as, Fruitore f, int anno)
    {
    	 return as.numeroPrestitiPerFruitorePerAnno(f, anno);
    }
    
}