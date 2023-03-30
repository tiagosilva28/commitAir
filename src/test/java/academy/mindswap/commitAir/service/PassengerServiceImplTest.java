package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.mapper.PassengerMapper;
import academy.mindswap.commitAir.repository.PassengerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PassengerServiceImplTest {

    @Mock
    private PassengerRepository passengerRepository;

    @Mock
    private PassengerMapper passengerMapper;

    private PassengerServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new PassengerServiceImpl(passengerRepository, passengerMapper);
    }

    @Test
    void getAllPassengers() {
        // when
        underTest.getAllPassengers();
        // then
        verify(passengerRepository).findAll();
    }
}
