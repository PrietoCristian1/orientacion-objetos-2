package tp4.ejercicio1.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    private final String username;
    private final String password;
    private final String conn;
    private Connection connection;

    public Conn(String username, String password, String conn) {
        this.username = username;
        this.password = password;
        this.conn = conn;
    }

    Connection open() {
        try {
            return DriverManager.getConnection(this.conn, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
