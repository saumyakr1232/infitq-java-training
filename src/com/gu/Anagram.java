package com.gu;

import java.io.*;
import java.util.*;
class Anagram
{
    String str,a[],result[];
    StringTokenizer st;
    StringBuffer presenttoken,bz;
    int nooftoken,i,lenpresenttoken,j,ct,len,matches,m,n;
    char ch,chara,charb;
    BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
    void getInput()throws IOException
    {
//        System.out.println("Enter a String ?? ");
        str=in.readLine();
        str=str.toLowerCase();
//System.out.println(”\nString agter conversion to lowecase is :: "+str+”\n”);
        convertToTokens();
        removePunctuation();
        calculate();
    }
    void convertToTokens()
    {
        st=new StringTokenizer(str);
        nooftoken=st.countTokens();
        a=new String[nooftoken];
        result=new String[nooftoken];
        for(i=0; i<nooftoken; i++)
        {
            a[i]=st.nextToken().toString();
        }
//System.out.println("\nIntial array :: ");
        display();
    }
    void removePunctuation()
    {
        for(i=0; i<nooftoken; i++)
        {
            presenttoken=new StringBuffer(a[i]);
            lenpresenttoken=presenttoken.length();
            ch=presenttoken.charAt(lenpresenttoken-1);
            if( (ch=='.') || (ch=='?') || (ch=='!') )
            {
                presenttoken=presenttoken.deleteCharAt(lenpresenttoken-1);
                a[i]=presenttoken.toString();
            }
        }
//System.out.println("\nArray after removing punctuation :: \n");
        display();
    }
    void calculate()
    {
        norepeats();
        findAnagram();
    }
    void norepeats()
    {
        for(i=0; i<(nooftoken-1); i++)
        {
            for(j=i+1; j<nooftoken; j++)
            {
                if(a[i].equals(a[j]))
                    a[j]="";
            }
        }
//System.out.println("\nString after no repeats :: \n");
        display();
    }
    void display()
    {
        for(i=0; i<nooftoken; i++)
        {
//            System.out.print(a[i]+" ");
        }
    }
    void findAnagram()
    {
        for(i=0; i<(nooftoken-1); i++)
        {
            if(a[i].length()==0)
                continue;
            else
            {
                result[0]=a[i];
                ct=1;
                for(j=i+1; j<nooftoken; j++)
                {
                    if(a[j].length()==0)
                        continue;
                    else
                    {
                        if(compareLengths(a[i],a[j]))
                        {
                            if(areAnagram(a[i],a[j]))
                            {
                                addtoResult(a[j],ct);
                                a[j]="";
                                ct++;
                            }
                            else
                            {
                                continue;
                            }
                        }
                        else
                        {
                            continue;
                        }
                    }
                }
                if(ct!=1)
                {
//System.out.println("Result :: ");
                    displayResult();
                    System.out.println();
                }
            }
        }
    }
    boolean compareLengths(String a, String b)
    {
        if(a.length()==b.length())
            return true;
        else
            return false;
    }
    boolean areAnagram(String a,String b)
    {
        bz=convertToStringBuffer(b);
        len=a.length();
        matches=0;
        for(m=0; m<len; m++)
        {
            chara=a.charAt(m);
            for(n=0; n<len; n++)
            {
                charb=bz.charAt(n);
                if(chara==charb)
                {
                    matches=matches+1;
                    bz.deleteCharAt(n);
                    bz.insert(n,' ');
                    break;
                }
                else
                {
                    continue;
                }
            }
        }
        if(matches==len)
            return true;
        else
            return false;
    }
    StringBuffer convertToStringBuffer(String str)
    {
        return(new StringBuffer(str));
    }
    void addtoResult(String a,int b)
    {
        result[b]=a;
    }
    void displayResult()
    {
        for(int u=0; u<ct; u++)
        {
            System.out.print(result[u]+" ");
        }
    }
}
class NewAnagram
{
    public static void main(String args[])throws IOException
    {
        Anagram ob=new Anagram();
        ob.getInput();
    }
}