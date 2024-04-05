package tp1.punto1.persistencia;

import tp1.punto1.modelo.RegistroDeInscripcion;

import java.sql.*;

public class EnBaseDeDatosRegistroDeInscripcion implements RegistroDeInscripcion {
    private static final String URL = "jdbc:mysql://localhost:3306/concursosypedidosdb";

    private static final String USER = "root";
    private static final String PASSWORD = "";


    @Override
    public void registrar(String registro) {
        String sql = "INSERT INTO registrodeinscripcion (fecha, idParticipante, idConcurso) VALUES (?, ?, ?)";

        // Separa la informacion del registro
        String[] partes = registro.split(",");
        String fecha = partes[0];
        String idParticipanteStr = partes[1];
        String idConcursoStr = partes[2].trim();
        int idParticpante = Integer.parseInt(idParticipanteStr);
        int idConcurso = Integer.parseInt(idConcursoStr);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fecha);
            pstmt.setDouble(2, idParticpante);
            pstmt.setInt(3, idConcurso);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo persistir...", e);
        }
    }

    @Override
    public String contenido() {
        String resultado = null;
        String sql = "SELECT fecha, idParticipante, idConcurso FROM registrodeinscripcion ORDER BY fecha DESC LIMIT 1";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            // Verifica si la consulta devuelve algún resultado
            if (rs.next()) {
                // Obtiene la fecha y el monto del primer resultado (que será el último registro agregado)
                String fecha = rs.getString("fecha");
                int idParticipante = rs.getInt("idParticipante");
                int idConcurso = rs.getInt("idConcurso");
                // Construye el string de resultado
                resultado = fecha + "," + idParticipante + "," + idConcurso;
            }
        } catch (SQLException e) {
            // Maneja la excepción (puede imprimir el error o lanzar una nueva excepción)
            throw new RuntimeException("No se puedo persistir...", e);
        }

        return resultado;
    }
}
