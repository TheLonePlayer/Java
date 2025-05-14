public class Libro
{
    private String codice;
    private String titolo;
    private String autore;
    private String casaEd;
    private String annopub;
    private String noleggiatore;
    private String datanoleggio;

    Libro(String codice, String titolo, String autore, String casaEd, String annopub)
    {
        this.codice = codice;
        this.titolo = titolo;
        this.autore = autore;
        this.casaEd = casaEd;
        this.annopub = annopub;
        noleggiatore= null;
        datanoleggio = null;
    }

    public String getCodice()
    {
        return codice;
    }

    public void noleggia(String noleggiatore, String datanoleggio)
    {
        this.noleggiatore = noleggiatore;
        this.datanoleggio = datanoleggio;
    }

    public void ritorna()
    {
        this.noleggiatore=null;
        this.datanoleggio=null;
    }

    public void stampa()
    {
        System.out.println("Codice libro: "+codice);
        System.out.println("Titolo libro: "+titolo);
        System.out.println("Autore libro: "+autore);
        System.out.println("Casa editrice: "+casaEd);
        System.out.println("Anno pubblicazione: "+annopub);
        if(noleggiatore!=null)
        {
            System.out.println("Codice noleggiatore: "+noleggiatore);
            System.out.println("Data noleggio: "+datanoleggio);
        }
        else
        {
            System.out.println("Libro non noleggiato");
        }
    }
}