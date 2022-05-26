package br.ufes.inf.jpalmeida.owid;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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
                String male = record.get(3);
                String female = record.get(4);
                System.out.printf("%s %s: %d %s - %s\n", code, entity, year, male, female);
                data d = new data(entity, code, year, male, female);
                v.add(d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return v;
    }

    public void getExpectativaPorPais(Integer[] datas) {
        ;
    }
    public static void main( String[] args )
    {
        Vector<data> v = readFileCSV("resources/file.csv");
    }
}