package academy.mindswap.commitAir.airLabsClient;

import academy.mindswap.commitAir.dto.AirLabsResponseCitiesDto;
import academy.mindswap.commitAir.dto.CityDto;
import org.springframework.web.client.RestTemplate;

import java.util.List;


public class AirLabsClient {
    public AirLabsResponseCitiesDto getCities(){
        String uri = "https://airlabs.co/api/v9/cities?api_key=51458100-5a17-4b86-a9f4-1388f74b5454&_filelds=name";
        RestTemplate restTemplate = new RestTemplate();
        AirLabsResponseCitiesDto result = restTemplate.getForObject(uri, AirLabsResponseCitiesDto.class);

        //System.out.println(result);
        return result;
    }
}
