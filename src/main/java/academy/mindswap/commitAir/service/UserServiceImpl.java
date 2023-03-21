package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.converter.UserConverter;
import academy.mindswap.commitAir.dto.RegisterRequest;
import academy.mindswap.commitAir.dto.UserDto;
import academy.mindswap.commitAir.exception.PasswordNotMatch;
import academy.mindswap.commitAir.model.User;
import academy.mindswap.commitAir.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    @Autowired
    UserConverter userConverter = new UserConverter();

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
}
