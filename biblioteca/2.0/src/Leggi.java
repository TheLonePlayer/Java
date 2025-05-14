import java.util.Scanner;
import java.util.Vector;
import java.util.Hashtable;
import java.io.File;
import java.io.FileNotFoundException;
public class Leggi
{
    public static Hashtable<String,Cliente> clienti(String nomefile,Hashtable<String,Cliente> contenitore, int[] cont)
    {
        File file = new File("..\\files\\"+nomefile);
        Vector<Integer> v = new Vector<>();
        try
        {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine())
            {
                String temp = sc.nextLine();
                temp = temp.replace("\n", "");
                String[] divided = temp.split(",");
                v.add(Integer.parseInt(divided[5]));
                contenitore.put(divided[0], new Cliente(divided[1], divided[2], divided[3], divided[4]));
            }
            Integer[] temp1 = new Integer[v.size()];
            for(int i=0;i<v.size();i++)
            {
                temp1[i] = v.elementAt(i);
            }
            cont[0] = max(temp1);
            sc.close();
        }
        catch(FileNotFoundException e){}
        return contenitore;
    }
    public static Hashtable<String,Libro> libri(String nomefile,Hashtable<String,Libro> contenitore, int[] cont)
    {
        Vector<Integer> v = new Vector<>();
        File file = new File("..\\files\\"+nomefile);
        try
        {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine())
            {

                String temp = sc.nextLine();
                temp = temp.replace("\n", "");
                String[] divided = temp.split(",");
                v.add(Integer.parseInt(divided[7]));
                if(divided[5].equals("n"))
                {
                    contenitore.put(divided[0], new Libro(divided[1],divided[2],divided[3],divided[4],null,null));
                }
                else
                {
                    contenitore.put(divided[0], new Libro(divided[1],divided[2],divided[3],divided[4],divided[5],divided[6]));
                }
            }
            Integer[] temp1 = new Integer[v.size()];
            for(int i=0;i<v.size();i++)
            {
                temp1[i] = v.elementAt(i);
            }
            cont[0] = max(temp1);
            sc.close();
        }
        catch(FileNotFoundException e){}
        return contenitore;
    }
    private static int max(Integer[] arr)
    {
        int max = 0;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]>arr[i+1])
            max=arr[i];
            else
            max=arr[i+1];
        }
        return max;
    }
}