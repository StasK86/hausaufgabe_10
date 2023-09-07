package com.krigersv;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.krigersv.model.ModelJson;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.assertj.core.api.Assertions.assertThat;

public class FilesTest {
    private static String jsonFile = ".json";
    private static ClassLoader cl = ModelJson.class.getClassLoader();
    private static ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream(jsonFile);
             Reader reader = new InputStreamReader(stream)) {

            ModelJson model = objectMapper.readValue(reader, ModelJson.class);


            assertThat(model.getFirstName()).isEqualTo("Britney");
            assertThat(model.getLastName()).isEqualTo("Spears");
            assertThat(model.getDateOfBirth()).isEqualTo("02 December 1981");
            assertThat(model.getPhoneNumber()).isEqualTo("7234567890");
            assertThat(model.getEmail()).isEqualTo("britneyspears@gmail.com");
            assertThat(model.getCurrentAddress()).isEqualTo("Las Vegas");
            assertThat(model.getHobbies()).contains("Music");
        }
    }
}
