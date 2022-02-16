package com.news;

import java.io.PrintWriter;
import java.util.List;

import static com.news.DataProcessor.endApplication;

public class FileWriter {

    public static void writeFile(List<String> articlesData, String fileName) {
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            for (String dataLine : articlesData) {
                printWriter.println(dataLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        endApplication();
    }
}
