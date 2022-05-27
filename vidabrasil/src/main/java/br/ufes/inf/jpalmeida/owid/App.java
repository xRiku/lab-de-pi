package br.ufes.inf.jpalmeida.owid;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.Vector;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * Hello world!
 *
 */
public class App 
{

    static public Vector<data> readFileCSV(String file) {
        Vector<data> v = new Vector<data>();
        try {
            Reader in = new FileReader(file);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            for (CSVRecord record : records) {
                String entity = record.get(0);
                String code = record.get(1);
                Integer year = Integer.parseInt(record.get(2));
                Double male = Double.parseDouble(record.get(3));
                Double female = Double.parseDouble(record.get(4));
                // System.out.printf("%s %s: %d %s - %s\n", code, entity, year, male, female);
                data d = new data(entity, code, year, male, female);
                v.add(d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return v;
    }

    static public void getExpectativaPorPaisEmUmAno(Vector<data> dt, Integer n) {
        Vector<data> ndt = new Vector<data>();
        for(data d: dt) {
            // System.out.println(n.equals(d.getYear()));
            if (n.equals(d.getYear())) {
                ndt.add(d);
            }
            // System.out.println(d.entity);
        }
        Collections.sort(ndt);
        for(data nd: ndt) {
            System.out.printf("%s: %.2f - %.2f\n", nd.getEntity(), nd.getMale(), nd.getFemale());
        }
    }
    public static void main( String[] args )
    {
        Vector<data> dt = readFileCSV("resources/file.csv");
        getExpectativaPorPaisEmUmAno(dt, 2020);
        
    }
}