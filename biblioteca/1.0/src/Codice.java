public class Codice
{
    public static String persona(String nome, String cognome, String data, String citta, int cont)
    {
        String cod="";
        nome = nome.toUpperCase();
        cognome = cognome.toUpperCase();
        citta = citta.toUpperCase();
        for(int i=0;i<3;i++)
        {
            try
            {
                if(nome.charAt(i)!=' ')
                {
                    cod+=nome.charAt(i);
                }
                else
                {
                    cod+="X";
                }
            }
            catch(IndexOutOfBoundsException e)
            {
                cod+="X";
            }
        }
        for(int i=0;i<3;i++)
        {
            try
            {
                if(cognome.charAt(i)!=' ')
                {
                    cod+=cognome.charAt(i);
                }
                else
                {
                    cod+="X";
                }
            }
            catch(IndexOutOfBoundsException e)
            {
                cod+="X";
            }
        }
        for(int i=0;i<3;i++)
        {
            try
            {
                if(citta.charAt(i)!=' ')
                {
                    cod+=citta.charAt(i);
                }
                else
                {
                    cod+="X";
                }
            }
            catch(IndexOutOfBoundsException e)
            {
                cod+="X";
            }
        }
        cod+=data.replace("/","")+cont;
        return cod;
    }

    public static String libro(String titolo, String autore, String casaEd, String dataPub,int cont)
    {
        String cod="";
        titolo=titolo.toUpperCase();
        autore=autore.toUpperCase();
        casaEd=casaEd.toUpperCase();
        for(int i=0;i<3;i++)
        {
            try
            {
                if(titolo.charAt(i)!=' ')
                {
                    cod+=titolo.charAt(i);
                }
                else
                {
                    cod+="X";
                }
            }
            catch(IndexOutOfBoundsException e)
            {
                cod+="X";
            }
        }
        for(int i=0;i<3;i++)
        {
            try
            {
                if(autore.charAt(i)!=' ')
                {
                    cod+=autore.charAt(i);
                }
                else
                {
                    cod+="X";
                }
            }
            catch(IndexOutOfBoundsException e)
            {
                cod+="X";
            }
        }
        for(int i=0;i<3;i++)
        {
            try
            {
                if(casaEd.charAt(i)!=' ')
                {
                    cod+=casaEd.charAt(i);
                }
                else
                {
                    cod+="X";
                }
            }
            catch(IndexOutOfBoundsException e)
            {
                cod+="X";
            }
        }
        cod+=dataPub.replace("/","")+cont;
        return cod;
    }
}