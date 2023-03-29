package academy.mindswap.commitAir.controller;

import academy.mindswap.commitAir.dto.AirportDto;
import academy.mindswap.commitAir.service.AirportService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


        return null;
    }
}
