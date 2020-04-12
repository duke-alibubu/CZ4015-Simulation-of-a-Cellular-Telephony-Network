package utils.writers;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;

public class MyCSVWriter {
    private static final String OUTPUT_BASE_PATH = System.getProperty("user.dir") + "/src/main/resources/output/Full_run";
    private String outputFilePath;
    private CSVWriter writer;

    public MyCSVWriter(String fileName){
        outputFilePath = OUTPUT_BASE_PATH + "/" + fileName + ".csv";
        try {
            writer = new CSVWriter(new FileWriter(new File(outputFilePath)));
            String[] firstLine = {"Dropped Rate", "Blocked Rate", "Number of Calls"};
            writer.writeNext(firstLine);
        }
        catch (Exception e){
            System.out.println("Cannot create CSV Writer!");
        }

    }

    public void writeDataToCSV(double droppedPercentage, double blockedPercentage, int numTotal){
        String[] data = {String.valueOf(droppedPercentage), String.valueOf(blockedPercentage), String.valueOf(numTotal)};
        writer.writeNext(data);
    }

    public void closeCSVWriter(){
        try {
            writer.close();
        }
        catch (Exception e){
            System.out.println("Cannot close CSV Writer!");
        }

    };
}
