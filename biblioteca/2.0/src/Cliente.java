public class Cliente
{
    private String nome;
    private String cognome;
    private String dataNascita;
    private String citta;

    Cliente(String nome, String cognome, String dataNascita, String citta)
    {
        this.nome = nome;
        this.cognome = cognome;
        this. dataNascita = dataNascita;
        this.citta = citta;
    }

    public String getNome()
    {
        return nome;
    }

    public String getCognome()
    {
        return cognome;
    }

    public String getData()
    {
        return dataNascita;
    }

    public String getCitta()
    {
        return citta;
    }

    public void stampa()
    {
        System.out.println("Nome cliente: "+nome);
        System.out.println("Cognome cliente: "+cognome);
        System.out.println("Data di nascita: "+dataNascita);
        System.out.println("Città di residenza: "+citta);
    }
}