package clase;

import conexion.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ControladorCliente {

    conexion cn = new conexion();
    errorPrestamo ep = new errorPrestamo();
    

public void agregar(Cliente cli) throws Exception{
    
    try{
       cn.conectar();
       cn.UID("INSERT INTO cliente (dui,nit,nombres,apellidos,sexo,direccion,telefonos,fecha_nacimiento,observaciones) VALUES ('"+cli.getDui()+"','"+cli.getNit()+"','"+cli.getNombre()+"','"+cli.getApellido()+"','"+cli.getSexo()+"','"+cli.getDirecion()+"','"+cli.getTelefono()+"','"+cli.getFechaN()+"','"+cli.getObs()+"');");
       }
    
    catch(Exception e){
      ep.nuevo("Error", e.getStackTrace().toString(), e.getMessage());
    }
    
    finally{
       cn.desconectar();
    }
}

public List<Cliente> obtener(){
     List<Cliente> clientes = new ArrayList();
     ResultSet rs;
     int contador=0;
     
      rs =  cn.getValores("SELECT * FROM cliente"); 
      
        try {
            while(rs.next()){
            clientes.add((Cliente) rs.getRef(contador));
            contador++;    
            } 
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    return clientes;
}

public void eliminar(Cliente cli){
    try{
     cn.conectar();
     
     if(cli.equals(cli.dui)){
        cn.UID("DELETE FROM cliente WHERE dui ='"+cli.getDui()+"'");
     }
     else if(cli.equals(cli.nit)){
        cn.UID("DELETE FROM cliente WHERE nit ='"+cli.getNit()+"'");
     }
     else if(cli.equals(cli.nombre)){
        cn.UID("DELETE FROM cliente WHERE nombres ='"+cli.getNombre()+"'");
     }
     else if(cli.equals(cli.apellido)){
        cn.UID("DELETE FROM cliente WHERE apellidos ='"+cli.getApellido()+"'");
     }
     else if(cli.equals(cli.telefono)){
        cn.UID("DELETE FROM cliente WHERE telefonos ='"+cli.getTelefono()+"'");
     }
     else{
        JOptionPane.showMessageDialog(null, "Parametro invalido");
     }
    
    }
    catch(Exception e){
    ep.nuevo("Error", e.getStackTrace().toString(), e.getMessage());
    }
    
    finally{
        cn.desconectar();
    }    
}

public ResultSet buscar(String s){
    
    Cliente cli = new Cliente();
    
    try{
        cn.conectar();
        
        if(s.equals(cli.dui)){
             return(cn.getValores("SELECT * FROM cliente WHERE dui='"+cli.getDui()+"'"));
        }
        else if(s.equals(cli.nit)){
             return(cn.getValores("SELECT * FROM cliente WHERE nit='"+cli.getNit()+"'"));
        }
        else if(s.equals(cli.nombre)){
             return(cn.getValores("SELECT * FROM cliente WHERE nombres='"+cli.nombre+"'"));
        }
        else if(s.equals(cli.apellido)){
             return(cn.getValores("SELECT * FROM cliente WHERE apellidos='"+cli.getApellido()+"'"));
        }
    }
    
    catch(Exception e){
        ep.nuevo("Error", e.getStackTrace().toString(), e.getMessage());
    }
    
    finally{
        cn.desconectar();
    }
    return null;
}   

}