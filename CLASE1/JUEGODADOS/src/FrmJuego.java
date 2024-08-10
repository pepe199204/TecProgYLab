import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class FrmJuego extends JFrame {
    
    JLabel lblDado1, lblDado2, lblLanzamientos, lblCenas;

    public FrmJuego() {
        setTitle("Apostemos a los datos!!!");
        setSize(600, 300);
        // Agrega operación para que cuando cierre la ventana se termine la ejecución
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        lblDado1 = new JLabel();
        lblDado2 = new JLabel();
        JLabel lbl1 = new JLabel();
        JLabel lbl2 = new JLabel();
        lblLanzamientos = new JLabel();
        lblCenas = new JLabel();
        JButton btnIniciar = new JButton();
        JButton btnLanzar = new JButton();

        String rutaDado = "/img/3.jpg";
        ImageIcon imgDado = new ImageIcon(getClass().getResource(rutaDado));

        lblDado1.setIcon(imgDado);
        lblDado2.setIcon(imgDado);

        lblDado1.setBounds(10, 10, imgDado.getIconWidth(), imgDado.getIconHeight());
        lblDado2.setBounds(20 + imgDado.getIconWidth(), 10, imgDado.getIconWidth(), imgDado.getIconHeight());

        lbl1.setText("Lanzamientos");
        lbl2.setText("Cenas");

        lbl1.setBounds(50 + 2*imgDado.getIconWidth(), 10, 100, 25);
        lbl2.setBounds(160 + 2*imgDado.getIconWidth(), 10, 100, 25);

        lblLanzamientos.setText("0");
        lblLanzamientos.setBackground(new Color(0, 0, 0));
        lblLanzamientos.setForeground(new Color(51, 255, 0));
        lblLanzamientos.setBounds(50 + 2*imgDado.getIconWidth(), 40, 100, 100);
        lblLanzamientos.setOpaque(true);
        lblLanzamientos.setFont(new Font("Tahoma", 1, 72));
        lblLanzamientos.setHorizontalAlignment(SwingConstants.CENTER);

        lblCenas.setText("0");
        lblCenas.setBackground(new Color(0, 0, 0));
        lblCenas.setForeground(new Color(51, 255, 0));
        lblCenas.setBounds(160 + 2*imgDado.getIconWidth(), 40, 100, 100);
        lblCenas.setOpaque(true);
        lblCenas.setFont(new Font("Tahoma", 1, 72));
        lblCenas.setHorizontalAlignment(SwingConstants.CENTER);

        btnIniciar.setText("Iniciar");
        btnIniciar.setBounds(10, 150, 100, 25);
        btnLanzar.setText("Lanzar");
        btnLanzar.setBounds(120, 150, 100, 25);

        getContentPane().setLayout(null);
        getContentPane().add(lblDado1);
        getContentPane().add(lblDado2);
        getContentPane().add(lbl1);
        getContentPane().add(lbl2);
        getContentPane().add(lblLanzamientos);
        getContentPane().add(lblCenas);
        getContentPane().add(btnIniciar);
        getContentPane().add(btnLanzar);
    }

    public void mostrarContadores() {

    }
}
