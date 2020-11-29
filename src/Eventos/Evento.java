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
    private String sTipo;
    private double tarifa;
    private Date fecha;
    private String codigo;
    private EstadoEvento estado = EstadoEvento.PENDIENTE;
    private Cliente cl;
    private Date hInicio;
    private Date hFin;
    private int capacidad;
    private Planificador pl;
    private static ArrayList<Evento> eventos= new ArrayList<>();

    public static ArrayList<Evento> getEventos() {
        return eventos;
    }

    public static void setEventos(ArrayList<Evento> eventos) {
        Evento.eventos = eventos;
    }
    
    

    public Evento(TipoEvento tipo, Date fecha, Cliente cl, Date hInicio, Date hFin) {
        this.tipo = tipo;
        this.defTarifa();
        this.fecha = fecha;
        this.cl = cl;
        this.tipoToString();
        this.hInicio = hInicio;
        this.hFin = hFin;

    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public double getTarifa() {
        return tarifa;
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

    public  static String generarCodigo() {
        ArrayList<String> codigos= new ArrayList<>();
        
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

    public void defTarifa() {
        switch (tipo) {
            case BODA:
                tarifa = 3500;

            case EMPRESARIAL:
                tarifa = 2000;

            case INFANTIL:
                tarifa = 300;
        }

    }

    public void tipoToString() {
        switch (tipo) {
            case BODA:
                sTipo = "Boda";

            case EMPRESARIAL:
                sTipo = "Empresarial";

            case INFANTIL:
                sTipo = "Infantil";
        }
    }

    @Override
    public String toString() {
        String linea = codigo + "," + cl.getNombre() + "," + sTipo + "," + hInicio + "," + hFin + "," + capacidad + "," + pl + "," + estado;
        return linea;
    }

    /**
     *
     * @param ev
     * @return
     */
    
    public static  ArrayList<Evento> agregarEvento(Evento ev){
      eventos.add(ev);
        return eventos;
    }
     public  void mostrarMensaje(){
         System.out.println("f");
        
    }
    

    
    
    
    
    
    
    
}


