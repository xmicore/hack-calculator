package de.pmrd.hackcalculator.example;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ExampleService {

    private static final String DATE_FORMAT_PATTERN = "dd.MM.yyyy HH:mm:ss";

    private final SimpleDateFormat dateFormat;

    public ExampleService() {
        dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
    }

    String getDateTimeAsString() {
        return dateFormat.format(new Date());
    }

}
