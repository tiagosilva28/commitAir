package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.converter.SeatConverter;
import academy.mindswap.commitAir.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService{

    SeatRepository seatRepository;
    SeatConverter seatConverter;

    @Autowired
    public SeatServiceImpl (SeatRepository seatRepository){
        this.seatRepository = seatRepository;
    }
}
