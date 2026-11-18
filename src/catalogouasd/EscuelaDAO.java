package catalogouasd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EscuelaDAO {

    public void listarEscuelas(int facultadId) {
        String sql = "SELECT Escuelaid, Nombre FROM Escuelas WHERE Facultadid = ? ORDER BY Nombre";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, facultadId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(
                        rs.getInt("Escuelaid") + " - " +
                        rs.getString("Nombre")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar escuelas: " + e.getMessage());
        }
    }
}