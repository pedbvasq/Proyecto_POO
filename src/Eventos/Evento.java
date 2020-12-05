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
    private Comida comida;
    private Bebida bebida;
    private Musica musica;
    private Fotografia fotografia;
    private Bocaditos bocaditos;
    private char desicion;
    private static ArrayList<Evento> eventos = new ArrayList<>();
    
    public Evento(TipoEvento tipo, Date fecha, Cliente cl,Date hInicio, Date hFin){
        this.tipo=tipo;
        this.defTarifa();
        this.fecha=fecha;
        this.cl=cl;
        this.tipoToString();
        this.hInicio=hInicio;
        this.hFin=hFin;
        
    }

    
    
    //constructor con valores por defecto para crear evento cuando se crea la solicitud 
    public Evento(TipoEvento tipo, Date fecha, Cliente cl){
        this.tipo=tipo;
        this.defTarifa();
        this.fecha=fecha;
        this.cl=cl;
        this.tipoToString();
        this.hInicio=null;
        this.hFin=null;
    }
    /**
     * 
     * @param tipo
     * @param fecha
     * @param codigo
     * @param cl
     * @param hInicio
     * @param hFin
     * @param capacidad
     * @param desicion
     * @param pl 
     */
     public Evento(TipoEvento tipo, Date fecha, String codigo, Cliente cl, Date hInicio, Date hFin, int capacidad, char desicion,Planificador pl) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.codigo = codigo;
        this.cl = cl;
        this.hInicio = hInicio;
        this.hFin = hFin;
        this.capacidad = capacidad;
        this.desicion = desicion;
        this.pl = pl;
    }
     /**
      * 
      * @return 
      */
    public static ArrayList<Evento> getEventos() {
        return eventos;
    }
    /**
     * 
     * @param tipo 
     */
    public void setTipo(TipoEvento tipo){
        this.tipo=tipo;
    }
    
    /**
     * 
     * @return 
     */
    public TipoEvento getTipo(){
        return tipo;
    }
      /**
       * 
       * @return 
       */
    public double getTarifa(){
        return tarifa;
    }
    /**
     * 
     * @param fecha 
     */
    public void setFecha(Date fecha){
        this.fecha=fecha;
    }
    /**
     * 
     * @return 
     */
    public Date getFecha(){
        return fecha;
    }
    /**
     * 
     * @param codigo 
     */
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }
    /**
     * 
     * @return 
     */
    public String getCodigo(){
        return codigo;
    }
    /**
     * 
     * @param capacidad 
     */
    public void setCapacidad(int capacidad){
        this.capacidad=capacidad;
    }
    /**
     * 
     * @return 
     */
    public int getCapacidad(){
        return capacidad;
    }
    /**
     * 
     * @param pl 
     */
    public void setPlanificador(Planificador pl){
        this.pl=pl;
    }
    /**
     * 
     * @return 
     */
    public Planificador getPlanificador(){
        return pl;
    }
    /**
     * 
     * @param hInicio 
     */
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
    
    public Cliente getCliente(){
        return cl;
    }
    
    public void setComida(Comida comida){
        this.comida = comida;
    }
    public void setBebida(Bebida bebida){
        this.bebida=bebida;    
    }
    public void setMusica(Musica musica){
        this.musica = musica;
    }
    public void setFotografia(Fotografia fotografia){
        this.fotografia=fotografia;
    }
    public void setBocaditos(Bocaditos bocaditos){
        this.bocaditos=bocaditos;
    }
    public Comida getComida(){
        return comida;
    }
    public Bebida getBebida(){
        return bebida;
    }
    public Musica getMusica(){
        return musica;
    }
    public Fotografia getFotografia(){
        return fotografia;
    }
    public Bocaditos getBocaditos(){
        return bocaditos;
    }
    
    
    static ArrayList<String> codigos=new ArrayList<>();
    public static String generarCodigo(){
        
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
    
/**
 * 
 * @return 
 */
    @Override
    public String toString(){
        String linea = codigo+"," + cl.getNombre()+","+sTipo+","+hInicio+","+hFin+","+capacidad+","+pl+","+estado;
        return linea;
    }
    /**
     * 
     * @return 
     */
    public double calcularCostoAdicionales(){
        
        double costoAdicionales = comida.getPrecioFinal()+bebida.getPrecioFinal()+musica.getPrecioFinal()+fotografia.getPrecioFinal()+bocaditos.getPrecioFinal();
        return costoAdicionales;
    }
    /**
     * 
     * @return 
     */
    public double calcularCostoTotal(){
        double costoTotal=this.tarifa+this.calcularCostoAdicionales();
        return costoTotal;
    }
    /**
     * 
     * @param ev 
     */
    public static void agregarEvento(Evento ev) {
        eventos.add(ev);
    }
   
}
    
