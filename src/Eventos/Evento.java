package Eventos;

import Usuarios.Cliente;
import Usuarios.Planificador;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.Iterator;

public class Evento {

    private TipoEvento tipo;
    private double tarifa;
    private String sTipo;
    private Date fecha;
    private String codigo;
    private EstadoEvento estado = EstadoEvento.PENDIENTE;
    private Cliente cl;
    private Date hInicio;
    private Date hFin;
    private int capacidad;
    private Planificador pl;
    private char desicion;
    private Comida comida;
    private Bebida bebida;
    private Musica musica;
    private Fotografia fotografia;
    private Bocaditos bocaditos;
    private static ArrayList<Evento> eventos = new ArrayList<>();

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
    
    

    public static ArrayList<Evento> getEventos() {
        return eventos;
    }

    public static void setEventos(ArrayList<Evento> eventos) {
        Evento.eventos = eventos;
    }

   public double getTarifa(){
        return tarifa;
    }

    
    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setPlanificador(Planificador pl) {
        this.pl = pl;
    }

    public Planificador getPlanificador() {
        return pl;
    }

    public void setInicio(Date hInicio) {
        this.hInicio = hInicio;
    }

    public Date getInicio() {
        return hInicio;
    }

    public void setFin(Date hFin) {
        this.hFin = hFin;
    }

    public Date getFin() {
        return hFin;
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
    public static String generarCodigo() {
        ArrayList<String> codigos = new ArrayList<>();

        String newCode = "";
        String codigo = "";
        while (!codigos.contains(codigo) && codigo.equals("")) {
            Random rd = new Random();
            IntStream code = rd.ints(4, 0, 10);
            Iterator iterator = code.iterator();
            while (iterator.hasNext()) {
                newCode = iterator.next() + "";
                codigo = codigo + newCode;
            }
        }
        codigos.add(codigo);
        return codigo;
    }

    public void confirmarEvento() {
        this.estado = EstadoEvento.CONFIRMADO;
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
    public String toString() {
        String linea = codigo + "," + cl.getNombre() + ","+ sTipo + "," + hInicio + "," + hFin + "," + capacidad + "," + pl + "," + estado;
        return linea;
    }

 
    public static void agregarEvento(Evento ev) {
        eventos.add(ev);
    }

    public void mostrarMensaje() {
        System.out.println("f");

    }
    public double calcularCostoAdicionales(){
        
        double costoAdicionales = comida.getPrecioFinal()+bebida.getPrecioFinal()+musica.getPrecioFinal()+fotografia.getPrecioFinal()+bocaditos.getPrecioFinal();
        return costoAdicionales;
    }
    public double calcularCostoTotal(){
        double costoTotal=this.tarifa+this.calcularCostoAdicionales();
        return costoTotal;
    }
}
    
   
}
