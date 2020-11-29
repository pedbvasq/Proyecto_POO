
package Eventos;
import Usuarios.Cliente;
import Usuarios.Planificador;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.Iterator;
import java.util.ArrayList;
/**
 *
 * @author alber
 */
public class Evento {
    private TipoEvento tipo;
    private String sTipo;
    private double tarifa;
    private Date fecha;
    private String codigo;
    private EstadoEvento estado=EstadoEvento.PENDIENTE;
    private Cliente cl;
    private Date hInicio;
    private Date hFin;
    private int capacidad;
    private Planificador pl;
    
    
    public Evento(TipoEvento tipo, Date fecha, Cliente cl,Date hInicio, Date hFin){
        this.tipo=tipo;
        this.defTarifa();
        this.fecha=fecha;
        this.cl=cl;
        this.tipoToString();
        this.hInicio=hInicio;
        this.hFin=hFin;
        
    }
    
    public void setTipo(TipoEvento tipo){
        this.tipo=tipo;
    }
    
    public TipoEvento getTipo(){
        return tipo;
    }
      
    public double getTarifa(){
        return tarifa;
    }
    
    public void setFecha(Date fecha){
        this.fecha=fecha;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public void setCapacidad(int capacidad){
        this.capacidad=capacidad;
    }
    
    public int getCapacidad(){
        return capacidad;
    }
    
    public void setPlanificador(Planificador pl){
        this.pl=pl;
    }
    
    public Planificador getPlanificador(){
        return pl;
    }
    
    public void setInicio(Date hInicio){
        this.hInicio=hInicio;
    }
    
    public Date getInicio(){
        return hInicio;
    }
    
    public void setFin(Date hFin){
        this.hFin=hFin;
    }
    
    public Date getFin(){
        return hFin;
    }
    
    ArrayList<String> codigos=new ArrayList<>();
    public String generarCodigo(){
        String newCode="";
        String codigo="";
        while (!codigos.contains(codigo) && codigo.equals("")){
            Random rd = new Random();
            IntStream code=rd.ints(4,0,10);
            Iterator iterator =code.iterator();
            while(iterator.hasNext()){
                newCode=iterator.next()+"";
                codigo=codigo+newCode;            
            }
        }
        codigos.add(codigo);
        return codigo;
    }
    
    public void confirmarEvento(){
        this.estado=EstadoEvento.CONFIRMADO;
    }
    
    public void defTarifa(){
       switch(tipo){
            case BODA:
                tarifa=3500;
        
            case EMPRESARIAL:
                tarifa=2000;
        
            case INFANTIL:
                tarifa=300;
        }
        
    }
    
    public void tipoToString(){
       switch(tipo){
            case BODA:
                sTipo="Boda";
        
            case EMPRESARIAL:
                sTipo="Empresarial";
        
            case INFANTIL:
                sTipo="Infantil";
        }
    }    
    

    @Override
    public String toString(){
        String linea = codigo+"," + cl.getNombre()+","+sTipo+","+hInicio+","+hFin+","+capacidad+","+pl+","+estado;
        return linea;
    }
}
