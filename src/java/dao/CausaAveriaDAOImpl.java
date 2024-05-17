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
import model.CausaAveria;

public class CausaAveriaDAOImpl implements CausaAveriaDAO {
    
    // Método para obtener una conexión a la base de datos
    private Connection conexion = DBConnection.getConnection();

    @Override
    public void crearCausaAveria(CausaAveria causaAveria) {
      // Query SQL para insertar una nueva solicitud
        String sql = "INSERT INTO CAUSA_AVERIAS(Descripcion) "
                + "VALUES (?)";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, causaAveria.getDescripcion());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración y la conexión
            statement.close();
            conexion.close();

            System.out.println("Causa avería agregado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al agregar la causa avería.");
        }
    }

    @Override
    public CausaAveria obtenerCausaAveria(int idCausaAveria) {
       // Query SQL para obtener una solicitud por su ID
        String sql = "SELECT * FROM CAUSA_AVERIAS WHERE idCausaAveria = ?";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID del tipo_solicitud)
            statement.setInt(1, idCausaAveria);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró una solicitud
            if (resultSet.next()) {
                // Crear un objeto Tipo_Solicitud con los datos obtenidos de la base de datos
                CausaAveria averia = new CausaAveria(
                        resultSet.getInt("IdCausaAveria"),
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
            System.out.println("Error al obtener la causa averia indicada.");
            return null;
        }
    }

    @Override
    public void actualizarCausaAveria(CausaAveria causaAveria) {
      // Query SQL para actualizar una solicitud
        String sql = "UPDATE CAUSA_AVERIAS SET Descripcion = ? WHERE IdCausaAveria = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, causaAveria.getDescripcion());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Causa Averia actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar la causa averia.");
        }
    }

    @Override
    public void eliminarCausaAveria(int idCausaAveria) {
       // Query SQL para eliminar una solicitud por su ID
        String sql = "DELETE FROM CAUSA_AVERIAS WHERE idCausaAveria = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID de la solicitud)
            statement.setInt(1, idCausaAveria);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Causa avería eliminada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminarla  causa avería.");
        }
    }

    @Override
    public List<CausaAveria> obtenerTodasLasCausasAverias() {
        List<CausaAveria> causaAverias = new ArrayList<>();
        // Query SQL para obtener todas las solicitudes
        String sql = "SELECT * FROM CAUSA_AVERIAS";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y crear objetos Solicitud
            while (resultSet.next()) {
                CausaAveria causaAveria = new CausaAveria(
                        resultSet.getInt("IdCausaAveria"),
                        resultSet.getString("Descripcion"));
                // Agregar la solicitud a la lista
                causaAverias.add(causaAveria);
            }

            // Cerrar el resultado y la declaración
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener todas las causas averías.");
        }

        return causaAverias;
    }
    // Implementación de los métodos CRUD utilizando JDBC o algún ORM
}

