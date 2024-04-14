package tp3.ejercicio2;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorCsv {
    private final String csvPath;

    public LectorCsv(String csvPath) {
        this.csvPath = csvPath;
    }

    public List<String[]> createList() throws IOException, CsvValidationException {
        List<String[]> csvData = new ArrayList<String[]>();
        CSVReader reader = new CSVReader(new FileReader(csvPath));
        String[] row = null;

        while ((row = reader.readNext()) != null) {
            csvData.add(row);
        }

        reader.close();
        csvData.remove(0);
        return csvData;
    }
}
