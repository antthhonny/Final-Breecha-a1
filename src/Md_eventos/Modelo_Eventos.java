/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Md_eventos;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Modelo_Eventos {

    private int id_Reserva;
    private LocalDate Fecha_de_Fiesta;  // Cambiado de double a LocalDate
    private String Tipo_de_Fiesta;
    private String Numero_de_Invitados;
    private Conexion conexion;

    // Constructor
    public Modelo_Eventos() {
        
    }

    // Getters
    public int getId_Reserva() {
        return id_Reserva;
    }

    public LocalDate getFecha_de_Fiesta() {
        return Fecha_de_Fiesta;
    }

    public String getTipo_de_Fiesta() {
        return Tipo_de_Fiesta;
    }

    public String getNumero_de_Invitados() {
        return Numero_de_Invitados;
    }

    public Conexion getConexion() {
        return conexion;
    }

   
    // Setters
    public void setId_Reserva(int id_Reserva) {
        this.id_Reserva = id_Reserva;
    }

    public void setFecha_de_Fiesta(LocalDate Fecha_de_Fiesta) {
        this.Fecha_de_Fiesta = Fecha_de_Fiesta;
    }

    public void setTipo_de_Fiesta(String Tipo_de_Fiesta) {
        this.Tipo_de_Fiesta = Tipo_de_Fiesta;
    }

    public void setNumero_de_Invitados(String Numero_de_Invitados) {
        this.Numero_de_Invitados = Numero_de_Invitados;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

 

    // Método para insertar una reserva
    public String insertarReserva(Modelo_Eventos mde) {
        Connection ex = conexion.conectar();
        if (ex != null) {
            try {
                String spInsertarReserva = "(call insertarReserva(?,?,?))";
                CallableStatement statement = ex.prepareCall(spInsertarReserva);
                statement.setDate(1, java.sql.Date.valueOf(mde.getFecha_de_Fiesta()));  // Convertir LocalDate a Date de SQL
                statement.setString(2, mde.getTipo_de_Fiesta());
                statement.setString(3, mde.getNumero_de_Invitados());
                statement.execute();
                return "El registro se ingresó con éxito en la base de datos.";
            } catch (SQLException cx) {
                return cx.getMessage();
            } finally {
                conexion.desconectar();
            }
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
        return null;
    }
    
    // Método para eliminar una reserva por ID
    public String eliminarReserva(int id_Reserva) {
        Connection ex = conexion.conectar();
            if (ex != null) {
        try {
            String spEliminarReserva = "(call eliminarReserva(?))";  // Procedimiento almacenado en tu BD
            CallableStatement statement = ex.prepareCall(spEliminarReserva);
            statement.setInt(1, id_Reserva);  // Se pasa el ID de la reserva
            statement.execute();
            return "La reserva ha sido eliminada con éxito.";
        } catch (SQLException cx) {
            return cx.getMessage();
        } finally {
            conexion.desconectar();
        }
    } else {
        System.out.println("No se pudo conectar a la base de datos.");
    }
    return null;
}

// Método para actualizar una reserva
    public String actualizarReserva(Modelo_Eventos mde) {
        Connection ex = conexion.conectar();
        if (ex != null) {
            try {
            String spActualizarReserva = "(call actualizarReserva(?,?,?,?))";  // Procedimiento almacenado en tu BD
            CallableStatement statement = ex.prepareCall(spActualizarReserva);
            statement.setInt(1, mde.getId_Reserva());  // ID de la reserva que se va a actualizar
            statement.setDate(2, java.sql.Date.valueOf(mde.getFecha_de_Fiesta()));  // Convertir LocalDate a Date de SQL
            statement.setString(3, mde.getTipo_de_Fiesta());
            statement.setString(4, mde.getNumero_de_Invitados());
            statement.execute();
            return "La reserva ha sido actualizada con éxito.";
        } catch (SQLException cx) {
            return cx.getMessage();
        } finally {
            conexion.desconectar();
        }
    } else {
        System.out.println("No se pudo conectar a la base de datos.");
        }
    return null;
    }
}