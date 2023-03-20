package Banco;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Principal {

    static Calendar Hora = Calendar.getInstance();
    static Calendar Fecha = Calendar.getInstance();

    public static void main(String[] args) {
        int hora, minutos, segundos, dia, mes, año;
        hora = Hora.get(Calendar.HOUR_OF_DAY);
        minutos = Hora.get(Calendar.MINUTE);
        segundos = Hora.get(Calendar.SECOND);
        dia = Fecha.get(Calendar.DATE);
        mes = Fecha.get(Calendar.MONTH);
        año = Fecha.get(Calendar.YEAR);
        BaseDatos conexion = new BaseDatos("Banco");
        Cuenta cliente = new Cuenta("Banco");
        ValidacionPIN pin = new ValidacionPIN("Banco");
        Statement st;
        ResultSet res;
        cliente.mesanjeBienvenida();
        CuentaAhorros clienteA = new CuentaAhorros("Banco");
        CuentaCorriente clienteC = new CuentaCorriente("Banco");
        int op = 3;
        while (op > 0) {
            int salir = 1;
            int PIN = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Contraseña"));
            op = 0;
            try {
                st = conexion.conectar().createStatement();
                res = st.executeQuery("select * from persona");
                while (res.next()) {
                    if (PIN == res.getInt("Contraseña")) {
                        System.out.println("Se conecto a la base de datos de " + res.getString("Nombres"));
                        JOptionPane.showMessageDialog(null, "Bienvenido " + res.getString("Nombres"));
                        cliente.tipo();
                        clienteA.setSaldo(res.getFloat("Saldo"));
                        pin.setPIN(res.getInt("Contraseña"));
                        pin.setPropietario(res.getString("Nombres"));
                        clienteA.setPropietario(res.getString("Nombres"));
                        System.out.println("El usuario" + " " + res.getString("Nombres") + " "
                                + "Tiene un saldo de" + " " + res.getFloat("Saldo"));
                        if (cliente.tipo == "Cuenta de Ahorros") {
                            System.out.println("El usuario a ingresado a la cuenta de ahorros a las "
                                    + hora + ":" + minutos + ":" + segundos + " Del " + dia + "/" + mes + "/" + año);

                            int rep = 0;
                            while (rep == 0) {
                                String[] options = {"Deposito", "Retiro", "Consulta de Saldo", "Cambio de Contraseña", "Salir"};
                                int elegir = JOptionPane.showOptionDialog(null, "Ingrese la opcion que sea realizar", "BIENVENIDO AL BANCO DE LOJA",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                                if (options[elegir] == "Deposito") {
                                    clienteA.deposito();
                                }
                                if (options[elegir] == "Retiro") {
                                    clienteA.retiro();
                                }
                                if (options[elegir] == "Consulta de Saldo") {
                                    clienteA.ConsultaSaldo();
                                }
                                if (options[elegir] == "Cambio de Contraseña") {
                                    pin.CambioContraseña();
                                }
                                if (options[elegir] == "Salir") {
                                    salir = 0;
                                    rep = 1;
                                }
                            }
                        }
                        if (cliente.tipo == "Cuenta Corriente") {
                            System.out.println("El usuario a ingresado a la cuenta corriente "
                                    + hora + ":" + minutos + ":" + segundos + " Del " + dia + "/" + mes + "/" + año);
                            clienteC.mensaje();
                            salir = 0;
                        }
                    }
                }
                if (salir == 1) {
                    JOptionPane.showMessageDialog(null, """
                                                       No exixste ningun registro con esa contraña
                                                       Vuelve a intentarlo
                                                       """);
                    op = 3;
                }
            } catch (Exception e) {
                System.out.println("Error al recuperar registros  " + e);
            }
        }
    }

}
