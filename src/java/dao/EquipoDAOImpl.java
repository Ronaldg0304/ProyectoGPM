/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Equipo;
import recursos.DBConnection;

public class EquipoDAOImpl implements EquipoDAO {

    // Método para obtener una conexión a la base de datos
    private Connection conexion = DBConnection.getConnection();

    // Implementación de los métodos de la interfaz EquipoDAO
    @Override
    public void crearEquipo(Equipo equipo) {
        // Query SQL para insertar una nueva solicitud
        String sql = "INSERT INTO EQUIPOS (IdEquipo, Fabricante, Modelo, NumeroSerie, FechaFabricacion, IdTipoEquipo) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setInt(1, equipo.getIdEquipo());
            statement.setString(2, equipo.getFabricante());
            statement.setString(3, equipo.getModelo());
            statement.setString(4, equipo.getNumeroSerie());
            statement.setDate(5, (Date) equipo.getFechaFabricacion());
            statement.setInt(6, equipo.getIdTipoEquipo());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración y la conexión
            statement.close();
            conexion.close();

            System.out.println("Equipo creado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al crear el equipo.");
        }
    }

    @Override
    public Equipo obtenerEquipo(int idEquipo) {
        // Query SQL para obtener una solicitud por su ID
        String sql = "SELECT * FROM EQUIPOS WHERE IdEquipo = ?";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID de la solicitud)
            statement.setInt(1, idEquipo);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró una solicitud
            if (resultSet.next()) {
                // Crear un objeto Solicitud con los datos obtenidos de la base de datos
                Equipo equipo = new Equipo(
                        resultSet.getInt("IdEquipo"),
                        resultSet.getString("Fabricante"),
                        resultSet.getString("Modelo"),
                        resultSet.getString("NumeroSerie"),
                        resultSet.getDate("FechaFabricacion"),
                        resultSet.getInt("IdTipoEquipo")
                );

                // Cerrar el resultado y la declaración
                resultSet.close();
                statement.close();
                // Retornar la solicitud obtenida
                return equipo;
            }

            // Si no se encontró la solicitud, retornar null
            statement.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener el equipo indicado.");
            return null;
        }
    }

    @Override
    public void actualizarEquipo(Equipo equipo) {
        // Query SQL para actualizar una solicitud
        String sql = "UPDATE EQUIPOS SET  Fabricante = ?, Modelo = ?, "
                + "NumeroSerie = ?, FechaFabricacion = ?, IdTipoEquipo = ? "
                + " WHERE IdEquipo = " + equipo.getIdEquipo();

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, equipo.getFabricante());
            statement.setString(2, equipo.getModelo());
            statement.setString(3, equipo.getNumeroSerie());
            statement.setDate(4, (Date) equipo.getFechaFabricacion());
            statement.setInt(5, equipo.getIdTipoEquipo());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Equipo actualizado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar el equipo.");
        }
    }

    @Override
    public void eliminarEquipo(int idEquipo) {
        // Query SQL para eliminar una solicitud por su ID
        String sql = "DELETE FROM EQUIPOS WHERE IdEquipo = ?";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID de la solicitud)
            statement.setInt(1, idEquipo);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Equipo eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar el equipo.");
        }
    }

    @Override
    public List<Equipo> obtenerTodosLosEquipos() {
        List<Equipo> equipos = new ArrayList<>();
        // Query SQL para obtener todas las solicitudes
        String sql = "SELECT * FROM EQUIPOS";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y crear objetos Solicitud
            while (resultSet.next()) {
                Equipo equipo = new Equipo(
                        resultSet.getInt("IdEquipo"),
                        resultSet.getString("Fabricante"),
                        resultSet.getString("Modelo"),
                        resultSet.getString("NumeroSerie"),
                        resultSet.getDate("FechaFabricacion"),
                        resultSet.getInt("IdTipoEquipo")
                );
                // Agregar la solicitud a la lista
                equipos.add(equipo);
            }

            // Cerrar el resultado y la declaración
            resultSet.close();
            statement.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener todos los equipos.");
        }

        return equipos;
    }
    

}
