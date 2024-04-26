package tp4.ejercicio3.main;

import tp4.ejercicio2.model.ProveedorDeFechasReal;
import tp4.ejercicio3.database.EnArchivoRegistroDeConcurso;
import tp4.ejercicio3.database.EnArchivoRegistroDeParticipante;
import tp4.ejercicio3.model.DefaultRadioCompetition;
import tp4.ejercicio3.ui.AgregarParticipanteView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new Main().start();
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }

    private void start() {
        new AgregarParticipanteView(new DefaultRadioCompetition(new EnArchivoRegistroDeConcurso(), new ProveedorDeFechasReal(), new EnArchivoRegistroDeParticipante()));
    }
}

