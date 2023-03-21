package academy.mindswap.commitAir.converter;

import academy.mindswap.commitAir.dto.RegisterRequest;
import academy.mindswap.commitAir.dto.UserDto;
import academy.mindswap.commitAir.model.Role;
import academy.mindswap.commitAir.model.User;

public class UserConverter {
    public User fromRegisterRequestToEntity(RegisterRequest createUser) {

        return User.builder()
                .firstName(createUser.getFirstName())
                .lastName(createUser.getLastName())
                .email(createUser.getEmail())
                .password(createUser.getPassword())
                .dateOfBirth(createUser.getDateOfBirth())
                .nationality(createUser.getNationality())
                .role(Role.USER)
                .build();

    }

    public UserDto fromUserEntityToUserDto(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .dateOfBirth(user.getDateOfBirth())
                .nationality(user.getNationality())
                .role(Role.USER)
                .build();


    }
}
