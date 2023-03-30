package academy.mindswap.commitAir.controller;

import academy.mindswap.commitAir.dto.PassengerDto;
import academy.mindswap.commitAir.service.PassengerServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    private final PassengerServiceImpl passengerService;

    @Autowired
    private PassengerController(PassengerServiceImpl passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping
    public ResponseEntity<PassengerDto> createPassenger(@RequestBody PassengerDto passenger, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
        }
        PassengerDto savedPassenger = passengerService.createPassenger(passenger);
        return new ResponseEntity<>(savedPassenger, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerDto> getById(@PathVariable Long id) {
        PassengerDto passenger = passengerService.getPassengerById(id);
        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<PassengerDto>> getAllPassengers() {
        List<PassengerDto> passengers = passengerService.getAllPassengers();
        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassengerDto> updatePassenger(@PathVariable Long id, @Valid @RequestBody PassengerDto passengerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
        }
        PassengerDto savedPassenger = passengerService.updatePassenger(id, passengerDto);
        return new ResponseEntity<>(savedPassenger, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(Long passengerId) {
        passengerService.deletePassenger(passengerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
