package com.deepweb.convo.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConvoRecordConversionException extends RuntimeException {
    ConvoRecordConversionException(String message) {
        super(message, null);
    }

    public ConvoRecordConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}
