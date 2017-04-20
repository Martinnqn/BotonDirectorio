package botondirectorio;

import com.sun.awt.AWTUtilities;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class VentanaOpciones extends JDialog {

    private String sDirectorio = null;
    private int x, y;
    private int estilo = 0;
    Shape dialogShape;
    JButton btnOk;
    JButton btnCancel;
    JTextArea txtPath;
    VentanaPrincipal padre;

    public VentanaOpciones(Shape shp, VentanaPrincipal pad) {
        super();
        padre = pad;
        this.setUndecorated(true);
        dialogShape = shp;
        getContentPane().setLayout(new GridLayout(2, 3));
        // Esta orden centra el dialogo en la pantalla
        this.setLocationRelativeTo(null);
        btnOk = new JButton("ok");
        btnOk.setContentAreaFilled(false);
        btnCancel = new JButton("cancel");
        btnCancel.setContentAreaFilled(false);
        txtPath = new JTextArea();
        txtPath.setColumns(500);
        add(txtPath, new GridLayout());
        add(btnOk, new GridLayout());
        add(btnCancel, new GridLayout());

        //funcionalidad botones
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                padre.setDir(txtPath.getText());
                dispose();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void formMousePressed(java.awt.event.MouseEvent evt) {
        x = evt.getX();
        y = evt.getY();
    }

    private void formMouseDragged(java.awt.event.MouseEvent evt) {
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }

    private void ocultarVentana() {
        this.setVisible(false);
    }

    private void mostrarVentana() {
        this.setVisible(true);
    }

    public String getDir() {
        return sDirectorio;
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
