package me.randomuser.out.user;

import java.io.File;
import java.util.Collections;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserRepositoryImpl implements UserRepository {

    private List<UserInterface> list = null;

    public UserRepositoryImpl() {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource("MOCK_DATA.csv").getFile();
            MappingIterator<UserInterface> readValues = 
              mapper.readerFor(UserInterface.class).with(bootstrapSchema).readValues(file);
            list = readValues.readAll();
        } catch (Exception e) {
            log.error("error while load resource : ", e);
            list =  Collections.emptyList();
        }
    }

    @Override
    public UserInterface get(int id) {
        return list.get(id);
    }
    
}
