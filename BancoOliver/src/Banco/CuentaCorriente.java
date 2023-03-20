
package Banco;

import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class CuentaCorriente extends Cuenta{
    public int numcuenta;
    public float saldo = 5000;

    public CuentaCorriente(String bd) {
        super(bd);
    }
    public void debito(){
        float saldoD = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor a debitar"));
        saldo = saldo - saldoD;
    }
    public void credito(){
        float saldoC = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor a debitar"));
        if(saldoC<=saldo){
        saldo = saldo - saldoC;
        }else{
            JOptionPane.showMessageDialog(null, "El valor que ingreso, sobrepasa el limite del credito");
        }
    }
    public void mensaje(){
        JOptionPane.showMessageDialog(null, "APARTADO EN DESARROLLO");
    }
    
}
