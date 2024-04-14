package tp3.ejercicio2;


import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Recaudacion {
    public static final String COMPANY_NAME = "company_name";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String ROUND = "round";
    private final LectorCsv lectorCsv;
    private List<String[]> data;

    public Recaudacion(LectorCsv lectorCsv) {
        this.lectorCsv = lectorCsv;
    }

    public List<Map<String, String>> where(Map<String, String> options)
            throws IOException, CsvValidationException {
        data = this.lectorCsv.createList();

        if (options.containsKey(COMPANY_NAME)) {
            data = filter((fila) -> fila[1].equals(options.get(COMPANY_NAME)));
        }

        if (options.containsKey(CITY)) {
            data = filter((fila) -> (fila[4].equals(options.get(CITY))));
        }

        if (options.containsKey(STATE)) {
            data = filter((fila) -> (fila[5].equals(options.get(STATE))));
        }

        if (options.containsKey(ROUND)) {
            data = filter((fila) -> (fila[9].equals(options.get(ROUND))));
        }

        return transformToListOfHashMap();
    }

    private List<Map<String, String>> transformToListOfHashMap() {
        List<Map<String, String>> output = new ArrayList<Map<String, String>>();

        for (String[] fila : data) {
            Map<String, String> mapped = new HashMap<String, String>();
            mapped.put("permalink", fila[0]);
            mapped.put(COMPANY_NAME, fila[1]);
            mapped.put("number_employees", fila[2]);
            mapped.put("category", fila[3]);
            mapped.put(CITY, fila[4]);
            mapped.put(STATE, fila[5]);
            mapped.put("funded_date", fila[6]);
            mapped.put("raised_amount", fila[7]);
            mapped.put("raised_currency", fila[8]);
            mapped.put(ROUND, fila[9]);
            output.add(mapped);
        }
        return output;
    }

    private List<String[]> filter(Predicate<String[]> predicate) {
        List<String[]> results = new ArrayList<String[]>();

        for (String[] fila : data) {
            if (predicate.test(fila)) {
                results.add(fila);
            }
        }
        return results;
    }
}