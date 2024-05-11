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
import model.TipoSolicitud;
import recursos.DBConnection;

public class TipoSolicitudDAOImpl implements TipoSolicitudDAO {

    // Método para obtener una conexión a la base de datos
    private Connection conexion = DBConnection.getConnection();

    // Implementación de los métodos de la interfaz TipoSolicitudDAO
    @Override
    public void crearTipoSolicitud(TipoSolicitud tipoSolicitud) {
        // Query SQL para insertar una nueva solicitud
        String sql = "INSERT INTO TIPO_SOLICITUD (Descripcion) "
                + "VALUES (?)";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, tipoSolicitud.getDescripcion());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración y la conexión
            statement.close();
            conexion.close();

            System.out.println("Tipo de Solicitud agregado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al agregar el tipo de solicitud.");
        }
    }

    @Override
    public TipoSolicitud obtenerTipoSolicitud(int idTipoSolicitud) {
        // Query SQL para obtener una solicitud por su ID
        String sql = "SELECT * FROM TIPO_SOLICITUD WHERE IdTipoSolicitud = ?" ;

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID del tipo_solicitud)
            statement.setInt(1, idTipoSolicitud);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró una solicitud
            if (resultSet.next()) {
                // Crear un objeto Tipo_Solicitud con los datos obtenidos de la base de datos
                TipoSolicitud tipoSolicitud = new TipoSolicitud(
                        resultSet.getInt("IdTipoSolicitud"),
                        resultSet.getString("Descripcion")
                );

                // Cerrar el resultado y la declaración
                resultSet.close();
                statement.close();
                // Retornar la solicitud obtenida
                return tipoSolicitud;
            }

            // Si no se encontró la solicitud, retornar null
            statement.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener el tipo de solicitud indicado.");
            return null;
        }
    }

    @Override
    public void actualizarTipoSolicitud(TipoSolicitud tipoSolicitud) {
        // Query SQL para actualizar una solicitud
        String sql = "UPDATE TIPO_SOLICITUD SET Descripcion = ? WHERE IdTipoSolicitud = " + tipoSolicitud.getIdTipoSolicitud();

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, tipoSolicitud.getDescripcion());
            
            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Tipo de Solicitud actualizado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar el tipo de solicitud.");
        }
    }

    @Override
    public void eliminarTipoSolicitud(int idTipoSolicitud) {
        // Query SQL para eliminar una solicitud por su ID
        String sql = "DELETE FROM TIPO_SOLICITUD WHERE IdTipoSolicitud = ? " ;

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID de la solicitud)
            statement.setInt(1, idTipoSolicitud);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Tipo de solicitud eliminada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar el tipo de solicitud.");
        }
    }

    @Override
    public List<TipoSolicitud> obtenerTodosLosTiposSolicitudes() {
        List<TipoSolicitud> tipoSolicitudes = new ArrayList<>();
        // Query SQL para obtener todas las solicitudes
        String sql = "SELECT * FROM TIPO_SOLICITUD";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y crear objetos Solicitud
            while (resultSet.next()) {
                TipoSolicitud tipoSolicitud = new TipoSolicitud(
                        resultSet.getInt("IdTipoSolicitud"),
                        resultSet.getString("Descripcion"));
                // Agregar la solicitud a la lista
                tipoSolicitudes.add(tipoSolicitud);
            }

            // Cerrar el resultado y la declaración
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener todos los tipo de solicitud.");
        }

        return tipoSolicitudes;
    }

}
