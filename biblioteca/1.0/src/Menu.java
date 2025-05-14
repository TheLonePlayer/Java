import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu
{
    private static String menu[] = {"Esci","Aggiungi un cliente","Rimuovi un cliente","Aggiungi un libro","Rimuovi un libro","Noleggia un libro","Ritorna un libro","Stampa clienti","Stampa Libri","Stampa noleggiati"};
    private static void stampaMenu()
    {
        System.out.println("--------------------");
        for(int i=0;i<menu.length;i++)
        {
            System.out.println(i+") "+menu[i]);
        }
        System.out.println("--------------------");
    }

    public static int scegli()
    {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        stampaMenu();
        int scelta = -1;
        while((scelta<0)||(scelta>menu.length))
        {
            try
            {
                System.out.print("Inserisci il numero corrispondente alla funzione da eseguire: ");
                try
                {
                    scelta = Integer.parseInt(sc.readLine());
                }
                catch(IOException e){}
            }
            catch(NumberFormatException e)
            {
                scelta=-1;
            }
        }
        return scelta;
    }

}