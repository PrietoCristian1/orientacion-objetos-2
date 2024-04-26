package tp4.ejercicio2.ui;

import tp4.ejercicio2.model.Empresa;

import javax.swing.*;
import java.awt.*;

public class AgregarEmpleadoView extends JFrame {
    private JTextField apellidoField;
    private JTextField nombreField;
    private JTextField fechaNacimientoField;
    private JTextField emailField;
    private Empresa empresa;

    public AgregarEmpleadoView(JFrame parent, Empresa empresa) {
        this.empresa = empresa;
        // Configuración de la ventana para agregar empleados
        setTitle("Agregar Empleado");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(parent);

        // Creación de los campos de texto
        apellidoField = new JTextField(10);
        nombreField = new JTextField(10);
        fechaNacimientoField = new JTextField(10);
        emailField = new JTextField(10);

        // Creación de los botones
        JButton agregarButton = new JButton("Agregar");
        JButton cancelarButton = new JButton("Cancelar");

        // Configuración de los eventos de los botones
        agregarButton.addActionListener(e -> agregarEmpleado());

        cancelarButton.addActionListener(e -> dispose());

        // Configuración del layout
        setLayout(new GridLayout(5, 2));

        // Añadir componentes a la ventana de agregar empleados
        add(new JLabel("Apellido:"));
        add(apellidoField);
        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Fecha de Nacimiento:"));
        add(fechaNacimientoField);
        add(new JLabel("Email:"));
        add(emailField);
        add(agregarButton);
        add(cancelarButton);
    }

    private void agregarEmpleado() {
        String apellido = apellidoField.getText();
        String nombre = nombreField.getText();
        String fechaNacimiento = fechaNacimientoField.getText();
        String email = emailField.getText();
        try {
            empresa.cargarEmpleado(apellido, nombre, fechaNacimiento, email);
            dispose();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

