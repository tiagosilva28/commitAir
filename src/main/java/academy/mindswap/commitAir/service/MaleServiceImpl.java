package academy.mindswap.commitAir.service;

import academy.mindswap.commitAir.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MaleServiceImpl implements MailService{

    JavaMailSender javaMailSender;

    @Autowired
    public MaleServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    @Override
    public void sendEmail(UserDto userDto) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(userDto.getEmail());
        mail.setSubject("Testing Mail API");
        mail.setText("Hurray ! You have done that dude...");
        javaMailSender.send(mail);
    }

}
