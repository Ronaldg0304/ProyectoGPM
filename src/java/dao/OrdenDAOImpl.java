/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import recursos.DBConnection;
import model.Orden;

public class OrdenDAOImpl implements OrdenDAO {

    // Método para obtener una conexión a la base de datos
    private Connection conexion = DBConnection.getConnection();

    // Implementación de los métodos de la interfaz ordenesDAO
    @Override
    public void crearOrden(Orden orden) {
        // Query SQL para insertar una nueva solicitud
        String sql = "INSERT INTO ORDENES (Responsable, IdEstado, FechaInicioOt, FechaFinOt, IdEquipo, IdSolicitud, IdOperatividad ) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, orden.getResponsable());
            statement.setInt(2, orden.getIdEstado());
            statement.setDate(3, new java.sql.Date(orden.getFechaInicioOt().getTime()));
            statement.setDate(4, null);
            statement.setInt(5, orden.getIdEquipo());
            statement.setInt(6, orden.getIdSolicitud());
            statement.setInt(7, orden.getIdOperatividad());
            

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración y la conexión
            statement.close();

            System.out.println("Orden creada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al crear la orden.");
        }
    }

    @Override
    public Orden obtenerOrden(int idOrden) {
        // Query SQL para obtener una solicitud por su ID
        String sql = "SELECT * FROM ORDENES WHERE IdOt = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID de la solicitud)
            statement.setInt(1, idOrden);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró una orden
            if (resultSet.next()) {
                // Crear un objeto Orden con los datos obtenidos de la base de datos
                Orden orden = new Orden(
                        resultSet.getInt("IdOt"),
                        resultSet.getString("Responsable"),
                        resultSet.getInt("IdEstado"),
                        resultSet.getDate("FechaInicioOt"),
                        resultSet.getDate("FechaFinOt"),
                        resultSet.getInt("IdEquipo"),
                        resultSet.getInt("IdSolicitud"),
                        resultSet.getInt("IdOperatividad")
                );

                // Cerrar el resultado y la declaración
                resultSet.close();
                statement.close();
                // Retornar la solicitud obtenida
                return orden;
            }

            // Si no se encontró la solicitud, retornar null
            statement.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener la orden.");
            return null;
        }
    }

    @Override
    public void actualizarOrden(Orden orden) {
        // Query SQL para actualizar una orden
        String sql = "UPDATE ORDENES SET Responsable = ?, IdEstado = ?, "
                + "FechaInicioOt = ?, FechaFinOt = ?, IdEquipo = ?,  "
                + " IdOperatividad = ?, IdSolicitud = ? WHERE IdOt = " + orden.getIdOt();

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, orden.getResponsable());
            statement.setInt(2, orden.getIdEstado());
            statement.setDate(4, new java.sql.Date(orden.getFechaInicioOt().getTime()));
            statement.setDate(5, null);
            statement.setInt(6, orden.getIdOperatividad());
            statement.setInt(7, orden.getIdEquipo());
            statement.setInt(8, orden.getIdOperatividad());
            statement.setInt(9, orden.getIdSolicitud());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Orden actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar la orden.");
        }
    }

    @Override
    public void eliminarOrden(int idOrden) {
        // Query SQL para eliminar una solicitud por su ID
        String sql = "DELETE FROM ORDENES WHERE IdOt = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID de la solicitud)
            statement.setInt(1, idOrden);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Orden eliminada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar la orden.");
        }
    }

    @Override
    public List<Orden> obtenerTodasLasOrdenes() {
        List<Orden> ordenes = new ArrayList<>();
        // Query SQL para obtener todas las solicitudes
        String sql = "SELECT * FROM ORDENES ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y crear objetos Solicitud
            while (resultSet.next()) {
                Orden orden = new Orden(
                        resultSet.getInt("IdOt"),
                        resultSet.getString("Responsable"),
                        resultSet.getInt("IdEstado"),
                        resultSet.getDate("FechaInicioOt"),
                        resultSet.getDate("FechaFinOt"),
                        resultSet.getInt("IdEquipo"),
                        resultSet.getInt("IdSolicitud"),
                        resultSet.getInt("IdOperatividad")
                );
                // Agregar la solicitud a la lista
                ordenes.add(orden);
            }

            // Cerrar el resultado y la declaración
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener todas las ordenes.");
        }

        return ordenes;
    }

    public List<Orden> obtenerOrdenByIdSolicitud(int idSolicitud) {
        List<Orden> ordenes = new ArrayList<>();
        // Query SQL para obtener una solicitud por su ID
        String sql = "SELECT * FROM ORDENES WHERE IdSolicitud = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID de la solicitud)
            statement.setInt(1, idSolicitud);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró una orden
            while (resultSet.next()) {
                // Crear un objeto Orden con los datos obtenidos de la base de datos
                Orden orden = new Orden(
                        resultSet.getInt("IdOt"),
                        resultSet.getString("Responsable"),
                        resultSet.getInt("IdEstado"),
                        resultSet.getDate("FechaInicioOt"),
                        resultSet.getDate("FechaFinOt"),
                        resultSet.getInt("IdEquipo"),
                        resultSet.getInt("IdSolicitud"),
                        resultSet.getInt("IdOperatividad")
                );

                ordenes.add(orden);
            }
            // Cerrar el resultado y la declaración
            resultSet.close();
            statement.close();
            // Retornar la solicitud obtenida

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener la orden.");
            return null;
        }

        return ordenes;

// Implementación de los métodos CRUD utilizando JDBC o algún ORM
    }
    public Orden obtenerOrdenByIdEquipo(int idOrden) {
        // Query SQL para obtener una solicitud por su ID
        String sql = "SELECT * FROM ORDENES WHERE IdOt = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID de la solicitud)
            statement.setInt(1, idOrden);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró una orden
            if (resultSet.next()) {
                // Crear un objeto Orden con los datos obtenidos de la base de datos
                Orden orden = new Orden(
                        resultSet.getInt("IdOt"),
                        resultSet.getString("Responsable"),
                        resultSet.getInt("IdEstado"),
                        resultSet.getDate("FechaInicioOt"),
                        resultSet.getDate("FechaFinOt"),
                        resultSet.getInt("IdEquipo"),
                        resultSet.getInt("IdSolicitud"),
                        resultSet.getInt("IdOperatividad")
                );

                // Cerrar el resultado y la declaración
                resultSet.close();
                statement.close();
                // Retornar la solicitud obtenida
                return orden;
            }

            // Si no se encontró la solicitud, retornar null
            statement.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener la orden.");
            return null;
        }
    }
}
