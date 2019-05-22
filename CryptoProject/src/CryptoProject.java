import java.util.Scanner;
import java.util.*;
public class CryptoProject
{
public static void main(String[] args)
{
    int b,c;
    Scanner input=new Scanner(System.in);
    System.out.println("Enter the String you want to encrypt:");
    String a=input.nextLine();
    System.out.println("Enter the shift value:");
    b=input.nextInt();
    System.out.println("Enter the code group size:");
    c=input.nextInt();
    String s=encryptString(a,b,c);
    System.out.println("Your string is encrypted");
    System.out.println("Encrypted string is: "+s);


}
public static String normalizeText(String m)
{

    return m.replaceAll(" ","").replaceAll("([^A-za-z])","").toUpperCase();
}
public static String obify(String p)
{

    return p.replaceAll("([AEIOUY])","OB$1");
    //there is an $1 sign in replacement because it helps us to
    //print OB along with the character .
}
public static String ceasarify(String n,int shift)
{
    //here n is a normalized string
    int m;
   char j;
    String result="";
    for(int i=0;i<n.length();i++)
    {
        m=n.charAt(i)+shift;
        if(m>'Z')
        {
            m=m-26;

        }
        else if(m<'A')
        {
            m+=26;
        }

            j=(char)m;
            result+=j;

    }

   return result;
}
public static String groupify(String d,int PerGroupElements)
{   String result="";
result+=d.charAt(0);

    if(d.length()%PerGroupElements==0)
    {
        for (int i = 1; i < d.length(); i++)
        {
           if(i%PerGroupElements==0)
           {

               result+=" "+d.charAt(i);
           }
           else
           {
               result+=d.charAt(i);
           }
        }
    }else
    {
        for (int i = 1; i < d.length(); i++)
        {
            if(i%PerGroupElements==0)
            {
                result+=" "+d.charAt(i);
                if(i==d.length()-1)
                {
                    result+="x";
                }


            }
            else
            {
                result+=d.charAt(i);
            }
        }

    }
return result;
}
public static String encryptString( String a,int b,int c)
{
  //Here String a is for encrypted text
  //int b is used for the integer shift value
  //int c is used for code group size or for PergroupElements
    String p=normalizeText(a);//p is a normalized string
    String q=obify(p);//q is now a obifiyed string
    String r=ceasarify(q,b);
    String s=groupify(r,c);
    return s;



}


}




