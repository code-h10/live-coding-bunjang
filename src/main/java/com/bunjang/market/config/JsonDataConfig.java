package com.bunjang.market.config;

import com.bunjang.market.service.EventsService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Configuration
public class JsonDataConfig {

    @Bean
    public List<Map> getEventsData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("events.json");
        File file = resource.getFile();
        return objectMapper.readValue(file, new TypeReference<List<Map>>(){});
    }

    @Bean
    public EventsService eventsService() throws IOException {
        return new EventsService(getEventsData());
    }
}
