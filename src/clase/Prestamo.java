package clase;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Prestamo {

    public int idPrestamo,cantidadCuotas;
    public double monto,valorCuota,tasaInteres,saldo;
    public Date fechaInicio,fechaFin,fechaUltimoPago;
    public boolean estado;
    public String observaciones;
    Cliente cliente = new Cliente();
    Cuota cuota = new Cuota();
    errorPrestamo ep = new errorPrestamo();
    ArrayList<Cuota> cuotas ;
    

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(double valorCuota) {
        this.valorCuota = valorCuota;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaUltimoPago() {
        return fechaUltimoPago;
    }

    public void setFechaUltimoPago(Date fechaUltimoPago) {
        this.fechaUltimoPago = fechaUltimoPago;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public double calcularCuotaMensual(){
        double interes,cantidad,cuotaMensual=0;
        int numeroCuotas;
        Date fechaI,fechaF;
        Calendar calendario = Calendar.getInstance();
        
        interes = this.getTasaInteres();
        cantidad = this.getMonto();
        numeroCuotas = 0;
        fechaI = this.getFechaInicio();
        cuotaMensual*=interes;
        calendario.setTime(fechaI);
                
        try{
          do{
              cantidad-=cuotaMensual;
              numeroCuotas++;
          }while(cantidad>0);
         this.setCantidadCuotas(numeroCuotas);
         
        calendario.add(Calendar.MONTH, numeroCuotas);
        fechaF=(Date) calendario.getTime();
        this.setFechaFin(fechaFin);
        this.setCantidadCuotas(numeroCuotas);
        }
        
        catch(Exception e){
         ep.nuevo("Advertencia", Arrays.toString(e.getStackTrace()), e.getMessage());
        }
        
        return cuotaMensual;
    }
    
    public boolean validar(){
        
        if(this.fechaInicio.toString().isEmpty() || this.idPrestamo <=0 || this.monto <=0 || this.observaciones.isEmpty() || this.tasaInteres <=0 || this.valorCuota <=0){
            JOptionPane.showMessageDialog(null, "Hay campos vacíos");
            return false;
        } else{
            return true;
        }                    
    }
    
    public void crearNuevaCuota(){
       this.cuota = new Cuota(); 
       
               
    }
    
    public void agregarCuota(Cuota cu){
           cuotas.add(cuota);
        Date fechaU;
        
        fechaU=this.getFechaUltimoPago();
        if(fechaU.toString() == null){
            
        }
    }
    
    public double calcularInteresMensual(){
        int numC;
        double pres,inte,intM=0;
        Date fechaUltimo=this.getFechaUltimoPago();
        Calendar calendario = Calendar.getInstance();
        calendario.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
        
        try{
            if(!fechaUltimo.before(calendario.getTime())){
                
            }
        }
        
        catch(Exception e){
            
        }
    
        
        return intM;
    }
}
