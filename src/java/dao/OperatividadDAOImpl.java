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
import model.Operatividad;
import recursos.DBConnection;

public class OperatividadDAOImpl implements OperatividadDAO {

    // Método para obtener una conexión a la base de datos
    private Connection conexion = DBConnection.getConnection();

    // Implementación de los métodos de la interfaz Operatividad
    @Override
    public void crearOperatividad(Operatividad operatividad) {
        // Query SQL para insertar una nueva solicitud
        String sql = "INSERT INTO OPERATIVIDAD (Descripcion) "
                + "VALUES (?)";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, operatividad.getDescripcion());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración y la conexión
            statement.close();
            conexion.close();

            System.out.println("Operatividad agregada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al agregar la operatividad.");
        }
    }

    @Override
    public Operatividad obtenerOperatividad(int idOperatividad) {
        // Query SQL para obtener una solicitud por su ID
        String sql = "SELECT * FROM OPERATIVIDAD WHERE IdOperatividad = ?";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID del tipo_solicitud)
            statement.setInt(1, idOperatividad);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró una solicitud
            if (resultSet.next()) {
                // Crear un objeto Tipo_Solicitud con los datos obtenidos de la base de datos
                Operatividad operativo = new Operatividad(
                        resultSet.getInt("IdOperatividad"),
                        resultSet.getString("Descripcion")
                );

                // Cerrar el resultado y la declaración
                resultSet.close();
                statement.close();

                return operativo;
            }

            statement.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener el operativo indicado.");
            return null;
        }
    }

    @Override
    public void actualizarOperatividad(Operatividad operatividad) {
        // Query SQL para actualizar una solicitud
        String sql = "UPDATE OPERATIVIDAD SET Descripcion = ? WHERE IdTipoSolicitud = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, operatividad.getDescripcion());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Operatividad actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar la operatividad.");
        }
    }

    @Override
    public void eliminarOperatividad(int idOperatividad) {
        // Query SQL para eliminar una solicitud por su ID
        String sql = "DELETE FROM OPERATIVIDAD WHERE IdOperatividad = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID de la solicitud)
            statement.setInt(1, idOperatividad);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Operatividad eliminada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminarla operatividad.");
        }
    }

    @Override
    public List<Operatividad> obtenerTodasLasOperatividades() {
        List<Operatividad> operativos = new ArrayList<>();
        // Query SQL para obtener todas las solicitudes
        String sql = "SELECT * FROM OPERATIVIDAD";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y crear objetos Solicitud
            while (resultSet.next()) {
                Operatividad operativo = new Operatividad(
                        resultSet.getInt("IdOperatividad"),
                        resultSet.getString("Descripcion"));
                // Agregar la solicitud a la lista
                operativos.add(operativo);
            }

            // Cerrar el resultado y la declaración
            resultSet.close();
            statement.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener todos los tipo de solicitud.");
        }

        return operativos;
    }

 }
