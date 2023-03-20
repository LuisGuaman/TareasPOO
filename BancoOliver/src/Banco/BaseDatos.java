
package Banco;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ASUS
 */
public class BaseDatos {
    Statement s = null;
    String bd = "Banco";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "2003/02/01sql";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;
    public BaseDatos(String bd){
        this.bd = bd;
    }
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd, user, password);
            System.out.println("Conexcion establecida correctamente a "+bd);
        } catch (SQLException|ClassNotFoundException ex) {
            System.out.println("No se conecto a la base de datos "+bd);
        }
        return cx;
    }
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}