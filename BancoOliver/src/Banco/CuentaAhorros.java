package Banco;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class CuentaAhorros extends Cuenta {
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    public String getPropietario() {
        return propietario;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public float getSaldo() {
        return saldo;
    }
    public int numcuenta;
    public float saldo;
    public CuentaAhorros(String bd) {
        super(bd);
    }
    public void deposito() {
        BaseDatos conection = new BaseDatos("Banco");
        try {
            float saldoD = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor a depositar"));
            saldo = saldo + saldoD;
            Statement stt = conection.conectar().createStatement();
            String update = "update persona set Saldo=" + saldo + " " + "Where Nombres='" + propietario + "'";
            stt.executeUpdate(update);
        } catch (SQLException ex) {
            System.out.println("No se puedo hacer el cambio" + ex);
        }
        JOptionPane.showMessageDialog(null, "Usted Cuenta con un saldo de " + saldo);
    }
    public void retiro() {
        BaseDatos saldoC = new BaseDatos("Banco");
        float saldoR = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor a debitar"));
        
        if (saldoR <= saldo) {
            try {
                saldo = saldo - saldoR;
                int opcion = JOptionPane.showConfirmDialog(null, """
                                           Desea Imprimir comprobante
                                           El costo del Comprobante 
                                           es $0.35
                                           """);
                if (opcion == 0) {
                    saldo = (float) (saldo - 0.35);
                }
                Statement stt = saldoC.conectar().createStatement();
                String update = "update persona set Saldo=" + saldo + " " + "where Nombres='" + propietario + "'";
                stt.executeUpdate(update);
                JOptionPane.showMessageDialog(null, "Usted Cuenta con un saldo de " + saldo);
            } catch (SQLException ex) {
                System.out.println("No se pudo hacer el cambio" + ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "El valor ingreso el mayor al que esta en la cuenta");
        }
    }
    public void ConsultaSaldo() {
        JOptionPane.showMessageDialog(null, "Cuenta con un saldo de " + saldo);
    }
}
