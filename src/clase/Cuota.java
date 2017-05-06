package clase;

import java.sql.Date;

public class Cuota {
    
    public double valor,interes,capital,saldoAnterior,saldoActualizado;
    public int numCuota;
    public Date fecha;
    
    errorPrestamo ep = new errorPrestamo();

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public double getSaldoActualizado() {
        return saldoActualizado;
    }

    public void setSaldoActualizado(double saldoActualizado) {
        this.saldoActualizado = saldoActualizado;
    }

    public int getNumCuota() {
        return numCuota;
    }

    public void setNumCuota(int numCuota) {
        this.numCuota = numCuota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public boolean validar(){
        boolean t=false;
        try{
           if(this.numCuota <=0 || this.capital <=0 || this.valor <=0 || this.fecha.toString().isEmpty()){
               t = false;
           } 
           else{
               t = true;
           }
        }
        
        catch(Exception e){
            ep.nuevo("Algo sucedio:", e.getStackTrace().toString(), e.getMessage());
        }
        
        return t;
    }

    public void calcularCuota(){
        double valor,saldoAnterior,inter,capital,saldoAct;
        
        valor = this.getValor();
        saldoAnterior = this.getSaldoActualizado();
        inter = this.getInteres();
        capital=this.getCapital();
        
        try{
          capital-=valor;
          
          
        }
        
        catch(Exception e){
         ep.nuevo("Advertencia", e.getStackTrace().toString(), e.getMessage());
        }
    }

   
}
