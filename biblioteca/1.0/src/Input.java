import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input
{
    public static String stringa(String prompt)
    {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String input="";
        while(input=="")
        {
            System.out.print(prompt);
            try
            {
                input=sc.readLine();
            }
            catch(IOException e){}
            input = input.replace('\n',' ');
            input = input.strip();
        }
        return input;
    }
    public static String data(String prompt)
    {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String d="";
        String gg="";
        String mm="";
        String aa="";
        System.out.println(prompt);
        while(!controllaNumero(aa, 4,null))
        {
            System.out.print("Inserire l'anno(aaaa): ");
            try
            {
                aa=sc.readLine();
            }
            catch(IOException e){}
            aa = aa.strip();
        }
        while(!controllaNumero(mm, 2,"12"))
        {
            System.out.print("Inserire il mese(mm): ");
            try
            {
                mm= sc.readLine();
            }
            catch(IOException e){}
            mm = mm.strip();
        }
        
        String max;
        int temp = Integer.parseInt(mm);
        if((temp==1)||(temp==3)||(temp==5)||(temp==7)||(temp==8)||(temp==10)||(temp==12))
        {
            max="31";
        }
        else if((temp==4)||(temp==6)||(temp==9)||(temp==11))
        {
            max = "30";
        }
        else
        {
            if(Integer.parseInt(aa)%4==0)
            {
                max="29";
            }
            else
            {
                max="28";
            }
        }
        while (!controllaNumero(gg,2,max))
        {
            System.out.print("Inserire il giorno(gg): ");
            try
            {
                gg= sc.readLine();
            }
            catch(IOException e){}
            gg = gg.strip();
        }
        d+=gg+"/"+mm+"/"+aa;;
        return d;
    }

    private static boolean controllaNumero(String contr, int prev,String max)
    {
        int conv=0;
        if(contr.length()!=prev)
        {
            return false;
        }
        try
        {
            conv = Integer.parseInt(contr);
            if(conv==0)
            {
                return false;
            }
            if(max != null) 
            {
                if(conv>Integer.parseInt(max))
                {
                    return false;
                }    
            }
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        return true;
    } 

    public static boolean bool(String prompt)
    {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int scelta = -1;
        while ((scelta!=0)&&(scelta!=1)) 
        {
            try
            {
                System.out.print(prompt);
                try
                {
                    scelta = Integer.parseInt(sc.readLine());
                }
                catch(IOException e){}
            }    
            catch(NumberFormatException e)
            {
                scelta = -1;
            }
        }
        if(scelta==0)
        {
            return false;
        }
        return true;
    }
}