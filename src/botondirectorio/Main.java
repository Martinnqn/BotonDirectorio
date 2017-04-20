/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botondirectorio;

import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Bermu
 */
public class Main {

    public static void main(String[] args) {
        Shape forma = new Ellipse2D.Float(0, 0, 150, 150);
        VentanaPrincipal ventanaP = new VentanaPrincipal(forma);
        ventanaP.setVisible(true);
    }
}
