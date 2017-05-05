package conexion;

//Recuerde importar la biblioteca de conexión

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class conexion {
    
    private String url = "jdbc:mysql://localhost:3307/prestamos";
    private String login = "root"; //Administrador de MySQL
    private String password = "123456";
    private Connection cnx = null;
     Connection link=null;
    private Statement sttm = null;
    private ResultSet rst = null;
    private int cont=0;
    Connection cnn;
    
    //método para Update, Insert, Delete
          public Connection conexion(){
      try{ 
        Class.forName("com.mysql.jdbc.Driver");
        cnn = DriverManager.getConnection(url, login, password);
      }catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
      }return cnn;
    }  
    public void UID(String sql) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url, login, password);
            sttm = cnx.createStatement();
            sttm.executeUpdate(sql); //statement
            
        } catch (ClassNotFoundException c) {
                      
            JOptionPane.showMessageDialog(null, "ERROR: " + c.getMessage());
            
        } catch (SQLException e) {
            if (e.getErrorCode()==1451){
                JOptionPane.showMessageDialog(null, "No se puede eliminar ya que es utilizado para los registros");
         
            }else if (e.getErrorCode()==1062){
                if (cont>0){
                
                }else{
                     JOptionPane.showMessageDialog(null, "Advertencia: Esta cita ya fue realizada parcial o totalmente", "¡ ADVERTENCIA !",
        JOptionPane.WARNING_MESSAGE);
                }
                cont++;
            
            }else{
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());}
        }
        
    }
    //Método para Consultar
    public ResultSet getValores(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url, login, password);
            sttm = cnx.createStatement();
            rst = sttm.executeQuery(sql);  //resultset
            
            
        } catch (ClassNotFoundException c) {
            JOptionPane.showMessageDialog(null, "ERROR: " + c.getMessage());
//            System.exit(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
//            System.exit(1);
        } finally {
            return rst;
            
        }
    }
    
 public  Connection conectar() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            link= DriverManager.getConnection(url,login,password);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN CONEXION:  " + e.getMessage());
        } return link;
    }
    
    public  void desconectar() {
       try{
       link.close();
       } catch(Exception e){}
    }

}