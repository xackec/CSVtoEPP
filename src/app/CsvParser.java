package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CsvParser {

    public static List<AbstractTag> parse(String path) {
        String line = "";
        String cvsSplitBy = ";";
        List<AbstractTag> result = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                String[] tag = line.split(cvsSplitBy);
                if(tag[0].equals("D")) {
                    result.add(new OpcDiscreteItem(tag));
                } else if(tag[0].equals("A")) {
                    result.add(new OpcAnalogItem(tag));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
