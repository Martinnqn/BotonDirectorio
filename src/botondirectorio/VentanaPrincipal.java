package botondirectorio;

import com.sun.awt.AWTUtilities;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * ventana flotante principal
 * @author Bermu
 */
public class VentanaPrincipal extends JDialog {

    private String sDirectorio = "c:\\Users\\Bermu\\Desktop\\1er cuatrimestre 2017.03.28";
    private int x, y;
    private int estilo = 0;
    // La forma de nuestro dialogo
    Shape dialogShape;

    public VentanaPrincipal(Shape shp) {
        super();
        //esto hace que no se minimice
        this.setAlwaysOnTop(true);
        this.setUndecorated(true);
        dialogShape = shp;
        initComponents();
        // Esta orden centra el dialogo en la pantalla
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jbPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jbPrincipal.setText("      ");
        jbPrincipal.setAlignmentY(0.0F);
        jbPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbPrincipal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbPrincipal.setMargin(new java.awt.Insets(-150, -150, 0, 0));
        jbPrincipal.setMaximumSize(new java.awt.Dimension(200, 200));
        jbPrincipal.setMinimumSize(new java.awt.Dimension(80, 80));
        jbPrincipal.setPreferredSize(new java.awt.Dimension(100, 100));
        jbPrincipal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jbPrincipalMouseDragged(evt);
            }
        });
        jbPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPrincipalMouseClicked(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbPrincipalMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void formMousePressed(java.awt.event.MouseEvent evt) {
        x = evt.getX();
        y = evt.getY();
    }

    private void formMouseDragged(java.awt.event.MouseEvent evt) {
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }

    private void jbPrincipalMouseClicked(java.awt.event.MouseEvent evt) {
        switch (evt.getButton()) {
            case MouseEvent.BUTTON1:
                if (estilo == 0) {
                    this.setVisible(false);
                    PanelCuadrado frameCuadrado = new PanelCuadrado(this, sDirectorio);
                    frameCuadrado.setVisible(true);
                } else if (estilo == 1) {

                }
                break;
            case MouseEvent.BUTTON2:
                System.out.println("abrir opciones");
                VentanaOpciones opc = new VentanaOpciones(dialogShape, this);
                opc.setBounds(x, y, 380, 380);
                opc.setVisible(true);
                break;
            case MouseEvent.BUTTON3:
                System.exit(0);
                break;
        }
    }

    private void jbPrincipalMouseDragged(java.awt.event.MouseEvent evt) {
        formMouseDragged(evt);
    }

    private void jbPrincipalMousePressed(java.awt.event.MouseEvent evt) {
        formMousePressed(evt);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jbPrincipal;
    // End of variables declaration                   

    public String getDir() {
        return sDirectorio;
    }

    public void setDir(String dir) {
        sDirectorio = dir;
    }

    @Override
    /**
     * Establece la forma de la ventana.
     *
     * @param shape
     */
    public void setShape(Shape shape) {
        this.dialogShape = shape;
    }

    @Override
    public void paint(Graphics g) {

        // Pintamos todo el contenido
        super.paint(g);
        // Establecemos la forma de la ventana
        AWTUtilities.setWindowShape(this, dialogShape);

    }

}
