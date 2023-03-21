package academy.mindswap.commitAir.controller;

import academy.mindswap.commitAir.service.PassengerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    private final PassengerServiceImpl passengerService;

    @Autowired
    public PassengerController(PassengerServiceImpl passengerService) {
        this.passengerService = passengerService;
    }
}
