package com.deepweb.convo.service;

import com.deepweb.convo.exception.ConvoFileImportException;

import java.util.concurrent.*;

public interface ImportFile {

    default void doImport() {
        // Start parallel thread and call importFile.
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<Boolean> callableTask = this::importFile;
        Future<Boolean> result = null;
        try {
            result = executorService.submit(callableTask);
            System.out.println("Result: is import of file successful? " + result.get());
        } catch (InterruptedException e) {
            System.out.println("ex:" + e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    boolean importFile() throws ConvoFileImportException;
}
