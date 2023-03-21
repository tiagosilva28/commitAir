package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryService {
    CountryDto createCountry(RegisterRequest country);
}
