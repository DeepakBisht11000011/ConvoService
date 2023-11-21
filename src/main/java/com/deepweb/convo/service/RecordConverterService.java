package com.deepweb.convo.service;

import com.deepweb.convo.exception.ConvoRecordConversionException;

public interface RecordConverterService {
    boolean convert(String[] values) throws ConvoRecordConversionException;
}
