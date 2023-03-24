package academy.mindswap.commitAir.service;


import academy.mindswap.commitAir.dto.AirLabsResponseCitiesDto;
import academy.mindswap.commitAir.model.Flight;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService{

    @Override
    public List<Flight> getAllFlights() {
        return null;
    }

    @Override
    public String getFlightById(String flightCode) {

        String uri = "https://airlabs.co/api/v9/flight?flight_iata=" + flightCode + "&api_key=51458100-5a17-4b86-a9f4-1388f74b5454";

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();

        /*
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);
        JsonNode root = objectMapper.readTree(responseEntity.getBody());
        JsonNode response = root.path("response");
       List<CityDto> cities =  objectMapper.readValue(root.toString(), new TypeReference<List<CityDto>>() {});

         */
        ResponseEntity<Flight> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, Flight.class);
        if(responseEntity.getStatusCode().isError()){
            throw new Error();
        }

        String uri2 = "https://ryanair.p.rapidapi.com/flights?origin_code=LGW&destination_code=DUB&origin_departure_date=2023-09-28&destination_departure_date=2023-10-28";
        RestTemplate restTemplate2 = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-RapidAPI-Key", "4de5cab2fcmshaccf16bbcacb5dap156556jsn775e2053adba");
        headers.add("X-RapidAPI-Host", "ryanair.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        ResponseEntity<String> responseEntity2 = restTemplate.exchange(uri2, HttpMethod.GET, entity, String.class);



        return responseEntity2.getBody();
    }
}
