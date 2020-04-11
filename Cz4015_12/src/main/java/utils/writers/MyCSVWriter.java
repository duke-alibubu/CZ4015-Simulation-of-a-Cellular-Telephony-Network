package utils.writers;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;

public class MyCSVWriter {
    private static final String OUTPUT_BASE_PATH = "D:/My Folder/Academic/Year 3 Sem 2/CZ4015 Simulation & Modeling/Assignment/Cz4015_12/src/main/resources/output";
    private String outputFilePath;
    private CSVWriter writer;

    public MyCSVWriter(String fileName){
        outputFilePath = OUTPUT_BASE_PATH + "/" + fileName + ".csv";
        try {
            writer = new CSVWriter(new FileWriter(new File(outputFilePath)));
        }
        catch (Exception e){
            System.out.println("Cannot create CSV Writer!");
        }

    }

    public void writeDataToCSV(double droppedPercentage, double blockedPercentage, double time){
        String[] data = {String.valueOf(droppedPercentage), String.valueOf(blockedPercentage), String.valueOf(time)};
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
