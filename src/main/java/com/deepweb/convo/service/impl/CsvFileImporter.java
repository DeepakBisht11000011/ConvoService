package com.deepweb.convo.service.impl;

import com.deepweb.convo.exception.ConvoFileImportException;
import com.deepweb.convo.service.ImportFile;
import com.deepweb.convo.service.RecordConverterService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CsvFileImporter implements ImportFile {

    private static final String COMMA_DELIMITER = ",";
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private RecordConverterService netflixRecordConverterService;

    @Override
    public boolean importFile() throws ConvoFileImportException {
        System.out.println("Hello");
//        firstWayOfReading();
        try {
            secondWayOfReading();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    private void secondWayOfReading() throws FileNotFoundException, IOException, CsvException {
        Resource resource = resourceLoader.getResource("classpath:/static/data/netflix_titles.csv");
        CSVReader reader = new CSVReader(new FileReader(resource.getFile()));
        List<List<String>> records = new ArrayList<List<String>>();
        String[] values = null;
        reader.skip(1);
//        values = reader.readNext();
//        records.add(Arrays.asList(values));
        while ((values = reader.readNext()) != null) {
            netflixRecordConverterService.convert(values);
            System.out.println(Arrays.toString(values));
        }
    }

    private void firstWayOfReading() {
        List<List<String>> records = new ArrayList<>();
        Resource resource = resourceLoader.getResource("classpath:/static/data/netflix_titles.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
