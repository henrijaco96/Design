package clase;

import conexion.conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ControladorPrestamo {
    
    Prestamo p = new Prestamo();
    errorPrestamo ep = new errorPrestamo();
    conexion cn = new conexion();
    Cliente c = new Cliente();

    
    public void agregar(Prestamo p){
        Cliente cli = new Cliente();
        try{
            cn.conectar();
            cn.UID("INSERT INTO prestamo (id_prestamo,dui,monto,valor_cuota,tasa_interes,cantidad_cuotas,fecha_inicio,fecha_fin,fecha_ultimo_pago,saldo,estado,observaciones) VALUES ('"+p.getIdPrestamo()+"','"+cli.getDui()+"','"+p.getMonto()+"','"+p.getValorCuota()+"','"+p.getTasaInteres()+"','"+p.getCantidadCuotas()+"','"+p.getFechaInicio()+"','"+p.getFechaFin()+"','"+p.getFechaUltimoPago()+"','"+p.getSaldo()+"','"+p.isEstado()+"','"+p.getObservaciones()+"');");
        }
        
        catch(Exception e){
            ep.nuevo("Advertencia: ", e.getStackTrace().toString(), e.getMessage());
        }
        
        finally{
            cn.desconectar();
        }
    }
    
    public List<Prestamo> ObtenerActivos(){
        List<Prestamo> salida = new ArrayList();        
        ResultSet gets = null;
        //return(cn.getValores("SELECT * FROM prestamo WHERE dui='"+c.getDui()+"'"));
        try{
            gets = cn.getValores("SELECT * FROM prestamo WHERE estado='"+"true"+"'");
    /*        for(int i=0;i<gets.;i++){
                
            }*/
           // salida=gets;
        }
        catch(Exception e){
            ep.nuevo("Advertencia",e.getStackTrace().toString(), e.getMessage());
        }
    
        return salida;
    }
    
    public ResultSet obtenerActivos(){
        return(cn.getValores("SELECT * FROM prestamo WHERE estado = 'activo'"));
    }
    
    public void modificar(Prestamo p){
        try{
            cn.conectar();
            cn.UID("UPDATE prestamo SET monto ='"+p.getMonto()+"', interes ='");
        }
        
        catch(Exception e){
            ep.nuevo("Advertencia", e.getStackTrace().toString(), e.getMessage());
        }
        
        finally{
          cn.desconectar();
        }
    }
}
