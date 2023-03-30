package academy.mindswap.commitAir.controller;

import academy.mindswap.commitAir.dto.CityDto;
import academy.mindswap.commitAir.service.CityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("")
    public ResponseEntity<List<CityDto>> getAllCities() throws JsonProcessingException {
        List<CityDto> cityDtos = cityService.getAllCities();
        return new ResponseEntity<>(cityDtos, HttpStatus.OK);
    }

}
