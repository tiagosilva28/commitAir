package academy.mindswap.commitAir.airLabsClient;

import academy.mindswap.commitAir.dto.AirLabsResponseCitiesDto;
import academy.mindswap.commitAir.dto.CityDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class AirLabsClient {
    RestTemplate restTemplate = new RestTemplate();


    ObjectMapper objectMapper = new ObjectMapper();
    public List<CityDto> getCities() throws JsonProcessingException {
        String uri = "https://airlabs.co/api/v9/cities?api_key=51458100-5a17-4b86-a9f4-1388f74b5454&_filelds=name";


        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);
        JsonNode root = objectMapper.readTree(responseEntity.getBody());
        JsonNode response = root.path("response");
       List<CityDto> cities =  objectMapper.readValue(response.toString(), new TypeReference<List<CityDto>>() {});


     /*   ResponseEntity<AirLabsResponseCitiesDto> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, AirLabsResponseCitiesDto.class);
        if(responseEntity.getStatusCode().isError()){
            throw new Error();
        }

      */


        return cities;
    }

    public AirLabsResponseCitiesDto getCities2(){

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "4de5cab2fcmshaccf16bbcacb5dap156556jsn775e2053adba");
        headers.set("X-RapidAPI-Host", "ryanair.p.rapidapi.com");

        String uri = "https://ryanair.p.rapidapi.com/flights?origin_code=LGW&destination_code=DUB&origin_departure_date=2023-09-28&destination_departure_date=2023-10-28";
        RestTemplate restTemplate = new RestTemplate();

        AirLabsResponseCitiesDto result = restTemplate
                .getForObject(uri, AirLabsResponseCitiesDto.class);
        return result;
    }
}
