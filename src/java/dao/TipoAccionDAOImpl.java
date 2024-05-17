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
import recursos.DBConnection;
import java.util.List;
import model.TipoAccion;

public class TipoAccionDAOImpl implements TipoAccionDAO {
    
    // Método para obtener una conexión a la base de datos
    private Connection conexion = DBConnection.getConnection();

    @Override
    public void crearTipoAccion(TipoAccion tipoAccion) {
      // Query SQL para insertar una nueva solicitud
        String sql = "INSERT INTO TIPO_ACCION(Descripcion) "
                + "VALUES (?)";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, tipoAccion.getDescripcion());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración y la conexión
            statement.close();
            conexion.close();

            System.out.println("Tipo acción agregado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al agregar el tipo acción.");
        }
    }

    @Override
    public TipoAccion obtenerTipoAccion(int idTipoAccion) {
        // Query SQL para obtener una solicitud por su ID
        String sql = "SELECT * FROM TIPO_ACCION WHERE idTipoAccion = ?";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID del tipo_solicitud)
            statement.setInt(1, idTipoAccion);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró una solicitud
            if (resultSet.next()) {
                // Crear un objeto Tipo_Solicitud con los datos obtenidos de la base de datos
                TipoAccion tipoAccion= new TipoAccion(
                        resultSet.getInt("IdTipoAccion"),
                        resultSet.getString("Descripcion")
                );

                // Cerrar el resultado y la declaración
                resultSet.close();
                statement.close();

                return tipoAccion;
            }

            statement.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener el tipo de acción.");
            return null;
        }
    }

    @Override
    public void actualizarTipoAccion(TipoAccion tipoAccion) {
        // Query SQL para actualizar una solicitud
        String sql = "UPDATE TIPO_ACCION SET Descripcion = ? WHERE IdTipoAccion = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, tipoAccion.getDescripcion());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Tipo de acción actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar el tipo de acción.");
        }
    }

    @Override
    public void eliminarTipoAccion(int idTipoAccion) {
        // Query SQL para eliminar una solicitud por su ID
        String sql = "DELETE FROM TIPO_ACCION WHERE IdTipoAccion = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID de la solicitud)
            statement.setInt(1, idTipoAccion);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Tipo de acción eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminarla el tipo de acción.");
        }
    }

    @Override
    public List<TipoAccion> obtenerTodosLosTiposAcciones() {
        List<TipoAccion> tipoAcciones = new ArrayList<>();
        // Query SQL para obtener todas las solicitudes
        String sql = "SELECT * FROM TIPO_ACCION";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y crear objetos Solicitud
            while (resultSet.next()) {
                TipoAccion tipoAccion = new TipoAccion(
                        resultSet.getInt("IdTipoAccion"),
                        resultSet.getString("Descripcion"));
                // Agregar la solicitud a la lista
                tipoAcciones.add(tipoAccion);
            }

            // Cerrar el resultado y la declaración
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener todos las acciones.");
        }

        return tipoAcciones;
    }
    // Implementación de los métodos CRUD utilizando JDBC o algún ORM
}

