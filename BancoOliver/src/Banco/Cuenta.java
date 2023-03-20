
package Banco;


import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Cuenta extends BaseDatos{
    public String tipo;
    public String propietario;
    public int PIN;

    public Cuenta(String bd) {
        super(bd);
    }
    public void tipo(){
      String[] opciones = {"Cuenta de Ahorros", "Cuenta Corriente"};
        int elegir = JOptionPane.showOptionDialog(null, "ELIGA EL TIPO DE CUENTA", "BANCO",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        this.tipo = opciones[elegir];
    }
    public void mesanjeBienvenida(){
        JOptionPane.showMessageDialog(null,"""
                                           ______________________________
                                           BIENVENIDO SU BANCO 
                                           TRABAJANDO POR SU SEGUIRIDAD
                                           ______________________________
                                           """);
    }
}
