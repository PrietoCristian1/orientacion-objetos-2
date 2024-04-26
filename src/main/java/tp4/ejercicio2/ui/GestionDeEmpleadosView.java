package tp4.ejercicio2.ui;

import tp4.ejercicio2.model.Empresa;

import javax.swing.*;
import java.awt.*;

public class GestionDeEmpleadosView extends JFrame {
    private final Empresa empresa;
    private JButton cargarButton;
    private JButton enviarSaludoButton;

    public GestionDeEmpleadosView(Empresa empresa) {
        this.empresa = empresa;
        setupUIComponents();
    }

    public void setupUIComponents() {
        setTitle("Gestión de Empleados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Creación de los botones
        cargarButton = new JButton("Cargar Empleados");
        enviarSaludoButton = new JButton("Enviar Saludo");

        // Configuración de los eventos de los botones
        cargarButton.addActionListener(e -> abrirVentanaAgregarEmpleado());

        enviarSaludoButton.addActionListener(e -> enviarSaludo());

        // Configuración del layout
        setLayout(new FlowLayout());

        // Añadir los botones a la ventana
        add(cargarButton);
        add(enviarSaludoButton);
        setVisible(true);
    }

    private void abrirVentanaAgregarEmpleado() {
        AgregarEmpleadoView agregarEmpleadoView = new AgregarEmpleadoView(this, empresa);
        agregarEmpleadoView.setVisible(true);
    }

    private void enviarSaludo() {
        empresa.enviarSaludos();
    }
}
