package academy.mindswap.commitAir.controller;

import academy.mindswap.commitAir.dto.AirportDto;
import academy.mindswap.commitAir.service.AirportService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    @Cacheable(value = "getAllAirports")
    public List<AirportDto> getAllAirports() throws JsonProcessingException {
        List<AirportDto> airports = airportService.getAllAirports();
        return airports;
    }
}
