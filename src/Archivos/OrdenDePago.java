
package Archivos;

import java.util.ArrayList;
import java.util.Date;


public class OrdenDePago {
    private String codigoOrden;
    private String codigoTransaccion;
    private Date fechaActual;
    private Estado estado;
    private static ArrayList<OrdenDePago> pagos = new ArrayList<>();

    public String getCodigoOrden() {
        return codigoOrden;
    }

    public void setCodigoOrden(String codigoOrden) {
        this.codigoOrden = codigoOrden;
    }

    public String getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(String codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public static ArrayList<OrdenDePago> getPagos() {
        return pagos;
    }

    public static void setPagos(ArrayList<OrdenDePago> pagos) {
        OrdenDePago.pagos = pagos;
    }

    public OrdenDePago(String codigoOrden, String codigoTransaccion, Date fechaActual) {
        this.codigoOrden = codigoOrden;
        this.codigoTransaccion = codigoTransaccion;
        this.fechaActual = fechaActual;
        this.estado = estado.PENDIENTEPAGO;
        String cod_evento = Evento.generarCodigo();
        
        String linea = codigoOrden + "," + cod_evento + "," + estado + "," + codigoTransaccion + "," + fechaActual;
        String ordenPago;
        ManejoArchivos.EscribirArchivo("ordenPago.txt", linea);
        
    }
    
    public void añadirPago(OrdenDePago Pago){
        pagos.add(Pago);
        
    }
    
    
}
