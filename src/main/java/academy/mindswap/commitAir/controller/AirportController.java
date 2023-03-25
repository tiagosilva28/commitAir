package academy.mindswap.commitAir.controller;

import academy.mindswap.commitAir.dto.AirportDto;
import academy.mindswap.commitAir.dto.CityDto;
import academy.mindswap.commitAir.service.AirportService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {
    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public List<AirportDto> getAirports() throws JsonProcessingException {
        String uri = "https://airlabs.co/api/v9/airports?iata_code=CDG&api_key=YOUR-API-KEY";

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();

        ResponseEntity<AirportDto> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, AirportDto.class);
        JsonNode root = objectMapper.readTree(String.valueOf(responseEntity.getBody()));
        JsonNode response = root.path("response");

        List<AirportDto> airports =  objectMapper.readValue(response.toString(), new TypeReference<List<AirportDto>>() {});


        return airports;
    }
}
