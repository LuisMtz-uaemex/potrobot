/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pb;

import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author luis
 */
public class Tools
  {

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
  }
