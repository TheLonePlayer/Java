import java.util.Enumeration;
import java.util.Hashtable;
/**
 * Classe che contiene i metodi per la gestione di una biblioteca
 * @author <a href="20405@studenti.marconiverona.edu.it">Pispisa Noah</a>
 * @since 1.0
 * @version 1.0
 */
public class Biblioteca
{
    private Hashtable<String,Cliente> clienti;
    private Hashtable<String,Libro> libri;
    private int contp,contl;
    /**
     * costruttore
     */
    Biblioteca()
    {
        int[] temp1 = new int[1];
        int[] temp2 = new int[1];
        clienti = new Hashtable<>();
        clienti = Leggi.clienti("clienti.txt",clienti,temp1);
        libri = new Hashtable<>();
        libri = Leggi.libri("libri.txt",libri,temp2);
        contp=temp1[0];
        contl=temp2[0];
        contp++;
        contl++;
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
        clienti.put(codice, new Cliente(nome,cognome,data,citta));
        new Scrivi("clienti.txt",clienti,null);
    }
    /**
     * Metodo per la rimozione di un cliente, chiede il codice personale del cliente all'utente
     */
    public void rimuoviCliente()
    {
        String cod=Input.stringa("Inseerisci il codice del cliente da rimuovere: ");
        cod = cod.toUpperCase();
        Cliente rm = clienti.get(cod);
        if(rm!=null)
        {
            clienti.remove(cod);
            new Scrivi("clienti.txt",clienti,null);
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
        Enumeration<String> K = clienti.keys();
        while(K.hasMoreElements())
        {
            String sep = "-----------------------------";
            System.out.println(sep);
            String temp = K.nextElement();
            System.out.println("Codice del cliente: "+temp);
            clienti.get(temp).stampa();
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
        libri.put(codice, new Libro(titolo,autore,casaEd,annoPub,null,null));
        new Scrivi("libri.txt",null,libri);
    }
    /**
     * Metodo per noleggiare un libro, viene chiesto il codice univoco del libro da noleggiare, il codice univoco del Cliente che lo noleggia e la data di noleggio
     */
    public void noleggia()
    {
        String cod=Input.stringa("Inserisci il codice del libro da noleggiare: ");
        cod = cod.toUpperCase();
        Libro nl = libri.get(cod);
        if(nl == null)
        {
            System.out.println("Libro non trovato");
            return;
        }
        if(nl.getNoleggiatore()!=null)
        {
            System.out.println("Libro gia' noleggiato");
            return;
        }
        String noleggiatore = Input.stringa("Inserisci il codice personale del noleggiatore: ");
        noleggiatore = noleggiatore.toUpperCase();
        Cliente cl = clienti.get(noleggiatore);
        if(cl == null)
        {
            System.out.println("Cliente non trovato");
            return;
        }
        String data = Input.data("Inserire la data di noleggio: ");
        nl.noleggia(noleggiatore, data);
        new Scrivi("libri.txt",null,libri);
    }

    public void ritorna()
    {
        String cod=Input.stringa("Inserisci il codice del libro da ritornare: ");
        cod = cod.toUpperCase();
        Libro nl = libri.get(cod);
        if(nl==null)
        {
            System.out.println("Libro non presente");
        }
        else
        {
            nl.ritorna();
            new Scrivi("libri.txt",null,libri);
            System.out.println("Libro ritornato");
        }
    }

    public void rimuoviLibro()
    {
        String cod=Input.stringa("Inseerisci il codice del libro da rimuovere: ");
        cod = cod.toUpperCase();
        Libro rm = libri.get(cod);
        if(rm==null)
        {
            System.out.println("libro non presente");
        }
        else
        {
            libri.remove(cod);
            new Scrivi("libri.txt",null,libri);
            System.out.println("Libro rimosso");
        }
    }

    public void stampaLibri()
    {
        Enumeration<String> K = libri.keys();
        while(K.hasMoreElements())
        {
            String sep = "-----------------------------";
            System.out.println(sep);
            String temp = K.nextElement();
            System.out.println("Codice del libro: "+temp);
            libri.get(temp).stampa();
            System.out.println(sep+"\n");
        }
    }

    public void stampaNoleggiati()
    {
        Enumeration<String> K = libri.keys();
        while(K.hasMoreElements())
        {
            String temp = K.nextElement();
            Libro t1 = libri.get(temp);
            if(t1!=null)
            {
                String sep = "-----------------------------";
                System.out.println(sep);
                System.out.println("Codice del libro: "+temp);
                t1.stampa();
                System.out.println(sep+"\n");

            }
            
        }
    }
}