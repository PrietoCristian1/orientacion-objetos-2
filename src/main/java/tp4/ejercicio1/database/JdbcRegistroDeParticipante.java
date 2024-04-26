package tp4.ejercicio1.database;

import tp4.ejercicio1.model.RegistroDeParticipantes;

import java.sql.SQLException;

public class JdbcRegistroDeParticipante implements RegistroDeParticipantes {
    private final Conn conn;

    public JdbcRegistroDeParticipante(String conn, String username, String password) {
        this.conn = new Conn(username, password, conn);
    }

    @Override
    public void cargarParticipante(String nombre, String telefono, String region) {
        try (var conexion = this.conn.open(); var stmt = conexion.prepareStatement(
                "INSERT INTO participantes (nombre, telefono, region) " + "VALUES (?, ?, ?)")) {
            stmt.setString(1, nombre);
            stmt.setString(2, telefono);
            stmt.setString(3, region);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
