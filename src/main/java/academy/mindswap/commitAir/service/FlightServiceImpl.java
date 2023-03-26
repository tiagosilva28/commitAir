package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.FlightDto;
import academy.mindswap.commitAir.exception.IdNotExist;
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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService{

    RestTemplate restTemplate = new RestTemplate();

    ObjectMapper objectMapper = new ObjectMapper();
    FlightRepository flightRepository;

    FlightMapper flightMapper;
    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }

    @Override
    public List<FlightDto> getAllFlightsFromAirport(String depIata) throws JsonProcessingException {
        String uri = "https://airlabs.co/api/v9/schedules?dep_iata=" + depIata + "&api_key=51458100-5a17-4b86-a9f4-1388f74b5454";
        ResponseEntity<String> entity = restTemplate.exchange(uri,HttpMethod.GET,null, String.class);
        JsonNode root = objectMapper.readTree(entity.getBody());
        JsonNode response = root.path("response");
        List<FlightDto> flights = objectMapper.readValue(response.toString(), new TypeReference<List<FlightDto>>() {});
        return flights;
    }

    @Override
    public FlightDto getFlightById(String flightIata) throws JsonProcessingException {

        String uri = "https://airlabs.co/api/v9/flight?flight_iata=" + flightIata + "&api_key=51458100-5a17-4b86-a9f4-1388f74b5454";

        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);
        JsonNode root = objectMapper.readTree(responseEntity.getBody());
        JsonNode response = root.path("response");

        if(root.path("error").path("message").equals("Flight not found")){
            throw new IdNotExist("Flight not found");
        }

        /*if (response.path("error").equals("Flight not found")) {
            throw new IdNotExist("Flight not found");
        }*/

        FlightDto flightDto = objectMapper.readValue(response.toString(), new TypeReference<FlightDto>() {});

        Flight flight = flightMapper.fromDtoToEntity(flightDto);


        flightRepository.save(flight);

       /* ResponseEntity<Flight> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, Flight.class);
        if(responseEntity.getStatusCode().isError()){
            throw new Error();
        }
        */

        return flightDto;
    }

    @Override
    public FlightDto getFlightByDate(String flightDate) {


        return null;
    }
}
