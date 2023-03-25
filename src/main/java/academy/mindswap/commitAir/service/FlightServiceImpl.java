package academy.mindswap.commitAir.service;


import academy.mindswap.commitAir.dto.FlightDto;
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
public class FlightServiceImpl implements FlightService{


    RestTemplate restTemplate = new RestTemplate();

    ObjectMapper objectMapper = new ObjectMapper();


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
        FlightDto flightDto =  objectMapper.readValue(response.toString(), new TypeReference<FlightDto>() {});



       /* ResponseEntity<Flight> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, Flight.class);
        if(responseEntity.getStatusCode().isError()){
            throw new Error();
        }

        */




        return flightDto;
    }
}
