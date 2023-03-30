package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.FlightDto;
import academy.mindswap.commitAir.exception.ApiError;
import academy.mindswap.commitAir.mapper.FlightMapper;
import academy.mindswap.commitAir.model.Flight;
import academy.mindswap.commitAir.repository.FlightRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    public String errorMessage;
    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper objectMapper = new ObjectMapper();
    private FlightRepository flightRepository;

    private FlightMapper flightMapper;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }

    @Override
    public List<FlightDto> getAllFlightsFromAirport(String depIata) throws JsonProcessingException {
        String uri = "https://airlabs.co/api/v9/schedules?dep_iata=" + depIata + "&api_key=51458100-5a17-4b86-a9f4-1388f74b5454";
        ResponseEntity<String> entity = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);
        JsonNode root = objectMapper.readTree(entity.getBody());
        JsonNode response = root.path("response");

        if (!root.path("error").isMissingNode()) {
            errorMessage = root.path("error").path("message").toString();
            throw new ApiError("Error from API: " + errorMessage);
        }
        
        List<FlightDto> flights = objectMapper.readValue(response.toString(), new TypeReference<List<FlightDto>>() {
        });
        return flights;
    }

    @Override
    public FlightDto getFlightById(String flightIata) throws JsonProcessingException {

        String uri = "https://airlabs.co/api/v9/flight?flight_iata=" + flightIata + "&api_key=51458100-5a17-4b86-a9f4-1388f74b5454";

        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);
        JsonNode root = objectMapper.readTree(responseEntity.getBody());
        JsonNode response = root.path("response");

        if (!root.path("error").isMissingNode()) {
            errorMessage = root.path("error").path("message").toString();
            throw new ApiError("Error from API: " + errorMessage);
        }

        FlightDto flightDto = objectMapper.readValue(response.toString(), new TypeReference<FlightDto>() {
        });

        Flight flight = flightMapper.fromDtoToEntity(flightDto);

        flightRepository.save(flight);

        return flightDto;
    }

    @Override
    public List<FlightDto> getAllFlightInformation(String depIata, String arrIata, String depTime) throws JsonProcessingException {
        String uri = "https://airlabs.co/api/v9/schedules?api_key=51458100-5a17-4b86-a9f4-1388f74b5454&dep_iata=" + depIata +
                "&arr_iata=" + arrIata +
                "&dep_time=" + depTime +
                "&status=scheduled";

        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);
        JsonNode root = objectMapper.readTree(responseEntity.getBody());
        JsonNode response = root.path("response");

        if (!root.path("error").isMissingNode()) {

            errorMessage = root.path("error").path("message").toString();
            throw new ApiError("Error from API: " + errorMessage);
        }

        List<FlightDto> flightsDto = objectMapper.readValue(response.toString(), new TypeReference<List<FlightDto>>() {
        });

        List<Flight> flights = flightMapper.fromDtoListToEntity(flightsDto);

        flightRepository.saveAll(flights);

        return flightsDto;
    }

}
