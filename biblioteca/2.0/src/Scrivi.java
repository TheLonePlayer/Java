import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Enumeration;
public class Scrivi
{
    Scrivi(String nomefile, Hashtable<String,Cliente> cont, Hashtable<String,Libro> cont1)
    {       
        try
        {
            FileWriter wr = new FileWriter("..\\files\\"+nomefile);
            Enumeration<String> K;
            if(nomefile.equals("clienti.txt"))
            {
                K = cont.keys();
            }
            else
            {
                K = cont1.keys();
            }
            while(K.hasMoreElements())
            {
                boolean scritto = false;
                String temp = K.nextElement();
                while (!scritto) 
                {
                    try
                    {
                        wr.append(temp+",");
                        scritto=true;
                    }
                    catch(IOException e){scritto=false;}
                }
                scritto=false;
                if(nomefile.equals("clienti.txt"))
                {
                    Cliente temp2 = cont.get(temp);
                    try
                    {
                        wr.append(temp2.getNome()+","+temp2.getCognome()+","+temp2.getData()+","+temp2.getCitta()+","+temp.charAt(temp.length()-1)+"\n");
                    }
                    catch(IOException e){}
                }
                if(nomefile.equals("libri.txt"))
                {   
                    Libro temp2 = cont1.get(temp);
                    try
                    {
                        wr.append(temp2.getTitolo()+","+temp2.getAutore()+","+temp2.getCasaEd()+","+temp2.getAnnopub()+",");
                    }
                    catch(IOException e){}
                    if(temp2.getNoleggiatore() == null)
                    {
                        try
                        {
                            wr.append("n,n");
                        }
                        catch(IOException e){}
                    }
                    else
                    {
                        try
                        {
                            wr.append(temp2.getNoleggiatore()+","+temp2.getDatanoleggio()+",");
                        }
                        catch(IOException e){}
                    }
                    wr.append(temp.charAt(temp.length()-1)+"\n");
                }
            }
            wr.close();
        }
        catch(IOException e){System.out.println("Errore");}
    }    
}
