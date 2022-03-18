/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pb;

import java.awt.Image;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author luis
 */
public class Tools
  {

    BooT bo = new BooT();

    public Tools()
      {
      }

    public Icon setIconoA(String url, JLabel boton)
      {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        int ancho = boton.getWidth();
        int alto = boton.getHeight();
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
      }

    public String cadeBoo(String mensaje)
      {
        String[] men = mensaje.split("\n");
        String cadeBoo = "";
        for (int i = 0; i < men.length; i++)
          {
            cadeBoo += bo.pesoBo(men[i].toString()) + "|";
          }
        return cadeBoo;
      }

    public String[][] frecuencia(String mensaje)
      {
        String[] pala = bolsa();
        String[][] resu = new String[pala.length][2];
        int fre;
        for (int i = 0; i < pala.length; i++)
          {
            fre = bo.frecuencia(mensaje, pala[i]);
            resu[i][0] = pala[i];
            resu[i][1] = "" + fre;
          }
        return resu;
      }

    public boolean validaEstres(String mensaje)
      {
        boolean estres = false;
        String[] pala = bolsa();
        int fre;
        int total = 0;
        for (int i = 0; i < pala.length; i++)
          {
            fre = bo.frecuencia(mensaje, pala[i]);
            total += fre;
          }
        if (total >= 8)
          {
            estres = true;
          }
        return estres;
      }

    public String[] bolsa()
      {
        ManipulaArchivos<String> mani = new ManipulaArchivos<String>();
        String bol = mani.carga("estres.dat");
        StringTokenizer tok = new StringTokenizer(bol, "[\n]");
        String[] bolsaR = new String[tok.countTokens()];
        int i = 0;
        while (tok.hasMoreElements())
          {
            bolsaR[i] = tok.nextToken();
            i++;
          }
        return bolsaR;
      }

    public void error(String mensa, String titu)
      {
        JOptionPane.showMessageDialog(null, mensa, titu, JOptionPane.ERROR_MESSAGE);
      }

    public void aviso(String mensa, String titu)
      {
        JOptionPane.showMessageDialog(null, mensa, titu, JOptionPane.INFORMATION_MESSAGE);
      }

    public int pregunta(String mensa, String titu)
      {
        int r;
        r = JOptionPane.showConfirmDialog(null, mensa, titu, JOptionPane.YES_NO_OPTION);
        return r;
      }
  }
