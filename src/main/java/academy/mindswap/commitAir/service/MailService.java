package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.UserDto;

public interface MailService {

    void sendEmail(UserDto userDto);
}
