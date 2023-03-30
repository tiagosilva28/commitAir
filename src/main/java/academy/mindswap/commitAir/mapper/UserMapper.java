package academy.mindswap.commitAir.mapper;

import academy.mindswap.commitAir.dto.RegisterRequest;
import academy.mindswap.commitAir.dto.UserDto;
import academy.mindswap.commitAir.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface UserMapper {
    User fromRegisterRequestToEntity(RegisterRequest createUser);

    UserDto fromUserEntityToUserDto(User user);
}
