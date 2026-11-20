package catalogouasd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/CatalogoUASD";
    private static final String USER = "root";
    private static final String PASSWORD = "ronald849";

    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa con MySQL.");
            return conexion;
        } catch (SQLException e) {
            System.out.println("Error al conectar con MySQL: " + e.getMessage());
            return null;
        }
    }
}