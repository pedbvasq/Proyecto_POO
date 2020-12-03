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
    private Date fecha;
    private String codigo;
    private EstadoEvento estado = EstadoEvento.PENDIENTE;
    private Cliente cl;
    private Date hInicio;
    private Date hFin;
    private int capacidad;
    private Planificador pl;
    private char desicion;
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


    @Override
    public String toString() {
        String linea = codigo + "," + cl.getNombre() + ","  + "," + hInicio + "," + hFin + "," + capacidad + "," + pl + "," + estado;
        return linea;
    }

 
    public static void agregarEvento(Evento ev) {
        eventos.add(ev);
    }

    public void mostrarMensaje() {
        System.out.println("f");

    }
   
}
