package ro.sd.a2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Properties;

@Configuration
@EnableWebMvc
public class MVCConfig implements WebMvcConfigurer {

    @Bean
    public SimpleMailMessage templateSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("This is the test email template for your email FUCK YOU");
        return message;
    }
    @Bean
    public JavaMailSenderImpl emailSender(){
        return  new JavaMailSenderImpl();
    }
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = emailSender();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("maria18and@gmail.com");
        mailSender.setPassword("gctnngcdkjyevoqt");


        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
