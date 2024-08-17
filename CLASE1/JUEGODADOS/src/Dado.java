import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dado {
    
    private int numero;

    public void lanzar(Random r) {
        numero = r.nextInt(6) + 1;
    }

    public void mostrar(JLabel lbl) {
        String rutaDado = "/img/"+numero+".jpg";
        ImageIcon imgDado = new ImageIcon(getClass().getResource(rutaDado));
        lbl.setIcon(imgDado);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
