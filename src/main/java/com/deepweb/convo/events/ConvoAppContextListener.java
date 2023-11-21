package com.deepweb.convo.events;

import com.deepweb.convo.service.ImportFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ConvoAppContextListener implements ApplicationRunner {

    @Autowired
    private ImportFile csvFileImporter;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        csvFileImporter.doImport();
    }
}
