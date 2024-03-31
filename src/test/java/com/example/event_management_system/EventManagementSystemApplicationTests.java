package com.example.event_management_system;

import com.example.event_management_system.Entities.Event;
import com.example.event_management_system.Repository.EventRepository;
import com.github.f4b6a3.ulid.UlidCreator;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootTest
class EventManagementSystemApplicationTests {

    private static final String filePath = "src/main/resources/data.csv";
    private final EventRepository repository;

    @Autowired
    EventManagementSystemApplicationTests(EventRepository repository) {
        this.repository = repository;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void dataEntry(){

        int count = 0;
        try (Reader reader = new FileReader(filePath)) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            for (CSVRecord record : csvParser) {
                if(count == 0){
                    count++;
                    continue;
                }
                Event event = new Event();
                event.setEvent_id(UlidCreator.getUlid().toString());
                event.setEvent_name(record.get(0));
                event.setCity_name(record.get(1));
                String dateString = record.get(2);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                Date date = formatter.parse(dateString);
                event.setDate(date);
                event.setTime(record.get(3));
                event.setLatitude(record.get(4));
                event.setLongitude(record.get(5));
                repository.save(event);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
