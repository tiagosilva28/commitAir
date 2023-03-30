package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.AirportDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {
    
    RestTemplate restTemplate = new RestTemplate();

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<AirportDto> getAllAirports() throws JsonProcessingException {
        String uri = "https://airlabs.co/api/v9/airports?api_key=51458100-5a17-4b86-a9f4-1388f74b5454";
        ResponseEntity<String> entity = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);
        JsonNode root = objectMapper.readTree(entity.getBody());
        JsonNode response = root.path("response");
        List<AirportDto> airports = objectMapper.readValue(response.toString(), new TypeReference<List<AirportDto>>() {
        });

        return airports;
    }
}
