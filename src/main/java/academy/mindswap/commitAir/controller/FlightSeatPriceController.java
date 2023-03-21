package academy.mindswap.commitAir.controller;

import academy.mindswap.commitAir.service.FlightSeatPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flightSeatPrice")
public class FlightSeatPriceController {

    private final FlightSeatPriceService flightSeatPriceService;

    @Autowired
    public FlightSeatPriceController(FlightSeatPriceService flightSeatPriceService) {
        this.flightSeatPriceService = flightSeatPriceService;
    }
}
