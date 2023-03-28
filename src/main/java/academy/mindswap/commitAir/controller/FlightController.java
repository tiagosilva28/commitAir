package academy.mindswap.commitAir.controller;

import academy.mindswap.commitAir.dto.FlightDto;
import academy.mindswap.commitAir.service.FlightServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightServiceImpl flightService;

    @Autowired
    public FlightController(FlightServiceImpl flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/byAirport/{depIata}")
    public ResponseEntity<List<FlightDto>> getAllFlightsFromAirport(@PathVariable String depIata) throws JsonProcessingException {
        List<FlightDto> flights = flightService.getAllFlightsFromAirport(depIata);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }


    @GetMapping("/{flightIata}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable String flightIata) throws JsonProcessingException {
       /* if (bindingResult.hasErrors()) {


            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
        }

        */
        FlightDto flight = flightService.getFlightById(flightIata);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @GetMapping("/{depIata}/{arrIata}/{depTime}")
    @ResponseStatus(HttpStatus.OK)
    @Cacheable(value = "getAllFlightInformation", key = "#depIata.concat('-').concat(#arrIata).concat('-').concat(#depTime)")
    public List<FlightDto> getAllFlightInformation(@PathVariable String depIata, String arrIata, String depTime) throws JsonProcessingException {
        List<FlightDto> flights = flightService.getAllFlightInformation(depIata, arrIata, depTime);
        return flights;
        //return new ResponseEntity<>(flights, HttpStatus.OK);
    }
}
