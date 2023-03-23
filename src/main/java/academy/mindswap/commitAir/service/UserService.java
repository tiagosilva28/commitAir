package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.RegisterRequest;
import academy.mindswap.commitAir.dto.UserCreateDto;
import academy.mindswap.commitAir.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(RegisterRequest user);
    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    UserDto updateUser(Long id, UserCreateDto userCreateDto);
}
