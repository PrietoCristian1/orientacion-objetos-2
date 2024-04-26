package tp4.ejercicio1.main;

import tp4.ejercicio1.database.JdbcRegistroDeParticipante;
import tp4.ejercicio1.model.DefaultConcurso;
import tp4.ejercicio1.ui.AgregarParticipanteView;

import java.awt.*;
import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/concursosdb";

    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws SQLException {
        inicializarDatabase();
        launchApplication();
    }

    private static void launchApplication() {
        EventQueue.invokeLater(() -> {
            try {
                JdbcRegistroDeParticipante jdbcRegistroDeParticipante = new JdbcRegistroDeParticipante(URL, USER, PASSWORD);
                DefaultConcurso concurso = new DefaultConcurso(jdbcRegistroDeParticipante);
                new AgregarParticipanteView(concurso);
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }

    private static void inicializarDatabase() {
        var jdbc = new SetUpDatabase(USER, PASSWORD, URL);
        jdbc.inicializar();
    }
}
