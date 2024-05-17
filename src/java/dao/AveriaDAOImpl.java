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
import model.Averia;

public class AveriaDAOImpl implements AveriaDAO {
    
     // Método para obtener una conexión a la base de datos
    private Connection conexion = DBConnection.getConnection();

    @Override
    public void crearAveria(Averia averia) {
      // Query SQL para insertar una nueva solicitud
        String sql = "INSERT INTO AVERIAS(Descripcion) "
                + "VALUES (?)";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, averia.getDescripcion());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración y la conexión
            statement.close();
            conexion.close();

            System.out.println("Avería agregado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al agregar la avería.");
        }
    }

    @Override
    public Averia obtenerAveria(int idAveria) {
        // Query SQL para obtener una solicitud por su ID
        String sql = "SELECT * FROM AVERIAS WHERE IdAveria = ?";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID del tipo_solicitud)
            statement.setInt(1, idAveria);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró una solicitud
            if (resultSet.next()) {
                // Crear un objeto Tipo_Solicitud con los datos obtenidos de la base de datos
                Averia averia = new Averia(
                        resultSet.getInt("IdAveria"),
                        resultSet.getString("Descripcion")
                );

                // Cerrar el resultado y la declaración
                resultSet.close();
                statement.close();

                return averia;
            }

            statement.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener la averia indicada.");
            return null;
        }
    }

    @Override
    public void actualizarAveria(Averia averia) {
        // Query SQL para actualizar una solicitud
        String sql = "UPDATE AVERIA SET Descripcion = ? WHERE IdAveria = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, averia.getDescripcion());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Avería actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar la avería.");
        }
    }

    @Override
    public void eliminarAveria(int idAveria) {
       // Query SQL para eliminar una solicitud por su ID
        String sql = "DELETE FROM AVERIAS WHERE IdAveria = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID de la solicitud)
            statement.setInt(1, idAveria);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Avería eliminada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminarla avería.");
        }
    }

    @Override
    public List<Averia> obtenerTodasLasAverias() {
        List<Averia> averias = new ArrayList<>();
        // Query SQL para obtener todas las solicitudes
        String sql = "SELECT * FROM AVERIAS";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y crear objetos Solicitud
            while (resultSet.next()) {
                Averia averia = new Averia(
                        resultSet.getInt("IdAveria"),
                        resultSet.getString("Descripcion"));
                // Agregar la solicitud a la lista
                averias.add(averia);
            }

            // Cerrar el resultado y la declaración
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener todos las averías.");
        }

        return averias;
    }
    
    // Implementación de los métodos CRUD utilizando JDBC o algún ORM
}

