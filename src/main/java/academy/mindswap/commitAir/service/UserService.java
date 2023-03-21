package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.RegisterRequest;
import academy.mindswap.commitAir.dto.UserDto;

public interface UserService {

    UserDto createUser(RegisterRequest user);
}
