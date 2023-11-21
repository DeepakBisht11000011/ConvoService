package com.deepweb.convo.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConvoFileImportException extends Exception {
    ConvoFileImportException(String message) {
        super(message, null);
    }

    ConvoFileImportException(String message, Throwable cause) {
        super(message, cause);
    }
}
