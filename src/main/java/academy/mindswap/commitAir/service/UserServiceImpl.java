package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.converter.UserConverter;
import academy.mindswap.commitAir.dto.RegisterRequest;
import academy.mindswap.commitAir.dto.UserCreateDto;
import academy.mindswap.commitAir.dto.UserDto;
import academy.mindswap.commitAir.exception.PasswordNotMatch;
import academy.mindswap.commitAir.model.User;
import academy.mindswap.commitAir.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(RegisterRequest createUser) {

        if (!createUser.getPassword().equals(createUser.getRetypedPassword())) {
            throw new PasswordNotMatch("Passwords do not match");
        }

        User user = userConverter.fromRegisterRequestToEntity(createUser);
        user = userRepository.save(user);

        return userConverter.fromUserEntityToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.parallelStream()
                .map(userConverter::fromUserEntityToUserDto)
                .toList();
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> user = userRepository.getUserById(id);
        if (user.isEmpty()) {
            //throw new IdNotExist("User not found");
            //TODO
            //create exceptions
        }
        return userConverter.fromUserEntityToUserDto(user.get());
    }

    @Override
    public UserDto updateUser(Long id, UserCreateDto userDto) {
        User user = userRepository.getReferenceById(id);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setNationality(userDto.getNationality());
        user.setRole(userDto.getRole());

        userRepository.save(user);
        return userConverter.fromUserEntityToUserDto(user);
    }
}
