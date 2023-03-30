package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import academy.mindswap.commitAir.dto.RegisterRequest;
import academy.mindswap.commitAir.mapper.UserMapper;
import academy.mindswap.commitAir.model.User;
import academy.mindswap.commitAir.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserServiceImpl(userRepository, userMapper);
    }

    @Test
    void createUser() throws ParseException {

        // Given
        String birthdateString = "1990-09-09";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdate = dateFormat.parse(birthdateString);

        RegisterRequest createUser = new RegisterRequest("John", "Doe", "johndoe@example.com", "password1", "password1", birthdate, "US");
        User user = new User();
        when(userMapper.fromRegisterRequestToEntity(eq(createUser))).thenReturn(user);
        when(userRepository.save(any())).thenReturn(user);
        UserDto userDto = new UserDto();
        when(userMapper.fromUserEntityToUserDto(eq(user))).thenReturn(userDto);

        // when
        UserDto result = underTest.createUser(createUser);

        // then
        assertEquals(userDto, result);
    }

    @Test
    void getAllUsers() {
        // when
        underTest.getAllUsers();
        // then
        verify(userRepository).findAll();
    }
}
