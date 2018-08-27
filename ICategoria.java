package dominio.parte2.punto3;

import java.util.ArrayList;

public interface ICategoria {
	
    public void inizializzaElencoRisorse();

	public String getNome();

	public ArrayList <Risorsa> getElencoRisorse();  
	
    public Risorsa getRisorsa(String t);
	
    public void aggiungiRisorsa(Risorsa r);
    
    public void rimuoviRisorsa(Risorsa r);
    
	public ArrayList <Risorsa> ricercaRisorsa(Ricerca r);  

    public String toString();

}
