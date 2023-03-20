
package Banco;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ValidacionPIN extends Cuenta {
    public ValidacionPIN(String bd) {
        super(bd);
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public String getPropietario() {
        return propietario;
    }

    public int getPIN() {
        return PIN;
    }

    public void CambioContraseña() throws SQLException {
        int intentos = 3;
        while (intentos >= 0) {
            int AntiguoPIN = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la contraseña actual"));
            if (AntiguoPIN == PIN) {
                int PIN = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Nueva contraseña"));
                int cont = 0;
                while (cont >= 0) {
                    int PINConfirmacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevamenta la contraseña"));
                    if (PIN == PINConfirmacion) {
                        cont = -1;
                        BaseDatos conection = new BaseDatos("Banco");
                        try {
                            Statement s = conection.conectar().createStatement();
                            String update = "update persona set Contraseña=" + PIN + " " + "Where Nombres='" + propietario + "'";
                            s.executeUpdate(update);
                            JOptionPane.showMessageDialog(null, """
                                                            Contraseña Cambiada
                                                            Exitosamente
                                                            """);
                        } catch (SQLException ex) {
                            System.out.println("No se pudo actualizar registros por: "+ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, """
                                                 Contraseñas No
                                                 Coinciden. Puede
                                                 Intentarlo           
                                                 """ + cont);
                    }
                    cont = cont - 1;
                }
                intentos = -1;
            } else {
                JOptionPane.showMessageDialog(null, """
                                                 Contraseña Incorrecta 
                                                 Tiene
                                                 """ + intentos);
                intentos = intentos - 1;
            }
        }

    }
}
