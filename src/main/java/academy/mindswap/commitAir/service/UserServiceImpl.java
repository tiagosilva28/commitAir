package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.RegisterRequest;
import academy.mindswap.commitAir.dto.UserDto;
import academy.mindswap.commitAir.exception.PasswordNotMatch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    @Override
    public UserDto createUser(RegisterRequest user) {

        if (!user.getPassword().equals(user.getRetypedPassword())) {
            throw new PasswordNotMatch("Passwords do not match");
        }

        return null;
    }
}
