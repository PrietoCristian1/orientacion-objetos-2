package tp4.ejercicio2.main;

import java.sql.DriverManager;

public class SetUpDatabase {
    private final String username;
    private final String password;
    private final String conn;

    public SetUpDatabase(String username, String password, String conn) {
        this.username = username;
        this.password = password;
        this.conn = conn;
    }

    public void inicializar() {
        try (var connection = DriverManager.getConnection(conn, username, password)) {
            var stmt = connection.createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
