public class Cliente
{
    private String codice;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String citta;

    Cliente(String codice, String nome, String cognome, String dataNascita, String citta)
    {
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
        this. dataNascita = dataNascita;
        this.citta = citta;
    }

    public String getCodice()
    {
        return codice;
    }

    public void stampa()
    {
        System.out.println("Codice cliente: "+codice);
        System.out.println("Nome cliente: "+nome);
        System.out.println("Cognome cliente: "+cognome);
        System.out.println("Data di nascita: "+dataNascita);
        System.out.println("Città di residenza: "+citta);
    }
}