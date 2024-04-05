package tp1.punto2.persistencia;

import tp1.punto2.modelo.RegistroDeCosto;

import java.sql.*;

public class EnBaseDeDatosRegistroDeCosto implements RegistroDeCosto {
    private static final String URL = "jdbc:mysql://localhost:3306/concursosypedidosdb";

    private static final String USER = "root";
    private static final String PASSWORD = "";

    @Override
    public void registrar(String registro) {
        String sql = "INSERT INTO registrodecosto (fecha, monto) VALUES (?, ?)";

        // Separa la informacion del registro
        String[] partes = registro.split("\\|\\|");
        String fecha = partes[0];
        String montoStr = partes[1];
        double monto = Double.parseDouble(montoStr);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fecha);
            pstmt.setDouble(2, monto);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo persistir...", e);
        }
    }

    @Override
    public String contenido() {
        String resultado = null;
        String sql = "SELECT fecha, monto FROM registrodecosto ORDER BY fecha DESC LIMIT 1";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            // Verifica si la consulta devuelve algún resultado
            if (rs.next()) {
                // Obtiene la fecha y el monto del primer resultado (que será el último registro agregado)
                String fecha = rs.getString("fecha");
                double monto = rs.getDouble("monto");

                // Construye el string de resultado
                resultado = fecha + "||" + monto;
            }
        } catch (SQLException e) {
            // Maneja la excepción (puede imprimir el error o lanzar una nueva excepción)
            throw new RuntimeException("No se puedo persistir...", e);
        }

        return resultado;
    }
}
