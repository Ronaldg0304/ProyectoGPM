/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Accion;
import recursos.DBConnection;


public class AccionDAOImpl implements AccionDAO {
    
    // Método para obtener una conexión a la base de datos
    private Connection conexion = DBConnection.getConnection();

    @Override
    public void crearAccion(Accion accion) {
        // Query SQL para insertar una nueva solicitud
        String sql = "INSERT INTO ACCIONES (TiempoAccion, ComentarioAccion, IdOt, IdAveria, IdCausaAveria, IdComponente, IdTipoAccion) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setInt(1, accion.getTiempoAccion());
            statement.setString(2, accion.getComentarioAccion());
            statement.setInt(3, accion.getIdOt());
            statement.setInt(4, accion.getIdAveria());
            statement.setInt(5, accion.getIdCausaAveria());
            statement.setInt(6, accion.getIdComponente());
            statement.setInt(7, accion.getIdTipoAccion());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración y la conexión
            statement.close();

            System.out.println("Accion creada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al crear la acción.");
        }
    }

    @Override
    public Accion obtenerAccion(int idAccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarAccion(Accion accion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarAccion(int idAccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Accion> obtenerTodasLasAcciones() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    // Implementación de los métodos CRUD utilizando JDBC o algún ORM
    public List<Accion> obtenerAccionByIdOt(int idOt) {
        List<Accion> acciones = new ArrayList<>();
        // Query SQL para obtener una solicitud por su ID
        String sql = "SELECT * FROM ACCIONES WHERE IdOt = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID de la solicitud)
            statement.setInt(1, idOt);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró una orden
            while (resultSet.next()) {
                // Crear un objeto Orden con los datos obtenidos de la base de datos
                Accion accion = new Accion(
                        resultSet.getInt("IdOt"),
                        resultSet.getInt("TiempoAccion"),
                        resultSet.getString("ComentarioAccion"),
                        resultSet.getInt("IdOt"),
                        resultSet.getInt("IdAveria"),
                        resultSet.getInt("IdCausaAveria"),
                        resultSet.getInt("IdComponente"),
                        resultSet.getInt("IdTipoAccion")
                );

                acciones.add(accion);
            }
            // Cerrar el resultado y la declaración
            resultSet.close();
            statement.close();
            // Retornar la solicitud obtenida

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener la accion.");
            return null;
        }

        return acciones;

// Implementación de los métodos CRUD utilizando JDBC o algún ORM
    }
}
