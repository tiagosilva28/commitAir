package academy.mindswap.commitAir.controller;

import academy.mindswap.commitAir.airLabsClient.AirLabsClient;
import academy.mindswap.commitAir.dto.AirLabsResponseCitiesDto;
import academy.mindswap.commitAir.dto.CityDto;
import academy.mindswap.commitAir.dto.RegisterRequest;
import academy.mindswap.commitAir.dto.UserDto;
import academy.mindswap.commitAir.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody RegisterRequest user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
        }
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<AirLabsResponseCitiesDto> city (){
        AirLabsClient airLabsClient = new AirLabsClient();
        var result = airLabsClient.getCities();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}
