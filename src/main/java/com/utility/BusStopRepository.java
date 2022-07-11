package com.utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.BusStop;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Component
public class BusStopRepository {
    public static List<BusStop> busStops;

    @Bean
    public void mapBusStops() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<BusStop> mappedBusStops = mapper.readValue(Paths.get("resources/stops.json").toFile(), new TypeReference<List<BusStop>>() {
        });

        busStops = mappedBusStops;
    }

}

