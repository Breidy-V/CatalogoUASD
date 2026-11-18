package catalogouasd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultadDAO {

    public void listarFacultades() {
        String sql = "SELECT Facultadid, Nombre FROM Facultades ORDER BY Nombre";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                    rs.getInt("Facultadid") + " - " +
                    rs.getString("Nombre")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar facultades: " + e.getMessage());
        }
    }
}