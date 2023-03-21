package academy.mindswap.commitAir.controller;

import academy.mindswap.commitAir.service.FlightSeatPriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flightSeatPrice")
public class FlightSeatPriceController {

    private final FlightSeatPriceServiceImpl flightSeatPriceService;

    @Autowired
    public FlightSeatPriceController(FlightSeatPriceServiceImpl flightSeatPriceService) {
        this.flightSeatPriceService = flightSeatPriceService;
    }
}
