package clase;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class errorPrestamo extends Exception{
    
    JTextArea hoja = new JTextArea();
    String salida;

    public void nuevo(String titulo,String ubicacion, String mensaje){
        String title = titulo;
        String direc = ubicacion;
        String msg = mensaje;
        
        salida = title+"\n"+msg+"\t"+"Se originó en: "+"\t"+direc;
        
        hoja.setText(salida);
        JOptionPane.showMessageDialog(null, hoja);
    }
    
}
