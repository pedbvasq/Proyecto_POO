package Usuarios;

import Archivos.Estado;
import Archivos.ManejoArchivos;
import Archivos.OrdenDePago;
import Archivos.Solicitud;
import Eventos.Evento;
import Eventos.TipoEvento;
import static Eventos.TipoEvento.BODA;
import static Eventos.TipoEvento.EMPRESARIAL;
import static Eventos.TipoEvento.INFANTIL;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;

public class Planificador extends Usuario {


    public Planificador(String nombre, String apellido, String idUsuario, String contraseña, char tipo) {
        super(nombre, apellido, idUsuario, contraseña, tipo);
    }

    public Planificador() {

    }

    public void ConsultarSolicitudesPendientes() {
        ArrayList<String> solicitudes = ManejoArchivos.LeeFichero("solicitudes.txt");
        System.out.print("/**********SOLICITUDES PENDIENTES*********/\n" + "/*                                       */\n" + "/*****************************************/\n");
        int num = 0;
        for (String i : solicitudes) {
            String[] sol = i.split(",");
            String id = sol[0];
            String fecha = sol[3];
            num++;
            System.out.println(num + ". " + id + " - " + fecha);
        }
    }

    public void registrarEvento() {
        System.out.print("/********** REGIRTRO DE EVENTOS**********/\n" + "/*  "
                + "                                   */\n" + "/***************************************/\n");
        Scanner sc = new Scanner(System.in);
        ArrayList<Solicitud> solicitudes = Solicitud.getSolicitudes();
        System.out.print("Ingrese id del evento: ");
        int id = sc.nextInt();
        for (Solicitud i : solicitudes) {
            if (id == i.getIdSolicitud()) {
                System.out.println("DATOS");
                System.out.println("CLIENTE: " + i.getCliente().getNombre());
                System.out.println("PLANIFICADOR ASIGNADO: " + this.getNombre());
                System.out.println("FECHA DE REGISTRO: " + i.getFechaEvento());
                System.out.println("TIPO: ");
                System.out.println("FECHA DEL EVENTO: " + i.getFechaEvento());
                switch (i.getTipo()) {
                    case BODA:
                        System.out.println("Precio Base: 3500");

                    case EMPRESARIAL:
                        System.out.println("Precio Base: 2000");

                    case INFANTIL:
                        System.out.println("Precio Base: 300");

                }
            }

        }

    }

    public void confirmarEvento() {
        System.out.print("/********** CONFIRMAR EVENTO **********/\n" + "/*  "
                + "                                   */\n" + "/***************************************/\n");
        String cod;
        System.out.println("Ingrese el ID de la orden de pago");
        cod = sc.nextLine();
        for (OrdenDePago i : OrdenDePago.getPagos()) {
            if (cod.equals(i.getCodigoOrden())) {
                System.out.println("El pago de este evento se ha realizo el : " + i.getFechaActual());
                i.setEstado(Estado.APROBADA);
                System.out.println("El evento se ha aprobado para la fecha establecida");

            }
        }

    }

    public void ConsultarEvento(String opcion) {

        switch (opcion) {
            case "1":
                System.out.println("Tiene " + filtro(BODA) + " Fiestas infantiles asigandas");

            case "2":
                System.out.println("Tiene " + filtro(INFANTIL) + " Fiestas infantiles asigandas");

            case "3":
                System.out.println("Tiene " + filtro(EMPRESARIAL) + " Fiesta empresarial asiganda");

            default:
                System.out.println("Opcion invalida!!!!");

        }

    }

    public int filtro(TipoEvento evento) {
        int acum = 0;
        ArrayList<Evento> eventos = Evento.getEventos();
        for (Evento e : eventos) {
            if (e.getCodigo().getClass().equals(evento)) {
                if (e.getPlanificador().nombre.contentEquals(this.nombre)) {
                    acum++;

                }

            }

        }
        return acum;

    }

    public void crearEvento(Date horaInicio, Date horaFin, int capacidad, char desicion) {
        ArrayList<Solicitud> solicitudes = Solicitud.getSolicitudes();
        for (Solicitud i : solicitudes) {
            Evento evento = new Evento(i.getTipo(), i.getFechaEvento(), Evento.generarCodigo(), i.getCliente(), horaInicio, horaFin, capacidad, desicion, i.getUser());
            Evento.agregarEvento(evento);

        }

    }

    public static Planificador validarCliente(String usuario, String contraseña) {
        for (Planificador i : planificadores) {
            if (i.getIdUsuario().equals(usuario) && i.getContraseña().equals(contraseña)) {
                return i;

            }
        }
        return null;

    }
   public void registroDatosEvento(Solicitud solicitud){
        Scanner sc = new Scanner(System.in);
        DateFormat hora = new SimpleDateFormat("HH:mm:ss");
        try{
            System.out.println("Hora inicio: ");
            String inicio = sc.nextLine();    
            Date hInicio = hora.parse(inicio);
            solicitud.getEvento().setInicio(hInicio);
       
            System.out.println("Hora fin: ");
            String fin = sc.nextLine();
            Date hFin=hora.parse(fin);
            solicitud.getEvento().setFin(hFin);
        } catch (ParseException e){System.out.println("Error:"+e.getMessage());}
        String descicion;
        do{
            System.out.println("/----------------------------------------------/");
            System.out.println("¿Desea agregar elementos adicionales?(S/N)");
            descicion= sc.nextLine().toLowerCase();
            Planificador.registrarAdicionales(solicitud);
        
        }while(!descicion.equals("n"));
    }
    
    public static void registrarAdicionales(Solicitud solicitud){
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("/*****REGISTRO DE ELEMENTOS ADICIONALES PARA EL EVENTO*****/");
            System.out.println("Las opciones son: \n"+"1. Comida \n"+"2. Bocaditos \n"+"3. Música \n"+"4. Fotografía \n"+"5. Bebida \n"+"6. Regresar al menú anterior");
            ArrayList<Integer> opcionesIngresadas = new ArrayList<>();
            
            opcion = sc.nextInt();
            if (!opcionesIngresadas.contains(opcion)&&opcion!=0){
                opcionesIngresadas.add(opcion);
                String sn;
                switch (opcion){

                    case 1:
                        Comida comida = new Comida();
                        comida.establecerCantidad();
                        System.out.println("Total: "+comida.getPrecioFinal());
                        System.out.print("Agregar (S/N)");
                        sn = sc.nextLine().toLowerCase();
                        if (sn.equals("s")){
                            solicitud.getEvento().setComida(comida);
                            System.out.println("Total a pagar: "+ solicitud.getEvento().calcularCostoTotal());
                        }else{break;}
                        break;
                    case 2:
                        Bocaditos bocaditos = new Bocaditos();
                        bocaditos.establecerCantidad();
                        System.out.println("Toatl: "+bocaditos.getPrecioFinal());
                        System.out.print("Agregar (S/N)");
                        sn = sc.nextLine().toLowerCase();
                        if (sn.equals("s")){
                            solicitud.getEvento().setBocaditos(bocaditos);
                            System.out.println("Total a pagar: "+ solicitud.getEvento().calcularCostoTotal());
                        }else{break;}

                    case 3: 
                        Musica musica = new Musica();
                        musica.establecerCantidad();
                        System.out.println("Total: "+musica.getPrecioFinal());
                        System.out.print("Agregar (S/N)");
                        sn = sc.nextLine().toLowerCase();
                        if (sn.equals("s")){
                            solicitud.getEvento().setMusica(musica);
                            System.out.println("Total a pagar: "+ solicitud.getEvento().calcularCostoTotal());
                        }else{break;}

                    case 4:
                        Fotografia foto = new Fotografia();
                        foto.establecerCantidad();
                        System.out.println("Total: "+foto.getPrecioFinal());
                        System.out.print("Agregar (S/N)");
                        sn = sc.nextLine().toLowerCase();
                        if (sn.equals("s")){
                            solicitud.getEvento().setFotografia(foto);
                            System.out.println("Total a pagar: "+ solicitud.getEvento().calcularCostoTotal());
                        }else{break;}
                    case 5:
                        Bebida bebida = new Bebida();
                        bebida.establecerCantidad();
                        System.out.println("Total: "+bebida.getCantidad());
                        System.out.print("Agregar (S/N)");
                        sn = sc.nextLine().toLowerCase();
                        if (sn.equals("s")){
                            solicitud.getEvento().setBebida(bebida);
                            System.out.println("Total a pagar: "+ solicitud.getEvento().calcularCostoTotal());
                        }else{break;}

                    case 6:
                        break;
                    default:
                        System.out.println("¡Opcion no valida!");
                    }
                }
            }while(opcion!=6);
        }
}
