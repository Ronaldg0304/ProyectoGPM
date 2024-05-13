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
import recursos.DBConnection;
import model.Estado;

public class EstadoDAOImpl implements EstadoDAO {

    // Método para obtener una conexión a la base de datos
    private Connection conexion = DBConnection.getConnection();

    // Implementación de los métodos de la interfaz Operatividad
    @Override
    public void crearEstado(Estado estado) {
        // Query SQL para insertar una nueva solicitud
        String sql = "INSERT INTO ESTADOS(Descripcion) "
                + "VALUES (?)";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, estado.getDescripcion());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración y la conexión
            statement.close();
            conexion.close();

            System.out.println("Estado agregado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al agregar el estado.");
        }
    }

    @Override
    public Estado obtenerEstado(int idEstado) {
        // Query SQL para obtener una solicitud por su ID
        String sql = "SELECT * FROM ESTADOS WHERE IdEstado = ?";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID del tipo_solicitud)
            statement.setInt(1, idEstado);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró una solicitud
            if (resultSet.next()) {
                // Crear un objeto Tipo_Solicitud con los datos obtenidos de la base de datos
                Estado estado = new Estado(
                        resultSet.getInt("IdEstado"),
                        resultSet.getString("Descripcion")
                );

                // Cerrar el resultado y la declaración
                resultSet.close();
                statement.close();

                return estado;
            }

            statement.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener el estado indicado.");
            return null;
        }
    }

    @Override
    public void actualizarEstado(Estado estado) {
        // Query SQL para actualizar una solicitud
        String sql = "UPDATE ESTADOS SET Descripcion = ? WHERE IdEstado = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, estado.getDescripcion());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Estado actualizado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar el estado.");
        }
    }

    @Override
    public void eliminarEstado(int idEstado) {
        // Query SQL para eliminar una solicitud por su ID
        String sql = "DELETE FROM ESTADOS WHERE IdEstado = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID de la solicitud)
            statement.setInt(1, idEstado);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Estado eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminarla estado.");
        }
    }

    @Override
    public List<Estado> obtenerTodosLosEstados() {
        List<Estado> estados = new ArrayList<>();
        // Query SQL para obtener todas las solicitudes
        String sql = "SELECT * FROM ESTADOS";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y crear objetos Solicitud
            while (resultSet.next()) {
                Estado estado = new Estado(
                        resultSet.getInt("IdEstado"),
                        resultSet.getString("Descripcion"));
                // Agregar la solicitud a la lista
                estados.add(estado);
            }

            // Cerrar el resultado y la declaración
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener todos los estados.");
        }

        return estados;
    }

    // Implementación de los métodos CRUD utilizando JDBC o algún ORM
}
