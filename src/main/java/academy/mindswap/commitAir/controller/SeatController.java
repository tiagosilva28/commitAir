package academy.mindswap.commitAir.controller;

import academy.mindswap.commitAir.service.SeatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat")
public class SeatController {

    private final SeatServiceImpl seatService;

    @Autowired
    public SeatController(SeatServiceImpl seatService) {
        this.seatService = seatService;
    }
}
