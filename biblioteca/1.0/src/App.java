/**
 * La classe permette di utilizzare i metodi realizzati per la gestione di una biblioteca di base
 * @author <a href="20405@studenti.marconivevrona.edu.it">Pispisa Noah</a>
 * @since 1.0
 * @version 1.0
 * 
 */
public class App
{
    /**
     * @param args parametri del programma
     */
    public static void main(String[] args)
    {
        Biblioteca bib = new Biblioteca();
        boolean rip = true;
        while(rip)
        {   
            int scelta = Menu.scegli();
            switch(scelta)
            {
                case 0:
                rip= false;
                break; 
                case 1:
                bib.aggiungiCliente();
                break;
                case 2:
                bib.rimuoviCliente();
                break;            
                case 3:
                bib.aggiungiLibro();
                break;            
                case 4:
                bib.rimuoviLibro();
                break;            
                case 5:
                bib.noleggia();
                break;            
                case 6:
                bib.ritorna();
                break;            
                case 7:
                bib.stampaClienti();
                break;            
                case 8:
                bib.stampaLibri();
                break;            
                case 9:
                bib.stampaNoleggiati();
                break;
            }
            if(rip)
            {
                rip=Input.bool("Vuoi fare qualcos'altro(1=si,0=no)?");
            }
            try
            {
                Thread.sleep(500);
                System.out.print("\033c");
            }
            catch(InterruptedException e){}
        }
    }
}