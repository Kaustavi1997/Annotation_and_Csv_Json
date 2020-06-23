package com.bridgelabz;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.CsvToBean;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class OpenCsvAndGsonTester {
    private static final String SAMPLE_CSV_FILE_PATH = "./records.csv";
    private static final String SAMPLE_JSON_FILE_PATH = "./records.json";

    public static void main(String[] args) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CsvToBeanBuilder<CSVUser> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CSVUser.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVUser> csvToBean = csvToBeanBuilder.build();
            List<CSVUser> csvUsers = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
            CSVUser[] usrobj = gson.fromJson(br,CSVUser[].class);
            List<CSVUser> csvUserList = Arrays.asList(usrobj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
