/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pb;

/**
 *
 * @author luis
 */
import java.*;
import static java.lang.Math.*;
import java.util.*;
import java.util.regex.*;
public class BooT
  {

    public BooT()
      {
      }
    
    public String pesoBo(String entra)
      {
         ManipulaArchivos <String> arch = new ManipulaArchivos<String>();
         String s= arch.carga("estres.dat");
         StringTokenizer toke= new StringTokenizer(s,"[\n]");
         String rege="";
         while(toke.hasMoreElements())
           {
               Pattern p = Pattern.compile(toke.nextToken());
               Matcher m = p.matcher(entra);
               if (m.find())
                 {
                   rege += "1";
                 } else
                 {
                   rege += "0";
                 }
           }
         
          return rege;
      }
    public int frecuencia(String texto, String palabra)
      {
        int cuenta=0;
        Pattern p= Pattern.compile(palabra);
        Matcher m= p.matcher(texto);
        while(m.find())
          {
            cuenta++;
          }
        return cuenta;
      }
    public double frecunciaIDF(int n, int f)
      {
        double idf, nD,fD;
        nD=n;
        fD=f;
        idf=Math.log((nD/fD));
        return idf;
      }
    public double pesado(int f,double l)
      {
        double p;
        p=f*l;
        return p;
      }
  }
