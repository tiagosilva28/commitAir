package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.RegisterRequest;
import academy.mindswap.commitAir.dto.UserCreateDto;
import academy.mindswap.commitAir.dto.UserDto;
import academy.mindswap.commitAir.exception.IdNotExist;
import academy.mindswap.commitAir.exception.PasswordNotMatch;
import academy.mindswap.commitAir.exception.UserDoesntExists;
import academy.mindswap.commitAir.exception.UserNotMatch;
import academy.mindswap.commitAir.mapper.UserMapper;
import academy.mindswap.commitAir.model.Role;
import academy.mindswap.commitAir.model.User;
import academy.mindswap.commitAir.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(RegisterRequest createUser) {

        if (!createUser.getPassword().equals(createUser.getRetypedPassword())) {
            throw new PasswordNotMatch("Passwords do not match");
        }

        User user = userMapper.fromRegisterRequestToEntity(createUser);
        user = userRepository.save(user);

        return userMapper.fromUserEntityToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.parallelStream()
                .map(userMapper::fromUserEntityToUserDto)
                .toList();
    }

    @Override
    public UserDto getUserById(Long id) {

        if (!userRepository.existsById(id)) {
            throw new UserDoesntExists("User Doesn't Exists");
        }
        Optional<User> user = userRepository.getUserById(id);
        User logInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println(logInUser.getRole());

        /*if (!logInUser.getId().equals(user.get().getId())){
            throw new UserNotMatch("You are trying to access other User");
        }*/

        if (!logInUser.getRole().equals(Role.ADMIN) && !logInUser.getId().equals(user.get().getId())) {
            throw new UserNotMatch("You are trying to access other User");
        }

        return userMapper.fromUserEntityToUserDto(user.get());
    }

    @Override
    public UserDto updateUser(Long id, UserCreateDto userDto) {

        if (!userRepository.existsById(id)) {
            throw new UserDoesntExists("User Doesn't Exists");
        }
        User user = userRepository.getReferenceById(id);
        User logInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (!logInUser.getId().equals(user.getId())) {
            throw new UserNotMatch("You are trying to access other User");
        }

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setNationality(userDto.getNationality());
        userRepository.save(user);
        return userMapper.fromUserEntityToUserDto(user);
    }

    @Override
    public void updateRole(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IdNotExist("User Doesn't Exists");
        }

        User user = userRepository.getReferenceById(id);
        user.setRole(Role.ADMIN);
        userRepository.save(user);

    }
}
