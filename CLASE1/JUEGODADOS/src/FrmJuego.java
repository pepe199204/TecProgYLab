import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class FrmJuego extends JFrame {
    
    JLabel lblDado1, lblDado2, lblLanzamientos, lblCenas;
    Dado dado1, dado2;
    Random r = new Random();

    private int lanzamientos, cenas;

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

        dado1 = new Dado();
        dado2 = new Dado();

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

        lanzamientos = 0;
        cenas = 0;
        mostrarContadores();

        btnIniciar.setText("Iniciar");
        btnIniciar.setBounds(10, 150, 100, 25);
        btnIniciar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                btnIniciar_Click(e);
                //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            

        });

        btnLanzar.setText("Lanzar");
        btnLanzar.setBounds(120, 150, 100, 25);
        btnLanzar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                btnLanzar_Click(e);
                //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            

        });

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

    private void btnIniciar_Click(ActionEvent e) {
        lanzamientos = 0;
        cenas = 0;
        mostrarContadores();
    }


    private void btnLanzar_Click(ActionEvent e) {
        dado1.lanzar(r);
        dado2.lanzar(r);

        dado1.mostrar(lblDado1);
        dado2.mostrar(lblDado2);

        lanzamientos++;
        if (dado1.getNumero() + dado2.getNumero() >= 11) {
            cenas++;
        }
        
        mostrarContadores();
    }

    public void mostrarContadores() {
        lblLanzamientos.setText(String.valueOf(lanzamientos));
        lblCenas.setText(String.valueOf(cenas));
    }
}
