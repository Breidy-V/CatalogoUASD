package catalogouasd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarreraDAO {

    public void listarCarreras(int escuelaId) {
        String sql = "SELECT Carreraid, Nombre FROM Carreras WHERE Escuelaid = ? ORDER BY Nombre";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, escuelaId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(
                        rs.getInt("Carreraid") + " - " +
                        rs.getString("Nombre")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar carreras: " + e.getMessage());
        }
    }
}