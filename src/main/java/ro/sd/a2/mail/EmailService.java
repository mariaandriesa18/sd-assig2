package ro.sd.a2.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public interface EmailService {

        void sendSimpleMessage(String to,
                               String subject,
                               String text);

        void sendSimpleMessageUsingTemplate(String to,
                                            String subject,
                                            SimpleMailMessage template,
                                            String... templateArgs);

        void sendMessageWithAttachment(String to,
                                       String subject,
                                       String text,
                                       String pathToAttachment);

}
