package tp4.ejercicio2.main;

import tp4.ejercicio2.database.EnArchivoRegistroDeEmpleado;
import tp4.ejercicio2.mailservice.JakartaEmail;
import tp4.ejercicio2.model.DefaultEmpresa;
import tp4.ejercicio2.model.ProveedorDeFechasReal;
import tp4.ejercicio2.ui.GestionDeEmpleadosView;

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
                EnArchivoRegistroDeEmpleado enArchivoRegistroDeEmpleado = new EnArchivoRegistroDeEmpleado();
                JakartaEmail jakartaEmail = new JakartaEmail();
                DefaultEmpresa empresa = new DefaultEmpresa(enArchivoRegistroDeEmpleado, jakartaEmail, "empresa@gmail.com", new ProveedorDeFechasReal());
                new GestionDeEmpleadosView(empresa);
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
