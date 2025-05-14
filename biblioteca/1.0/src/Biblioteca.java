import java.util.Vector;
/**
 * Classe che contiene i metodi per la gestione di una biblioteca
 * @author <a href="20405@studenti.marconiverona.edu.it">Pispisa Noah</a>
 * @since 1.0
 * @version 1.0
 */
public class Biblioteca
{
    private Vector<Cliente> clienti;
    private Vector<Libro> libri;
    private Vector<Libro> noleggiati;
    private int contp,contl;
    /**
     * costruttore
     */
    Biblioteca()
    {
        clienti = new Vector<>();
        libri = new Vector<>();
        noleggiati = new Vector<>();
        contp = 0;
        contl = 0;
    }
    /** 
     * Metodo per l'aggiunta di un cliente, chiede i dati all'utente nel momento della chiamata
    */
    public void aggiungiCliente()
    {
        String nome="";
        String cognome="";
        String data="";
        String citta="";
        String codice;
        nome = Input.stringa("Inserisci il nome del cliente: ");
        char[] temp = {nome.charAt(0)};
        String temp1 = new String(temp);
        nome = nome.replaceFirst(temp1,temp1.toUpperCase());
        cognome = Input.stringa("Inserisci il cognome del cliente: ");
        char[] temp2 = {cognome.charAt(0)};
        String temp3 = new String(temp2);
        cognome = cognome.replaceFirst(temp3,temp3.toUpperCase());
        data = Input.data("Inserisci la data di nascita del cliente: ");
        citta = Input.stringa("Inserisci la città di residenza del cliente: ");
        char[] temp4 = {citta.charAt(0)};
        String temp5 = new String(temp4);
        citta = citta.replaceFirst(temp5,temp5.toUpperCase());
        codice = Codice.persona(nome,cognome,data,citta,contp);
        contp++;
        clienti.add(new Cliente(codice,nome,cognome,data,citta));
    }
    /**
     * Metodo per la rimozione di un cliente, chiede il codice personale del cliente all'utente
     */
    public void rimuoviCliente()
    {
        String cod=Input.stringa("Inseerisci il codice del cliente da rimuovere: ");
        cod = cod.toUpperCase();
        Cliente rm = null;
        for(int i=0;i<clienti.size();i++)
        {
            if(clienti.elementAt(i).getCodice().equals(cod))
            {
                rm = clienti.elementAt(i);
            }
        }
        if(clienti.removeElement(rm))
        {
            System.out.println("Cliente rimosso");
        }
        else
        {
            System.out.println("Cliente non presente");
        }
    }
    /**
     * stampa un elenco descrittivo di tutti i clienti, questo contiene: 
     * Codice personale univoco; 
     * nome; 
     * cognome; 
     * data di nascita;
     * città di residenza
     * del cliente 
     */
    public void stampaClienti()
    {
        String sep = "-----------------------------";
        for(int i=0;i<clienti.size();i++)
        {
            System.out.println(sep);
            clienti.elementAt(i).stampa();
            System.out.println(sep+"\n");
        }
    }
    /**
     * Metodo per l'aggiunta di un libro, i dati sono chiesti all'interno del metodo
     */
    public void aggiungiLibro()
    {
        String titolo="";
        String autore="";
        String casaEd="";
        String annoPub="";
        String codice="";
        titolo=Input.stringa("Inserisci il titolo del libro: ");
        autore=Input.stringa("Inserisci l'autore del libro: ");
        char[] temp1 = {autore.charAt(0)};
        String temp2 = new String(temp1);
        autore = autore.replaceFirst(temp2, temp2.toUpperCase());
        casaEd=Input.stringa("Inserisci la casa editrice del libro: ");
        annoPub=Input.data("Inserisci l'anno di pubblicazione del libro: ");
        codice=Codice.libro(titolo, autore, casaEd, annoPub, contl);
        contl++;
        libri.add(new Libro(codice,titolo,autore,casaEd,annoPub));
    }
    /**
     * Metodo per noleggiare un libro, viene chiesto il codice univoco del libro da noleggiare, il codice univoco del Cliente che lo noleggia e la data di noleggio
     */
    public void noleggia()
    {
        String cod=Input.stringa("Inserisci il codice del libro da noleggiare: ");
        cod = cod.toUpperCase();
        Libro nl = null;
        for(int i=0;i<libri.size();i++)
        {
            if(libri.elementAt(i).getCodice().equals(cod))
            {
                nl = libri.elementAt(i);
            }
        }
        if(nl == null)
        {
            System.out.println("Libro non presente");
            return;
        }
        String noleggiatore = Input.stringa("Inserisci il codice personale del noleggiatore: ");
        noleggiatore = noleggiatore.toUpperCase();
        Cliente cl = null;
        for(int i=0;i<clienti.size();i++)
        {
            if(clienti.elementAt(i).getCodice().equals(cod))
            {
                cl = clienti.elementAt(i);
            }
        }
        if(cl == null)
        {
            System.out.println("Cliente non trovato");
            return;
        }
        String data = Input.data("Inserire la data di noleggio: ");
        nl.noleggia(noleggiatore, data);
        noleggiati.add(nl);
    }

    public void ritorna()
    {
        String cod=Input.stringa("Inserisci il codice del libro da ritornare: ");
        cod = cod.toUpperCase();
        Libro nl = null;
        for(int i=0;i<libri.size();i++)
        {
            if(libri.elementAt(i).getCodice().equals(cod))
            {
                nl = libri.elementAt(i);
            }
        }
        nl.ritorna();
        if(noleggiati.remove(nl))
        {
            System.out.println("Libro ritornato");
        }
        else
        {
            System.out.println("Libro non presente");
        }
    }

    public void rimuoviLibro()
    {
        String cod=Input.stringa("Inseerisci il codice del libro da rimuovere: ");
        cod = cod.toUpperCase();
        Libro rm = null;
        for(int i=0;i<libri.size();i++)
        {
            if(libri.elementAt(i).getCodice().equals(cod))
            {
                rm = libri.elementAt(i);
            }
        }
        if(libri.removeElement(rm))
        {
            System.out.println("libro rimosso");
        }
        else
        {
            System.out.println("libro non presente");
        }
    }

    public void stampaLibri()
    {
        String sep = "-----------------------------";
        for(int i=0;i<libri.size();i++)
        {
            System.out.println(sep);
            libri.elementAt(i).stampa();
            System.out.println(sep+"\n");
        }
    }

    public void stampaNoleggiati()
    {
        String sep = "-----------------------------";
        for(int i=0;i<noleggiati.size();i++)
        {
            System.out.println(sep);
            noleggiati.elementAt(i).stampa();
            System.out.println(sep+"\n");
        }
    }
}