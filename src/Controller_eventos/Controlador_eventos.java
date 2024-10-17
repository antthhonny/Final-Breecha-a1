/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_eventos;

import Md_eventos.Modelo_Eventos;
import Vista_Eventos.VistaaCR;
import Vista_Eventos.VistaaMenuu;
import Vista_Eventos.VistasReservas;
import java.time.LocalDate;

/**
 *
 * @author antho
 */
public class Controlador_eventos {
 
    //modelo
    private Modelo_Eventos mde;
    
    
    //vistas
    private VistaaCR creacion;
    private VistaaMenuu menu;
    private VistasReservas reserva;
    
     //public + modelogeneral          + modelo               + Primera Vista 
    public Controlador_eventos(Modelo_Eventos cli, VistaaCR view )
    {
    this.mde=cli;
    this.creacion=view;
    }
    
     //public + modelogeneral          + modelo               + Primera Vista 
    public Controlador_eventos(Modelo_Eventos cli, VistaaMenuu view )
    {
    this.mde=cli;
    this.menu=view;
    }
    
    //public + modelogeneral          + modelo               + Primera Vista 
    public Controlador_eventos(Modelo_Eventos cli,  VistasReservas view )
    {
    this.mde=cli;
    this.reserva=view;
    }
    
    //insertar reserva
      public String InsertarReserva (LocalDate Fecha, String Tipo, String Numero)
      {
       mde.getFecha_de_Fiesta();
       mde.getTipo_de_Fiesta();
       mde.getNumero_de_Invitados();
       String mensaje =  mde.insertarReserva(mde);
       return mensaje ;
      }
     
      public String ActualizarReserva(int id_Reserva, LocalDate Fecha, String Tipo, String Numero) {
    
       mde.setId_Reserva(id_Reserva);
       mde.setFecha_de_Fiesta(Fecha);
       mde.setTipo_de_Fiesta(Tipo);
       mde.setNumero_de_Invitados(Numero);
       String mensaje = mde.actualizarReserva(mde);
       return mensaje;
    }
      
       public String EliminarReserva(int id_Reserva, LocalDate Fecha, String Tipo, String Numero) {
    
       mde.setId_Reserva(id_Reserva);
       mde.setFecha_de_Fiesta(Fecha);
       mde.setTipo_de_Fiesta(Tipo);
       mde.setNumero_de_Invitados(Numero);
       String mensaje = mde.eliminarReserva(id_Reserva);
       return mensaje;
    }
}
